# Elo Rating REST-API

## Manual

This API has a few endpoints, you can list all players, add a new player and update the statistics of players.

 |Player	       |
 |---------------------|
 |id: 		integer|
 |playcount:	integer|
 |score:	double |
 |username:	String | 

### Listing all players

This endpoint doesn't require any parameters. It will list all the players and their information from the database.

EXAMPLE:

```curl .../players```

### Adding a player

This endpoint requires one ```username``` parameter. It will then insert a new row into a database. You cant add two users with the same username.

EXAMPLE:

```curl -d "username=Niko" -X POST .../addplayer```

### Updating the players statistics

This endpoint requires two parameters, ```username``` of the winner and the loser. This method will then collect the necessary info of the sent users and calculate the correct amount of points to be subtracted form the loser and given to the winner.

EXAMPLE:

```curl -d "winner=janne&loser=niko" -X POST .../game``` 

## Roadmap

At the current state this API should be considered as really bare bones MVP. Should the development continue, some security should be added. JSON Web Tokens or something along those lines.

## Editing a player

It would be nice to have a way to edit an existing user without logging into the database. change their points, playcounts or whatever else comes to mind.

### Deleting a player

Pretty straightforward feature, but it could be really useful.

### Having more control with the scoring system

In some cases it could be useful to change the maximum amount of points a player could win in a single game


## Technologies

* Java 8
* Spring Boot
* JPA

## Server

* Ubuntu Server
* Apache Tomcat 8
