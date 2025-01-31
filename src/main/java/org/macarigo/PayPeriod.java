package org.macarigo;

import java.time.DayOfWeek;
import java.util.List;

public class PayPeriod {

    private int year;
    private int month;
    private boolean[] daysOfWeek;
    private double hoursWorkedPerDay;
    private double extraHours;

    public PayPeriod(int year, int month, boolean[] daysOfWeek, double hoursWorkedPerDay, double extraHours) {
        this.year = year;
        this.month = month;
        this.daysOfWeek = daysOfWeek;
        this.hoursWorkedPerDay = hoursWorkedPerDay;
        this.extraHours = extraHours;
    }

    public PayPeriod(int year, int month, List<DayOfWeek> workingDays, double hoursWorkedPerDay, double extraHours) {
        this.year = year;
        this.month = month;
        this.daysOfWeek = new boolean[7];

        for (DayOfWeek day : workingDays) {
            this.daysOfWeek[day.getValue() -1] = true;
        }

        this.hoursWorkedPerDay = hoursWorkedPerDay;
        this.extraHours = extraHours;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public boolean[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public double getHoursWorkedPerDay() {
        return hoursWorkedPerDay;
    }

    public double getExtraHours() {
        return extraHours;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDaysOfWeek(boolean[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setHoursWorkedPerDay(double hoursWorkedPerDay) {
        this.hoursWorkedPerDay = hoursWorkedPerDay;
    }

    public void setExtraHours(double extraHours) {
        this.extraHours = extraHours;
    }
}
