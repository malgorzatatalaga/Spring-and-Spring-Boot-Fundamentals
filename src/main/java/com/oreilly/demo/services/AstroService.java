package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroService {
    private final RestTemplate restTemplate;

    @Autowired
    public AstroService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public AstroResult getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return restTemplate.getForObject(url, AstroResult.class);
    }
}
