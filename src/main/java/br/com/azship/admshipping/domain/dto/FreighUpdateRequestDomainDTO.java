package br.com.azship.admshipping.domain.dto;

import java.util.Map;

public record FreighUpdateRequestDomainDTO(
        String frete_id,
        Map<String, Object> propriedades
){

}
