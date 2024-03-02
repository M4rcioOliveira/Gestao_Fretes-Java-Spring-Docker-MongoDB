package br.com.azship.admshipping.application.service;

import br.com.azship.admshipping.application.port.in.CreateShippingUseCase;
import br.com.azship.admshipping.application.port.in.GetShippingByValueUseCase;
import br.com.azship.admshipping.application.port.in.RemoveShippingByIdUseCase;
import br.com.azship.admshipping.application.port.in.UpdateShippingUseCase;
import br.com.azship.admshipping.application.port.out.GetShippingByValuePort;
import br.com.azship.admshipping.application.port.out.RemoveShippingByIdPort;
import br.com.azship.admshipping.application.port.out.SaveShippingPort;
import br.com.azship.admshipping.application.port.out.UpdateShippingPort;

import java.util.UUID;

public class ShippingService implements CreateShippingUseCase, GetShippingByValueUseCase, RemoveShippingByIdUseCase, UpdateShippingUseCase {

    private final GetShippingByValuePort getShippingByValuePort;
    private final RemoveShippingByIdPort removeShippingByIdPort;
    private final SaveShippingPort saveShippingPort;
    private final UpdateShippingPort updateShippingPort;

    public ShippingService(GetShippingByValuePort getShippingByValuePort, RemoveShippingByIdPort removeShippingByIdPort, SaveShippingPort saveShippingPort, UpdateShippingPort updateShippingPort) {
        this.getShippingByValuePort = getShippingByValuePort;
        this.removeShippingByIdPort = removeShippingByIdPort;
        this.saveShippingPort = saveShippingPort;
        this.updateShippingPort = updateShippingPort;
    }

    @Override
    public void create() {

    }

    @Override
    public void get(Object value) {

    }

    @Override
    public void remove(UUID id) {

    }

    @Override
    public void update() {

    }
}