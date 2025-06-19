package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.request.RequestDreams;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.MotivationService;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.Book;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Motivação | Motivation")
@RestController
@RequestMapping("/auth/api/motivation/dreams")
@SecurityRequirement(name = "bearerAuth")
public class MotivationController {

    @Autowired
    private MotivationService motivationService;

    @PostMapping
    Mono<ResponseEntity<Dreams>> addDream (
            Authentication authentication,
            @RequestBody Mono<DreamRequestDTO> monoDreamDTO
    ) {
        return monoDreamDTO.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Dreams dream = motivationService.addDream(idUser, dto);
            return ResponseEntity.ok(dream);
        });
    }

    @PatchMapping
    Mono<ResponseEntity<Dreams>> updateDream (
            Authentication authentication,
            @RequestBody Mono<RequestDreams> monoDreamDTO
    ){
        return monoDreamDTO.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Dreams dream = motivationService.updateDream(idUser, dto);
            return ResponseEntity.ok(dream);
        });
    }

    @DeleteMapping("/{idDream}")
    Mono<ResponseEntity<ResponseDeleteDream>> deleteDream (
            Authentication authentication,
            @PathVariable UUID idDream
    ){
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseDeleteDream responseDeleteDream = motivationService.deleteDream(idUser, idDream);
            return ResponseEntity.ok(responseDeleteDream);
        });
    }

    @GetMapping("/user")
    Mono<ResponseEntity<List<Dreams>>> getDreamsByUserId(Authentication authentication){
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Dreams> dreams = motivationService.getDreamsByUserId(idUser);
            return ResponseEntity.ok(dreams);
        });
    }

    @GetMapping("/{idDream}")
    Mono<ResponseEntity<Dreams>> getDreamByID(
            Authentication authentication,
            @PathVariable UUID idDream
    ){
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Dreams dream = motivationService.getDreamByID(idUser, idDream);
            return ResponseEntity.ok(dream);
        });
    }

    @GetMapping("/visionbord/generate")
    Mono<ResponseEntity<ResponseVisionBord>> generateVisionBordByUserId(Authentication authentication){
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseVisionBord visionBord = motivationService.generateVisionBordByUserId(idUser);
            return ResponseEntity.ok(visionBord);
        });
    }

}
