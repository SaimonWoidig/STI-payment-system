package cz.woidig.sti.paymentsystem.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import cz.woidig.sti.paymentsystem.service.CardPaymentService;
import cz.woidig.sti.paymentsystem.service.CashPaymentService;
import cz.woidig.sti.paymentsystem.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaymentController {
    XmlMapper xmlMapper;

    @PostMapping(path = "/payment")
    public void makePayment(@RequestBody() MakePaymentDTO makePaymentDTO) throws IllegalArgumentException {
        PaymentService paymentService = switch (makePaymentDTO.paymentType()) {
            case "card" -> new CardPaymentService();
            case "cash" -> new CashPaymentService(xmlMapper);
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
        paymentService.makePayment(makePaymentDTO);
    }
}
