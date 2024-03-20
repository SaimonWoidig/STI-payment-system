package cz.woidig.sti.paymentsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import cz.woidig.sti.paymentsystem.enums.PaymentType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record MakePaymentDTO(
        @JsonProperty("price")
        @NotNull
        Float price,
        @JsonProperty("currency")
        @NotNull
        String currency,
        @JsonProperty("dateTime")
        @NotNull
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime dateTime,
        @JsonProperty("paymentType")
        @NotNull
        PaymentType paymentType,
        @JsonProperty("items")
        @NotNull
        List<String> items
) {
}
