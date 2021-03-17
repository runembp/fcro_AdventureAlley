package com.adventurealley.aafcro.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
}
