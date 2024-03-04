package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.dto.FreighRegistryRequestDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighUpdateRequestDomainDTO;
import br.com.azship.admshipping.domain.custom.DomainPage;
import br.com.azship.admshipping.domain.custom.DomainPageable;

public interface FreightService {

    DomainPage<FreighResponseDomainDTO> findAllBy(String value, DomainPageable domainPageable);

    FreighResponseDomainDTO findFreightById(String id);

    DomainPage<FreighResponseDomainDTO> findFreightByCnpj(String cnpj, DomainPageable domainPageable);

    FreighResponseDomainDTO registerFreight(FreighRegistryRequestDomainDTO freight);

    FreighResponseDomainDTO updateFreight(FreighUpdateRequestDomainDTO freight);

    void removeFreight(String id);

}
