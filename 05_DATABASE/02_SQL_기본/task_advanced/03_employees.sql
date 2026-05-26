use employees;

-- employees db에서 각 부서별 관리자 출력
-- 조건: 현재 재직자 (to_date = 9999-01-01)
select *
from dept_manager
where to_date = '9999-01-01';

-- 부서번호 d005의 현재 관리자 정보 출력
select *
from employees
where emp_no = (select emp_no
                from dept_manager
                where to_date = '9999-01-01'
                    and dept_no = 'd005');

-- 입사일 내림차순 정렬, 한 페이지당 20명 출력
select *
from employees
order by hire_date desc
limit 20 offset 0;

-- 재직자 총 수
select count(*) as `재직자 총 수`
from dept_manager
where to_date = '9999-01-01';

-- 재직자 평균 급여
select avg(salary) as `평균 급여`
from salaries
where to_date = '9999-01-01';

-- 재직자 평균 급여보다 더 많이 받는 재직자
select *
from salaries
where to_date = '9999-01-01'
    and salary > (
        select avg(salary)
        from salaries
        where to_date = '9999-01-01'
    );

-- 각 부서별 재직자 수
-- 부서번호 오름차순 정렬
select dept_no, count(*) as `부서별 재직자 수`
from dept_emp
where to_date = '9999-01-01'
group by dept_no
order by dept_no;