package com.courseapp.Repository;

import com.courseapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITrainerRepository extends JpaRepository<Trainer, Integer> {


    List<Trainer> findByTrainerNameContaining(String trainerName); // all trainers with the trainer name containing

    List<Trainer> findByCoursesCourseName(String courseName); // all trainers for a course name containing java
   // Trainer findTrainerDetails(String trainerName); // all course by this trainer

    List<Trainer> findByTechStack(String techStack );

    @Query("from Trainer t inner join t.courses c where c.category=?1 and t.ratings<=?2")
    List<Trainer> findByTrainerRatings(String category,double ratings );

    @Query("from Trainer t inner join t.courses c where c.category=?1 and t.experience>=?2")
    List<Trainer> findByTrainerExperience(String category,int experience  );

    @Query("from Trainer t inner join t.courses c where c.courseName like ?1 and c.fees<=?2")
    List<Trainer> findByCourseNameFees(String courseName, double fees  );

    @Query("from Trainer t inner join t.courses c where c.courseName like ?1 and c.durationDays=?2")
    List<Trainer> findByNameDuration(String courseName, int duration); // all course having java

    @Query("from Trainer t where t.joiningDate<=?1")
    List<Trainer>findByJoiningBetween(LocalDate beforeDate);


}
