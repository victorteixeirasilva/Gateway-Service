package tech.inovasoft.inevolving.api.service.client.books_service.dto;

import java.util.UUID;

public record Book(
        UUID id,
        String title,
        String author,
        String theme,
        String status,
        String coverImage,
        UUID idUser
) {
}
