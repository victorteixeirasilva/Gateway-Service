package tech.inovasoft.inevolving.api.service;

import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.service.client.categories_service.dto.*;

import java.util.UUID;

@Service
public class CategoriesService {

    public Category addCategory(
            UUID idUser,
            RequestCategoryDTO dto
    ) {
        //TODO: implement
        return null;
    }

    public ResponseCategoryAndNewObjectiveDTO addObjectiveToCategory(
            UUID idUser,
            RequestAddObjectiveToCategoryDTO dto
    ) {
        //TODO: implement
        return null;
    }

    public ResponseMessageDTO removeObjectiveToCategory(UUID idUser, UUID idCategory, UUID idObjective) {
        //TODO: implement
        return null;
    }

    public ResponseMessageDTO removeCategory(UUID idUser, UUID idCategory) {
        //TODO: implement
        return null;
    }

    public Category updateCategory(UUID idUser, UUID idCategory, RequestUpdateCategoryDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseCategoriesDTO getCategories(UUID idUser) {
        //TODO: implement
        return null;
    }

    public ResponseObjectivesByCategory getObjectivesByCategory(UUID idUser, UUID idCategory) {
        //TODO: implement
        return null;
    }
}
