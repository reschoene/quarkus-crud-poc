package br.com.reschoene.resources;

import br.com.reschoene.entities.Produto;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/produtos")
public class ProdutoResource {
    @Inject
    EntityManager entityManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){
        return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }
}
