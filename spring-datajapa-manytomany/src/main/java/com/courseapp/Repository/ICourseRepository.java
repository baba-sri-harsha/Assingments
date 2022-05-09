package com.courseapp.Repository;

import com.courseapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {

    Course findById(int courseId);
    List<Course> findAll();
    List<Course> findByCategory(String category);

    List<Course> findByCourseNameContaining(String name); // all course having java

    @Query("from Course c  where c.courseName like ?1 and c.fees<=?2")
    List<Course> findByNameAndFees(String name, double fees);

    @Query("from Course c  inner join c.trainers t where t.trainerName=?1")
    List<Course> findByTrainer(String trainerName); // all course by this trainer

    @Query("from Course c  inner join c.trainers t where t.trainerName=?1 and t.techStack=?2")
    List<Course> findByTrainerExpertise(String trainerName,String techStack );

    @Query("from Course c  inner join c.trainers t where t.trainerName=?1 and t.ratings=?2")
    List<Course> findByTrainerRatings(String trainerName,double ratings );

    @Query("from Course c  inner join c.trainers t where t.trainerName=?1 and t.experience=?2")
    List<Course> findByTrainerExperience(String trainerName,int experience  );

    @Query("from Course c  inner join c.trainers t where t.trainerName=?1 and c.courseName like ?2")
    List<Course> findByTrainerCourseName(String trainerName,String courseName  ); //name containing

    @Query("from Course c   where c.courseName=?1 and c.durationDays=?2")
    List<Course> findByNameDuration(String name, int duration);

}
