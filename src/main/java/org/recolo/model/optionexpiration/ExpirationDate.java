package org.recolo.model.optionexpiration;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpirationDate
{

    private int year;
    private int month;
    private int day;
    private String expiryType;

    // Getters & Setters
    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public String getExpiryType()
    {
        return expiryType;
    }

    public void setExpiryType(String expiryType)
    {
        this.expiryType = expiryType;
    }

    /** Utility: Convert fragmented date fields to a java.time.LocalDate */
    public LocalDate toLocalDate()
    {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String toString()
    {
        return "ExpirationDate{" + "date=" + toLocalDate() + ", expiryType='" + expiryType + '\'' + '}';
    }
}
