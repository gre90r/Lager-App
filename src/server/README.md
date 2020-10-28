# Lager App Server
A web API which provides a DB with CRUD functionality to
store items in locations.

Currently, using embedded DB. (*TODO: use MySQL*)

# Technologies used
* Java 8
* Spring Boot
* JPA
* Apache Derby DB (in-memory DB)

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
    "id": 1,
    "name": "chair",
    "location": "living room",
    "description": "beside table"
}
```
Send this with HTTP POST to /items and it will create that
item.

To update the above chair to location kitcgeb, you send
this with HTTP PUT to /items

```
{
    "id": 1,
    "name": "chair",
    "location": "kitchen",
    "description": "beside table"
}
```
item with id 1 will be overwritten.

## 2.2. Location requests
Same as Item requests. Only with */locations* as mapping.

the JSON looks like this:
```
{
    "id": 1,
    "name": "pen drawer in living room",
    "lagerTyp": "living room",
    "lagerBereich": "closet 1",
    "lagerPlatz": "drawer 1"
}
```

# 3 Tests
## 3.1 Unit tests
run `mvn test`

## 3.2 Postman
To test server requests use the postman collection located
in *src/test/postman/Lager-App.postman_collection.json*
