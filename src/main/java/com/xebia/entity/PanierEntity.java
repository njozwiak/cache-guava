package com.xebia.entity;

import com.xebia.domain.Panier;
import com.xebia.domain.Product;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Panier")
public class PanierEntity {

    private Integer idPanier;

    private Integer idClient;

    private List<Product> products;

    public PanierEntity() {
    }

    public PanierEntity(Integer idPanier, Integer idClient) {
        this.idPanier = idPanier;
        this.idClient = idClient;
    }

    public PanierEntity(Panier panier) {
       this.idPanier = panier.getIdPanier();
       this.idClient = panier.getIdClient();
       this.products = panier.getProducts();
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
}
