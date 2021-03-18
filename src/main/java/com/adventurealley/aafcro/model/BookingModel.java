package com.adventurealley.aafcro.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class BookingModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "date", nullable = false)
    LocalDate date;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    ActivityModel activity;

    public BookingModel() {
    }

    public BookingModel(LocalDate date, Long userId, ActivityModel activity)
    {
        this.date = date;
        this.userId = userId;
        this.activity = activity;
    }

    public ActivityModel getActivity()
    {
        return activity;
    }

    public void setActivity(ActivityModel activity)
    {
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
