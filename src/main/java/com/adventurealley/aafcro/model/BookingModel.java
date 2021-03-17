package com.adventurealley.aafcro.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bookings")
public class BookingModel
{
    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    LocalDate date;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "activity_id", nullable = false)
    private Long activityId;

    @ManyToMany(mappedBy = "activityBookingSet")
    Set<ActivityModel> activityBookingSet = new HashSet<>();

    public Set<ActivityModel> getActivityBookingSet() {
        return activityBookingSet;
    }

    public void setActivityBookingSet(Set<ActivityModel> activityBookingSet) {
        this.activityBookingSet = activityBookingSet;
    }

    public BookingModel() {
    }

    public BookingModel(LocalDate date, Long userId, Long activityId) {
        this.date = date;
        this.userId = userId;
        this.activityId = activityId;
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
