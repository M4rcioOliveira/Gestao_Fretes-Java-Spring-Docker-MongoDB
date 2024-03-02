package br.com.azship.admshipping.application.port.out;

import java.util.UUID;

public interface RemoveShippingByIdPort {

    void remove(UUID id);

}
