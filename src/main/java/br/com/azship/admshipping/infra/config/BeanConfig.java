package br.com.azship.admshipping.infra.config;

import br.com.azship.admshipping.AdmShippingApplication;
import br.com.azship.admshipping.domain.integration.ClientIntegration;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.domain.service.ClientService;
import br.com.azship.admshipping.domain.service.ClientServiceImpl;
import br.com.azship.admshipping.domain.service.FreightService;
import br.com.azship.admshipping.domain.service.FreightServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AdmShippingApplication.class)
public class BeanConfig {

    @Bean
    FreightService freightService(final FreightRepository freightRepository, final ClientService clientService){
        return new FreightServiceImpl(freightRepository, clientService);
    }

    @Bean
    ClientService clientService(final ClientIntegration clientIntegration){
        return new ClientServiceImpl(clientIntegration);
    }

}
