# DynamoDBDemo

## Instruction
#### To run this app, you need to create a table in DynamoDB using the same schema as Homework POJO.
#### You need to create an access key and configure env variable "AWS_ACCESS_KEY_ID" and "AWS_SECRET_KEY" with your own info.

## API

### Get all homeworks
http method: GET
URL: http://localhost:8080/homework

### Get homework by id
http method: GET
URL: http://localhost:8080/homework/<homework_id>

### Create new homework
http method: POST
URL: http://localhost:8080/homework
body example:
```
{
  "homeworkId": "17263",
  "trainerId": "Jimmy",
  "batchId": "August",
  "description": "SpringMVC project"
}
```

### Update homework by id
http method: PUT
URL: http://localhost:8080/homework/<homework_id>
body example:
```
{
  "homeworkId": "17263",
  "trainerId": "Jimmy",
  "batchId": "August",
  "description": "SpringMVC project"
}
```


### Delete homework by id
http method: DELETE
URL: http://localhost:8080/homework/<homework_id>
