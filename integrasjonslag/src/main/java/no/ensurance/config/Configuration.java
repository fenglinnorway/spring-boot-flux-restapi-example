package no.ensurance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
    
    @Value("${fagssytem.url}")
    private String integrasjonslagUrl;

    @Value("${brevtjeneste.url}")
    private String brevtjenesteUrl;

    public String getIntegrationUrl() {
        return integrasjonslagUrl;
    }
    @Autowired
    public Configuration() {}


    public String getBrevtjenesteUrl() {
        return integrasjonslagUrl;
    }
}
