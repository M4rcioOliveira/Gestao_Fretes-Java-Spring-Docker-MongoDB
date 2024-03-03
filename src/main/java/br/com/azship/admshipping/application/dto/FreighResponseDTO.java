package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.Client;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;

import java.util.Map;

public record FreighResponseDTO(
        String frete_id,
        Client cliente,
        Map<String, Object> propriedades

) {

    public FreighResponseDTO (FreighResponseDomainDTO responseDomainDTO){
        this(responseDomainDTO.frete_id(), responseDomainDTO.cliente(), responseDomainDTO.propriedades());
    }
}
