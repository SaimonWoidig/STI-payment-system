package cz.woidig.sti.paymentsystem.service;

import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService implements PaymentService {
    @Override
    public void makePayment(MakePaymentDTO dto) {
        pay(dto.price(), dto.currency());
    }

    private void pay(Float price, String currency) {
        System.out.println("Paid " + price + " " + currency + " with card");
    }
}