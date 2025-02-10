package org.macarigo.service;

import org.macarigo.PayCalculator;
import org.macarigo.PayPeriod;
import org.springframework.stereotype.Service;

@Service
public class PayCalculatorService {

    public double calculatePay(PayPeriod payPeriod) {
        PayCalculator calculator = new PayCalculator(payPeriod.getHourlyRate(), payPeriod);
        return calculator.calculateMonthlyPay();
    }
}
