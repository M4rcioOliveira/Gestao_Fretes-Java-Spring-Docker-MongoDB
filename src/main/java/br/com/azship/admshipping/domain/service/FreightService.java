package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.dto.FreighRequestDomainDTO;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;

public interface FreightService {

    DomainPage<FreighResponseDomainDTO> findAllBy(String value, DomainPageable domainPageable);

    FreighResponseDomainDTO findFreightById(String id);

    FreighResponseDomainDTO saveFreight(FreighRequestDomainDTO freight);

    FreighResponseDomainDTO updateFreight(FreighRequestDomainDTO freight);

    void removeFreight(String freight);

}
