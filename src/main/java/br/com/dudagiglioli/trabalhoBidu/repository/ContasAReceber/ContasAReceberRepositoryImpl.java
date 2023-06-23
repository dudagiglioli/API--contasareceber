package br.com.dudagiglioli.trabalhoBidu.repository.ContasAReceber;

import br.com.dudagiglioli.trabalhoBidu.model.ContasAReceber;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ContasAReceberFilter;
import br.com.dudagiglioli.trabalhoBidu.repository.projections.ContasAReceberDTO;
import org.apache.commons.lang3.StringUtils;
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
    public Page<ContasAReceberDTO> Filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasAReceberDTO> criteria = builder.createQuery((ContasAReceberDTO.class));
        Root<ContasAReceber> root = criteria.from((ContasAReceber.class));

        criteria.select(builder.construct(ContasAReceberDTO.class,
                root.get("id"),
                root.get("data"),
                root.get("valorconta"),
                root.get("cliente").get("nomecliente")
                ));

        Predicate[] predicates = criarRestricoes(contasAReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("data")));

        TypedQuery<ContasAReceberDTO> query = manager.createQuery(criteria);
        addrestricoesdepaginacao(query, pageable);
        
        return new PageImpl<>(query.getResultList(), pageable, total(contasAReceberFilter));
    }

    private void addrestricoesdepaginacao(TypedQuery<?> query, Pageable pageable) {
        int pagatual = pageable.getPageNumber();
        int totalderestricoesporpag = pageable.getPageSize();
        int primeiroregistropag = pagatual * totalderestricoesporpag;

        query.setFirstResult(primeiroregistropag);
        query.setMaxResults(totalderestricoesporpag);
    }

    private Predicate[] criarRestricoes(ContasAReceberFilter contasAReceberFilter, CriteriaBuilder builder, Root<ContasAReceber> root) {

        List<Predicate> predicates = new ArrayList<>();


        if(contasAReceberFilter.getValorconta() != null){
            predicates.add(builder.equal(root.get("valorconta"), contasAReceberFilter.getValorconta()));
        }
        if(contasAReceberFilter.getData() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("data"), contasAReceberFilter.getData()));
        }
        if (!StringUtils.isEmpty(contasAReceberFilter.getNomecliente())) {
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                    "%" + contasAReceberFilter.getNomecliente().toLowerCase() + "%"
            ));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }

    private Long total(ContasAReceberFilter contasAReceberFilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasAReceber> root = criteria.from(ContasAReceber.class);

        Predicate[] predicates = criarRestricoes(contasAReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("data")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }
}
