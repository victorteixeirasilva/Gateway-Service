package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.exception.BooksServiceException;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.BooksService;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.Book;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.RequestBookDTO;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.ResponseDeleteBookDTO;

import java.util.List;
import java.util.UUID;


@Tag(name = "Livros | Books")
@RestController
@RequestMapping("/auth/api/books")
@SecurityRequirement(name = "bearerAuth")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping
    public Mono<ResponseEntity<Book>> addBook(
            Authentication authentication,
            @RequestBody Mono<RequestBookDTO> dtoMono
    ) {
        return dtoMono.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            var book = booksService.addBook(idUser, dto);
            return ResponseEntity.ok(book);
        });

    }

    @PutMapping("/{idBook}")
    Mono<ResponseEntity<Book>> updateBook(
            Authentication authentication,
            @PathVariable UUID idBook,
            @RequestBody Mono<RequestBookDTO> dtoMono
    ) {
        return dtoMono.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Book book = booksService.updateBook(idUser, idBook, dto);
            return ResponseEntity.ok(book);
        });
    }

    @PatchMapping("/status/todo/{idBook}")
    Mono<ResponseEntity<Book>> updateBookStatusToDo(
            Authentication authentication,
            @PathVariable UUID idBook
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Book book = booksService.updateBookStatusToDo(idUser, idBook);
            return ResponseEntity.ok(book);
        });
    }

    @PatchMapping("/status/progress/{idBook}")
    Mono<ResponseEntity<Book>> updateBookStatusInProgress(
            Authentication authentication,
            @PathVariable UUID idBook
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Book book = booksService.updateBookStatusInProgress(idUser, idBook);
            return ResponseEntity.ok(book);
        });
    }

    @PatchMapping("/status/completed/{idBook}")
    Mono<ResponseEntity<Book>> updateBookStatusCompleted(
            Authentication authentication,
            @PathVariable UUID idBook
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Book book = booksService.updateBookStatusCompleted(idUser, idBook);
            return ResponseEntity.ok(book);
        });
    }

    @DeleteMapping("/{idBook}")
    Mono<ResponseEntity<ResponseDeleteBookDTO>> deleteBook(
            Authentication authentication,
            @PathVariable UUID idBook
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseDeleteBookDTO responseDeleteBookDTO = booksService.deleteBook(idUser, idBook);
            return ResponseEntity.ok(responseDeleteBookDTO);
        });
    }

    @GetMapping
    Mono<ResponseEntity<List<Book>>> getBooks(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Book> books = booksService.getBooks(idUser);
            return ResponseEntity.ok(books);
        });
    }

    @GetMapping("/status/todo")
    Mono<ResponseEntity<List<Book>>> getBooksToDo(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Book> books = booksService.getBooksToDo(idUser);
            return ResponseEntity.ok(books);
        });
    }

    @GetMapping("/status/progress")
    Mono<ResponseEntity<List<Book>>> getBooksInProgress(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Book> books = booksService.getBooksInProgress(idUser);
            return ResponseEntity.ok(books);
        });
    }

    @GetMapping("/status/completed")
    Mono<ResponseEntity<List<Book>>> getBooksCompleted(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Book> books = booksService.getBooksCompleted(idUser);
            return ResponseEntity.ok(books);
        });
    }

    @GetMapping("/{idBook}")
    Mono<ResponseEntity<Book>> getBook(
            Authentication authentication,
            @PathVariable UUID idBook
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Book book = booksService.getBook(idUser, idBook);
            return ResponseEntity.ok(book);
        });
    }
}
