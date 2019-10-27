package com.fullstack.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mentorskills")
public class MentorSkills implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "mentor_id", nullable = false)
    private long mentorId;

    @Column(name = "technology_id", nullable = false)
    private long technologyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
