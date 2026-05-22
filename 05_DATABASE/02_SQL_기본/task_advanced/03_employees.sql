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

select *
from employees
order by hire_date desc;