package com.adventurealley.aafcro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "timeslots")
public class TimeSlotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slot_id")
    private Long timeSlotId;

    @Column(name = "activity_start", nullable = false)
    private String start;

    @Column(name = "activity_end", nullable = false)
    private String end;

    @ManyToMany(mappedBy = "timeSlotModelSet")
    @JsonIgnore
    Set<ActivityModel> activityModelSet = new HashSet<>();

    @OneToMany(mappedBy = "timeSlot")
    private Set<BookingModel> bookings = new HashSet<>();

    public TimeSlotModel(){}

    public TimeSlotModel(String start, String end){
        this.start = start;
        this.end = end;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Set<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public Set<ActivityModel> getActivityModelSet()
   {
       return activityModelSet;
   }

   public void setActivityModelSet(Set<ActivityModel> activities)
   {
       this.activityModelSet = activities;
   }
}
