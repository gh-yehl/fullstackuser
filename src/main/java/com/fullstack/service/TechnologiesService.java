package com.fullstack.service;

import com.fullstack.domain.Technologies;
import com.fullstack.model.TechnologiesDTO;
import com.fullstack.repository.TechnologiesRepository;
import com.fullstack.utils.FullStackBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Service
public class TechnologiesService {

    @Autowired
    private TechnologiesRepository technologiesRepository;

    public void addTechnologies(TechnologiesDTO technologiesDTO) {
        technologiesRepository.save(FullStackBeanUtils.cloneTechnologiesDTO(technologiesDTO));
    }

    public void editTechnologies(TechnologiesDTO technologiesDTO) {
        technologiesRepository.save(FullStackBeanUtils.cloneTechnologiesDTO(technologiesDTO));
    }


    public List<TechnologiesDTO> getAllTechnologies() {
        List<TechnologiesDTO> dtoList = new ArrayList<>();
        List<Technologies> list = technologiesRepository.findAll();

        if (list != null && list.size() > 0)  {
            Iterator iter = list.iterator();
            while(iter.hasNext()){
                Technologies technologies = (Technologies) iter.next();
                dtoList.add(FullStackBeanUtils.cloneTechnologies(technologies));
            }
        }
        return dtoList;
    }

    public TechnologiesDTO getTechnologyById(long id) {
        Technologies technologies = technologiesRepository.findById(id);
        return FullStackBeanUtils.cloneTechnologies(technologies);
    }

    public void deleteTechnology(long id) {
        technologiesRepository.deleteById(id);
    }
}
