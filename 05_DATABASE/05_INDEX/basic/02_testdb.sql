use testdb;

drop table if exists usertbl;
create table usertbl (
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null,
    addr nchar(2) not null
);

insert into usertbl values ('LSG', '이승기', 1987, '서울');
insert into usertbl values ('KBS', '김범수', 1979, '경남');
insert into usertbl values ('KKH', '김경호', 1971, '전남');
insert into usertbl values ('JYP', '조용필', 1950, '경기');
insert into usertbl values ('S나', '성시경', 1979, '서울');

show index from usertbl;

alter table usertbl
drop primary key;

alter table usertbl
add constraint primary key pk_name(name);

select *
from usertbl;

show index from usertbl;
