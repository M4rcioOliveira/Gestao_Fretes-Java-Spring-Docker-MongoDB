package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.dto.FreighUpdateRequestDomainDTO;

import java.util.Map;

public record FreighUpdateRequestDTO(
        String frete_id,
        Map<String, Object> propriedades

) {

    public static FreighUpdateRequestDomainDTO toFreighUpdateRequestDomainDTO(FreighUpdateRequestDTO freighUpdateRequestDTO){
        return new FreighUpdateRequestDomainDTO(freighUpdateRequestDTO.frete_id, freighUpdateRequestDTO.propriedades);
    }

}
