package com.antra.DynamoDBdemo.controller;

import com.antra.DynamoDBdemo.entity.Homework;
import com.antra.DynamoDBdemo.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    private final HomeworkService homeworkService;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping
    public Homework createHomework(@RequestBody Homework homework) {
        return homeworkService.saveHomework(homework);
    }

    @GetMapping("/{homeworkId}")
    public Homework getHomeworkById(@PathVariable String homeworkId) {
        return homeworkService.getHomeworkById(homeworkId);
    }

    @GetMapping
    public List<Homework> getAllHomework() {
        return homeworkService.getAllHomework();
    }

    @DeleteMapping("/{homeworkId}")
    public void deleteHomework(@PathVariable String homeworkId) {
        homeworkService.deleteHomework(homeworkId);
    }

    @PutMapping("/{homeworkId}")
    public Homework updateHomework(@PathVariable String homeworkId, @RequestBody Homework homework) {
        homework.setHomeworkId(homeworkId);
        return homeworkService.updateHomework(homework);
    }
}