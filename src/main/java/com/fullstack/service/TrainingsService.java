package com.fullstack.service;

import com.fullstack.domain.Trainings;
import com.fullstack.model.TrainingsDTO;
import com.fullstack.repository.TrainingsRepository;
import com.fullstack.utils.FullStackBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingsService {

    @Autowired
    private TrainingsRepository trainingsRepository;

    /**
     * Find training by mentor ID(Table: Trainings; Column: Mentor_ID)
     * @param
     * @return
     */
    public void addTraining(TrainingsDTO trainingsDTO) {
        trainingsRepository.save(FullStackBeanUtils.cloneTrainingsDTO(trainingsDTO));
    }

    public List getMentorCurrentTraining(long id) {
        List<Trainings> list = trainingsRepository.findByMentorIdAndStatus(id, "0");
        List<TrainingsDTO> newList = new ArrayList<TrainingsDTO>();
        for (Trainings trainings : list) {
            TrainingsDTO trainingsDTO = FullStackBeanUtils.cloneTrainings(trainings);
            newList.add(trainingsDTO);
        }
        return newList;
    }

    public List getMentorCompletedTraining(long id) {
        List<Trainings> list = trainingsRepository.findByMentorIdAndStatus(id, "1");
        List<TrainingsDTO> newList = new ArrayList<TrainingsDTO>();
        for (Trainings trainings : list) {
            TrainingsDTO trainingsDTO = FullStackBeanUtils.cloneTrainings(trainings);
            newList.add(trainingsDTO);
        }
        return newList;
    }

    public List getUserCurrentTraining(long id) {
        List<Trainings> list = trainingsRepository.findByUserIdAndStatus(id, "0");
        List<TrainingsDTO> newList = new ArrayList<TrainingsDTO>();
        for (Trainings trainings : list) {
            TrainingsDTO trainingsDTO = FullStackBeanUtils.cloneTrainings(trainings);
            newList.add(trainingsDTO);
        }
        return newList;
    }

    public List getUserCompletedTraining(long id) {
        List<Trainings> list = trainingsRepository.findByUserIdAndStatus(id, "1");
        List<TrainingsDTO> newList = new ArrayList<TrainingsDTO>();
        for (Trainings trainings : list) {
            TrainingsDTO trainingsDTO = FullStackBeanUtils.cloneTrainings(trainings);
            newList.add(trainingsDTO);
        }
        return newList;
    }
}
