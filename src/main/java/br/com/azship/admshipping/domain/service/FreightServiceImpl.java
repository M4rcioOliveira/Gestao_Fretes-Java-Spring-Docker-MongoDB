package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.dto.FreighRegistryRequestDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.dto.FreighUpdateRequestDomainDTO;
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

        Freight freight = freightRepository.findById(id);

        return new FreighResponseDomainDTO(freight);

    }

    @Override
    public FreighResponseDomainDTO registerFreight(FreighRegistryRequestDomainDTO dto) {

        Client client = clientService.findClienyById(dto.client_id());

        return Freight.toFreightDomainDTO(freightRepository.save(new Freight(UUID.randomUUID().toString(), client, dto.propriedades())));

    }

    @Override
    public FreighResponseDomainDTO updateFreight(FreighUpdateRequestDomainDTO domainDTO) {

        FreighResponseDomainDTO freightDTO = findFreightById(domainDTO.frete_id());

        Freight freight = FreighResponseDomainDTO.toFreight(freightDTO);

        freight.setPropriedades(domainDTO.propriedades());

        return Freight.toFreightDomainDTO(freightRepository.save(freight));

    }


    @Override
    public void removeFreight(String id) {

        FreighResponseDomainDTO freightDTO = findFreightById(id);

        freightRepository.remove(id);

    }
}
