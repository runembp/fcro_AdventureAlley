package com.adventurealley.aafcro.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name = "activities")
public class ActivityModel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Column(name= "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "min_height")
    private Integer minHeight;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToMany
    @JoinTable(
            name = "activity_timeslots",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id")
    )
    @JsonIgnore
    Set<TimeSlotModel> timeslot = new HashSet<>();

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private Set<BookingModel> bookingsSet = new HashSet<>();

    public ActivityModel(){}

    public ActivityModel(String title, String description, Double price, Integer minHeight, Integer minAge, String equipment, String imageLink){
        this.title = title;
        this.description = description;
        this.price = price;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.equipment = equipment;
        this.imageLink = imageLink;
    }


    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activity_id) {
        this.activityId = activity_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Set<TimeSlotModel> getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Set<TimeSlotModel> timeslot) {
        this.timeslot = timeslot;
    }

    public Set<BookingModel> getBookingsSet() {
        return bookingsSet;
    }

    public void setBookingsSet(Set<BookingModel> bookingsSet) {
        this.bookingsSet = bookingsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityModel that = (ActivityModel) o;
        return title.equals(that.title) && description.equals(that.description) && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price);
    }
}
