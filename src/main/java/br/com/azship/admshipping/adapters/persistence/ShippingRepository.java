package br.com.azship.admshipping.adapters.persistence;

import br.com.azship.admshipping.application.port.out.GetShippingByValuePort;
import br.com.azship.admshipping.application.port.out.RemoveShippingByIdPort;
import br.com.azship.admshipping.application.port.out.SaveShippingPort;
import br.com.azship.admshipping.application.port.out.UpdateShippingPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShippingRepository implements GetShippingByValuePort, RemoveShippingByIdPort, SaveShippingPort, UpdateShippingPort {
    @Override
    public void get(Object value) {

    }

    @Override
    public void remove(UUID id) {

    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }
}
