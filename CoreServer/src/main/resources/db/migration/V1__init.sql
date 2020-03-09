CREATE TABLE waypoint (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    INDEX_COL int not null,
    route_id int not null,
    x float not null,
    y float not null,
    z float not null
);

CREATE TABLE waypoint_to_waypoint (
    outgoing_ID int not null,
    incoming_ID int not null
);

CREATE TABLE route (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    map varchar(255),
    revision int,
    date varchar(255)
);

CREATE TABLE marker (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    route_ID int NOT NULL,
    waypoint_id int not null,
    name varchar(255),
    group_id int
);

CREATE TABLE "group" (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    route_ID int NOT NULL,
    name varchar(255)
);