/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.datetime.provider.test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author armen.arzumanyan@gmail.com
 */
public class DateTimeProvider {

    public static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }

    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    public static DayOfWeek getDayOfWeekFromLocalDate(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day;
    }

    public static int getFirstDayOfMonth() {

        //System.out.println("WoW");
        return 1;
    }

    public static int getLastDayOfMonth(int year, Month month) {

        int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();

        return lastDayOfMonth;
    }

    public static int getLastDayOfCurrentMonth(int year) {

        Month currentMonth = getCurrentMonth();

        int lastDayOfMonth = YearMonth.of(year, currentMonth).lengthOfMonth();

        return lastDayOfMonth;
    }

    public static LocalDate getCurrenDate() {

        return LocalDate.now();
    }

    public static int getCurrentDayOfMonth() {

        return LocalDate.now().getDayOfMonth();
    }

    public static Month getCurrentMonth() {

        return LocalDate.now().getMonth();
    }

    public static int getCurrentYear() {

        return LocalDate.now().getYear();
    }

    public static LocalDateTime getNextDayOfWeek(LocalDateTime localDateTime, int month, DayOfWeek mayOfWeek) {

        LocalDateTime nextDay = localDateTime.with(TemporalAdjusters.dayOfWeekInMonth(month, mayOfWeek));

        return nextDay;
    }

    public static int getLocalWeekNumber(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        int weekNumber = date.get(weekFields.dayOfWeek());
        return weekNumber;
    }

    public static int getWeekDaysInMonth(LocalDate date) {
        return weekDaysInMonth(YearMonth.from(date));
    }

    private static int weekDaysInMonth(YearMonth yearMonth) {
        int len = yearMonth.lengthOfMonth(); // 28-31, supporting leap year
        int dow = yearMonth.atDay(1).getDayOfWeek().getValue(); // 1=Mon, 7=Sun
        return (dow <= 5 ? Math.min(len - 8, 26 - dow) : Math.max(len + dow - 16, 20));
    }

    public static int getBusinessDaysInMonth(final LocalDate ld) {

        int weekDays = 0;
        LocalDate date = ld.withDayOfMonth(1);
        final int intendedMonthValue = ld.getMonthValue();
        do {
            final DayOfWeek dayOfWeek = date.getDayOfWeek();

            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                weekDays++;
            }

            date = date.plusDays(1);
        } while (date.getMonthValue() == intendedMonthValue);

        return weekDays;
    }

    public static Date convertLocalTimeToDate(LocalTime localTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(0, 0, 0, localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return calendar.getTime();
    }

    public static LocalTime getTime10Am() {
        return LocalTime.of(10, 00, 00);
    }

    public static LocalTime getTime9Am() {
        return LocalTime.of(9, 00, 00);
    }

    public static LocalDateTime convertDateToLocalDateTime(Date dateToConvert) {

        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private LocalDateTime previousDay8Pm() {
        return LocalDateTime.now().minusDays(1).withHour(20).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime previousDay11Pm() {
        return LocalDateTime.now().minusDays(1).withHour(23).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime today1Pm() {
        return LocalDateTime.now().withHour(13).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime theDayAfter3Pm() {
        return LocalDateTime.now().plusDays(1).withHour(15).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime today6Pm() {
        return LocalDateTime.now().withHour(18).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime nextDay9Am() {
        return LocalDateTime.now().plusDays(1).withHour(9).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime nextDay11Am() {
        return LocalDateTime.now().plusDays(1).withHour(11).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime fourDaysLater3pm() {
        return LocalDateTime.now().plusDays(4).withHour(15).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime sevenDaysLater0am() {
        return LocalDateTime.now().plusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime eightDaysLater0am() {
        return LocalDateTime.now().plusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public LocalDate getInitialDate() {
        return LocalDate.now().plusDays(1);
    }

    public static LocalDate convertDateAsLocalDate(java.util.Date date) {
        return asLocalDate(date, ZoneId.systemDefault());
    }

    public static LocalDateTime convertDateAsLocalDateTime(java.util.Date date) {
        return asLocalDateTime(date, ZoneId.systemDefault());
    }

    private static LocalDateTime asLocalDateTime(java.util.Date date, ZoneId zone) {
        if (date == null) {
            return null;
        }

        if (date instanceof java.sql.Timestamp) {
            return ((java.sql.Timestamp) date).toLocalDateTime();
        } else {
            return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDateTime();
        }
    }

    private static LocalDate asLocalDate(java.util.Date date, ZoneId zone) {
        if (date == null) {
            return null;
        }

        if (date instanceof java.sql.Date) {
            return ((java.sql.Date) date).toLocalDate();
        } else {
            return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
        }
    }
}
