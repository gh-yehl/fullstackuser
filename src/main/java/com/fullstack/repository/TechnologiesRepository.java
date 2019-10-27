package com.fullstack.repository;

import com.fullstack.domain.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologiesRepository extends JpaRepository<Technologies,Long> {

      public Technologies findById(long id);
      public List<Technologies> findAll();
      public void deleteById(long id);
}
