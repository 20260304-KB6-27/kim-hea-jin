use tabledb;

drop table if exists usertbl;
create table usertbl(
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null
);

drop table if exists buytbl;
create table buytbl(
    num int not null primary key,
    userID char(8) not null,
    prodName char(6) not null,
    foreign key (userID) references usertbl(userID)
);

drop table buytbl;
drop table usertbl;
create table usertbl (
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null,
    email char(30) null unique
);

drop table usertbl;
create table usertbl (
    userID char(8) not null primary key,
    name varchar(10),
    birthyear int check (birthyear >= 1900 and birthyear <= 2023),
    mobile char(3) not null
);

drop table usertbl;
create table usertbl (
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null default -1,
    addr char(2) not null default '서울',
    mobile1 char(3),
    mobile2 char(8),
    height smallint default 170,
    mDate date
);

INSERT INTO usertbl
VALUES ('00000000', 'name', default, default, NULL, NULL, default, NULL);

select * from usertbl;

alter table usertbl
drop column mobile1;

alter table usertbl
rename column name to uName;

alter table usertbl
drop primary key;
