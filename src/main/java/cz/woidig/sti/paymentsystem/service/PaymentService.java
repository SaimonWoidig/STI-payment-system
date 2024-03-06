package cz.woidig.sti.paymentsystem.service;

import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;

public interface PaymentService {
    void makePayment(MakePaymentDTO dto);
}
