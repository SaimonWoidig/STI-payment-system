package cz.woidig.sti.paymentsystem.service;

import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import cz.woidig.sti.paymentsystem.service.card.CardPaymentService;
import cz.woidig.sti.paymentsystem.service.cash.CashPaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@Service
@Validated
public class PaymentServiceImpl implements PaymentService {
    private final CardPaymentService cardPaymentService;
    private final CashPaymentService cashPaymentService;

    @Override
    public void makePayment(@Valid @NotNull MakePaymentDTO dto) throws IllegalArgumentException {
        switch (dto.paymentType()) {
            case CARD -> cardPaymentService.pay(dto.price(), dto.currency());
            case CASH -> cashPaymentService.cash(dto.price(), dto.currency(), dto.dateTime());
        }
    }
}
