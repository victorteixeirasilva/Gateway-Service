package tech.inovasoft.inevolving.api.service.client.objectives_service.dto;

import tech.inovasoft.inevolving.api.domain.dto.request.CreateObjectiveDTO;

import java.util.UUID;

public record RequestCreateObjectiveDTO(
        String nameObjective,
        String descriptionObjective,
        UUID idUser
) {
    public RequestCreateObjectiveDTO(UUID idUser, CreateObjectiveDTO dto) {
        this(
                dto.nameObjective(),
                dto.descriptionObjective(),
                idUser
        );
    }
}
