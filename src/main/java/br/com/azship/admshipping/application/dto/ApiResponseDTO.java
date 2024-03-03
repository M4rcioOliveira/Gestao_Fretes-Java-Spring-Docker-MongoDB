package br.com.azship.admshipping.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ApiResponseDTO<T>(

        T data,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        AppPageDTO pagination

) {
}
