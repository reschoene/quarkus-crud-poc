package br.com.reschoene.resources;

import br.com.reschoene.entities.Produto;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/produtos")
@Transactional
public class ProdutoResource {
    @Inject
    EntityManager entityManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){
        return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void addProduto(Produto p){
        entityManager.persist(p);
    }
}
