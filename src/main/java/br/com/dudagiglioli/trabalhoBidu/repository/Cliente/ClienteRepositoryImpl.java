package br.com.dudagiglioli.trabalhoBidu.repository.Cliente;

import br.com.dudagiglioli.trabalhoBidu.model.Cliente;
import br.com.dudagiglioli.trabalhoBidu.repository.Filter.ClienteFilter;
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

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{

   @PersistenceContext
   private EntityManager manager;

    @Override
    public Page<Cliente> Filtrar(ClienteFilter clienteFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecliente")));

        TypedQuery<Cliente> query = manager.createQuery(criteria);
        //transformar o meu criteria em uma Query/consulta

        adicionarRestricoesDePaginacao(query, pageable); //criar método

        return new PageImpl<>(query.getResultList(), pageable, totaldepaginas(clienteFilter));
    }

    private Long totaldepaginas(ClienteFilter clienteFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder(); //criação de consulta
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class); //select que retorna a qtde de registros da pág
        Root<Cliente> root = criteria.from(Cliente.class); // é o pai, mostra qual é  a classe pai do sql

        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecliente")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Cliente> query, Pageable pageable) {

        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);

    }

    private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
        List<Predicate> predicates = new ArrayList<>(); // armazena os dados

        if (!StringUtils.isEmpty(clienteFilter.getNomecliente())){
            predicates.add(builder.like(builder.lower(root.get("nomecliente")),
                    "%" + clienteFilter.getNomecliente().toLowerCase() + "%" ));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
