package br.com.azship.admshipping.domain.integration;

import br.com.azship.admshipping.domain.Client;

import java.util.Optional;

public interface ClientIntegration {

    Optional<Client> findById(String id);

}
