-- DML
-- 데이터의 값을 삽입, 수정, 삭제하는 SQL문

-- INSERT
insert into
    employees
values
    (2, 20260522, '태근', '박', 'M', 20260304);

select * from employees limit 2;

-- column 명시하면 insert 시 데이터 순서 바꾸기 가능
insert into
    employees(emp_no, birth_date, last_name, first_name, gender, hire_date)
values
    (5, 20260522, 'a', 'b', 'M', 20260304),
    (6, 20260522, 'c', 'd', 'M', 20260304);

-- UPDATE
-- 테이블에 기록된 컬럼의 값을 수정하는 구문
update
    employees
set
    last_name = 'A',
    first_name = 'B'
where
    first_name = 'b';

-- DELETE
-- 테이블 행을 삭제
delete
from employees
where first_name = 'd';