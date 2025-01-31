package org.macarigo.service;

import org.macarigo.PayPeriod;
import org.springframework.stereotype.Service;

@Service
public class PayCalculatorService {

    public double calculatePay(PayPeriod payPeriod, double hourlyRate) {
        int totalWorkingDays = 0;

        for (int i = 0; i < payPeriod.getDaysOfWeek().length; i++) {
            if(payPeriod.getDaysOfWeek()[i]) {
                totalWorkingDays++;
            }
        }

        double totalWorkingHours = totalWorkingDays * payPeriod.getHoursWorkedPerDay();
        double totalHours = totalWorkingHours + payPeriod.getExtraHours();
        return totalHours * hourlyRate;
    }
}
