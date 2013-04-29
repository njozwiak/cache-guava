package com.xebia.resource;

import com.google.inject.Inject;
import com.xebia.entity.PanierEntity;
import com.xebia.service.PanierService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/panier")
@Produces({MediaType.APPLICATION_JSON})
public class PanierResource {

    private PanierService panierService;

    @Inject
    public PanierResource(PanierService panierService) {
        this.panierService = panierService;
    }

    @GET
    @Path("/{idClient}")
    public Response getClientById(@PathParam("idClient") Integer idClient) {
        PanierEntity panierEntity = panierService.getPanierByClientId(idClient);
        return Response.ok(panierEntity).build();
    }
}
