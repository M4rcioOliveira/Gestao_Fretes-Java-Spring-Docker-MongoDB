package br.com.azship.admshipping.domain.repository;

import br.com.azship.admshipping.domain.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;

import java.util.Optional;
import java.util.UUID;

public interface FreightRepository {

    Optional<Freight> findByValue(Object value);

    Optional<Freight> findById(String id);

    Freight save(Freight freight);

    Freight update(Freight freight);

    void remove(String freight);


}
