package br.com.azship.admshipping.infra.repository.mongo;

import br.com.azship.admshipping.domain.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.infra.entity.FreightEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoFreightRepository implements FreightRepository {

    private final SpringDataMongoFreightRepository mongoFreightRepository;

    public MongoFreightRepository(SpringDataMongoFreightRepository mongoFreightRepository) {
        this.mongoFreightRepository = mongoFreightRepository;
    }


    @Override
    public Optional<Freight> findByValue(Object value) {
        return Optional.empty();
    }

    @Override
    public Optional<Freight> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Freight save(Freight freight) {

        FreightEntity freightEntity = mongoFreightRepository.save(new FreightEntity(freight));

        return FreightEntity.toFreight(freightEntity);

    }

    @Override
    public Freight update(Freight freight) {
        return null;
    }

    @Override
    public void remove(String freight) {

    }
}
