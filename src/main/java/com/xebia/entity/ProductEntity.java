package com.xebia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
public class ProductEntity {

    public Integer idProduct;

    public String name;

    public String description;

    public Integer price;

    public ProductEntity() {
    }
}
