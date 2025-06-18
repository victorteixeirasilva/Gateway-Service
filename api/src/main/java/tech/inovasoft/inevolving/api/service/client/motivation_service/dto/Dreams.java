package tech.inovasoft.inevolving.api.service.client.motivation_service.dto;

import java.util.UUID;

public record Dreams(
        UUID id,
        String name,
        String description,
        String urlImage,
        UUID idUser
) {
}
