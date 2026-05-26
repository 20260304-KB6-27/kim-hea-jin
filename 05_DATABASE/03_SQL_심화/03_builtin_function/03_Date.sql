-- 날짜 내장함수

use employees;

select emp_no
from employees
limit 10;

select emp_no,
       hire_date,  -- datetime
       YEAR(hire_date),  # 연도 추출
       MONTH(hire_date),  # 월 추출
       DAY(hire_date)  # 일 추출
from employees
limit 10;

/*
 DATEDIFF(date1, date2)
 - date1에서 date2를 뺀 일수 차이
 */

select emp_no,
       hire_date,
       DATEDIFF(curdate(), hire_date)
from employees
limit 10;

/*
 DATE_FORMAT(date, format)
 - %Y: 4자리 연도, %m: 2자리 월, %d: 2자리 일
 - %y: 2자리 연도, %M: 영문 월, %W: 영문 요일
 */

select emp_no, hire_date,
       DATE_FORMAT(hire_date, '%Y년 %m월 %d일')
from employees
limit 10;