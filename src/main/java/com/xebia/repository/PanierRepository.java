package com.xebia.repository;

import com.xebia.domain.Panier;
import com.xebia.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkArgument;

public class PanierRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PanierRepository.class);

    public Panier getPanierByClientId(Integer idClient) {
        checkArgument(idClient != null, "id client cannot be null");

        LOGGER.info("Access to panier repository for id client {}", idClient);

        Panier panier = new Panier(1, idClient);
        panier.addProduct(new Product(1, "livre", "description livre", idClient * 10));
        panier.addProduct(new Product(2, "ordinateur", "description ordinateur", idClient * 120));

        return panier;
    }

}
