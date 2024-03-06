package cz.woidig.sti.paymentsystem.service.card;

import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {
    public void pay(Float price, String currency) {
        System.out.println("Paid with card");
        System.out.println("Amount: " + price + " " + currency);
    }
}