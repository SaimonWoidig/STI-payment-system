package cz.woidig.sti.paymentsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentSystemApplicationTest {
    @Test
    public void testMain() {
        Assertions.assertDoesNotThrow(() -> PaymentSystemApplication.main(new String[]{}));
    }
}