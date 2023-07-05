package com.antra.DynamoDBdemo.service;

import com.antra.DynamoDBdemo.entity.Homework;

import java.util.List;

public interface HomeworkService {
    Homework saveHomework(Homework homework);
    Homework getHomeworkById(String homeworkId);
    List<Homework> getAllHomework();
    void deleteHomework(String homeworkId);

    Homework updateHomework(Homework homework);
}
