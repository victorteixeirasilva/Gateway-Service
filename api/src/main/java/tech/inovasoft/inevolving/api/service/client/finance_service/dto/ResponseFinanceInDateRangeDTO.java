package tech.inovasoft.inevolving.api.service.client.finance_service.dto;

import java.util.List;
import java.util.UUID;

public record ResponseFinanceInDateRangeDTO(
        UUID idUser,
        Double wage,
        Double totalBalance,
        Double availableCostOfLivingBalance,
        Double balanceAvailableToInvest,
        Double extraBalanceAdded,
        List<ResponseTransactionDTO> transactionsCostOfLiving,
        List<ResponseTransactionDTO> transactionsInvestment,
        List<ResponseTransactionDTO> transactionsExtraAdded
) {
}

