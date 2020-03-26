CREATE TABLE route (

    id varchar(99) NOT NULL PRIMARY KEY,
    name varchar(255),
    map varchar(255),
    revision int,
    description varchar(3000),
    username varchar(255),
    date DATETIME,
    uploaded DATETIME,
    updated DATETIME
);

CREATE TABLE ad_group (
    id varchar(99) NOT NULL PRIMARY KEY,
    route_ID varchar(99) NOT NULL,
    name varchar(255),

    FOREIGN KEY (route_ID) REFERENCES route(id)
);

CREATE TABLE waypoint (

    id varchar(99) NOT NULL PRIMARY KEY,
    route_id varchar(99) not null,
    x float not null,
    y float not null,
    z float not null,
    marker_name varchar(255),
    group_id varchar(99),

    FOREIGN KEY (route_ID) REFERENCES route(id),
    FOREIGN KEY (group_id) REFERENCES ad_group(id)
);

CREATE TABLE waypoint_to_waypoint (
    outgoing_ID varchar(99) not null,
    incoming_ID varchar(99) not null,

    FOREIGN KEY (outgoing_ID) REFERENCES waypoint(id),
    FOREIGN KEY (incoming_ID) REFERENCES waypoint(id)

);

