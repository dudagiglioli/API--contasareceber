package br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceber;

import br.com.dudagiglioli.trabalhoBidu.model.ContasAReceber;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ContasAReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContasAReceberRepositoryImpl implements ContasAReceberRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContasAReceber> Filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasAReceber> criteria = builder.createQuery((ContasAReceber.class));
        Root<ContasAReceber> root = criteria.from((ContasAReceber.class));

        Predicate[] predicates = criarRestricoes(contasAReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("data")));

        TypedQuery<ContasAReceber> query = manager.createQuery(criteria);

        return new PageImpl<>(query.getResultList(), pageable, totaldepaginas(contasAReceberFilter));
    }

    private Long totaldepaginas(ContasAReceberFilter contasAReceberFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasAReceber> root = criteria.from(ContasAReceber.class);

        Predicate[] predicates = criarRestricoes(contasAReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("data")));

        criteria.select(builder.count(root));

        return  manager.createQuery(criteria).getSingleResult();
    }

    private void addrestricoesdepaginacao(TypedQuery<ContasAReceber> query, Pageable pageable){
        int paginaatual = pageable.getPageNumber();
        int totalresgistros = pageable.getPageSize();
        int primeiroregistrodepagina = paginaatual * totalresgistros;

        query.setFirstResult(primeiroregistrodepagina);
        query.setMaxResults(totalresgistros);
    }

    private Predicate[] criarRestricoes(ContasAReceberFilter contasAReceberFilter, CriteriaBuilder builder, Root<ContasAReceber> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(contasAReceberFilter.getValorconta() != null){
            predicates.add(builder.equal(root.get("valorconta"), contasAReceberFilter.getValorconta()));
        }
        if(contasAReceberFilter.getData() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("data"), contasAReceberFilter.getData()));
        }


        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
