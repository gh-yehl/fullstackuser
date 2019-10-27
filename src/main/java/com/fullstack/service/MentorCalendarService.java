package com.fullstack.service;

import com.fullstack.domain.MentorCalendar;
import com.fullstack.model.MentorCalendarDTO;
import com.fullstack.repository.MentorCalendarRepository;
import com.fullstack.utils.FullStackBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorCalendarService {
    @Autowired
    private MentorCalendarRepository mentorCalendarRepository;

    public void addCalendar(MentorCalendarDTO mentorCalendarDTO) {
        MentorCalendar mentorCalendar = FullStackBeanUtils.cloneMentorCalendarDTO(mentorCalendarDTO);
        mentorCalendarRepository.save(mentorCalendar);
    }
}
