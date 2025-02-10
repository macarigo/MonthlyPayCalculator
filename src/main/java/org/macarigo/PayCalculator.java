package org.macarigo;

import java.time.DayOfWeek;

public class PayCalculator {

    private final double hourlyRate;
    private final PayPeriod payPeriod;

    public PayCalculator(double hourlyRate, PayPeriod payPeriod) {
        this.hourlyRate = hourlyRate;
        this.payPeriod = payPeriod;
    }

    public double calculateMonthlyPay() {
        DateCalculator dateCalculator = new DateCalculator();
        int totalWorkingDays = 0;

        for(int i = 0; i < payPeriod.getDaysOfWeek().length; i++) {
            if(payPeriod.getDaysOfWeek()[i]) {
                DayOfWeek dayOfWeek = DayOfWeek.of(i + 1);
                totalWorkingDays += dateCalculator.countDaysOfWeek(payPeriod.getYear(), payPeriod.getMonth(), dayOfWeek);
            }
        }

        double totalWorkingHours = totalWorkingDays * payPeriod.getHoursWorkedPerDay();
        double totalHours = totalWorkingHours + payPeriod.getExtraHours();
        return totalHours * hourlyRate;
    }
}
