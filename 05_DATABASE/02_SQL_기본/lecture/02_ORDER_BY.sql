use employees;

-- ORDER BY
-- 특정 컬럼/값에 따라 정렬할 때 사용
-- 주의) 데이터가 많을 때 정렬 시 오래 걸릴 수 있음

select
    emp_no,
    first_name,
    last_name
from employees
order by
#     emp_no;  -- 기본: pk로 정렬
    emp_no desc;  -- 내림차순 정렬

-- 컬럼에 따라 여러기준으로 정렬가능
-- first_name으로 내림차순 정렬
-- 같은 값 있으면 last_name 기준 오름차순 정렬
select
    emp_no,
    first_name,
    last_name
from employees
order by
    first_name desc,
    last_name;  -- 정렬 우선순위 1. first_name 2. last_name