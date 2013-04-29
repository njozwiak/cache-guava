package com.xebia.resource;

import com.google.inject.Inject;
import com.sun.jersey.api.JResponse;
import com.xebia.entity.ClientEntity;
import com.xebia.service.ClientService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
@Produces({MediaType.APPLICATION_JSON})
public class ClientsResource {

    private ClientService clientService;

    @Inject
    public ClientsResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    public JResponse<List<ClientEntity>> getClients() {
        List<ClientEntity> clientEntity = clientService.getClients();

        return JResponse.ok(clientEntity).build();
    }

}
