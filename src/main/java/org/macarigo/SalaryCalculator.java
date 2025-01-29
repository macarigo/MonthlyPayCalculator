package org.macarigo;

import java.time.DayOfWeek;

public class SalaryCalculator {

    private double hourlyRate;
    private int hoursPerDay;

    public SalaryCalculator(int hoursPerDay, double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.hoursPerDay = hoursPerDay;
    }

    public double calculateMonthlyPay(int year, int month) {
        DateCalculator dateCalculator = new DateCalculator();

        int mondays = dateCalculator.countDaysOfWeek(year, month, DayOfWeek.MONDAY);
        int wednesdays = dateCalculator.countDaysOfWeek(year, month, DayOfWeek.WEDNESDAY);
        int fridays = dateCalculator.countDaysOfWeek(year, month, DayOfWeek.FRIDAY);

        double totalHours = (mondays + wednesdays + fridays) * hoursPerDay;
        return totalHours * hourlyRate;
    }
}
