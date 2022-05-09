package com.courseapp.Service;

import com.courseapp.model.Trainer;

import java.time.LocalDate;
import java.util.List;


public interface ITrainerService {

    Trainer addTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(int trainerId);
    Trainer getById(int trainerId);

    List<Trainer>  getByCourseNameContaining(String courseName);

    List<Trainer> getByTechStackRatings(String techStack , double ratings);

    List<Trainer> getBySubCategoryTopic(String subcategory , String topic);

    List<Trainer> getBySubCategoryLevel(String subcategory , String level);

    List<Trainer> getByTopicLanguage(String topic , String language);

    List<Trainer> getByTopic(String topic );

    List<Trainer> getByTopicLevel(String topic , String level);

    List<Trainer> getByTopicFeature(String topic , String feature);






}