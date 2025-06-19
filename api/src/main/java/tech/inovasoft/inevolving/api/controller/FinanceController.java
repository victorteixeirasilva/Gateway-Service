package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.request.TransactionRequestDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.FinanceService;
import tech.inovasoft.inevolving.api.service.client.finance_service.dto.*;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.Dreams;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Tag(name = "Finance | Finanças")
@RestController
@RequestMapping("/auth/api/finance")
@SecurityRequirement(name = "bearerAuth")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @PostMapping
    Mono<ResponseEntity<FinancePlanning>> addPlanningWhenRegistering(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            FinancePlanning financePlanning = financeService.addPlanningWhenRegistering(idUser);
            return ResponseEntity.ok(financePlanning);
        });
    }

    @PatchMapping("/wage")
    Mono<ResponseEntity<ResponseUserWageDTO>> updateWage(
            Authentication authentication,
            @RequestBody Mono<RequestUpdateWageDTO> monoRequestDTO
    ) {
        return monoRequestDTO.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseUserWageDTO responseUserWageDTO = financeService.updateWage(idUser, dto);
            return ResponseEntity.ok(responseUserWageDTO);
        });
    }

    @PostMapping("/transaction/cost_of_living")
    Mono<ResponseEntity<ResponseTransactionDTO>> addTransactionCostOfLiving(
            Authentication authentication,
            @RequestBody Mono<TransactionRequestDTO> monoRequestDTO
    ) {
        return monoRequestDTO.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTransactionDTO responseTransactionDTO = financeService.addTransactionCostOfLiving(idUser, dto);
            return ResponseEntity.ok(responseTransactionDTO);
        });
    }

    @PostMapping("/transaction/investment")
    Mono<ResponseEntity<ResponseTransactionDTO>> addTransactionInvestment(
            Authentication authentication,
            @RequestBody Mono<TransactionRequestDTO> monoRequestDTO
    ) {
        return monoRequestDTO.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTransactionDTO responseTransactionDTO = financeService.addTransactionInvestment(idUser, dto);
            return ResponseEntity.ok(responseTransactionDTO);
        });
    }

    @PostMapping("/transaction/extra_contribution")
    Mono<ResponseEntity<ResponseTransactionDTO>> addTransactionExtraContribution(
            Authentication authentication,
            @RequestBody Mono<TransactionRequestDTO> monoRequestDTO
    ) {
        return monoRequestDTO.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTransactionDTO responseTransactionDTO = financeService.addTransactionExtraContribution(idUser, dto);
            return ResponseEntity.ok(responseTransactionDTO);
        });
    }

    @DeleteMapping("/transaction/{idTransaction}")
    Mono<ResponseEntity<ResponseMessageDTO>> deleteTransaction(
            Authentication authentication,
            @PathVariable("idTransaction") UUID idTransaction
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseMessageDTO responseMessageDTO = financeService.deleteTransaction(idUser, idTransaction);
            return ResponseEntity.ok(responseMessageDTO);
        });
    }

    @GetMapping("/transaction/{idTransaction}")
    Mono<ResponseEntity<ResponseTransactionDTO>> getTransaction(
            Authentication authentication,
            @PathVariable UUID idTransaction
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTransactionDTO responseTransactionDTO = financeService.getTransaction(idUser, idTransaction);
            return ResponseEntity.ok(responseTransactionDTO);
        });
    }

    @GetMapping("/{startDate}/{endDate}")
    Mono<ResponseEntity<ResponseFinanceInDateRangeDTO>> getInfosFinanceInDateRange(
            Authentication authentication,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseFinanceInDateRangeDTO responseFinanceInDateRangeDTO = financeService.getInfosFinanceInDateRange(idUser, startDate, endDate);
            return ResponseEntity.ok(responseFinanceInDateRangeDTO);
        });
    }

}
