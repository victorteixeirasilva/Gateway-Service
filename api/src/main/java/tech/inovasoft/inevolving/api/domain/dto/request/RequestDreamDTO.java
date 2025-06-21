package tech.inovasoft.inevolving.api.domain.dto.request;

import java.util.UUID;

public record RequestDreamDTO(
        String name,
        String description,
        String urlImage
) {
}
