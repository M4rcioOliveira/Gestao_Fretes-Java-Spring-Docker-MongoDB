package br.com.azship.admshipping.adapters.config;

import br.com.azship.admshipping.AdmShippingApplication;
import br.com.azship.admshipping.adapters.persistence.ShippingRepository;
import br.com.azship.admshipping.application.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AdmShippingApplication.class)
public class BeanConfiguration {

    @Bean
    ShippingService shippingService(ShippingRepository repository){

       return new ShippingService(repository,repository, repository, repository);
    }

}
