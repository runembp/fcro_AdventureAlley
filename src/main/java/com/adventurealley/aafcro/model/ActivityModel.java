package com.adventurealley.aafcro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "activities")
public class ActivityModel
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "activity_timeslots",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id")
    )

    Set<TimeSlotModel> timeSlotModelSet = new HashSet<>();

    @OneToMany(mappedBy = "activity")
    private Set<BookingModel> bookings = new HashSet<>();

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

    public Set<TimeSlotModel> getTimeSlotModelSet()
   {
       return timeSlotModelSet;
   }

    public Set<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public void setTimeSlotModelSet(Set<TimeSlotModel> timeslots){
        this.timeSlotModelSet = timeslots;
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
