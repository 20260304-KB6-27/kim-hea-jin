use sqldb;

drop table if exists tbl1;
create table tbl1 (
    a int primary key,
    b int,
    c int
);
show index from tbl1;

drop table if exists tbl2;
create table tbl2 (
    a int primary key,
    b int unique,
    c int unique,
    d int
);
show index from tbl2;

drop table if exists tbl3;
create table tbl3 (
    a int unique,
    b int unique,
    c int unique,
    d int
);
show index from tbl3;

drop table if exists tbl4;
create table tbl4 (
    a int unique not null,
    b int unique,
    c int unique,
    d int
);
show index from tbl4;

drop table if exists tbl5;
create table tbl5 (
    a int unique not null,
    b int unique,
    c int unique,
    d int primary key
);
show index from tbl5;

