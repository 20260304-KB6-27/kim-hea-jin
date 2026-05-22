-- SUB QUERY
-- 다른 쿼리에서 실행되는 쿼리(보조역할)
-- 메인쿼리 실행중에 서브쿼리를 실행해 결과값을 메인쿼리에 전달

# 규칙
-- 서브쿼리는 소괄호로 묶어야 함
-- 서브쿼리는 연산자의 오른쪽에 있어야 함
-- 서브쿼리는 order by 지원 안 됨

use employees;

-- employees db에서 각 부서별 관리자의 직원 정보 출력
-- 조건: 현재 재직자
-- 관리자 코드: dept_no = d005, 재직중: to_date = 9999-01-01

select *
from employees
where emp_no = (select emp_no
       from dept_manager
       where dept_no = 'd005' and to_date = '9999-01-01');

/*
 Common Table Expressions (CTE)
 - 서브쿼리와 비슷한 개념, 코드의 가독성과 재사용성을 위한 임시테이블 생성
 */

with current_manager as (select emp_no
                         from dept_manager
                         where dept_no = 'd005' and to_date = '9999-01-01')

select * from employees
where emp_no = (select emp_no from current_manager);

-- 재직자 전체 평균급여보다 급여를 더 많이 받는 재직자 정보 출력

# 재직자의 평균 급여
select avg(salary)
from salaries
where to_date = '9999-01-01';

# 재직자의 평균급여 이상으로 받는 재직자ID
select emp_no
from salaries
where to_date = '9999-01-01'
  and salary > (select avg(salary)
                from salaries
                where to_date = '9999-01-01');

# 해당 재직자의 직원정보
select * from employees
where emp_no in (select emp_no
                 from salaries
                 where to_date = '9999-01-01'
                   and salary > (select avg(salary)
                                 from salaries
                                 where to_date = '9999-01-01'));

# create table ... select
-- select문의 결과를 그대로 새 테이블로 저장
-- 복잡한 쿼리, 결과 반복 조회, 무거운 쿼리 실행 대신 테이블로 저장 시 조회 빠름
-- 원본 데이터 손상 방지

-- columm명-datatype은 select한 결과로 복사됨
-- index, pk, fk 등의 제약조건 복사 안 됨 (추가 가능)

-- 연도별 입사자 수를 구하고 그 중 입사자가 20000명 이상인 연도 출력
select year(hire_date) as hire_year, count(*) as hire_count
from employees
group by hire_year;

# 연도별 입사자 수
create table yearly_hire
select year(hire_date) as hire_year, count(*) as hire_count
from employees
group by hire_year;

# 입사자 20000명 이상인 연도
select hire_year
from yearly_hire
where hire_count >= 20000;