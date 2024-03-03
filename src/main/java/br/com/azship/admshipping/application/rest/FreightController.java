package br.com.azship.admshipping.application.rest;

import br.com.azship.admshipping.application.dto.FreighRequestDTO;
import br.com.azship.admshipping.domain.FreighResponseDomainDTO;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.service.FreightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/freight")
public class FreightController {

    private final FreightService freightService;

    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @PostMapping("/register")
    public ResponseEntity<FreighResponseDomainDTO> saveFreight(@RequestBody FreighRequestDTO freighRequestDTO) {

        FreighResponseDomainDTO body = freightService.saveFreight(FreighRequestDTO.toFreighRequestDomainDTO(freighRequestDTO));

        return new ResponseEntity<>(body, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Freight> findFreightById(@PathVariable String id) {

        return null;

    }


}
