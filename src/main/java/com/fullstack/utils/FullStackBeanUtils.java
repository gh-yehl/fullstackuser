package com.fullstack.utils;

import ch.qos.logback.classic.pattern.DateConverter;
import com.fullstack.domain.*;
import com.fullstack.model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import org.apache.commons.beanutils.BeanUtils;

public class FullStackBeanUtils {

    /**
     *
     * @param technologies
     * @return
     */
    public static TechnologiesDTO cloneTechnologies(Technologies technologies) {
        if (technologies == null) {
            return null;
        }
        TechnologiesDTO technologiesDTO = new TechnologiesDTO();
        technologiesDTO.setId(technologies.getId());
        technologiesDTO.setFee(technologies.getFee());
        technologiesDTO.setTechnologyName(technologies.getTechnologyName());
        technologiesDTO.setTotalHours(technologies.getTotalHours());
        return technologiesDTO;
    }

    public static Technologies cloneTechnologiesDTO(TechnologiesDTO technologiesDTO) {
        if (technologiesDTO == null) {
            return null;
        }
        Technologies technologies = new Technologies();
        technologies.setId(technologiesDTO.getId());
        technologies.setFee(technologiesDTO.getFee());
        technologies.setTechnologyName(technologiesDTO.getTechnologyName());
        technologies.setTotalHours(technologiesDTO.getTotalHours());
        return technologies;
    }


    /**
     *
     * @param users
     * @return
     */
    public static UsersDTO cloneUsers(Users users) {
        if(users == null) {
            return null;
        }
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setRole(users.getRole());
        usersDTO.setUserName(users.getUserName());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setActive(users.getActive());
        usersDTO.setContactNumber(users.getContactNumber());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setLinkedinURL(users.getLinkedinURL());
        usersDTO.setWorkingYears(users.getWorkingYears());
        return usersDTO;
    }

    public static Users cloneUsersDTO(UsersDTO usersDTO) {
        if (usersDTO == null) {
            return null;
        }
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setRole(usersDTO.getRole());
        users.setUserName(usersDTO.getUserName());
        users.setPassword(usersDTO.getPassword());
        users.setActive(usersDTO.getActive());
        users.setContactNumber(usersDTO.getContactNumber());
        users.setEmail(usersDTO.getEmail());
        users.setLinkedinURL(usersDTO.getLinkedinURL());
        users.setWorkingYears(usersDTO.getWorkingYears());
        return users;
    }


    /**
     *
     * @param trainings
     * @return
     */
    public static TrainingsDTO cloneTrainings(Trainings trainings) {
        if (trainings == null) {
            return null;
        }
        TrainingsDTO trainingsDTO = new TrainingsDTO();
        trainingsDTO.setId(trainings.getId());
        trainingsDTO.setMentorId(trainings.getMentorId());
        trainingsDTO.setUserId(trainings.getUserId());
        trainingsDTO.setTechnologyId(trainings.getTechnologyId());
        trainingsDTO.setStartTime(trainings.getStartTime());
        trainingsDTO.setEndTime(trainings.getEndTime());
        trainingsDTO.setStatus(trainings.getStatus());

        trainingsDTO.setTechnologies(trainings.getTechnologies());
        trainingsDTO.setUser(trainings.getUser());
        trainingsDTO.setMentor(trainings.getMentor());
        return trainingsDTO;
    }

    public static Trainings cloneTrainingsDTO(TrainingsDTO trainingsDTO) {
        if (trainingsDTO == null) {
            return null;
        }
        Trainings trainings = new Trainings();
        trainings.setId(trainingsDTO.getId());
        trainings.setMentorId(trainingsDTO.getMentorId());
        trainings.setUserId(trainingsDTO.getUserId());
        trainings.setTechnologyId(trainingsDTO.getTechnologyId());
        trainings.setStartTime(trainingsDTO.getStartTime());
        trainings.setEndTime(trainingsDTO.getEndTime());
        trainings.setStatus(trainingsDTO.getStatus());
        return trainings;
    }

    /**
     *
     * @param mentorSkills
     * @return
     */
    public static MentorSkillsDTO cloneMentorSkills(MentorSkills mentorSkills) {
        if (mentorSkills == null) {
            return null;
        }
        MentorSkillsDTO mentorSkillsDTO = new MentorSkillsDTO();
        mentorSkillsDTO.setId(mentorSkills.getId());
        mentorSkillsDTO.setMentorId(mentorSkills.getMentorId());
        mentorSkillsDTO.setTechnologyId(mentorSkills.getTechnologyId());
        return  mentorSkillsDTO;
    }

    public static MentorSkills cloneMentorSkillsDTO(MentorSkillsDTO mentorSkillsDTO) {
        if (mentorSkillsDTO == null) {
            return null;
        }
        MentorSkills mentorSkills = new MentorSkills();
        mentorSkills.setId(mentorSkillsDTO.getId());
        mentorSkills.setMentorId(mentorSkillsDTO.getMentorId());
        mentorSkills.setTechnologyId(mentorSkillsDTO.getTechnologyId());
        return  mentorSkills;
    }


    /**
     * @param mentorCalendar
     * @return
     */
    public static MentorCalendarDTO cloneMentorCalendar(MentorCalendar mentorCalendar) {
        if (mentorCalendar == null) {
            return null;
        }
        MentorCalendarDTO mentorCalendarDTO = new MentorCalendarDTO();
        mentorCalendarDTO.setId(mentorCalendar.getId());
        mentorCalendarDTO.setMentorId(mentorCalendar.getMentorId());
        mentorCalendarDTO.setTimezone(mentorCalendar.getTimezone());
        mentorCalendarDTO.setStartTime(mentorCalendar.getStartTime());
        mentorCalendarDTO.setEndTime(mentorCalendar.getEndTime());
        return mentorCalendarDTO;
    }

    public static MentorCalendar cloneMentorCalendarDTO(MentorCalendarDTO mentorCalendarDTO) {
        if (mentorCalendarDTO == null) {
            return null;
        }
        MentorCalendar mentorCalendar = new MentorCalendar();
        mentorCalendar.setMentorId(mentorCalendarDTO.getMentorId());
        mentorCalendar.setId(mentorCalendarDTO.getId());
        mentorCalendar.setTimezone(mentorCalendarDTO.getTimezone());
        mentorCalendar.setStartTime(mentorCalendarDTO.getStartTime());
        mentorCalendar.setEndTime(mentorCalendarDTO.getEndTime());
        return mentorCalendar;
    }

    public static <T> T request2Bean(HttpServletRequest request, Class<T> bean) {
        T t = null;
        try {
            t = bean.newInstance();
            Enumeration parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = (String) parameterNames.nextElement();
                String value = request.getParameter(name);

                BeanUtils.setProperty(t, name, value);//使用BeanUtils来设置对象属性的值
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;

    }
}
