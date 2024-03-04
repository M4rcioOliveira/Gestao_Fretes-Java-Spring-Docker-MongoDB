package br.com.azship.admshipping.application.rest;

import br.com.azship.admshipping.application.dto.*;
import br.com.azship.admshipping.domain.dto.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.service.FreightService;
import br.com.azship.admshipping.domain.util.DomainPage;
import br.com.azship.admshipping.domain.util.DomainPageable;
import jakarta.validation.Valid;
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
    public ResponseEntity<ApiResponseDTO<FreighResponseDTO>> registerFreight(@Valid  @RequestBody FreighRegistryRequestDTO freighRegistryRequestDTO) {

        FreighResponseDomainDTO body = freightService.registerFreight(FreighRegistryRequestDTO.toFreighRegistryRequestDomainDTO(freighRegistryRequestDTO));

        return new ResponseEntity<>(new ApiResponseDTO<>(new FreighResponseDTO(body), null), HttpStatus.CREATED);

    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponseDTO<FreighResponseDTO>> updateFreight(@Valid @RequestBody FreighUpdateRequestDTO freighUpdateRequestDTO) {

        FreighResponseDomainDTO body = freightService.updateFreight(FreighUpdateRequestDTO.toFreighUpdateRequestDomainDTO(freighUpdateRequestDTO));

        return new ResponseEntity<>(new ApiResponseDTO<>(new FreighResponseDTO(body), null), HttpStatus.OK);

    }


    @GetMapping("/propriedade")
    public ResponseEntity<ApiResponseDTO<List<FreighResponseDomainDTO>>> findAllBy(@RequestParam String value, @PageableDefault(size = 10, page = 0) Pageable pageable) {

        DomainPage<FreighResponseDomainDTO> domain = freightService.findAllBy(value, new DomainPageable(pageable.getPageSize(), pageable.getPageNumber()));

        List<FreighResponseDomainDTO> content = domain.content();

        ApiResponseDTO<List<FreighResponseDomainDTO>> body = new ApiResponseDTO<>(content, new AppPageDTO(domain.totalPages(), domain.totalElements(), domain.pageSize(), domain.pageNumber()));

        return new ResponseEntity<>(body, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<FreighResponseDTO>> findByID(@PathVariable String id) {

        FreighResponseDomainDTO body = freightService.findFreightById(id);

        return new ResponseEntity<>(new ApiResponseDTO<>(new FreighResponseDTO(body), null), HttpStatus.OK);

    }

    @GetMapping("/documento")
    public ResponseEntity<ApiResponseDTO<List<FreighResponseDomainDTO>>> findByCnpj(@RequestParam String cnpj, @PageableDefault(size = 10, page = 0) Pageable pageable) {

        DomainPage<FreighResponseDomainDTO> domain = freightService.findFreightByCnpj(cnpj, new DomainPageable(pageable.getPageSize(), pageable.getPageNumber()));

        List<FreighResponseDomainDTO> content = domain.content();

        ApiResponseDTO<List<FreighResponseDomainDTO>> body = new ApiResponseDTO<>(content, new AppPageDTO(domain.totalPages(), domain.totalElements(), domain.pageSize(), domain.pageNumber()));

        return new ResponseEntity<>(body, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<FreighResponseDTO>> remove(@PathVariable String id) {

        freightService.removeFreight(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }


}
