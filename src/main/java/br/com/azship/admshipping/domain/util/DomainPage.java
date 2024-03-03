package br.com.azship.admshipping.domain.util;

import java.util.List;

public record DomainPage<T>(
        List<T> content,
        int totalPages,
        long totalElements,
        int pageSize,
        int pageNumber

) {
}
