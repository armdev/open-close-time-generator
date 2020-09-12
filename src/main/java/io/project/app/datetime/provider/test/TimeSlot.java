/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.datetime.provider.test;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 *
 * @author armen.arzumanyan@gmail.com
 */
public class TimeSlot implements Serializable{

    private int year;
    
    private Month month;

    private DayOfWeek dayOfWeek;

    private LocalDateTime openDateTime;

    private LocalDateTime closeDateTime;

    private LocalTime openTime;

    private LocalTime closeTime;
    
    private int lastDayOfMonth;
    
    private int businessDaysInMonth;

    public TimeSlot() {
    }

    public TimeSlot(int year, Month month, DayOfWeek dayOfWeek, LocalDateTime openDateTime, LocalDateTime closeDateTime, LocalTime openTime, LocalTime closeTime, int lastDayOfMonth, int businessDaysInMonth) {
        this.year = year;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.lastDayOfMonth = lastDayOfMonth;
        this.businessDaysInMonth = businessDaysInMonth;
    }
    
    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(LocalDateTime openDateTime) {
        this.openDateTime = openDateTime;
    }

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public void setCloseDateTime(LocalDateTime closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public int getLastDayOfMonth() {
        return lastDayOfMonth;
    }

    public void setLastDayOfMonth(int lastDayOfMonth) {
        this.lastDayOfMonth = lastDayOfMonth;
    }

    public int getBusinessDaysInMonth() {
        return businessDaysInMonth;
    }

    public void setBusinessDaysInMonth(int businessDaysInMonth) {
        this.businessDaysInMonth = businessDaysInMonth;
    }
    

}
