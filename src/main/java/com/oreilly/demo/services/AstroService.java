package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {
    private final RestTemplate restTemplate;
    private final WebClient client;

    @Autowired
    public AstroService(RestTemplateBuilder restTemplateBuilder,
                        WebClient.Builder webfluxBuilder) {
        restTemplate = restTemplateBuilder.build();
        client = webfluxBuilder.baseUrl("http://api.open-notify.org").build();
    }

    public AstroResult getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return restTemplate.getForObject(url, AstroResult.class);
    }

    public AstroResult getAstronautsWebFlux() {
        return client.get()
                .uri("astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}
