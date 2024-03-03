package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.dto.FreighRequestDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FreightServiceImpl implements FreightService {

    private final FreightRepository freightRepository;
    private final ClientService clientService;

    public FreightServiceImpl(FreightRepository freightRepository, ClientService clientService) {
        this.freightRepository = freightRepository;
        this.clientService = clientService;
    }


    @Override
    public DomainPage<FreighResponseDomainDTO> findAllBy(String value, DomainPageable domainPageable) {

        DomainPage<Freight> domainPage = freightRepository.findAllBy(value, domainPageable);

        List<Freight> freight = domainPage.content();

        return new DomainPage<>(freight.stream().map(FreighResponseDomainDTO::new).collect(Collectors.toList()),
                domainPage.totalPages(), domainPage.totalElements(), domainPage.pageSize(), domainPage.pageNumber());
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
