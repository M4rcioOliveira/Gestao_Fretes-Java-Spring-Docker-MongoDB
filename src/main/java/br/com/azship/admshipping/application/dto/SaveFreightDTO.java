package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.Freight;

import java.util.Map;
import java.util.UUID;

public record SaveFreightDTO(

        UUID id,
        Map<String, Object> propriedades

) {

    public static Freight toFreight(SaveFreightDTO freightDTO) {

        return new Freight(UUID.randomUUID().toString(), freightDTO.propriedades);

    }

}
