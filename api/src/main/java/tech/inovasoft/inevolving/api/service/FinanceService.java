package tech.inovasoft.inevolving.api.service;

import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.TransactionRequestDTO;
import tech.inovasoft.inevolving.api.service.client.finance_service.dto.*;

import java.sql.Date;
import java.util.UUID;

@Service
public class FinanceService {
    public FinancePlanning addPlanningWhenRegistering(UUID idUser) {
        //TODO: implement
        return null;
    }

    public ResponseUserWageDTO updateWage(UUID idUser, RequestUpdateWageDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseTransactionDTO addTransactionCostOfLiving(UUID idUser, TransactionRequestDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseTransactionDTO addTransactionInvestment(UUID idUser, TransactionRequestDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseTransactionDTO addTransactionExtraContribution(UUID idUser, TransactionRequestDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseMessageDTO deleteTransaction(UUID idUser, UUID idTransaction) {
        //TODO: implement
        return null;
    }

    public ResponseTransactionDTO getTransaction(UUID idUser, UUID idTransaction) {
        //TODO: implement
        return null;
    }

    public ResponseFinanceInDateRangeDTO getInfosFinanceInDateRange(UUID idUser, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }
}
