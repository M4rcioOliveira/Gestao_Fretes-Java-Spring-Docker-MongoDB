package br.com.azship.admshipping.domain.repository;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;

import java.util.Optional;

public interface FreightRepository {

    DomainPage<Freight> findAllBy(String value, DomainPageable domainPageable);

    Optional<Freight> findById(String id);

    Freight save(Freight freight);

    Freight update(Freight freight);

    void remove(String freight);


}
