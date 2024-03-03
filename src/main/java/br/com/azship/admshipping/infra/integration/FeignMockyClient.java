package br.com.azship.admshipping.infra.integration;

import br.com.azship.admshipping.infra.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "mock", url = "https://run.mocky.io/v3/a555beae-07cf-4b02-a232-f14f284f35f0")
public interface FeignMockyClient {

    @GetMapping
    List<ClientDTO> getClients();

}
