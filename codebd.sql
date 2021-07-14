CREATE DATABASE train;
USE train;
CREATE TABLE route
(
id INT PRIMARY KEY AUTO_INCREMENT,
number_route CHAR(100),
route CHAR(100)
);
 
CREATE TABLE station 
(
id_entry INT PRIMARY KEY AUTO_INCREMENT, 
id_route INT,
name_station CHAR(100),
departure_time CHAR(100),
parking_time CHAR(100),
arrival_time CHAR(100),
travel_time CHAR (100),
FOREIGN KEY (id_route) REFERENCES route (id)
);

Вывод списка всех маршрутов в формате «Номер маршрута-Станция отправления-Станция назначения-время прибытия-время отправления».
SELECT route.number_route, route.route, station.arrival_time, station.departure_time FROM station LEFT JOIN route ON station.id_route=route.id;

Вывод информации о маршруте по введенному номеру маршрута (формат вывода как в первом случае).
SELECT route.number_route, route.route, station.arrival_time, station.departure_time FROM station LEFT JOIN route ON station.id_route=route.id WHERE number_route=?;

Расширенный вывод информации о маршруте (содержит все промежуточные станции).
SELECT  route.id, route.number_route, route.route, station.id_entry,
 station.id_route, station.name_station, station.departure_time,
 station.parking_time, station.arrival_time, station.travel_time FROM station LEFT JOIN route ON station.id_route=route.id;