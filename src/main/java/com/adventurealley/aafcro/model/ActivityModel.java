package com.adventurealley.aafcro.model;

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
    private Long activity_id;

    @Column(name= "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "min_height")
    private Integer minHeight;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "equipment")
    private String equipment;

    @ManyToMany
    @JoinTable(
            name = "activity_timeslots",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id")
    )
    Set<TimeSlotModel> timeSlotModelSet = new HashSet<>();

    public ActivityModel(){}

    public ActivityModel(String title, String description, Double price, Integer minHeight, Integer minAge, String equipment){
        this.title = title;
        this.description = description;
        this.price = price;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.equipment = equipment;
    }

   public Set<TimeSlotModel> getTimeSlotModelSet()
   {
       return timeSlotModelSet;
   }

   public void setTimeSlotModelSet(Set<TimeSlotModel> timeslots){
        this.timeSlotModelSet = timeslots;
   }

    public Long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Long activity_id) {
        this.activity_id = activity_id;
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
