package org.macarigo;

public enum Month {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
    JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);


    private final int monthNumber;

    Month(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static Month fromInt(int month) {
        for (Month m : values()) {
            if(m.getMonthNumber() == month) {
                return m;
            }
        }
        throw new IllegalArgumentException("Invalid month number: " + month);
    }
}
