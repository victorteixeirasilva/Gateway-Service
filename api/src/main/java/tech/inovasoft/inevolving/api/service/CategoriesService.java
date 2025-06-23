package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.exception.BooksServiceException;
import tech.inovasoft.inevolving.api.domain.exception.CategoriesServiceException;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.Book;
import tech.inovasoft.inevolving.api.service.client.categories_service.CategoriesServiceClient;
import tech.inovasoft.inevolving.api.service.client.categories_service.dto.*;

import java.util.UUID;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesServiceClient categoriesServiceClient;

    public Category addCategory(
            UUID idUser,
            RequestCategoryDTO dto
    ) {
        ResponseEntity<Category> response = categoriesServiceClient.addCategory(idUser, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.addCategory(idUser ("+idUser+"), dto ("+dto+"))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.addCategory(idUser ("+idUser+"), dto ("+dto+"))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.addCategory(idUser ("+idUser+"), dto ("+dto+"))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseCategoryAndNewObjectiveDTO addObjectiveToCategory(
            UUID idUser,
            RequestAddObjectiveToCategoryDTO dto
    ) {
        ResponseEntity<ResponseCategoryAndNewObjectiveDTO> response =
                categoriesServiceClient.addObjectiveToCategory(idUser, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.addObjectiveToCategory(idUser ("+idUser+"), dto ("+dto+")).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.addObjectiveToCategory(idUser ("+idUser+"), dto ("+dto+")).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.addObjectiveToCategory(idUser ("+idUser+"), dto ("+dto+")).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseMessageDTO removeObjectiveToCategory(
            UUID idUser,
            UUID idCategory,
            UUID idObjective
    ) {
        ResponseEntity<ResponseMessageDTO> response =
                categoriesServiceClient.removeObjectiveToCategory(idUser, idCategory, idObjective);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.removeObjectiveToCategory(idUser ("+idUser+"), idCategory ("+idCategory+"), idObjective ("+idObjective+")).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.removeObjectiveToCategory(idUser ("+idUser+"), idCategory ("+idCategory+"), idObjective ("+idObjective+")).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.removeObjectiveToCategory(idUser ("+idUser+"), idCategory ("+idCategory+"), idObjective ("+idObjective+")).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseMessageDTO removeCategory(
            UUID idUser,
            UUID idCategory
    )
    {
        ResponseEntity<ResponseMessageDTO> response =
                categoriesServiceClient.removeCategory(idUser, idCategory);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.removeCategory(idUser ("+idUser+"), idCategory ("+idCategory+"))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.removeCategory(idUser ("+idUser+"), idCategory ("+idCategory+"))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.removeCategory(idUser ("+idUser+"), idCategory ("+idCategory+"))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Category updateCategory(
            UUID idUser,
            UUID idCategory,
            RequestUpdateCategoryDTO dto
    ) {
        ResponseEntity<Category> response =
                categoriesServiceClient.updateCategory(idUser, idCategory, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.updateCategory(idUser ("+idUser+"), idCategory ("+idCategory+"), dto ("+dto+")).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.updateCategory(idUser ("+idUser+"), idCategory ("+idCategory+"), dto ("+dto+")).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.updateCategory(idUser ("+idUser+"), idCategory ("+idCategory+"), dto ("+dto+")).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseCategoriesDTO getCategories(
            UUID idUser
    ) {
        ResponseEntity<ResponseCategoriesDTO> response =
                categoriesServiceClient.getCategories(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.getCategories(idUser ("+idUser+"))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.getCategories(idUser ("+idUser+"))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.getCategories(idUser ("+idUser+"))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseObjectivesByCategory getObjectivesByCategory(
            UUID idUser,
            UUID idCategory
    ) {
        ResponseEntity<ResponseObjectivesByCategory> response =
                categoriesServiceClient.getObjectivesByCategory(idUser, idCategory);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new CategoriesServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.getObjectivesByCategory(idUser ("+idUser+"), idCategory ("+idCategory+"))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new CategoriesServiceException(
                    "Error (FORBIDDEN) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.getObjectivesByCategory(idUser ("+idUser+"), idCategory ("+idCategory+"))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new CategoriesServiceException(
                    "Error (NOT_FOUND) in micro service (categories-service), during operation " +
                            "(categoriesServiceClient.getObjectivesByCategory(idUser ("+idUser+"), idCategory ("+idCategory+"))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
