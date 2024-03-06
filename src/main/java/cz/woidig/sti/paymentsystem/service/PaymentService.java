package cz.woidig.sti.paymentsystem.service;

import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface PaymentService {
    void makePayment(@Valid @NotNull MakePaymentDTO dto);
}
