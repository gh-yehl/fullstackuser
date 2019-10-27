package com.fullstack.service;

import com.fullstack.domain.MentorSkills;
import com.fullstack.model.MentorSkillsDTO;
import com.fullstack.repository.MentorSkillsRepository;
import com.fullstack.utils.FullStackBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MentorSkillsService {

    @Autowired
    private MentorSkillsRepository mentorSkillsRepository;
    private Iterable<MentorSkills> skillsList;

    public void addMentorSkills(MentorSkillsDTO mentorSkillsDTO) {
        mentorSkillsRepository.save(FullStackBeanUtils.cloneMentorSkillsDTO(mentorSkillsDTO));
    }

    public void addAllMentorSkills(List<MentorSkillsDTO> mentorSkillsDTOList) {
        List<MentorSkills> tempList = new ArrayList<MentorSkills>();
        for (MentorSkillsDTO mentorSkillsDTO: mentorSkillsDTOList) {
            MentorSkills mentorSkills= FullStackBeanUtils.cloneMentorSkillsDTO(mentorSkillsDTO);
            tempList.add(mentorSkills);
        }

        skillsList = tempList;
        mentorSkillsRepository.saveAll(skillsList);
    }
}
