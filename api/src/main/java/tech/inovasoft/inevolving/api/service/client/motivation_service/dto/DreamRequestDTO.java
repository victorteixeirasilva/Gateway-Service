package tech.inovasoft.inevolving.api.service.client.motivation_service.dto;

import tech.inovasoft.inevolving.api.domain.dto.request.RequestDreamDTO;

import java.util.UUID;

public record DreamRequestDTO(
        String name,
        String description,
        String urlImage,
        UUID idUser
) {
    public DreamRequestDTO(UUID idUser, RequestDreamDTO dto) {
        this(
                dto.name(),
                dto.description(),
                dto.urlImage(),
                idUser
        );
    }
}
