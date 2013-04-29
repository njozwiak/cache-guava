package com.xebia.config;

import com.google.inject.Scopes;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.xebia.cache.PanierCache;
import com.xebia.repository.ClientRepository;
import com.xebia.repository.PanierRepository;
import com.xebia.resource.ClientResource;
import com.xebia.resource.ClientsResource;
import com.xebia.resource.PanierResource;
import com.xebia.service.ClientService;
import com.xebia.service.PanierService;

public class GuiceConfig extends JerseyServletModule {

    @Override
    protected void configureServlets() {

        bind(ClientRepository.class).in(Scopes.SINGLETON);
        bind(PanierRepository.class).in(Scopes.SINGLETON);
        bind(ClientService.class).in(Scopes.SINGLETON);
        bind(PanierService.class).in(Scopes.SINGLETON);
        bind(PanierCache.class).in(Scopes.SINGLETON);

        bind(ClientsResource.class);
        bind(ClientResource.class);
        bind(PanierResource.class);

        serve("/rest/*").with(GuiceContainer.class);
    }
}
