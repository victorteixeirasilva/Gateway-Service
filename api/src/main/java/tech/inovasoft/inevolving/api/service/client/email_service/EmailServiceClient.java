package tech.inovasoft.inevolving.api.service.client.email_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.dto.ResponseDashbordDTO;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "email-service", url = "http://localhost:8092/ms/email")
public interface EmailServiceClient {

    @PostMapping
    ResponseEntity<String> sendEmail(@RequestBody EmailRequest request);

}
