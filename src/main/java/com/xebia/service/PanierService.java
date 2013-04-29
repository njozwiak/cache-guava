package com.xebia.service;

import com.google.inject.Inject;
import com.xebia.domain.Panier;
import com.xebia.entity.PanierEntity;
import com.xebia.repository.PanierRepository;

public class PanierService {

    private PanierRepository panierRepository;

    @Inject
    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    public PanierEntity getPanierByClientId(Integer idClient) {
        Panier panier = panierRepository.getPanierByClientId(idClient);

        return new PanierEntity(panier);
    }
}
