package no.ensurance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
    
    @Value("${integrasjonslag.url}")
    private String integrasjonslagUrl;

    @Autowired
    public Configuration() {}

    public String getUrl() {
        return integrasjonslagUrl;
    }
}
