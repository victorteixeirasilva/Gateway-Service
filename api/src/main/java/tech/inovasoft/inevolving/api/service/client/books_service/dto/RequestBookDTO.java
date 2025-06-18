package tech.inovasoft.inevolving.api.service.client.books_service.dto;

public record RequestBookDTO(
        String title,
        String author,
        String theme,
        String coverImage
) {
}
