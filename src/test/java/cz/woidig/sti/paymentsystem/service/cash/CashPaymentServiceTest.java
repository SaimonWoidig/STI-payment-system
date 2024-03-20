package cz.woidig.sti.paymentsystem.service.cash;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CashPaymentServiceTest {
    CashPaymentService cashPaymentService;

    @BeforeEach
    void setUp() {
        XmlMapper xmlMapper = XmlMapper.xmlBuilder().build();
        this.cashPaymentService = new CashPaymentService(xmlMapper);
    }

    @Test
    void toXMLDataValid() {
        Float price = 1.0f;
        String currency = "CZK";
        // 1.1.2000 12:00:00
        LocalDateTime dateTime = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        CashTransaction cashTransaction = new CashTransaction(price, currency, dateTime);

        String expectedXmlString = "<transaction><price>1.0</price><currency>CZK</currency><dateTime>2000-01-01T12:00:00</dateTime></transaction>";

        Assertions.assertEquals(expectedXmlString, this.cashPaymentService.toXMLData(cashTransaction));
    }

    @Test
    void toXMLDataInvalid() {
        CashTransaction cashTransaction = new CashTransaction(null, null, null);

        Assertions.assertNull(this.cashPaymentService.toXMLData(cashTransaction));
    }

    @Test
    void cashValid() {
        Assertions.assertDoesNotThrow(() -> this.cashPaymentService.cash(1.0f, "CZK", LocalDateTime.now()));
    }

    @Test
    void cashInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.cashPaymentService.cash(null, null, null));
    }
}