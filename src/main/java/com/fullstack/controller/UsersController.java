package com.fullstack.controller;

import com.fullstack.model.TrainingsDTO;
import com.fullstack.model.UsersDTO;
import com.fullstack.service.TrainingsService;
import com.fullstack.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TrainingsService trainingsService;

    @RequestMapping("/currentTrainings")
    public List<TrainingsDTO> currentTrainings(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        List<TrainingsDTO> list = trainingsService.getUserCurrentTraining(Long.valueOf(userId));
        return list;
    }

    @RequestMapping("/completedTrainings")
    public List<TrainingsDTO> completedTrainings(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        List<TrainingsDTO> list = trainingsService.getUserCompletedTraining(Long.valueOf(userId));
        return list;
    }


    @RequestMapping(value = "/proposeTraining", method = RequestMethod.POST)
    public TrainingsDTO proposeTraining(@RequestBody TrainingsDTO trainingsDTO) {
        trainingsDTO.setStatus("0");

        trainingsService.addTraining(trainingsDTO);
        return trainingsDTO;
    }


}
