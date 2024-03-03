package br.com.azship.admshipping.infra.repository.mongo;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.infra.entity.FreightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataMongoFreightRepository extends MongoRepository<FreightEntity, String> {

    Page<FreightEntity> findByPropriedadesJsonRegex(String value, Pageable pageable);

}
