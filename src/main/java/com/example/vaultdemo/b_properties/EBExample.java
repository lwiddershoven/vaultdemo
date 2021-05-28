package com.example.vaultdemo.b_properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

public class EBExample {
}

// Structure

@Data
@Configuration
@ConfigurationProperties("eb.financial.percentage")
class EBConfiguration {
    private double margin = 1.10;
    private Vat vat = new Vat(1.21, 1.06);

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Vat {
        double high;
        double low;
    }
}

@Data
@Configuration
@ConfigurationProperties("eb.request.config")
class EBRequestConfigConfiguration {
    String scheme;
    String host;
    int port;
    String path;

    Duration connectTimeout; // format: PT1.5S == 1500  = 1.5s
    Duration requestTimeout;

    @Data
    static class Proxy {
        boolean enabled = false;
        String host;
        int port;
    }

    // Example Usage
//    final HttpGet httpget = new HttpGet(protocol + "://" + host + ":" + port + "/" + path);
//    final RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
//            .setConnectionRequestTimeout( requestTimeout )
//            .setConnectTimeout( connectTimeout )
//            .setProxy(new HttpHost(proxy.host, proxy.port))
//            .build();
//            httpget.setConfig(requestConfig);

}