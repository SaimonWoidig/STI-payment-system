package cz.woidig.sti.paymentsystem.service;

import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import cz.woidig.sti.paymentsystem.enums.PaymentType;
import cz.woidig.sti.paymentsystem.service.card.CardPaymentService;
import cz.woidig.sti.paymentsystem.service.cash.CashPaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
    @Mock
    CardPaymentService cardPaymentService;
    @Mock
    CashPaymentService cashPaymentService;

    PaymentServiceImpl paymentService;


    @BeforeEach
    void setUp() {
        this.paymentService = new PaymentServiceImpl(cardPaymentService, cashPaymentService);
    }

    @Test
    void makePaymentCard() {
        Float price = 1.0f;
        String currency = "CZK";
        LocalDateTime dateTime = LocalDateTime.now();
        PaymentType paymentType = PaymentType.CARD;
        List<String> items = List.of("test");
        MakePaymentDTO dto = new MakePaymentDTO(price, currency, dateTime, paymentType, items);

        this.paymentService.makePayment(dto);

        Mockito.verify(cardPaymentService, Mockito.times(1)).pay(price, currency);
    }

    @Test
    void makePaymentCash() {
        Float price = 1.0f;
        String currency = "CZK";
        LocalDateTime dateTime = LocalDateTime.now();
        PaymentType paymentType = PaymentType.CASH;
        List<String> items = List.of("test");
        MakePaymentDTO dto = new MakePaymentDTO(price, currency, dateTime, paymentType, items);

        this.paymentService.makePayment(dto);

        Mockito.verify(cashPaymentService, Mockito.times(1)).cash(price, currency, dateTime);
    }

}