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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.addPlanningWhenRegistering).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.addPlanningWhenRegistering).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.addPlanningWhenRegistering).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.updateWage).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.updateWage).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.updateWage).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.addTransactionCostOfLiving).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.addTransactionCostOfLiving).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.addTransactionCostOfLiving).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.addTransactionInvestment).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.addTransactionInvestment).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.addTransactionInvestment).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.addTransactionExtraContribution).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.addTransactionExtraContribution).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.addTransactionExtraContribution).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.deleteTransaction).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.deleteTransaction).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.deleteTransaction).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.getTransaction).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.getTransaction).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.getTransaction).",
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
                    "Error (INTERNAL_SERVER_ERROR) in micro service (finance-service), during operation (financeServiceClient.getInfosFinanceInDateRange).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new FinanceServiceException(
                    "Error (FORBIDDEN) in micro service (finance-service), during operation (financeServiceClient.getInfosFinanceInDateRange).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new FinanceServiceException(
                    "Error (NOT_FOUND) in micro service (finance-service), during operation (financeServiceClient.getInfosFinanceInDateRange).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
