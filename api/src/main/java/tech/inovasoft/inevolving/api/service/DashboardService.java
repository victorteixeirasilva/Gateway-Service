package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.exception.DashboardServiceException;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.DashboardServiceClient;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.dto.ResponseDashbordDTO;

import java.util.UUID;

@Service
public class DashboardService {

    @Autowired
    private DashboardServiceClient dashboardServiceClient;

    public ResponseDashbordDTO getDashboard(UUID idUser) {
        ResponseEntity<ResponseDashbordDTO> response =
                dashboardServiceClient.getDashboard(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new DashboardServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (dashboard-service), during operation " +
                            "(dashboardServiceClient.getDashboard(idUser ("+idUser+"))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new DashboardServiceException(
                    "Error (FORBIDDEN) in micro service (dashboard-service), during operation " +
                            "(dashboardServiceClient.getDashboard(idUser ("+idUser+"))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new DashboardServiceException(
                    "Error (NOT_FOUND) in micro service (dashboard-service), during operation " +
                            "(dashboardServiceClient.getDashboard(idUser ("+idUser+"))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
