package br.com.azship.admshipping.infra.repository.mongo;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.exception.FreightNotFoundException;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.domain.custom.DomainPage;
import br.com.azship.admshipping.domain.custom.DomainPageable;
import br.com.azship.admshipping.infra.dto.ClientDTO;
import br.com.azship.admshipping.infra.entity.FreightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoFreightRepository implements FreightRepository {


    private final SpringDataMongoFreightRepository mongoFreightRepository;

    public MongoFreightRepository(SpringDataMongoFreightRepository mongoFreightRepository) {
        this.mongoFreightRepository = mongoFreightRepository;
    }


    @Override
    public DomainPage<Freight> findAllBy(String value, DomainPageable domainPageable) {

        Pageable pageable = PageRequest.of(domainPageable.pageNumber(), domainPageable.pageSize());

        Page<FreightEntity> pageFreights = mongoFreightRepository.findByPropriedadesJsonRegex(value, pageable);

        Result result = getResult(pageFreights, pageable);

        return getFreightDomainPage(result);

    }

    @Override
    public Freight findById(String id) {

        FreightEntity freight = mongoFreightRepository.findById(id).orElseThrow(() -> new FreightNotFoundException("Frete [" + id +"] não encontrado."));

        return FreightEntity.toFreight(freight);
    }

    @Override
    public DomainPage<Freight> findByCnpj(String cnpj, DomainPageable domainPageable) {

        Pageable pageable = PageRequest.of(domainPageable.pageNumber(), domainPageable.pageSize());

        Page<FreightEntity> pageFreights = mongoFreightRepository.findByClienteCnpjRegex(cnpj, pageable);

        Result result = getResult(pageFreights, pageable);

        return getFreightDomainPage(result);
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

    //Auxiliares

    private static Result getResult(Page<FreightEntity> pageFreights, Pageable pageable) {
        List<FreightEntity> freightsEntity = pageFreights.getContent();

        int totalPages = pageFreights.getTotalPages();
        long totalElements = pageFreights.getTotalElements();
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();

        List<Freight> freights = freightsEntity.stream().map(f -> new Freight(f.getId(), ClientDTO.toClient(f.getCliente()), f.getPropriedades())).toList();
        return new Result(totalPages, totalElements, pageSize, pageNumber, freights);

    }

    private record Result(int totalPages, long totalElements, int pageSize, int pageNumber, List<Freight> freights) {
    }

    private static DomainPage<Freight> getFreightDomainPage(Result result) {
        return new DomainPage<>(result.freights(), result.totalPages(), result.totalElements(), result.pageSize(), result.pageNumber());
    }
}
