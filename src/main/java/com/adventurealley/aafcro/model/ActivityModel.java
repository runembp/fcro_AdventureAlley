package com.adventurealley.aafcro.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activities")
public class ActivityModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activity_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private Integer min_height;

    private Integer min_age;

    private String equipment;

    public ActivityModel(){}

    public ActivityModel(String title, String description, Integer min_height, Integer min_age, String equipment){
        this.title = title;
        this.description = description;
        this.min_height = min_height;
        this.min_age = min_age;
        this.equipment = equipment;
    }

    //TODO
    //Relation skal implementeres

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

    public int getMin_height() {
        return min_height;
    }

    public void setMin_height(int min_height) {
        this.min_height = min_height;
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
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
        return title.equals(that.title) && description.equals(that.description) && min_height.equals(that.min_height) && min_age.equals(that.min_age) && equipment.equals(that.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, min_height, min_age, equipment);
    }
}
