package br.com.azship.admshipping.domain;

import java.util.Map;

public record FreighResponseDomainDTO(
        String frete_id,
        Client cliente,
        Map<String, Object> propriedades
){
}
