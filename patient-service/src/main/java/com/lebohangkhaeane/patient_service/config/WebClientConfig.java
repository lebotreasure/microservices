package com.lebohangkhaeane.patient_service.config;

import com.lebohangkhaeane.patient_service.client.AppointmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient appointmentWebClient() {
        return WebClient.builder()
                .baseUrl("http://appointment-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public AppointmentClient appointmentClient() {
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(appointmentWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(AppointmentClient.class);
    }
}
