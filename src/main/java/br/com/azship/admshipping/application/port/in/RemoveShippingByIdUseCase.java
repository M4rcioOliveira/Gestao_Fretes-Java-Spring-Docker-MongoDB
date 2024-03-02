package br.com.azship.admshipping.application.port.in;

import java.util.UUID;

public interface RemoveShippingByIdUseCase {

    void remove(UUID id);

}
