package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.exception.BooksServiceException;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.client.books_service.BooksServiceClient;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.Book;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.RequestBookDTO;
import tech.inovasoft.inevolving.api.service.client.books_service.dto.ResponseDeleteBookDTO;

import java.util.List;
import java.util.UUID;

@Service
public class BooksService {

    @Autowired
    private BooksServiceClient booksServiceClient;

    public Book addBook(UUID idUser, RequestBookDTO dto) {
        ResponseEntity<Book> response = booksServiceClient.addBook(idUser, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (booksServiceClient.addBook(idUser, dto)).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (booksServiceClient.addBook(idUser, dto)).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (booksServiceClient.addBook(idUser, dto)).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Book updateBook(UUID idUser, UUID idBook, RequestBookDTO dto) {
        ResponseEntity<Book> response = booksServiceClient.updateBook(idUser, idBook, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (updateBook(UUID idUser, UUID idBook, RequestBookDTO dto)).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (updateBook(UUID idUser, UUID idBook, RequestBookDTO dto)).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (updateBook(UUID idUser, UUID idBook, RequestBookDTO dto)).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Book updateBookStatusToDo(UUID idUser, UUID idBook) {
        ResponseEntity<Book> response = booksServiceClient.updateBookStatusToDo(idUser, idBook);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (updateBookStatusToDo(UUID idUser, UUID idBook)).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (updateBookStatusToDo(UUID idUser, UUID idBook)).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (updateBookStatusToDo(UUID idUser, UUID idBook)).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();

    }

    public Book updateBookStatusInProgress(UUID idUser, UUID idBook) {
        //TODO: Desenvolver método
        return null;
    }

    public Book updateBookStatusCompleted(UUID idUser, UUID idBook) {
        //TODO: Desenvolver método
        return null;
    }

    public ResponseDeleteBookDTO deleteBook(UUID idUser, UUID idBook) {
        //TODO: Desenvolver método
        return null;
    }

    public List<Book> getBooks(UUID idUser) {
        //TODO: Desenvolver método
        return null;
    }

    public List<Book> getBooksToDo(UUID idUser) {
        //TODO: Desenvolver método
        return null;
    }

    public List<Book> getBooksInProgress(UUID idUser) {
        //TODO: Desenvolver método
        return null;
    }

    public List<Book> getBooksCompleted(UUID idUser) {
        //TODO: Desenvolver método
        return null;
    }

    public Book getBook(UUID idUser, UUID idBook) {
        //TODO: Desenvolver método
        return null;
    }
}
