package br.com.azship.admshipping.application.dto;

import br.com.azship.admshipping.domain.dto.FreighUpdateRequestDomainDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record FreighUpdateRequestDTO(

        @NotBlank(message = "Informe um frete_id")
        String frete_id,
        @NotEmpty(message = "Informe no mínimo uma propriedade")
        Map<String, Object> propriedades

) {

    public static FreighUpdateRequestDomainDTO toFreighUpdateRequestDomainDTO(FreighUpdateRequestDTO freighUpdateRequestDTO){
        return new FreighUpdateRequestDomainDTO(freighUpdateRequestDTO.frete_id, freighUpdateRequestDTO.propriedades);
    }

}
