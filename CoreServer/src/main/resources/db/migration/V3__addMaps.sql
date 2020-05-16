CREATE TABLE map_info (

    id varchar(99) NOT NULL PRIMARY KEY,
    name varchar(255),
    resolution_x int,
    resolution_y int
);

create table map_tile_data (
 id varchar(99) NOT NULL PRIMARY KEY,
 map_id varchar(99) not null,
 name varchar(255),
 zoom_level int not null,
 x int not null,
 y int not null,
 data mediumblob not null,

 FOREIGN KEY (map_id) REFERENCES map_info(id)
);

create UNIQUE INDEX ix_map_tile_data on map_tile_data (zoom_level, name, x, y);
