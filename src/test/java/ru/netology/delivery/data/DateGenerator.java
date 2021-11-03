package ru.netology.delivery.data;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

public class DateGenerator {
    public static String getToDate(int day) {
        return LocalDate.now().plusDays(day).format(ofPattern("dd.MM.yyyy"));
    }
}
