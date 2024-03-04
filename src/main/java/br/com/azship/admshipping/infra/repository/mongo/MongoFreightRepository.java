package br.com.azship.admshipping.infra.repository.mongo;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;
import br.com.azship.admshipping.infra.dto.ClientDTO;
import br.com.azship.admshipping.infra.entity.FreightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MongoFreightRepository implements FreightRepository {

    private final MongoTemplate mongoTemplate;

    private final SpringDataMongoFreightRepository mongoFreightRepository;

    public MongoFreightRepository(MongoTemplate mongoTemplate, SpringDataMongoFreightRepository mongoFreightRepository) {
        this.mongoTemplate = mongoTemplate;
        this.mongoFreightRepository = mongoFreightRepository;
    }


    @Override
    public DomainPage<Freight> findAllBy(String value, DomainPageable domainPageable) {

//        Pageable pageable = PageRequest.of(domainPageable.getPage(), domainPageable.getSize());
//
//        Query query = new Query();
//        query.addCriteria(Criteria.where("propriedadesJson").regex(".*" + value + ".*")).with(pageable);
//        List<FreightEntity> freights = mongoTemplate.find(query, FreightEntity.class);
//
//        int totalPages;
//        int totalElements;
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//
//        return  freights.stream().map(f -> new Freight(f.getId(), ClientDTO.toClient(f.getCliente()), f.getPropriedades())).toList();

        Pageable pageable = PageRequest.of(domainPageable.pageNumber(), domainPageable.pageSize());

        Page<FreightEntity> pageFreights = mongoFreightRepository.findByPropriedadesJsonRegex(value, pageable);

        List<FreightEntity> freights = pageFreights.getContent();

        int totalPages = pageFreights.getTotalPages();
        long totalElements = pageFreights.getTotalElements();
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();

        var list = freights.stream().map(f -> new Freight(f.getId(), ClientDTO.toClient(f.getCliente()), f.getPropriedades())).toList();

        return new DomainPage<Freight>(list, totalPages, totalElements, pageSize, pageNumber);

    }

    @Override
    public Freight findById(String id) {

        FreightEntity freight = mongoFreightRepository.findById(id).orElseThrow(() -> new RuntimeException("Frete não encontrado!"));

        return FreightEntity.toFreight(freight);
    }

    @Override
    public DomainPage<Freight> findByCnpj(String Cnpj) {
        return null;
    }


    @Override
    public Freight save(Freight freight) {

        FreightEntity freightEntity = mongoFreightRepository.save(new FreightEntity(freight));

        return FreightEntity.toFreight(freightEntity);

    }

    @Override
    public Freight update(Freight freight) {

        FreightEntity freightEntity = mongoFreightRepository.save(new FreightEntity(freight));

        return FreightEntity.toFreight(freightEntity);

    }

    @Override
    public void remove(String id) {

        mongoFreightRepository.deleteById(id);

    }
}
