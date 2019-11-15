package com.fullstack.controller;

import com.fullstack.domain.Users;
import com.fullstack.model.*;
import com.fullstack.service.MentorCalendarService;
import com.fullstack.service.MentorSkillsService;
import com.fullstack.service.TrainingsService;
import com.fullstack.service.UsersService;
import com.fullstack.utils.FullStackBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class ApplicationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private MentorCalendarService mentorCalendarService;

    @Autowired
    private MentorSkillsService mentorSkillsService;

    @Autowired
    private TrainingsService trainingsService;
    /**
     * User signUp Function
     * @param userFormDTO
     * @return
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public UsersDTO signUp(@RequestBody UsersDTO userFormDTO) {
        userFormDTO.setActive("1");
        usersService.addUser(userFormDTO);

        UsersDTO savedUsersDTO = usersService.findUser(userFormDTO);
        //set calendar and skills for Mentor
        if("Mentor".equals(userFormDTO.getRole())) {
            //set calendar
            long mentor_id = savedUsersDTO.getId();
            MentorCalendarDTO mentorCalendarDTO = new MentorCalendarDTO();
            mentorCalendarDTO.setMentorId(mentor_id);
            mentorCalendarDTO.setStartTime(Time.valueOf(userFormDTO.getSignup_startTime()));
            mentorCalendarDTO.setEndTime(Time.valueOf(userFormDTO.getSignup_endTime()));
            mentorCalendarService.addCalendar(mentorCalendarDTO);
            
            //set skills
            List<MentorSkillsDTO> skillsDTOList = new ArrayList<MentorSkillsDTO>();
            String skills = userFormDTO.getTechnologiesSelected();
            String[] skillArr = skills.split(",");
            for (String technology: skillArr) {
                MentorSkillsDTO mentorSkillsDTO = new MentorSkillsDTO();
                mentorSkillsDTO.setMentorId(mentor_id);
                mentorSkillsDTO.setTechnologyId(Long.valueOf(technology));
                skillsDTOList.add(mentorSkillsDTO);
            }
            mentorSkillsService.addAllMentorSkills(skillsDTOList);
        }

        return savedUsersDTO;
    }


    /**
     * User signIn function
     * @param userFormDTO
     * @return
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public UsersDTO sigIn(@RequestBody UsersDTO userFormDTO) {
        UsersDTO usersDTO = usersService.findUser(userFormDTO);

        return usersDTO;
    }


    /**
     * GuestSearch Function
     * @param request
     * @return
     */
    @RequestMapping("/guestSearch")
    public List<TrainingInfoDTO> findTrainings(HttpServletRequest request) {
        String technologyId = request.getParameter("technologyId");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");

        List<TrainingInfoDTO> list = usersService.guestSearch(Long.valueOf(technologyId), Time.valueOf(startTime), Time.valueOf(endTime));
        System.out.println(list);
        return list;
    }

    
//    @RequestMapping("/findUsers")
//    public UsersDTO findUsers(String email, String endTime, String technology) {
//        Time start_time = Time.valueOf("13:00:00");
//        Time end_time = Time.valueOf("18:00:00");
//
//        UsersDTO usersDTO = usersService.findUsers(1);
//        return usersDTO;
//    }
    
@RequestMapping("/test")
public String test(HttpServletRequest request) {
    return "heiha";
}

}
