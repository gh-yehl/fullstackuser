package com.fullstack.repository;

import com.fullstack.domain.Users;
import com.fullstack.model.TrainingInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;


public interface UsersRepository extends JpaRepository<Users,Long> {
    public Users findById(long id);

    public Users findUsersByEmailAndPassword(String email, String password);


    @Query(value =  "select new com.fullstack.model.TrainingInfoDTO(mc.mentorId, u.userName, t.id, t.fee, t.technologyName, u.workingYears, u, mc) " +
                    "from Users u, MentorCalendar mc, MentorSkills ms, Technologies t " +
                    "where u.id=mc.mentorId and mc.mentorId = ms.mentorId and ms.technologyId = t.id " +
                           "and ms.technologyId = ?1 and  ?2 <= mc.startTime  and mc.endTime <= ?3 "   )
    public List<TrainingInfoDTO> findTrainingInfo(long technology_id, Time start_time, Time end_time);

    @Query(value = "select * from users u where u.id = ?1 ", nativeQuery = true)
    public Users findUsersById(int id);

    @Query(value = "select * from Users u where u.user_name like %?1% " , nativeQuery = true)
    public List<Users> findByUserNameLike(String userName);
}
