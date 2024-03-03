package br.com.azship.admshipping.application.dto;

public record AppPageDTO(

        int totalPages,
        long totalElements,
        int pageSize,
        int pageNumber

){
}
