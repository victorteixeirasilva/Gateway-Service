package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.RequestDreamDTO;
import tech.inovasoft.inevolving.api.domain.dto.request.RequestDreams;
import tech.inovasoft.inevolving.api.domain.exception.DashboardServiceException;
import tech.inovasoft.inevolving.api.service.client.finance_service.dto.FinancePlanning;
import tech.inovasoft.inevolving.api.service.client.motivation_service.MotivationServiceClient;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.*;

import java.util.List;
import java.util.UUID;

@Service
public class MotivationService {

    @Autowired
    private MotivationServiceClient motivationServiceClient;

    public Dreams addDream(UUID idUser, RequestDreamDTO dto) {
        ResponseEntity<Dreams> response =
                motivationServiceClient.addDream(new DreamRequestDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (motivation-service), during operation (motivationServiceClient.addDream).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (motivation-service), during operation (motivationServiceClient.addDream).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (motivation-service), during operation (motivationServiceClient.addDream).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Dreams updateDream(UUID idUser, RequestDreams dto) {
        ResponseEntity<Dreams> response =
                motivationServiceClient.updateDream(new Dreams(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (motivation-service), during operation (motivationServiceClient.updateDream).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (motivation-service), during operation (motivationServiceClient.updateDream).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (motivation-service), during operation (motivationServiceClient.updateDream).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Dreams> getDreamsByUserId(UUID idUser) {
        ResponseEntity<List<Dreams>> response =
                motivationServiceClient.getDreamsByUserId(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (motivation-service), during operation (motivationServiceClient.getDreamsByUserId).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (motivation-service), during operation (motivationServiceClient.getDreamsByUserId).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (motivation-service), during operation (motivationServiceClient.getDreamsByUserId).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Dreams getDreamByID(UUID idUser, UUID idDream) {
        ResponseEntity<Dreams> response =
                motivationServiceClient.getDreamByID(idDream,idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (motivation-service), during operation (motivationServiceClient.getDreamByID).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (motivation-service), during operation (motivationServiceClient.getDreamByID).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (motivation-service), during operation (motivationServiceClient.getDreamByID).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseVisionBord generateVisionBordByUserId(UUID idUser) {
        ResponseEntity<ResponseVisionBord> response =
                motivationServiceClient.generateVisionBordByUserId(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (motivation-service), during operation " +
                            "(motivationServiceClient.generateVisionBordByUserId).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (motivation-service), during operation " +
                            "(motivationServiceClient.generateVisionBordByUserId).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (motivation-service), during operation " +
                            "(motivationServiceClient.generateVisionBordByUserId).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseDeleteDream deleteDream(UUID idUser, UUID idDream) {
        ResponseEntity<ResponseDeleteDream> response =
                motivationServiceClient.deleteDream(new RequestDeleteDream(idDream, idUser));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (motivation-service), during operation " +
                            "(motivationServiceClient.deleteDream).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (motivation-service), during operation " +
                            "(motivationServiceClient.deleteDream).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (motivation-service), during operation " +
                            "(motivationServiceClient.deleteDream).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
