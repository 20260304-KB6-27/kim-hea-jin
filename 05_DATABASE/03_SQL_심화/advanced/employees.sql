use employees;

-- 4. 현재 재직 중인 직원 정보 출력
-- 출력 항목: emp_no, first_name, last_name, title
select e.emp_no, e.first_name, e.last_name, t.title
from employees e
join titles t on e.emp_no = t.emp_no
where t.to_date = '9999-01-01';


-- 5. 현재 재직 중인 직원 정보 출력
-- 출력 항목: 직원 기본 정보 모두, title, salary
select e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date,
       t.title, s.salary
from employees e
join titles t on e.emp_no = t.emp_no
join salaries s on e.emp_no = s.emp_no
where t.to_date = '9999-01-01';


-- 6. 현재 재직 중인 직원 정보 출력
-- 출력 항목: emp_no, first_name, last_name, dept_name
-- 정렬: emp_no 오름차순
select e.emp_no, e.first_name, e.last_name, d.dept_name
from employees e
join dept_emp de on e.emp_no = de.emp_no
join departments d on de.dept_no = d.dept_no
where de.to_date = '9999-01-01'
order by e.emp_no;


-- 7. 부서별 재직 중인 직원 수 출력
-- 출력 항목: dept_no, dept_name, count(*)
-- 정렬: 부서 번호 오름차순
select de.dept_no, d.dept_name, count(*)
from dept_emp de
join departments d on de.dept_no = d.dept_no
where de.to_date = '9999-01-01'
group by de.dept_no
order by de.dept_no;


-- 8. 직원 번호가 10209인 직원의 부서 이동 히스토리 출력
-- 출력 항목: emp_no, first_name, last_name, dept_name, from_date, to_date
select e.emp_no, e.first_name, e.last_name, d.dept_name, de.from_date, de.to_date
from employees e
join dept_emp de on e.emp_no = de.emp_no
join departments d on de.dept_no = d.dept_no
where e.emp_no = 10209;
