/*
 OUTER JOIN
 - 한 쪽 테이블의 데이터가 JOIN 조건에 맞지 않아도 출력
 - 조건에 맞지 않는 쪽 컬럼값은 NULL로 채워짐

 LEFT OUTER JOIN: 왼쪽(FROM) 테이블 기준 모두 출력
 RIGHT OUTER JOIN: 오른쪽(JOIN) 테이블 기준 모두 출력
 OUTER 생략가능
*/

-- schema, table 생성
drop database if exists join_demo;
create database join_demo;
use join_demo;

create table customers (
                           id   int primary key,
                           name varchar(30)
);

create table orders (
                        id          int primary key,
                        customer_id int,
                        product     varchar(50),
                        amount      int
);

insert into customers values
                          (1, '김철수'),
                          (2, '이영희'),
                          (3, '박민준'),
                          (4, '최수진'),
                          (5, '정태현');

insert into orders values
                       (1, 1, '노트북',   1200000),
                       (2, 1, '마우스',     30000),
                       (3, 3, '키보드',     80000);

-- (주문한)고객, 고객의 주문 데이터
select *
from customers c
join orders o on c.id = o.customer_id;

-- 주문하지 않은 고객도 포함(모든 고객, o.id = NULL)
select *
from customers c
left join orders o on c.id = o.customer_id;

-- 주문을 하나도 하지 않은 고객 조회
select *
from customers c
left join orders o on c.id = o.customer_id
where o.id IS NULL;

-- 구매정보 모두 조회 -> inner join과 같은 결과
select *
from customers c
right join orders o on c.id = o.customer_id;

-- RIGHT JOIN - 테이블 순서만 반대
select *
from orders o
right join customers c on c.id = o.customer_id;