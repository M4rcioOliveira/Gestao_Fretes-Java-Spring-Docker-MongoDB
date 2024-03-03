package br.com.azship.admshipping.domain.dto;

import java.util.Map;

public record FreighRequestDomainDTO(
        String client_id,
        Map<String, Object> propriedades
){

}
