package tech.inovasoft.inevolving.api.service.client.categories_service.dto;


import java.util.List;
import java.util.UUID;

public record Category(
        UUID id,
        UUID idUser,
        String categoryName,
        String categoryDescription,
        List<UUID> objectives
) {
}
