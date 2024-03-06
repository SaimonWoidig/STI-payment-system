package cz.woidig.sti.paymentsystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import cz.woidig.sti.paymentsystem.dto.MakePaymentDTO;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@Log
public class CashPaymentService implements PaymentService {
    private XmlMapper xmlMapper;

    @Override
    public void makePayment(MakePaymentDTO dto) {
        cash(toXMLData(dto));
    }

    private String toXMLData(MakePaymentDTO dto) {
        try {
            return xmlMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            log.severe(e.getMessage());
            return null;
        }
    }

    private void cash(String XMLData) {
        System.out.println("Paid with cash");
        System.out.println("Data:");
        System.out.println(XMLData);
    }
}
