package cz.woidig.sti.paymentsystem.controller;

import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import cz.woidig.sti.paymentsystem.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping(path = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void makePayment(@Valid @RequestBody MakePaymentDTO makePaymentDTO) throws IllegalArgumentException {
        paymentService.makePayment(makePaymentDTO);
    }
}
