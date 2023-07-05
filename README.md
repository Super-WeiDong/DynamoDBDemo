# DynamoDBDemo

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
