package br.com.azship.admshipping.application.rest;

import br.com.azship.admshipping.application.dto.AppPageDTO;
import br.com.azship.admshipping.application.dto.ApiResponseDTO;
import br.com.azship.admshipping.application.dto.FreighRequestDTO;
import br.com.azship.admshipping.application.dto.FreighResponseDTO;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.service.FreightService;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/freight")
public class FreightController {

    private final FreightService freightService;

    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO<FreighResponseDTO>> saveFreight(@RequestBody FreighRequestDTO freighRequestDTO) {

        FreighResponseDomainDTO body = freightService.saveFreight(FreighRequestDTO.toFreighRequestDomainDTO(freighRequestDTO));

        return new ResponseEntity<>(new ApiResponseDTO<>(new FreighResponseDTO(body), null), HttpStatus.CREATED);

    }

    @GetMapping("/{value}")
    public ResponseEntity<ApiResponseDTO<List<FreighResponseDomainDTO>>> findAllBy(@PathVariable String value, @PageableDefault(size = 10, page = 0) Pageable pageable) {

        DomainPage<FreighResponseDomainDTO> domain = freightService.findAllBy(value, new DomainPageable(pageable.getPageSize(), pageable.getPageNumber()));

        List<FreighResponseDomainDTO> content = domain.content();

        ApiResponseDTO<List<FreighResponseDomainDTO>> dto = new ApiResponseDTO<>(content, new AppPageDTO(domain.totalPages(), domain.totalElements(), domain.pageSize(), domain.pageNumber()));

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }


}
