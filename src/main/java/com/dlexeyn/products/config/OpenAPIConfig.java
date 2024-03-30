package com.dlexeyn.products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${dlexeyn.openapi.dev-url}")
    private String devURL;

    @Bean
    public OpenAPI openAPI(){
        Server devServer = new Server();
        devServer.setUrl(devURL);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("galenko.aleksej17@gmail.com");
        contact.setName("dlexeyn");

        License mitLicense = new License().name("MIT License");

        Info info = new Info()
                .title("Products API")
                .version("1.0")
                .contact(contact)
                .description("This API provides endpoints to manage products in a product warehouse for a test job from MediaSoft.")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
