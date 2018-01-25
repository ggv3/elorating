# Elo Rating REST-API

## Manual

This API has two endpoints, one for adding a new player and one for updating the actual game results.

```.../addplayer```

This endpoint requires one ```username``` parameter. It will then insert a new row into a database. You cant add two users with the same username.
EXAMPLE:

```curl -d "username=Niko" -X POST .../addplayer```
```.../game```

## Technologies

* Java 8
* Spring Boot
* JPA

## Server

* Ubuntu Server
* Apache Tomcat 8
