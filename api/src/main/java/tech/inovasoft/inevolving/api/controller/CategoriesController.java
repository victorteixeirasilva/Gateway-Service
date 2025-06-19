package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.CategoriesService;
import tech.inovasoft.inevolving.api.service.client.categories_service.dto.*;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.Dreams;

import java.util.List;
import java.util.UUID;

@Tag(name = "Categorias | Categories")
@RestController
@RequestMapping("/auth/api/categories")
@SecurityRequirement(name = "bearerAuth")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    Mono<ResponseEntity<Category>> addCategory(
            Authentication authentication,
            @RequestBody Mono<RequestCategoryDTO> monoDto
    ){
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Category category = categoriesService.addCategory(idUser, dto);
            return ResponseEntity.ok(category);
        });
    }

    @PostMapping("/objective")
    Mono<ResponseEntity<ResponseCategoryAndNewObjectiveDTO>> addObjectiveToCategory(
            Authentication authentication,
            @RequestBody Mono<RequestAddObjectiveToCategoryDTO> monoDto
    ){
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseCategoryAndNewObjectiveDTO responseCategoryAndNewObjectiveDTO = categoriesService
                    .addObjectiveToCategory(idUser, dto);
            return ResponseEntity.ok(responseCategoryAndNewObjectiveDTO);
        });
    }

    @DeleteMapping("/objective/{idCategory}/{id}")
    Mono<ResponseEntity<ResponseMessageDTO>> removeObjectiveToCategory(
            Authentication authentication,
            @PathVariable("idCategory") UUID idCategory,
            @PathVariable("id") UUID idObjective
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseMessageDTO responseMessageDTO =
                    categoriesService.removeObjectiveToCategory(idUser, idCategory, idObjective);
            return ResponseEntity.ok(responseMessageDTO);
        });
    }

    @DeleteMapping("/{idCategory}")
    Mono<ResponseEntity<ResponseMessageDTO>> removeCategory(
            Authentication authentication,
            @PathVariable("idCategory") UUID idCategory
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseMessageDTO responseMessageDTO =
                    categoriesService.removeCategory(idUser, idCategory);
            return ResponseEntity.ok(responseMessageDTO);
        });
    }

    @PatchMapping("/{idCategory}")
    Mono<ResponseEntity<Category>> updateCategory(
            Authentication authentication,
            @PathVariable("idCategory") UUID idCategory,
            @RequestBody Mono<RequestUpdateCategoryDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Category category = categoriesService
                    .updateCategory(idUser, idCategory, dto);
            return ResponseEntity.ok(category);
        });
    }

    @GetMapping
    Mono<ResponseEntity<ResponseCategoriesDTO>> getCategories(
            Authentication authentication
    ){
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseCategoriesDTO responseCategoriesDTO =
                    categoriesService.getCategories(idUser);
            return ResponseEntity.ok(responseCategoriesDTO);
        });
    }

    @GetMapping("/{idCategory}")
    Mono<ResponseEntity<ResponseObjectivesByCategory>> getObjectivesByCategory(
            Authentication authentication,
            @PathVariable("idCategory") UUID idCategory
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseObjectivesByCategory responseObjectivesByCategory =
                    categoriesService.getObjectivesByCategory(idUser, idCategory);
            return ResponseEntity.ok(responseObjectivesByCategory);
        });
    }

}
