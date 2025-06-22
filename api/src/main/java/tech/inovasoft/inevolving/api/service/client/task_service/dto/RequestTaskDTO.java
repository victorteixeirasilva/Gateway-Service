package tech.inovasoft.inevolving.api.service.client.task_service.dto;

import tech.inovasoft.inevolving.api.domain.dto.request.TaskRequestDTO;

import java.time.LocalDate;
import java.util.UUID;

public record RequestTaskDTO(
        String nameTask,
        String descriptionTask,
        LocalDate dateTask,
        UUID idObjective,
        UUID idUser
){
    public RequestTaskDTO(UUID idUser, TaskRequestDTO dto) {
        this(
                dto.nameTask(),
                dto.descriptionTask(),
                dto.dateTask(),
                dto.idObjective(),
                idUser
        );
    }
}
