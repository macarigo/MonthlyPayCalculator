package org.macarigo;

import java.time.DayOfWeek;

public class PayCalculator {

    private double hourlyRate;
    private int hoursPerDay;
    private double extraHours;

    public PayCalculator(int hoursPerDay, double hourlyRate, double extraHours) {
        this.hourlyRate = hourlyRate;
        this.hoursPerDay = hoursPerDay;
        this.extraHours = extraHours;
    }

    public double calculateMonthlyPay(int year, int month) {
        DateCalculator dateCalculator = new DateCalculator();

        int mondays = dateCalculator.countDaysOfWeek(year, month, DayOfWeek.MONDAY);
        int wednesdays = dateCalculator.countDaysOfWeek(year, month, DayOfWeek.WEDNESDAY);
        int fridays = dateCalculator.countDaysOfWeek(year, month, DayOfWeek.FRIDAY);

        double totalHours = ((mondays + wednesdays + fridays) * hoursPerDay) + extraHours;
        return totalHours * hourlyRate;
    }
}
