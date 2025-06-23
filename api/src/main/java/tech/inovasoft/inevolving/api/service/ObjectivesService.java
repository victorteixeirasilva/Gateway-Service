package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.CreateObjectiveDTO;
import tech.inovasoft.inevolving.api.domain.exception.DashboardServiceException;
import tech.inovasoft.inevolving.api.domain.exception.ObjectivesServiceException;
import tech.inovasoft.inevolving.api.service.client.objectives_service.ObjectivesServiceClient;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.Objective;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.RequestCreateObjectiveDTO;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.ResponseMessageDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ObjectivesService {

    @Autowired
    private ObjectivesServiceClient objectivesServiceClient;

    public Objective add(UUID idUser, CreateObjectiveDTO dto) {
        ResponseEntity<Objective> response =
                objectivesServiceClient.add(new RequestCreateObjectiveDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(add(new RequestCreateObjectiveDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                    "(add(new RequestCreateObjectiveDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                    "(add(new RequestCreateObjectiveDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Objective update(UUID idObjective, UUID idUser, CreateObjectiveDTO dto) {
        ResponseEntity<Objective> response =
                objectivesServiceClient.update(idObjective, idUser, new RequestCreateObjectiveDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.update(idObjective(" + idObjective + "), idUser(" + idUser + "), " +
                    "new RequestCreateObjectiveDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.update(idObjective(" + idObjective + "), idUser(" + idUser + "), " +
                    "new RequestCreateObjectiveDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.update(idObjective(" + idObjective + "), idUser(" + idUser + "), " +
                    "new RequestCreateObjectiveDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseMessageDTO completeObjective(UUID idUser, UUID idObjective, LocalDate conclusionDate) {
        ResponseEntity<ResponseMessageDTO> response =
                objectivesServiceClient.completeObjective(idObjective, conclusionDate, idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.completeObjective(idObjective(" + idObjective + "), conclusionDate(" + conclusionDate + "), idUser(" + idUser + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                            "(objectivesServiceClient.completeObjective(idObjective(" + idObjective + "), conclusionDate(" + conclusionDate + "), idUser(" + idUser + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                            "(objectivesServiceClient.completeObjective(idObjective(" + idObjective + "), conclusionDate(" + conclusionDate + "), idUser(" + idUser + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Objective getObjectiveById(UUID idUser, UUID idObjective) {
        ResponseEntity<Objective> response =
                objectivesServiceClient.getObjectiveById(idObjective, idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectiveById(idObjective(" + idObjective + "), idUser(" + idUser + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectiveById(idObjective(" + idObjective + "), idUser(" + idUser + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectiveById(idObjective(" + idObjective + "), idUser(" + idUser + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Objective> getObjectivesByIdUser(UUID idUser) {
        ResponseEntity<List<Objective>> response =
                objectivesServiceClient.getObjectivesByIdUser(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUser(idUser(" + idUser + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUser(idUser(" + idUser + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUser(idUser(" + idUser + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Objective> getObjectivesByIdUserToDo(UUID idUser) {
        ResponseEntity<List<Objective>> response =
                objectivesServiceClient.getObjectivesByIdUserToDo(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUserToDo(idUser(" + idUser + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUserToDo(idUser(" + idUser + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUserToDo(idUser(" + idUser + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }


    public List<Objective> getObjectivesByIdUserDone(UUID idUser) {
        ResponseEntity<List<Objective>> response =
                objectivesServiceClient.getObjectivesByIdUserDone(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new ObjectivesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUserDone(idUser(" + idUser + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new ObjectivesServiceException(
                    "Error (FORBIDDEN) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUserDone(idUser(" + idUser + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new ObjectivesServiceException(
                    "Error (NOT_FOUND) in micro service (objectives-service), during operation " +
                    "(objectivesServiceClient.getObjectivesByIdUserDone(idUser(" + idUser + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
