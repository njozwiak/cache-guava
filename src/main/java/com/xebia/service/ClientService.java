package com.xebia.service;

import com.google.inject.Inject;
import com.xebia.domain.Client;
import com.xebia.entity.ClientEntity;
import com.xebia.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private ClientRepository clientRepository;

    @Inject
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity getClientById(Integer idClient) {
        Client client = clientRepository.getClientById(idClient);

        return new ClientEntity(client);
    }

    public List<ClientEntity> getClients() {
        List<Client> clients = clientRepository.getClients();

        List<ClientEntity> clientEntities = new ArrayList<ClientEntity>();

        for (Client client : clients) {
            clientEntities.add(new ClientEntity(client));
        }

        return clientEntities;
    }
}
