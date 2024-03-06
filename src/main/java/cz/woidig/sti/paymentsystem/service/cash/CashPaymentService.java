package cz.woidig.sti.paymentsystem.service.cash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Log
@Service
@AllArgsConstructor
public class CashPaymentService {
    private XmlMapper xmlMapper;

    public String toXMLData(CashTransaction transaction) {
        try {
            return xmlMapper.writeValueAsString(transaction);
        } catch (JsonProcessingException e) {
            log.severe(e.getMessage());
            return null;
        }
    }

    public void cash(Float price, String currency, LocalDateTime dateTime) {
        CashTransaction transaction = new CashTransaction(price, currency, dateTime);
        String XMLData = toXMLData(transaction);
        if (Objects.isNull(XMLData)) {
            log.severe("Error converting transaction data to XML");
            return;
        }
        System.out.println("Paid with cash");
        System.out.println("Data:");
        System.out.println(XMLData);
    }
}
