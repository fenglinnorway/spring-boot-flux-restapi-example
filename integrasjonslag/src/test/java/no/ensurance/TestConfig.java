package no.ensurance;

import static org.mockito.Mockito.mock;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import no.ensurance.client.EmailClient;
import no.ensurance.client.FagsystemClient;

@Configuration
@ComponentScan(basePackages = "no.ensurance")
public class TestConfig {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}