# Lager App Server
A web API which provides a DB with CRUD functionality to
store items in locations.

# Technologies used
* Java 8
* Spring Boot
* JPA / Hibernate
* MySQL

# 1 Run
Start `buildAndRun.sh`

# 2 Available requests
See the postman collection in
*src/test/postman/Lager-App.postman_collection.json*

## 2.1 Item requests
* on URL /items
    * HTTP GET and POST possible
    * get all items and create item
* on URL /items/{id}
    * e.g. /items/1
    * HTTP GET, PUT, DELETE
    * get, update and delete single data
    
### create and update items
To create and update items, you have to send JSON.
    
e.g.

```
{
    "name": "paper",
    "location": {
        "lagerTyp": "living room",
        "lagerBereich": "table",
        "lagerPlatz": "1st drawer from left"
    },
    "description": "paper for writing letters"
}
```
Send this with HTTP POST to /items and it will create
that item and location. You do not provide ID here,
because it'd auto generated.

To update the above paper to location kitchen, you send
this with HTTP PUT to /items. This time you have to
provide the ID. Find out ID by getting all items ->
GET request to /items.

```
{
    "id": 1,
    "name": "paper",
    "location": {
        "lagerTyp": "kitchen",
        "lagerBereich": "table",
        "lagerPlatz": "1st drawer from left"
    },
    "description": "paper for writing letters"
}
```
item with id 1 will be overwritten.

## 2.2. Location requests
Same as Item requests. Only with */locations* as mapping.

the JSON looks like this:
```
{
    "lagerTyp": "living room",
    "lagerBereich": "table",
    "lagerPlatz": "1st drawer from left"
}
```

# 3 Tests
## 3.1 Unit tests
run `mvn test`

## 3.2 Postman
To test server requests use the postman collection located
in *src/test/postman/Lager-App.postman_collection.json*


# 4 Create MySQL DB
reference:
https://spring.io/guides/gs/accessing-data-mysql/

Creating the DB
```
sudo mysql -u root
mysql> create database lagerapp;
mysql> create user 'springuser'@'%' identified by 'ThePassword';
mysql> grant all on lagerapp.* to 'springuser'@'%';
mysql> quit
```
user "springuser" and password "ThePassword" must match
the user and password in
*src/main/resources/application.properties*. So, look
inside the application.properties which user and
password are entered there. You have to replace
"springuser" and "ThePassword" in the above
 mysql terminal commands with the user and
password in the application.properties file.
