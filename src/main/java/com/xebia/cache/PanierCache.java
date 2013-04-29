package com.xebia.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.Inject;
import com.xebia.domain.Panier;
import com.xebia.repository.PanierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PanierCache extends CacheLoader<Integer, Panier> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PanierCache.class);

    private PanierRepository panierRepository;

    private LoadingCache<Integer, Panier> cache;

    private ListeningExecutorService listeningScheduledExecutorService;

    @Inject
    public PanierCache(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;

        cache = CacheBuilder.newBuilder().recordStats().refreshAfterWrite(1, TimeUnit.MINUTES).expireAfterAccess(2, TimeUnit.MINUTES).build(this);
        listeningScheduledExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));
    }

    @Override
    public final Panier load(Integer idClient) {
        LOGGER.info("Load panier for id client {}", idClient);

        LOGGER.info("Stats cache: {}", cache.stats());

        return panierRepository.getPanierByClientId(idClient);
    }


    @Override
    public ListenableFuture<Panier> reload(final Integer idClient, Panier oldValue) {
        LOGGER.info("Reload panier for id client {}", idClient);

        return listeningScheduledExecutorService.submit(new Callable<Panier>() {
            @Override
            public Panier call() throws Exception {
                return load(idClient);
            }
        });

    }

    public Panier loadPanier(final Integer idClient) {
        return cache.getUnchecked(idClient);
    }
}
