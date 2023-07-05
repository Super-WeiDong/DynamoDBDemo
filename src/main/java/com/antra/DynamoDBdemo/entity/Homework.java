package com.antra.DynamoDBdemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.document.Item;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@DynamoDBTable(tableName = "Homework")
public class Homework {
    private String homeworkId;
    private String trainerId;
    private String batchId;
    private String description;

    @DynamoDBHashKey(attributeName = "homework_id")
    @DynamoDBAutoGeneratedKey
    public String getHomeworkId() {
        return homeworkId;
    }

    @DynamoDBAttribute(attributeName = "trainer_id")
    public String getTrainerId() {
        return trainerId;
    }

    @DynamoDBAttribute(attributeName = "batch_id")
    public String getBatchId() {
        return batchId;
    }

    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    // Convert Item to Homework object
    public static Homework fromItem(Item item) {
        Homework homework = new Homework();
        homework.setHomeworkId(item.getString("homework_id"));
        homework.setTrainerId(item.getString("trainer_id"));
        homework.setBatchId(item.getString("batch_id"));
        homework.setDescription(item.getString("description"));
        return homework;
    }

    // Convert Homework object to Item
    public Item toItem() {
        return new Item()
                .withString("homework_id", homeworkId)
                .withString("trainer_id", trainerId)
                .withString("batch_id", batchId)
                .withString("description", description);
    }
}
