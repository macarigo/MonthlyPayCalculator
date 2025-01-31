package org.macarigo.controller;

import org.macarigo.PayCalculator;
import org.macarigo.PayPeriod;
import org.macarigo.dto.PayCalculationResponse;
import org.macarigo.service.PayCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay")
public class PayController {

    private final PayCalculatorService payCalculatorService;

    public PayController(PayCalculatorService payCalculatorService) {
        this.payCalculatorService = payCalculatorService;
    }

    @PostMapping
    public ResponseEntity<PayCalculationResponse> calculatePay(@RequestBody PayPeriod payPeriod) {
        double totalPay = payCalculatorService.calculatePay(payPeriod, payPeriod.getHoursWorkedPerDay());
        PayCalculationResponse response = new PayCalculationResponse(totalPay);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
