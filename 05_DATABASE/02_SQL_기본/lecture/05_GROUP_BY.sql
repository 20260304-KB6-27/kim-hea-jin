/*
 그룹화
 -- 결과 집합을 특정 열의 값에 따라 그룹화 할 때 사용
 -- HAVING은 GROUP BY 절과 함께 사용해 그룹핑한 결과에 조건 적용
 -- SELECT절의 집계함수와 같이 사용가능
 */

use employees;

select * from salaries;

-- 직원별 급여횟수, 평균급여, 총급여 조회
-- 평균급여가 50000~60000사이 데이터 조회
select
    emp_no,
    count(*) as 급여횟수,
    avg(salary) as 평균급여,
    sum(salary) as 총급여
from salaries
group by emp_no
having 평균급여 between 50000 and 60000;
