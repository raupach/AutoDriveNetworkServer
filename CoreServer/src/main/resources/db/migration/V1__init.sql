CREATE TABLE waypoint (

    id varchar(99) NOT NULL PRIMARY KEY,
    INDEX_COL int,
    route_id varchar(99) not null,
    x float not null,
    y float not null,
    z float not null
);

CREATE TABLE waypoint_to_waypoint (
    outgoing_ID varchar(99) not null,
    incoming_ID varchar(99) not null
);

CREATE TABLE route (

    id varchar(99) NOT NULL PRIMARY KEY,
    name varchar(255),
    map varchar(255),
    revision int,
    date DATETIME
);

CREATE TABLE marker (
    id varchar(99) NOT NULL PRIMARY KEY,
    route_ID varchar(99) NOT NULL,
    waypoint_id varchar(99) not null,
    name varchar(255),
    group_id varchar(99)
);

CREATE TABLE ad_group (
    id varchar(99) NOT NULL PRIMARY KEY,
    route_ID varchar(99) NOT NULL,
    name varchar(255)
);



--
--
--CREATE TABLE waypoint (
--
--    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    INDEX_COL int,
--    route_id int not null,
--    x float not null,
--    y float not null,
--    z float not null
--);
--
--CREATE TABLE waypoint_to_waypoint (
--    outgoing_ID int not null,
--    incoming_ID int not null
--);
--
--CREATE TABLE route (
--
--    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    name varchar(255),
--    map varchar(255),
--    revision int,
--    date varchar(255)
--);
--
--CREATE TABLE marker (
--    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    route_ID int NOT NULL,
--    waypoint_id int not null,
--    name varchar(255),
--    group_id int
--);
--
--CREATE TABLE ad_group (
--    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    route_ID int NOT NULL,
--    name varchar(255)
--);