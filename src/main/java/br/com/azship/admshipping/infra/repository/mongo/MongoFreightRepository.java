package br.com.azship.admshipping.infra.repository.mongo;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.infra.entity.FreightEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoFreightRepository implements FreightRepository {

    private final SpringDataMongoFreightRepository freightRepository;

    public MongoFreightRepository(SpringDataMongoFreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    @Override
    public Optional<Freight> findByValue(final Object value) {
        return Optional.empty();
    }

    @Override
    public Optional<Freight> findById(final String id) {

        Optional<FreightEntity> freightEntity = freightRepository.findById(id);

        return freightEntity.map(FreightEntity::toFreight);

    }

    @Override
    public Freight save(final Freight freight) {
        return FreightEntity.toFreight(freightRepository.save(new FreightEntity(freight)));
    }

    @Override
    public Freight update(final Freight freight) {
        return null;
    }

    @Override
    public void remove(final String freight) {

    }
}