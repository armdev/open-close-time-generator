/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.datetime.provider.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author armen.arzumanyan@gmail.com
 */

public class OpenCloseTimeForCurrentMonthTest {

    public static void main(String[] args) {

        LocalTime startTime = LocalTime.of(10, 00, 00);

        LocalTime endTime = LocalTime.of(19, 00, 00);

        System.out.println("Set open time 10.00, close time 19.00 for all Mondays in the current Month!");
        List<TimeSlot> mondaySlot = generateOpenCloseDateTimesForGivenWeekDayForCurrentMonth(startTime, endTime, DayOfWeek.MONDAY, 2020);
        System.out.println("Save me to database: Slot size " + mondaySlot.size());

    }

    public static List<TimeSlot> generateOpenCloseDateTimesForGivenWeekDayForCurrentMonth(LocalTime openTime, LocalTime closeTime, DayOfWeek weekDay, int year) {

        List<TimeSlot> slotList = new ArrayList();

        Month currentMonth = DateTimeProvider.getCurrentMonth();

        int lastDayOfMonth = DateTimeProvider.getLastDayOfCurrentMonth(year);

        LocalDate startDate = LocalDate.of(year, currentMonth, DateTimeProvider.getFirstDayOfMonth());

        LocalDate endDate = LocalDate.of(year, currentMonth, lastDayOfMonth);

        List<LocalDate> datesBetween = DateTimeProvider.getDatesBetween(startDate, endDate);

        int businessDaysInMonth = DateTimeProvider.getBusinessDaysInMonth(endDate);

        System.out.println("BusinessDaysInMonth " + businessDaysInMonth);

        TimeSlot timeSlot = null;
        for (LocalDate ld : datesBetween) {
            DayOfWeek dayOfWeekFromLocalDate = DateTimeProvider.getDayOfWeekFromLocalDate(ld);

            if (weekDay.getValue() == dayOfWeekFromLocalDate.getValue()) {
                LocalDateTime openDateTime = LocalDateTime.of(ld, openTime);
                LocalDateTime closeDateTime = LocalDateTime.of(ld, closeTime);

                timeSlot = new TimeSlot(year, currentMonth, dayOfWeekFromLocalDate, openDateTime, closeDateTime, openTime, closeTime, lastDayOfMonth, businessDaysInMonth);
                slotList.add(timeSlot);
                System.out.println(dayOfWeekFromLocalDate + " Open Date " + openDateTime + " Close Day " + closeDateTime);

            }
        }

        return slotList;

    }

}
