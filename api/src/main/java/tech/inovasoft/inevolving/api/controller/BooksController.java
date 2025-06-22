package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
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

    @Operation(description = "End-point para adicionar um novo livro a lista de leitura do usuário. | Registra um novo livro a lista de leitura do usuário, o livro sempre é adicionado como pendente a leitura.")
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

    @Operation(description = "End-point para editar um livro da lista de leitura do usuário.")
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

    @Operation(description = "End-point para editar o status de um livro para pendente da lista de leitura do usuário.")
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

    @Operation(description = "End-point para editar o status de um livro para em progresso da lista de leitura do usuário.")
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

    @Operation(description = "End-point para editar o status de um livro para concluido da lista de leitura do usuário.")
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

    @Operation(description = "End-point para deletar um livro da lista de leitura do usuário.")
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

    @Operation(description = "End-point para listar todos os livros da lista de leitura do usuário.")
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

    @Operation(description = "End-point para listar todos os livros pendentes da lista de leitura do usuário.")
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

    @Operation(description = "End-point para listar todos os livros em progresso da lista de leitura do usuário.")
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

    @Operation(description = "End-point para listar todos os livros concluidos da lista de leitura do usuário.")
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

    @Operation(description = "End-point para listar um livro da lista de leitura do usuário.")
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
