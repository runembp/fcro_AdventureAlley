package com.adventurealley.aafcro.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name = "bookings")
public class BookingModel implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    private Long dummy;
    private Long dummyTimeSlot;

    @ManyToOne
    //@JsonBackReference(value = "id")
    private UserModel users;


    @ManyToOne
    @JsonBackReference(value = "activity")
    private ActivityModel activityModel;


    @ManyToOne
    @JsonBackReference(value = "timeslot")
    private TimeSlotModel timeSlot;


    public BookingModel() {
    }

    public BookingModel(LocalDate now) {
        this.bookingDate = now;

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

    public void setActivity(ActivityModel activityModel) {
        this.activityModel = activityModel;
    }


    public ActivityModel getActivity() {
        return activityModel;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public Long getBookingId() {
        return id;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

}
