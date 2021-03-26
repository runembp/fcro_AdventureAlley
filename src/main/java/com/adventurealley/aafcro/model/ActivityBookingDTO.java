package com.adventurealley.aafcro.model;

import java.time.LocalDate;

public class ActivityBookingDTO
{
    //Activity
    private String title;
    private String equipment;
    private int minAge;
    private int minHeight;

    //Booking
    private Long timeslotId;
    private LocalDate bookingDate;

    //User
    private String userFirstName;
    private String userLastname;
    private LocalDate userBirthDate;
    private int height;

    public ActivityBookingDTO(String title, String equipment, int minAge, int minHeight, Long timeslotId, LocalDate bookingDate, String userFirstName, String userLastname, LocalDate userBirthDate, int height)
    {
        this.title = title;
        this.equipment = equipment;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.timeslotId = timeslotId;
        this.bookingDate = bookingDate;
        this.userFirstName = userFirstName;
        this.userLastname = userLastname;
        this.userBirthDate = userBirthDate;
        this.height = height;
    }

    public String getTitle()
    {
        return title;
    }

    public String getEquipment()
    {
        return equipment;
    }

    public int getMinAge()
    {
        return minAge;
    }

    public int getMinHeight()
    {
        return minHeight;
    }

    public Long getTimeslotId()
    {
        return timeslotId;
    }

    public LocalDate getBookingDate()
    {
        return bookingDate;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }

    public String getUserLastname()
    {
        return userLastname;
    }

    public LocalDate getUserBirthDate()
    {
        return userBirthDate;
    }

    public int getHeight()
    {
        return height;
    }
}
