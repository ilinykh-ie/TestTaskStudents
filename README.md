# Students app

## Для запуска контейнера с бд локально:
```
docker run --name students-test-task-db -e MYSQL_ROOT_PASSWORD=my-sql -e MYSQL_DATABASE=students-db -e MYSQL_USER=admin -e MYSQL_PASSWORD=my-sql -p 3306:3306 -d mysql:latest
```