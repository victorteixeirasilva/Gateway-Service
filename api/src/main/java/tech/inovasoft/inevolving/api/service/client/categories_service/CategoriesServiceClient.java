package tech.inovasoft.inevolving.api.service.client.categories_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.categories_service.dto.*;

import java.util.UUID;

@FeignClient(name = "categories-service", url = "${inevolving.uri.ms.categories}")
public interface CategoriesServiceClient {

    @PostMapping("/{idUser}")
    ResponseEntity<Category> addCategory(
            @PathVariable("idUser") UUID idUser,
            @RequestBody RequestCategoryDTO dto
    );

    @PostMapping("/objective/{idUser}")
    ResponseEntity<ResponseCategoryAndNewObjectiveDTO> addObjectiveToCategory(
            @PathVariable("idUser") UUID idUser,
            @RequestBody RequestAddObjectiveToCategoryDTO dto
    );

    @DeleteMapping("/objective/{idUser}/{idCategory}/{id}")
    ResponseEntity<ResponseMessageDTO> removeObjectiveToCategory(
            @PathVariable("idUser") UUID idUser,
            @PathVariable("idCategory") UUID idCategory,
            @PathVariable("id") UUID idObjective
    );

    @DeleteMapping("/{idUser}/{idCategory}")
    ResponseEntity<ResponseMessageDTO> removeCategory(
            @PathVariable("idUser") UUID idUser,
            @PathVariable("idCategory") UUID idCategory
    );

    @PutMapping("/{idUser}/{idCategory}")
    ResponseEntity<Category> updateCategory(
            @PathVariable("idUser") UUID idUser,
            @PathVariable("idCategory") UUID idCategory,
            @RequestBody RequestUpdateCategoryDTO dto
    );

    @GetMapping("/{idUser}")
    ResponseEntity<ResponseCategoriesDTO> getCategories(@PathVariable("idUser") UUID idUser);

    @GetMapping("/{idUser}/{idCategory}")
    ResponseEntity<ResponseObjectivesByCategory> getObjectivesByCategory(
            @PathVariable("idUser") UUID idUser,
            @PathVariable("idCategory") UUID idCategory
    );


}
