package com.courseapp.Service;

import com.courseapp.Repository.ITrainerRepository;
import com.courseapp.model.Trainer;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainerServiceImpl implements  ITrainerService{

    ITrainerRepository trainerRepository;

    public TrainerServiceImpl(ITrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
         trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(int trainerId) {
        trainerRepository.deleteById(trainerId);
    }

    @Override
    public Trainer getById(int trainerId) {
        return trainerRepository.getById(trainerId);
    }

    @Override
    public List<Trainer> getByCourseNameContaining(String courseName) {
        return trainerRepository.findByTrainerNameContaining(courseName);
    }

    @Override
    public List<Trainer> getByTechStackRatings(String techStack, double ratings) {
        return trainerRepository.findByTrainerRatings(techStack,ratings);
    }

    @Override
    public List<Trainer> getBySubCategoryTopic(String subcategory, String topic) {
        return trainerRepository.findByS;
    }

    @Override
    public List<Trainer> getBySubCategoryLevel(String subcategory, String level) {
        return trainerRepository.findBy ;
    }

    @Override
    public List<Trainer> getByTopicLanguage(String topic, String language) {
        return null;
    }

    @Override
    public List<Trainer> getByTopic(String topic) {
        return null;
    }

    @Override
    public List<Trainer> getByTopicLevel(String topic, String level) {
        return trainerRepository.findByT;
    }

    @Override
    public List<Trainer> getByTopicFeature(String topic, String feature) {
        return null;
    }
}
