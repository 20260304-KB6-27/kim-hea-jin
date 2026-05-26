-- 형변환 내장함수

use employees;

/*
 CAST(value AS type)
 - value를 지정한 type으로 변경
 - type: CHAR, SIGNED(정수), UNSIGNED(양의 정수), DECIMAL, DATE, DATETIME
 */

select emp_no,
       -- 문자열 크기 명시X -> 필요한 크기만큼 자동 생성
       CONCAT('사번: ', CAST(emp_no AS CHAR(30))) as '사번 문자'
from employees
limit 5, 10;

/*
 CONVERT(value, type)
 - CAST와 동일한 역할 수행
 - 문자셋 변환에도 사용가능 -> CONVERT(str USING uft8mb4)
 */

select emp_no, hire_date,
       CONVERT(YEAR(hire_date), CHAR) as 입사연도_문자,  -- varchar(4)
       CONVERT(YEAR(hire_date), SIGNED) as 입사연도_정수  -- bigint
from employees
limit 5, 10;