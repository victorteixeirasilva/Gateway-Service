package tech.inovasoft.inevolving.api.service.client.finance_service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;
import tech.inovasoft.inevolving.api.service.client.finance_service.dto.*;

import java.sql.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "finance-service", url = "http://localhost:8093/ms/finance")
public interface FinanceServiceClient {
    //TODO: Desenvolver teste de integração
    //TODO: Desenvolver controllers

    @PostMapping("/{idUser}")
    ResponseEntity<FinancePlanning> addPlanningWhenRegistering(
            @PathVariable("idUser") UUID idUser
    );

    @PatchMapping("/wage/{idUser}")
    ResponseEntity<ResponseUserWageDTO> updateWage(
            @PathVariable("idUser") UUID idUser,
            @RequestBody RequestUpdateWageDTO requestDTO
    );

    @PostMapping("/transaction/cost_of_living")
    ResponseEntity<ResponseTransactionDTO> addTransactionCostOfLiving(
            @RequestBody RequestTransactionDTO requestDTO
    );

    @PostMapping("/transaction/investment")
    ResponseEntity<ResponseTransactionDTO> addTransactionInvestment(
            @RequestBody RequestTransactionDTO requestDTO
    );

    @PostMapping("/transaction/extra_contribution")
    ResponseEntity<ResponseTransactionDTO> addTransactionExtraContribution(
            @RequestBody RequestTransactionDTO requestDTO
    );

    @DeleteMapping("/transaction/{idUser}/{idTransaction}")
    ResponseEntity<ResponseMessageDTO> deleteTransaction(
            @PathVariable("idUser") UUID idUser,
            @PathVariable("idTransaction") UUID idTransaction
    );

    @GetMapping("/transaction/{idUser}/{idTransaction}")
    ResponseEntity<ResponseTransactionDTO> getTransaction(
            @PathVariable UUID idUser,
            @PathVariable UUID idTransaction
    );

    @GetMapping("/{idUser}/{startDate}/{endDate}")
    ResponseEntity<ResponseFinanceInDateRangeDTO> getInfosFinanceInDateRange(
            @PathVariable UUID idUser,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

}
