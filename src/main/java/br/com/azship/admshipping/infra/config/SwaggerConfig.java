package br.com.azship.admshipping.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL in Development environment");


        Contact contact = new Contact();
        contact.setEmail("developer@azship.com.br");
        contact.setName("AZShip");
        contact.setUrl("https://azship.com.br");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("adm-azs-shipping")
                .version("1.0")
                .contact(contact)
                .description("Gestão de Fretes").termsOfService("https://azship.com.br")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}
