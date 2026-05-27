/*
 SELF JOIN
 - 하나의 테이블을 서로 다른 별칭을 붙여 두번 참조하는 JOIN
 - 같은 테이블에서 행끼리 비교 / 관계 찾을 때 사용
*/

use employees;

-- 같은 생년월일인 직원 조회
select
    concat(e1.first_name, ' ', e1.last_name) as `직원A 이름`,
    e1.birth_date as 생년월일,
    concat(e2.first_name, ' ', e2.last_name) as `직원B 이름`
from employees e1
join employees e2 on e1.birth_date = e2.birth_date
and e1.emp_no < e2.emp_no  -- 같은 쌍, 중복 제거
limit 10;
