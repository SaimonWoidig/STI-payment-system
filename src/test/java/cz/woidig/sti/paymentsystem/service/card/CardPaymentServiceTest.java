package cz.woidig.sti.paymentsystem.service.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardPaymentServiceTest {
    CardPaymentService cardPaymentService;

    @BeforeEach
    void setUp() {
        this.cardPaymentService = new CardPaymentService();
    }

    @Test
    void pay() {
        Float price = 1.0f;
        String currency = "CZK";

        Assertions.assertDoesNotThrow(() -> this.cardPaymentService.pay(price, currency));
    }
}