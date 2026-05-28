use employees;

/*
 VIEW
 - 실제 데이터 저장X, 하나 이상의 테이블을 조회하는 SELECT문을 가상의 테이블로 사용하는 객체
 - 원본 변경 시 view에도 반영됨
 - insert, update, delete 가능 but 원본 왜곡 가능 (비권장)

 장점
 - 자주 사용하는 SELECT 쿼리 재사용 가능
 - 보안, 편의성, 유지보수성 향상
 */

-- 참조하고 있는 테이블 사라지면 뷰 깨질 수 있음 -> 뷰 먼저 삭제
create or replace view v_employees
as
select emp_no, concat(first_name, ' ', last_name)
from employees;

select *
from v_employees;