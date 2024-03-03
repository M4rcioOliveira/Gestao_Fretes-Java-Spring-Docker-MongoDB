package br.com.azship.admshipping.infra.repository.mongo;

import br.com.azship.admshipping.infra.entity.FreightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoFreightRepository extends MongoRepository<FreightEntity, String> {
}
