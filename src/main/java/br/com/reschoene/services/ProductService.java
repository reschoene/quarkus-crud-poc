package br.com.reschoene.services;

import br.com.reschoene.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
public class ProductService {
    public List<Product> listAll(){
        return Product.listAll();
    }

    public Product findById(Long id){
        return Product.findById(id);
    }

    public Product create(Product p){
        p.persist();
        return p;
    }

    public Product update(Long id, Product p) {
        Product existingProduct = Product.findById(id);
        if(existingProduct == null)
            throw new NotFoundException();

        // map all fields from the person parameter to the existing entity
        existingProduct.code = p.code;
        existingProduct.brand = p.brand;
        existingProduct.description = p.description;

        return existingProduct;
    }

    public void delete(Long id) {
        Product existingProduct = Product.findById(id);
        if(existingProduct == null)
            throw new NotFoundException();

        existingProduct.delete();
    }

    public Product findByCode(String code) {
        return Product.findByCode(code);
    }

    public Long count() {
        return Product.count();
    }
}
