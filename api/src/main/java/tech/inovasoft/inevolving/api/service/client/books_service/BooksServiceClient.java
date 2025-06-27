package tech.inovasoft.inevolving.api.service.client.books_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.Book;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.RequestBookDTO;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.ResponseDeleteBookDTO;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "books-service", url = "${inevolving.uri.ms.books}")
public interface BooksServiceClient {

    @PostMapping("/{idUser}")
    ResponseEntity<Book> addBook(@PathVariable UUID idUser, @RequestBody RequestBookDTO dto);

    @PutMapping("/{idUser}/{idBook}")
    ResponseEntity<Book> updateBook(@PathVariable UUID idUser, @PathVariable UUID idBook, @RequestBody RequestBookDTO dto);

    @PutMapping("/status/todo/{idUser}/{idBook}")
    ResponseEntity<Book> updateBookStatusToDo(@PathVariable UUID idUser, @PathVariable UUID idBook);

    @PutMapping("/status/progress/{idUser}/{idBook}")
    ResponseEntity<Book> updateBookStatusInProgress(@PathVariable UUID idUser, @PathVariable UUID idBook);

    @PutMapping("/status/completed/{idUser}/{idBook}")
    ResponseEntity<Book> updateBookStatusCompleted(@PathVariable UUID idUser, @PathVariable UUID idBook);

    @DeleteMapping("/{idUser}/{idBook}")
    ResponseEntity<ResponseDeleteBookDTO> deleteBook(@PathVariable UUID idUser, @PathVariable UUID idBook);

    @GetMapping("/{idUser}")
    ResponseEntity<List<Book>> getBooks(@PathVariable UUID idUser);

    @GetMapping("/status/todo/{idUser}")
    ResponseEntity<List<Book>> getBooksToDo(@PathVariable UUID idUser);

    @GetMapping("/status/progress/{idUser}")
    ResponseEntity<List<Book>> getBooksInProgress(@PathVariable UUID idUser);

    @GetMapping("/status/completed/{idUser}")
    ResponseEntity<List<Book>> getBooksCompleted(@PathVariable UUID idUser);

    @GetMapping("/{idUser}/{idBook}")
    ResponseEntity<Book> getBook(@PathVariable UUID idUser, @PathVariable UUID idBook);

}
