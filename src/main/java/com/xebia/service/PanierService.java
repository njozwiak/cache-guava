package com.xebia.service;

import com.google.inject.Inject;
import com.xebia.cache.PanierCache;
import com.xebia.domain.Panier;
import com.xebia.entity.PanierEntity;

public class PanierService {

    private PanierCache panierCache;

    @Inject
    public PanierService(PanierCache panierCache) {
        this.panierCache = panierCache;
    }

    public PanierEntity getPanierByClientId(Integer idClient) {
        Panier panier = panierCache.loadPanier(idClient);

        return new PanierEntity(panier);
    }
}
