package org.macarigo;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class PayPeriod {

    private int year;
    private int month;
    private boolean[] daysOfWeek;
    private double hourlyRate;
    private double hoursWorkedPerDay;
    private double extraHours;

    public PayPeriod(int year, int month, boolean[] daysOfWeek, double hourlyRate, double hoursWorkedPerDay, double extraHours) {
        this.year = year;
        this.month = month;
        this.daysOfWeek = daysOfWeek;
        this.hourlyRate = hourlyRate;
        this.hoursWorkedPerDay = hoursWorkedPerDay;
        this.extraHours = extraHours;
    }

    public PayPeriod(int year, int month, List<DayOfWeek> workingDays, double hourlyRate, double hoursWorkedPerDay, double extraHours) {
        this.year = year;
        this.month = month;
        this.daysOfWeek = new boolean[7];

        for (DayOfWeek day : workingDays) {
            this.daysOfWeek[day.getValue() -1] = true;
        }

        this.hourlyRate = hourlyRate;
        this.hoursWorkedPerDay = hoursWorkedPerDay;
        this.extraHours = extraHours;
    }

    public PayPeriod() {}

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public boolean[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public double getHourlyRate() {
        return hourlyRate;
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

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorkedPerDay(double hoursWorkedPerDay) {
        this.hoursWorkedPerDay = hoursWorkedPerDay;
    }

    public void setExtraHours(double extraHours) {
        this.extraHours = extraHours;
    }

    @Override
    public String toString() {
        return "PayPeriod{" +
                "year=" + year +
                ", month=" + month +
                ", daysOfWeek=" + Arrays.toString(daysOfWeek) +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorkedPerDay=" + hoursWorkedPerDay +
                ", extraHours=" + extraHours +
                '}';
    }
}
