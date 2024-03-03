package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.FreighRequestDomainDTO;
import br.com.azship.admshipping.domain.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;

public interface FreightService {

    FreighResponseDomainDTO findFreightByValue(Object value);

    FreighResponseDomainDTO findFreightById(String id);

    FreighResponseDomainDTO saveFreight(FreighRequestDomainDTO freight);

    FreighResponseDomainDTO updateFreight(FreighRequestDomainDTO freight);

    void removeFreight(String freight);

}
