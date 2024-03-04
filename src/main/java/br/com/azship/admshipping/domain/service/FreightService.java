package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.dto.FreighRegistryRequestDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighUpdateRequestDomainDTO;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;

public interface FreightService {

    DomainPage<FreighResponseDomainDTO> findAllBy(String value, DomainPageable domainPageable);

    FreighResponseDomainDTO findFreightById(String id);

    FreighResponseDomainDTO registerFreight(FreighRegistryRequestDomainDTO freight);

    FreighResponseDomainDTO updateFreight(FreighUpdateRequestDomainDTO freight);

    void removeFreight(String id);

}
