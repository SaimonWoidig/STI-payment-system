package cz.woidig.sti.paymentsystem.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

class GlobalExceptionHandlerTest {
    private GlobalExceptionHandler handler;

    @BeforeEach
    void setUp() {
        this.handler = new GlobalExceptionHandler();
    }

    @Test
    void test_handleValidationErrors() {
        FieldError fieldError = new FieldError(
                "TestObject",
                "testField",
                "invalidValue",
                true,
                null,
                null,
                "testField value is invalid"
        );
        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        Mockito.doReturn(List.of(fieldError)).when(bindingResult).getFieldErrors();
        MethodArgumentNotValidException exception = Mockito.mock(MethodArgumentNotValidException.class);
        Mockito.doReturn(bindingResult).when(exception).getBindingResult();

        ResponseEntity<Map<String, List<String>>> expected = ResponseEntity.badRequest().body(
                Map.of("errors", List.of("testField: testField value is invalid"))
        );

        ResponseEntity<Map<String, List<String>>> actual = this.handler.handleValidationErrors(exception);

        Assertions.assertEquals(expected, actual);
    }
}