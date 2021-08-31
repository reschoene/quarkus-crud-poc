package br.com.reschoene.entities;

import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {
    public String code;
    public String brand;
    public String description;

    public static Product findByCode(String code) {
        return find("code", code).firstResult();
    }
}
