package com.antra.DynamoDBdemo.service;

import com.antra.DynamoDBdemo.entity.Homework;
import com.antra.DynamoDBdemo.repo.HomeworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepo homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepo homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public Homework saveHomework(Homework homework) {
        return homeworkRepository.save(homework);
    }

    @Override
    public Homework getHomeworkById(String homeworkId) {
        return homeworkRepository.findById(homeworkId);
    }

    @Override
    public List<Homework> getAllHomework() {
        return (List<Homework>) homeworkRepository.findAll();
    }

    @Override
    public void deleteHomework(String homeworkId) {
        homeworkRepository.delete(homeworkId);
    }

    @Override
    public Homework updateHomework(Homework homework) {
        return homeworkRepository.updateHomework(homework);
    }
}
