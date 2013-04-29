package com.xebia.resource;

import com.google.inject.Inject;
import com.xebia.entity.ClientEntity;
import com.xebia.service.ClientService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
@Produces({MediaType.APPLICATION_JSON})
public class ClientResource {

    private ClientService clientService;

    @Inject
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    @Path("/{idClient}")
    public Response getClientById(@PathParam("idClient") Integer idClient) {
        ClientEntity clientEntity = clientService.getClientById(idClient);

        return Response.ok(clientEntity).build();
    }
}
