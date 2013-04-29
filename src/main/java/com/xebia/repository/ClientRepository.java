package com.xebia.repository;

import com.xebia.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class ClientRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRepository.class);

    public Client getClientById(Integer idClient) {
        checkArgument(idClient != null, "id client cannot be null");
        return new Client(idClient, "Tom", "Sawyer");
    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<Client>();

        LOGGER.info("Access to client repository");

        clients.add(new Client(1, "Tom", "Sawyer"));
        clients.add(new Client(2, "Kovacs", "Takeshi"));
        clients.add(new Client(3, "Yoh", "Asura"));
        clients.add(new Client(4, "Bruce", "Lee"));

        return clients;
    }
}
