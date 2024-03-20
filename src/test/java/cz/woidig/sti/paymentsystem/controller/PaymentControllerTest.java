package cz.woidig.sti.paymentsystem.controller;


import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import cz.woidig.sti.paymentsystem.enums.PaymentType;
import cz.woidig.sti.paymentsystem.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {
    @Mock
    PaymentService paymentService;
    PaymentController paymentController;

    @BeforeEach
    void setUp() {
        paymentController = new PaymentController(paymentService);
    }

    @Test
    void makePaymentTest() {
        Float price = 1.0f;
        String currency = "CZK";
        LocalDateTime dateTime = LocalDateTime.now();
        PaymentType paymentType = PaymentType.CARD;
        List<String> items = List.of("test");
        MakePaymentDTO dto = new MakePaymentDTO(price, currency, dateTime, paymentType, items);
        paymentController.makePayment(dto);
    }
}