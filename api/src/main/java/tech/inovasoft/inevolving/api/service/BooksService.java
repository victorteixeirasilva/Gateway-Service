package tech.inovasoft.inevolving.api.service;

import lombok.extern.slf4j.Slf4j;
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (booksServiceClient.addBook("+idUser+", "+dto+")).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (booksServiceClient.addBook("+idUser+", "+dto+")).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (booksServiceClient.addBook(idUser - "+idUser+", dto - "+dto+")).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Book updateBook(UUID idUser, UUID idBook, RequestBookDTO dto) {
        ResponseEntity<Book> response = booksServiceClient.updateBook(idUser, idBook, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation " +
                            "(updateBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + "), RequestBookDTO dto (" + dto + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "(updateBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + "), RequestBookDTO dto (" + dto + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "(updateBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + "), RequestBookDTO dto (" + dto + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Book updateBookStatusToDo(UUID idUser, UUID idBook) {
        ResponseEntity<Book> response = booksServiceClient.updateBookStatusToDo(idUser, idBook);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation " +
                            "(updateBookStatusToDo(UUID idUser (" + idUser + "), UUID idBook (" + idBook + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "(updateBookStatusToDo(UUID idUser (" + idUser + "), UUID idBook (" + idBook + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "(updateBookStatusToDo(UUID idUser (" + idUser + "), UUID idBook (" + idBook + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();

    }

    public Book updateBookStatusInProgress(UUID idUser, UUID idBook) {
        ResponseEntity<Book> response = booksServiceClient.updateBookStatusInProgress(idUser, idBook);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation " +
                            "(updateBookStatusInProgress(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "(updateBookStatusInProgress(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "(updateBookStatusInProgress(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Book updateBookStatusCompleted(UUID idUser, UUID idBook) {
        ResponseEntity<Book> response = booksServiceClient.updateBookStatusCompleted(idUser, idBook);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation " +
                            "(updateBookStatusCompleted(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "(updateBookStatusCompleted(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "(updateBookStatusCompleted(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();

    }

    public ResponseDeleteBookDTO deleteBook(UUID idUser, UUID idBook) {
        ResponseEntity<ResponseDeleteBookDTO> response = booksServiceClient.deleteBook(idUser, idBook);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation " +
                            "(deleteBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "(deleteBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "(deleteBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Book> getBooks(UUID idUser) {
        ResponseEntity<List<Book>> response = booksServiceClient.getBooks(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), " +
                            "during operation (getBooks(UUID idUser (" + idUser + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "during operation (getBooks(UUID idUser (" + idUser + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "during operation (getBooks(UUID idUser (" + idUser + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Book> getBooksToDo(UUID idUser) {
        ResponseEntity<List<Book>> response = booksServiceClient.getBooksToDo(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (getBooksToDo(UUID idUser)).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (getBooksToDo(UUID idUser)).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (getBooksToDo(UUID idUser)).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Book> getBooksInProgress(UUID idUser) {
        ResponseEntity<List<Book>> response = booksServiceClient.getBooksInProgress(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (getBooksInProgress(UUID idUser)).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (getBooksInProgress(UUID idUser)).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (getBooksInProgress(UUID idUser)).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Book> getBooksCompleted(UUID idUser) {
        ResponseEntity<List<Book>> response = booksServiceClient.getBooksCompleted(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), during operation (getBooksCompleted(UUID idUser)).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation (getBooksCompleted(UUID idUser)).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation (getBooksCompleted(UUID idUser)).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public Book getBook(UUID idUser, UUID idBook) {
        ResponseEntity<Book> response = booksServiceClient.getBook(idUser, idBook);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new BooksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (books_service), " +
                            "during operation (getBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new BooksServiceException(
                    "Error (FORBIDDEN) in micro service (books_service), during operation " +
                            "during operation (getBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new BooksServiceException(
                    "Error (NOT_FOUND) in micro service (books_service), during operation " +
                            "during operation (getBook(UUID idUser (" + idUser + "), UUID idBook (" + idBook + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
