package com.antra.DynamoDBdemo.repo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.antra.DynamoDBdemo.entity.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DynamoDBHomeworkRepository implements HomeworkRepo{

    private final DynamoDB dynamoDB;
    private final String tableName = "Homework";
    @Autowired
    public DynamoDBHomeworkRepository(AmazonDynamoDB amazonDynamoDB) {
        this.dynamoDB = new DynamoDB(amazonDynamoDB);
    }


    @Override
    public Homework save(Homework homework) {
        Table table = dynamoDB.getTable(tableName);
        Item item = homework.toItem();
        table.putItem(item);
        return homework;
    }

    @Override
    public Homework findById(String homeworkId) {
        Table table = dynamoDB.getTable(tableName);
        GetItemSpec getItemSpec = new GetItemSpec()
                .withPrimaryKey("homework_id", homeworkId);

        Item item = table.getItem(getItemSpec);

        if (item != null) {
            return Homework.fromItem(item);
        }

        return null;
    }

    @Override
    public Iterable<Homework> findAll() {
        Table table = dynamoDB.getTable(tableName);
        ItemCollection<ScanOutcome> items = table.scan();

        List<Homework> homeworkList = new ArrayList<>();
        for (Item item : items) {
            homeworkList.add(Homework.fromItem(item));
        }

        return homeworkList;
    }

    @Override
    public void delete(String homeworkId) {
        Table table = dynamoDB.getTable(tableName);
        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey("homework_id", homeworkId);

        table.deleteItem(deleteItemSpec);
    }

    @Override
    public Homework updateHomework(Homework homework) {
        Table table = dynamoDB.getTable(tableName);
        Item item = homework.toItem();
        table.putItem(item);

        return homework;
    }
}
