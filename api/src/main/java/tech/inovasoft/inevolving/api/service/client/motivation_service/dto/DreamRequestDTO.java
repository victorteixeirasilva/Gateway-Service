package tech.inovasoft.inevolving.api.service.client.motivation_service.dto;

import java.util.UUID;

public record DreamRequestDTO(
        String name,
        String description,
        String urlImage,
        UUID idUser
) {
}
