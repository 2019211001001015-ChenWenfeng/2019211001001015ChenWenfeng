create database userdb;

create table usertable(
                          username varchar(40) not null,
                          password varchar(40) not null,
                          email varchar(40) not null,
                          gender varchar(40) not null,
                          birthDate date not null
)charset=utf8;