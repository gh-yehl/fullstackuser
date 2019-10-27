package com.fullstack.model;

import java.util.List;

public class UsersDTO {

    private long id;
    private String userName;
    private String password;
    private String contactNumber;
    private String role;
    private String linkedinURL;
    private String workingYears;
    private String active;
    private String email;
    private String trainingsDelivered;

    private String signup_startTime;
    private String signup_endTime;
    private String technologiesSelected;
    private String status;


    private List<TrainingsDTO> trainingsDTOList;

    public List<TrainingsDTO> getTrainingsDTOList() {
        return trainingsDTOList;
    }

    public void setTrainingsDTOList(List<TrainingsDTO> trainingsDTOList) {
        this.trainingsDTOList = trainingsDTOList;
        if(trainingsDTOList != null && trainingsDTOList.size() > 0) {
            setTrainingsDelivered(String.valueOf(trainingsDTOList.size()));
        }
    }

    public String getTrainingsDelivered() {
        return trainingsDelivered;
    }

    public void setTrainingsDelivered(String trainingsDelivered) {
        this.trainingsDelivered = trainingsDelivered;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLinkedinURL() {
        return linkedinURL;
    }

    public void setLinkedinURL(String linkedinURL) {
        this.linkedinURL = linkedinURL;
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears;
    }


    public String getSignup_startTime() {
        return signup_startTime;
    }

    public void setSignup_startTime(String signup_startTime) {
        this.signup_startTime = signup_startTime;
    }

    public String getSignup_endTime() {
        return signup_endTime;
    }

    public void setSignup_endTime(String signup_endTime) {
        this.signup_endTime = signup_endTime;
    }

    public String getStatus() {
        if("1".equals(getActive())) {
            this.status = "Active";
        }
        else {
            this.status = "In-active";
        }

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTechnologiesSelected() {
        return technologiesSelected;
    }

    public void setTechnologiesSelected(String technologiesSelected) {
        this.technologiesSelected = technologiesSelected;
    }
}
