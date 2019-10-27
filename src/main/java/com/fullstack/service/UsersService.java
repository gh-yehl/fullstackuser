package com.fullstack.service;

import com.fullstack.domain.Trainings;
import com.fullstack.domain.Users;
import com.fullstack.model.TrainingInfoDTO;
import com.fullstack.model.TrainingsDTO;
import com.fullstack.model.UsersDTO;
import com.fullstack.repository.UsersRepository;
import com.fullstack.utils.FullStackBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void addUser(UsersDTO usersDTO) {
        Users users = FullStackBeanUtils.cloneUsersDTO(usersDTO);
        usersRepository.save(users);
    }

    public void editUser(UsersDTO usersDTO) {
        Users users = FullStackBeanUtils.cloneUsersDTO(usersDTO);
        usersRepository.save(users);
    }

    public UsersDTO findUserById(long id) {
        return FullStackBeanUtils.cloneUsers(usersRepository.findById(id));
    }

    public UsersDTO findUser(UsersDTO usersDTO) {
        Users user = usersRepository.findUsersByEmailAndPassword(usersDTO.getEmail(), usersDTO.getPassword());
        return FullStackBeanUtils.cloneUsers(user);
    }

    public List<UsersDTO> findAll() {
        List<Users> list = usersRepository.findAll();
        List<UsersDTO> newList = new ArrayList();
        for (Users user: list) {
            UsersDTO usersDTO = FullStackBeanUtils.cloneUsers(user);
            newList.add(usersDTO);
        }
        return newList;
    }

//    public List<TrainingInfoDTO> findTrainings(int technology_id, Time start_time, Time end_time) {
//        return usersRepository.findTrainingInfo(technology_id, start_time, end_time);
//    };

    public List<TrainingInfoDTO> guestSearch(long technology_id, Time start_time, Time end_time) {
        List<TrainingInfoDTO> list = usersRepository.findTrainingInfo(technology_id,start_time,end_time);
        return list;
    }

    public UsersDTO findUsers(int id) {
        Users users = usersRepository.findUsersById(id);
        UsersDTO usersDTO = new UsersDTO();
        usersDTO = FullStackBeanUtils.cloneUsers(users);

        List<Trainings> list = users.getTrainingsList();
        List<TrainingsDTO> trainingsDTOList = new ArrayList<TrainingsDTO>();
        if (list != null && list.size() > 0) {
            for (Trainings trainings : list) {
                trainingsDTOList.add(FullStackBeanUtils.cloneTrainings(trainings));
            }
        }

        usersDTO.setTrainingsDTOList(trainingsDTOList);
        return usersDTO;
    };

    /**
     * Used by function Admin search
     * @param userName
     * @return
     */
    public List<UsersDTO> findUsersByName(String userName) {
        List<UsersDTO> list = new ArrayList<UsersDTO>();
        List<Users> usersList = new ArrayList<Users>();
        if("*".equals(userName)) {
            usersList = usersRepository.findAll();
        }else {
            usersList = usersRepository.findByUserNameLike(userName);
        }

        for(Users users: usersList) {
            list.add(FullStackBeanUtils.cloneUsers(users));
        }
        return list;
    }
}
