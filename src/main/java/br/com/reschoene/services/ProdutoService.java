package br.com.reschoene.services;

import br.com.reschoene.entities.Produto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
    @Inject
    ProdutoService produtoService;

    public List<Produto> getProdutos(){
        return produtoService.getProdutos();
    }

    public void addProduto(Produto p){
        produtoService.addProduto(p);
    }
}
