create table appuser (
id integer,
firstName varchar(30),
lastName varchar(30),
userName varchar(30),
password varchar(40),
constraint appuser_pk primary key(id),
constraint app_username_uk unique(userName)
);