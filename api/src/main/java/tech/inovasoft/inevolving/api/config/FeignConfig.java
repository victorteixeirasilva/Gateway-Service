package tech.inovasoft.inevolving.api.config;

import feign.Request;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.cloud.openfeign.support.SpringEncoder;


@Configuration
public class FeignConfig {

    @Bean
    public HttpMessageConverters messageConverters() {
        return new HttpMessageConverters();
    }

    @Bean
    public Encoder feignEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringEncoder(converters);
    }

    @Bean
    public Request.Options requestOptions() {
        // 10 minutos de timeout (600000 ms)
        return new Request.Options(60000, 600000);
    }

}
