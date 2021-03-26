package com.adventurealley.aafcro.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "bookings")
public class BookingModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingID;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    private Long dummy;
    private Long dummyTimeSlot;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user_id")
    private UserModel users;


    @ManyToOne
    @JoinColumn(name = "activity_id")
    @JsonBackReference(value = "activity")
    private ActivityModel activity;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    @JsonBackReference(value = "timeslot")
    private TimeSlotModel timeSlot;

    public BookingModel() {
    }

    public BookingModel(LocalDate now) {
        this.bookingDate = now;

    }

    public ActivityModel getActivity() {
        return activity;
    }

    public void setActivity(ActivityModel activity) {
        this.activity = activity;
    }

    public UserModel getUsers() {
        return users;
    }

    public void setUsers(UserModel users) {
        this.users = users;
    }

    public Long getDummy() {
        return dummy;
    }

    public void setDummy(Long activityId) {
        this.dummy = activityId;
    }

    public Long getDummyTimeSlot() {
        return dummyTimeSlot;
    }

    public TimeSlotModel getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlotModel timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setDummyTimeSlot(Long dummeTimeSlot) {
        this.dummyTimeSlot = dummeTimeSlot;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

}
