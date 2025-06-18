package tech.inovasoft.inevolving.api.service.client.motivation_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "motivation-service", url = "http://localhost:8080/ms/motivation/dreams")
public interface MotivationServiceClient {

    @PostMapping
    ResponseEntity<Dreams> addDream (@RequestBody DreamRequestDTO dreamDTO);

    @PatchMapping
    ResponseEntity<Dreams> updateDream (@RequestBody Dreams dreamDTO);

    @DeleteMapping
    ResponseEntity<ResponseDeleteDream> deleteDream (@RequestBody RequestDeleteDream dto);

    @GetMapping("/user/{id}")
    ResponseEntity<List<Dreams>> getDreamsByUserId(@PathVariable UUID id);

    @GetMapping("/{idDream}/{idUser}")
    ResponseEntity<Dreams> getDreamByID(@PathVariable UUID idDream, @PathVariable UUID idUser);

    @GetMapping("/visionbord/generate/{idUser}")
    ResponseEntity<ResponseVisionBord> generateVisionBordByUserId(@PathVariable UUID idUser);

}
