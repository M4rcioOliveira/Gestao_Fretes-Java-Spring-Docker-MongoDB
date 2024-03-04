package br.com.azship.admshipping.domain.repository;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;

public interface FreightRepository {

    DomainPage<Freight> findAllBy(String value, DomainPageable domainPageable);

    Freight findById(String id);

    DomainPage<Freight> findByCnpj(String cnpj, DomainPageable domainPageable);

    Freight save(Freight freight);

    Freight update(Freight freight);

    void remove(String id);

}
