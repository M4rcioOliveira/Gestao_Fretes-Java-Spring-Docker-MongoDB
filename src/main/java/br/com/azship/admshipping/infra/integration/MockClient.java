package br.com.azship.admshipping.infra.integration;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.integration.ClientIntegration;
import br.com.azship.admshipping.infra.dto.ClientResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MockClient implements ClientIntegration {

    private final FeignMockyClient feignMockyClient;

    public MockClient(FeignMockyClient feignMockyClient) {
        this.feignMockyClient = feignMockyClient;
    }

    @Override
    public Optional<Client> findById(String id) {

        List<ClientResponseDTO> clients = feignMockyClient.getClients();

        return clients.stream().filter(c -> c.client_id().equals(id)).map(ClientResponseDTO::toClient).findFirst();

    }
}
