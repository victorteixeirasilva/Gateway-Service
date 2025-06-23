package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.exception.DashboardServiceException;
import tech.inovasoft.inevolving.api.domain.exception.EmailServiceException;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.dto.ResponseDashbordDTO;
import tech.inovasoft.inevolving.api.service.client.email_service.EmailServiceClient;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;

@Service
public class EmailService {

    @Autowired
    private EmailServiceClient emailServiceClient;

    public String sendEmail(EmailRequest dto) {
        ResponseEntity<String> response =
                emailServiceClient.sendEmail(dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new EmailServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (email-service), during operation " +
                            "(emailServiceClient.sendEmail(dto ("+dto+"))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new EmailServiceException(
                    "Error (FORBIDDEN) in micro service (email-service), during operation " +
                            "(emailServiceClient.sendEmail(dto ("+dto+"))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new EmailServiceException(
                    "Error (NOT_FOUND) in micro service (email-service), during operation " +
                            "(emailServiceClient.sendEmail(dto ("+dto+"))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
