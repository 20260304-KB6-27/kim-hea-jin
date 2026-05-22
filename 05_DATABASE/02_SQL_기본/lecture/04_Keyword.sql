use sqldb;

-- DISTINCT
-- 중복된 값을 제거할 때 사용
-- null 포함

select distinct userID  -- 중복 userID 제외 후 조회
from buytbl;

select distinct groupName
from buytbl;

-- LIMIT
-- select문의 결과 집합에서 반환할 행의 갯수 제한 시 사용
-- offset 이용해서 페이징할 때 사용가능
-- limit [offset], [rowcount] : offset행부터 rowcount만큼
-- limit [rowcount] : rowcount만큼

select *
from buytbl
limit 5;

select *
from buytbl
order by price
limit 5;

select *
from buytbl
order by price
limit 3, 5;