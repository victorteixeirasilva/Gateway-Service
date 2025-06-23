package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.TransactionRequestDTO;
import tech.inovasoft.inevolving.api.domain.exception.DashboardServiceException;
import tech.inovasoft.inevolving.api.domain.exception.FinanceServiceException;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.dto.ResponseDashbordDTO;
import tech.inovasoft.inevolving.api.service.client.finance_service.FinanceServiceClient;
import tech.inovasoft.inevolving.api.service.client.finance_service.dto.*;

import java.sql.Date;
import java.util.UUID;

@Service
public class FinanceService {

    @Autowired
    private FinanceServiceClient financeServiceClient;

    public FinancePlanning addPlanningWhenRegistering(UUID idUser) {
        ResponseEntity<FinancePlanning> response =
                financeServiceClient.addPlanningWhenRegistering(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(financeServiceClient.addPlanningWhenRegistering(idUser(" + idUser + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(financeServiceClient.addPlanningWhenRegistering(idUser(" + idUser + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(financeServiceClient.addPlanningWhenRegistering(idUser(" + idUser + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseUserWageDTO updateWage(UUID idUser, RequestUpdateWageDTO dto) {
        ResponseEntity<ResponseUserWageDTO> response =
                financeServiceClient.updateWage(idUser, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(updateWage(idUser(" + idUser + "), dto(" + dto + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(updateWage(idUser(" + idUser + "), dto(" + dto + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(updateWage(idUser(" + idUser + "), dto(" + dto + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTransactionDTO addTransactionCostOfLiving(UUID idUser, TransactionRequestDTO dto) {
        ResponseEntity<ResponseTransactionDTO> response =
                financeServiceClient.addTransactionCostOfLiving(new RequestTransactionDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(addTransactionCostOfLiving(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(addTransactionCostOfLiving(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(addTransactionCostOfLiving(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTransactionDTO addTransactionInvestment(UUID idUser, TransactionRequestDTO dto) {
        ResponseEntity<ResponseTransactionDTO> response =
                financeServiceClient.addTransactionInvestment(new RequestTransactionDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(addTransactionInvestment(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(addTransactionInvestment(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(addTransactionInvestment(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTransactionDTO addTransactionExtraContribution(UUID idUser, TransactionRequestDTO dto) {
        ResponseEntity<ResponseTransactionDTO> response =
                financeServiceClient.addTransactionExtraContribution(new RequestTransactionDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(addTransactionExtraContribution(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(addTransactionExtraContribution(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(addTransactionExtraContribution(new RequestTransactionDTO(idUser(" + idUser + "), dto(" + dto + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseMessageDTO deleteTransaction(UUID idUser, UUID idTransaction) {
        ResponseEntity<ResponseMessageDTO> response =
                financeServiceClient.deleteTransaction(idUser, idTransaction);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(financeServiceClient.deleteTransaction(idUser(" + idUser + "), idTransaction(" + idTransaction + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(financeServiceClient.deleteTransaction(idUser(" + idUser + "), idTransaction(" + idTransaction + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(financeServiceClient.deleteTransaction(idUser(" + idUser + "), idTransaction(" + idTransaction + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTransactionDTO getTransaction(UUID idUser, UUID idTransaction) {
        ResponseEntity<ResponseTransactionDTO> response =
                financeServiceClient.getTransaction(idUser, idTransaction);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(financeServiceClient.getTransaction(idUser(" + idUser + "), idTransaction(" + idTransaction + "))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(financeServiceClient.getTransaction(idUser(" + idUser + "), idTransaction(" + idTransaction + "))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(financeServiceClient.getTransaction(idUser(" + idUser + "), idTransaction(" + idTransaction + "))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseFinanceInDateRangeDTO getInfosFinanceInDateRange(UUID idUser, Date startDate, Date endDate) {
        ResponseEntity<ResponseFinanceInDateRangeDTO> response =
                financeServiceClient.getInfosFinanceInDateRange(idUser, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new FinanceServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation " +
                    "(financeServiceClient.getInfosFinanceInDateRange(idUser(" + idUser + "), startDate(" + startDate + "), endDate(" + endDate + ")))).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation " +
                    "(financeServiceClient.getInfosFinanceInDateRange(idUser(" + idUser + "), startDate(" + startDate + "), endDate(" + endDate + ")))).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation " +
                    "(financeServiceClient.getInfosFinanceInDateRange(idUser(" + idUser + "), startDate(" + startDate + "), endDate(" + endDate + ")))).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
