package br.com.azship.admshipping.application.rest;

import br.com.azship.admshipping.application.dto.SaveFreightDTO;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.service.FreightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/freight")
public class FreightController {

    private final FreightService freightService;

    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @PostMapping("/register")
    public ResponseEntity<Freight> saveFreight(@RequestBody SaveFreightDTO freightDTO) {

        Freight body = freightService.saveFreight(SaveFreightDTO.toFreight(freightDTO));

        return new ResponseEntity<>(body, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Freight> findFreightById(@PathVariable String id) {

        Freight body = freightService.findFreightById(id);

        return new ResponseEntity<>(body, HttpStatus.OK);

    }


}
