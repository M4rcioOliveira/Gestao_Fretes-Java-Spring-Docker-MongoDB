package br.com.azship.admshipping.infra.integration;

import br.com.azship.admshipping.infra.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "mock", url = "https://run.mocky.io/v3/11929995-fd80-4d4d-8944-ad72ea9e3501")
public interface FeignMockyClient {

    @GetMapping
    List<ClientDTO> getClients();

}
