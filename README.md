# CarRentalBackend

## Technologies
This project uses such technologies as: java, spring-boot:2.5.2 and ms-sql-server (postgresql on heroku).

## Description
This is the backend part of CarRental application. This application allows the user to rent a car. In this application we have two roles : user and admin.
The user can select a car and rent it. Moreover, he can show all his rents. Admin can show all rented cars. He can end the rental when the user returns the car.
The user who is not logged in is not able to rent cars. This application uses basic authentication.

## How to start

### Local
Run spring-boot app. The application is running on port 8080

### Heroku
The backend can be accessed at `https://car-rental-java-backend.herokuapp.com`. 
Application uses application-prod.properties and heroku config vars.

## Users

We have several application users :
- user1:user1pass
- user2:user2pass
- user3:user3pass
- admin:admin1pass
