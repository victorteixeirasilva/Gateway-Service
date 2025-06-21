package tech.inovasoft.inevolving.api.service.client.motivation_service.dto;

import tech.inovasoft.inevolving.api.domain.dto.request.RequestDreams;

import java.util.UUID;

public record Dreams(
        UUID id,
        String name,
        String description,
        String urlImage,
        UUID idUser
) {
    public Dreams(UUID idUser, RequestDreams dto) {
        this(
                dto.id(),
                dto.name(),
                dto.description(),
                dto.urlImage(),
                idUser
        );
    }
}
