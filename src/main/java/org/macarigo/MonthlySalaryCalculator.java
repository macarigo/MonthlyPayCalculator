package org.macarigo;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MonthlySalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year;
        int month;
        double hourlyRate;
        int hoursPerDay;

        try {
            System.out.println("Enter the year: ");
            year = scanner.nextInt();

            System.out.println("Enter the month (1-12): ");
            month = scanner.nextInt();

            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month. Please enter a number between 1 and 12.");
            }

            System.out.println("Enter the hourly rate: ");
            hourlyRate = scanner.nextDouble();

            if (hourlyRate < 0) {
                throw new IllegalArgumentException("Invalid hourly rate. Please enter a non-negative value.");
            }

            System.out.println("Enter number of worked hours per day: ");
            hoursPerDay = scanner.nextInt();

            if (hoursPerDay < 0 || hoursPerDay > 24) {
                throw new IllegalArgumentException("Invalid worked hours per day. Please insert a number between 0 and 24");
            }

            SalaryCalculator salaryCalculator = new SalaryCalculator(hoursPerDay, hourlyRate);
            double totalPay = salaryCalculator.calculateMonthlyPay(year, month);

            Month currentMonth = Month.fromInt(month);


            System.out.println("Total pay for " + currentMonth + " " + year + ": " + totalPay + "€");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
