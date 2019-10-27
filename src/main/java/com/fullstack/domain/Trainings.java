package com.fullstack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "trainings")
public class Trainings implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "mentor_id", insertable = false, updatable = false)
    private Users mentor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;


    @ManyToOne
    @JoinColumn(name = "technology_id", insertable = false, updatable = false)
    private Technologies technologies;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "mentor_id", nullable = false)
    private long mentorId;

    @Column(name = "technology_id", nullable = false)
    private long technologyId;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "start_time", nullable = true)
    private Time startTime;

    @Column(name = "endTime", nullable = true)
    private Time endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMentorId() {
        return mentorId;
    }

    public void setMentorId(long mentorId) {
        this.mentorId = mentorId;
    }

    public long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(long technologyId) {
        this.technologyId = technologyId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Technologies getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Technologies technologies) {
        this.technologies = technologies;
    }

    public Users getMentor() {
        return mentor;
    }

    public void setMentor(Users mentor) {
        this.mentor = mentor;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
