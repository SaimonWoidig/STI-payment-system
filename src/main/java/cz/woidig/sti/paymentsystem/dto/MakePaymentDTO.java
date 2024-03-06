package cz.woidig.sti.paymentsystem.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

public record MakePaymentDTO(
        Float price,
        String currency,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        LocalDateTime dateTime,
        String paymentType,
        List<String> items
) {}
