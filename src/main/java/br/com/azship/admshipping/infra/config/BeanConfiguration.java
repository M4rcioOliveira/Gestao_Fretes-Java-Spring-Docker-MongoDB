package br.com.azship.admshipping.infra.config;

import br.com.azship.admshipping.AdmShippingApplication;
import br.com.azship.admshipping.domain.Freight;
import br.com.azship.admshipping.domain.repository.FreightRepository;
import br.com.azship.admshipping.domain.service.FreightService;
import br.com.azship.admshipping.domain.service.FreightServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AdmShippingApplication.class)
public class BeanConfiguration {

    @Bean
    FreightService freightService(final FreightRepository freightRepository){
        return new FreightServiceImpl(freightRepository);
    }

}
