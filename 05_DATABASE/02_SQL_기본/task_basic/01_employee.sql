-- 현재 서버의 db 확인
show databases;

-- 현재 db employees로 설정
use employees;

-- employees db의 table 목록 출력
show tables;

-- employes table의 column 목록 출력
show columns in employees;


-- titles table의 data 출력
select * from titles;

-- employees table의 first_name column만 출력
select first_name
from employees;

-- employees table의 first_name, last_name, gender column 출력
select first_name, last_name, gender
from employees;


select first_name as 이름, gender as 성별, hire_date as 회사입사일
from employees;