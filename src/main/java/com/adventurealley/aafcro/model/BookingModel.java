package com.adventurealley.aafcro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private Long dummy;
    private Long dummyTimeSlot;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    @JsonIgnore
    private ActivityModel activity;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    @JsonIgnore
    private TimeSlotModel timeSlot;

    public BookingModel() {
    }

    public BookingModel(LocalDate bookingDate, Long userId) {
        this.bookingDate = bookingDate;
        this.userId = userId;
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

    public void setActivity(ActivityModel activity) {
        this.activity = activity;
    }

    public ActivityModel getActivity() {
        return activity;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public Long getBookingId() {
        return id;
    }

    public void setBookingDate(LocalDate date) {
        this.bookingDate = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
