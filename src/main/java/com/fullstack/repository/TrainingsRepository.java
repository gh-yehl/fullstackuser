package com.fullstack.repository;

import com.fullstack.domain.Trainings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingsRepository extends JpaRepository<Trainings,Long> {
    public Trainings findByMentorId(long id);
    public List<Trainings> findByMentorIdAndStatus(long id, String status);
    public List<Trainings> findByUserIdAndStatus(long id, String status);
}

