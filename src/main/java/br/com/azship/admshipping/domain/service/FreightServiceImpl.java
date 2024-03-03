package br.com.azship.admshipping.domain.service;

import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;

import java.util.UUID;

public class FreightServiceImpl implements FreightService{

    private final FreightRepository freightRepository;

    public FreightServiceImpl(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }


    @Override
    public Freight findFreightByValue(Object value) {
        return null;
    }

    @Override
    public Freight findFreightById(String id) {
        return freightRepository.findById(id).orElseThrow(() -> new RuntimeException("Frete não encontrado"));
    }

    @Override
    public Freight saveFreight(Freight freight) {
        return freightRepository.save(freight);
    }

    @Override
    public Freight updateFreight(Freight freight) {
        return null;
    }

    @Override
    public void removeFreight(String freight) {

    }
}
