package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.FreighRequestDomainDTO;
import br.com.azship.admshipping.domain.Freight;

import java.util.Map;
import java.util.UUID;

public record FreighRequestDTO(

        String client_id,
        Map<String, Object> propriedades

) {

    public static FreighRequestDomainDTO toFreighRequestDomainDTO(FreighRequestDTO freighRequestDTO) {

        return new FreighRequestDomainDTO(freighRequestDTO.client_id(), freighRequestDTO.propriedades);

    }

}
