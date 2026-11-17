package com.klef.soa.exam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "volunteer_activities")
public class VolunteerActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Activity name is required")
    @Column(nullable = false)
    private String activityName;

    @NotBlank(message = "Organizer name is required")
    @Column(nullable = false)
    private String organizerName;

    @Min(value = 0)
    @Column(nullable = false)
    private Integer volunteerCount;

    @Column(nullable = false)
    private Boolean active;

    public VolunteerActivity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public Integer getVolunteerCount() {
        return volunteerCount;
    }

    public void setVolunteerCount(Integer volunteerCount) {
        this.volunteerCount = volunteerCount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}