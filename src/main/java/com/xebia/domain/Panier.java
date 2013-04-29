package com.xebia.domain;

import com.google.common.collect.Lists;

import java.util.List;

public class Panier {

    private Integer idPanier;
    private Integer idClient;
    private List<Product> products;

    public Panier(Integer idPanier, Integer idClient) {
        this.idPanier = idPanier;
        this.idClient = idClient;
        this.products = Lists.newArrayList();
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
