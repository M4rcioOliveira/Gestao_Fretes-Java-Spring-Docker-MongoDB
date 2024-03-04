package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.dto.FreighRegistryRequestDomainDTO;

import java.util.Map;

public record FreighRegistryRequestDTO(

        String client_id,
        Map<String, Object> propriedades

) {

    public static FreighRegistryRequestDomainDTO toFreighRegistryRequestDomainDTO(FreighRegistryRequestDTO freighRegistryRequestDTO) {

        return new FreighRegistryRequestDomainDTO(freighRegistryRequestDTO.client_id(), freighRegistryRequestDTO.propriedades);

    }

}
