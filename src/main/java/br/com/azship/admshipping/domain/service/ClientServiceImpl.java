package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.exception.ClientNotFoundException;
import br.com.azship.admshipping.domain.integration.ClientIntegration;

public class ClientServiceImpl implements ClientService{

    private final ClientIntegration clientIntegration;

    public ClientServiceImpl(ClientIntegration clientIntegration) {
        this.clientIntegration = clientIntegration;
    }

    @Override
    public Client findClientById(String id) {
        return clientIntegration.findById(id).orElseThrow(() -> new ClientNotFoundException("Cliente [" + id +"] não encontrado."));
    }
}
