package com.fullstack.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "technologies")
public class Technologies implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "technology_name", nullable = false)
    private String technologyName;

    @Column(name = "Total_Hours", nullable = false)
    private String TotalHours;

    @Column(name = "fee", nullable = false)
    private String fee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTotalHours() {
        return TotalHours;
    }

    public void setTotalHours(String totalHours) {
        TotalHours = totalHours;
    }
}
