use employees;

create view employees_info
as
select e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date,
       t.title, t.from_date t_from, t.to_date t_to,
       s.salary, s.from_date s_from, s.to_date s_to
from employees e
join titles t on t.emp_no = e.emp_no
join salaries s on e.emp_no = s.emp_no;

select * from employees_info;

select * from employees_info
where t_to = '9999-01-01' and s_to = '9999-01-01';

create view emp_dept_info
as
select * from dept_emp;

select * from emp_dept_info;

select * from emp_dept_info
where to_date = '9999-01-01';

