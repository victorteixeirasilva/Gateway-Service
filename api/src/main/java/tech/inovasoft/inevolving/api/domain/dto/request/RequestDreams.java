package tech.inovasoft.inevolving.api.domain.dto.request;

import java.util.UUID;

public record RequestDreams(
        String name,
        String description,
        String urlImage,
        UUID idUser
) {
}
