package org.macarigo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class DateCalculator {

    public int countDaysOfWeek(int year, int month, DayOfWeek dayOfWeek) {
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        int count = 0;

        for (int day = 1; day <= daysInMonth; day ++) {
            LocalDate date = LocalDate.of(year, month, day);
            if (date.getDayOfWeek() == dayOfWeek) {
                count++;
            }
        }
        return count;
    }
}
