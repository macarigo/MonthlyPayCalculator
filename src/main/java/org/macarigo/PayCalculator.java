package org.macarigo;

import java.time.DayOfWeek;

public class PayCalculator {

    private final double hourlyRate;
    private final double hoursPerDay;
    private final double extraHours;

    public PayCalculator(double hourlyRate, PayPeriod payPeriod) {
        this.hourlyRate = hourlyRate;
        this.hoursPerDay = payPeriod.getHoursWorkedPerDay();
        this.extraHours = payPeriod.getExtraHours();
    }

    public double calculateMonthlyPay(PayPeriod payPeriod) {
        DateCalculator dateCalculator = new DateCalculator();
        int totalWorkingDays = 0;

        for(int i = 0; i < 7; i++) {
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
