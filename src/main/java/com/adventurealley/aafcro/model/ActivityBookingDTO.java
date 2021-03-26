package com.adventurealley.aafcro.model;

import java.time.LocalDate;

public class ActivityBookingDTO
{
    private String activityTitle;
    private LocalDate date;

    public ActivityBookingDTO(String activityTitle, LocalDate date)
    {
        this.activityTitle = activityTitle;
        this.date = date;
    }

    public String getActivityTitle()
    {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle)
    {
        this.activityTitle = activityTitle;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}
