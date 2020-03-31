CREATE TABLE user (

    id varchar(99) NOT NULL PRIMARY KEY,
    keycloak_user_id varchar(255) NOT NULL,
    username varchar(255)
);

alter table route drop column username;
alter table route add user_id varchar(255);
