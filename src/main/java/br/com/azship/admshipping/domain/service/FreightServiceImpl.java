package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.FreighRequestDomainDTO;
import br.com.azship.admshipping.domain.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;

import java.util.UUID;

public class FreightServiceImpl implements FreightService{

    private final FreightRepository freightRepository;
    private final ClientService clientService;

    public FreightServiceImpl(FreightRepository freightRepository, ClientService clientService) {
        this.freightRepository = freightRepository;
        this.clientService = clientService;
    }


    @Override
    public FreighResponseDomainDTO findFreightByValue(Object value) {
        return null;
    }

    @Override
    public FreighResponseDomainDTO findFreightById(String id) {
        return null;
    }

    @Override
    public FreighResponseDomainDTO saveFreight(FreighRequestDomainDTO freight) {

        Client client = clientService.findClienyById(freight.client_id());

        Freight savedFreight = freightRepository.save(new Freight(UUID.randomUUID().toString(), client, freight.propriedades()));

        return Freight.toFreightDomainDTO(savedFreight);

    }

    @Override
    public FreighResponseDomainDTO updateFreight(FreighRequestDomainDTO freight) {
        return null;
    }

    @Override
    public void removeFreight(String freight) {

    }
}
