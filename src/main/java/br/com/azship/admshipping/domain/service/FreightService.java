package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.Freight;

import java.util.UUID;

public interface FreightService {

    Freight findFreightByValue(Object value);

    Freight findFreightById(String id);

    Freight saveFreight(Freight freight);

    Freight updateFreight(Freight freight);

    void removeFreight(String freight);

}
