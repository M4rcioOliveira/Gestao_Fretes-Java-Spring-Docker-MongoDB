package br.com.azship.admshipping.domain.dto;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.Freight;

import java.util.Map;

public record FreighResponseDomainDTO(
        String frete_id,
        Client cliente,
        Map<String, Object> propriedades
) {

    public static Freight toFreight(FreighResponseDomainDTO dto){
        return new Freight(dto.frete_id(), dto.cliente, dto.propriedades);
    }

    public FreighResponseDomainDTO(Freight freight) {
        this(freight.getId(), freight.getClient(), freight.getPropriedades());
    }



}
