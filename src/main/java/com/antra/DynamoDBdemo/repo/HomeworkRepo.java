package com.antra.DynamoDBdemo.repo;

import com.antra.DynamoDBdemo.entity.Homework;
import org.springframework.data.repository.CrudRepository;


public interface HomeworkRepo{
    Homework save(Homework homework);
    Homework findById(String homeworkId);
    Iterable<Homework> findAll();
    void delete(String homeworkId);

}
