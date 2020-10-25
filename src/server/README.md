# Lager App Server
Currently, this server has CRUD functionality for items.
No DB yet, everything runs in memory.

# 1 Run
start `buildAndRun.sh`

# 2 Available requests
see the postman collection in
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
    "name": "pencil"
}
```
send this with HTTP POST to /items and it will create that
item.

To update the above pencil to screw driver, you send this
with HTTP PUT to /items

```
{
    "id": 1,
    "name": "screw driver"
}
```
item with id 1 will be overwritten.

# 3 Tests
# 3.1 Unit tests
run `mvn test`

# 3.2 Postman
To test server requests use the postman collection located
in *src/test/postman/Lager-App.postman_collection.json*
