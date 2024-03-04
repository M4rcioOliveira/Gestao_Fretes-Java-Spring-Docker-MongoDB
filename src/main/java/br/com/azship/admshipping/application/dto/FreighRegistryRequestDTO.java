package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.dto.FreighRegistryRequestDomainDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record FreighRegistryRequestDTO(

        @NotBlank(message = "Informe um client_id")
        String client_id,
        @NotEmpty(message = "Informe no mínimo uma propriedade")
        Map<String, Object> propriedades

) {

    public static FreighRegistryRequestDomainDTO toFreighRegistryRequestDomainDTO(FreighRegistryRequestDTO freighRegistryRequestDTO) {

        return new FreighRegistryRequestDomainDTO(freighRegistryRequestDTO.client_id(), freighRegistryRequestDTO.propriedades);

    }

}
