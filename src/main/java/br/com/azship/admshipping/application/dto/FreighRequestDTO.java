package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.dto.FreighRequestDomainDTO;

import java.util.Map;

public record FreighRequestDTO(

        String client_id,
        Map<String, Object> propriedades

) {

    public static FreighRequestDomainDTO toFreighRequestDomainDTO(FreighRequestDTO freighRequestDTO) {

        return new FreighRequestDomainDTO(freighRequestDTO.client_id(), freighRequestDTO.propriedades);

    }

}
