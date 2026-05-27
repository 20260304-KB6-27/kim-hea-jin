-- sqldb 데이터베이스에서 다음 조건 처리
use sqldb;

-- 사용자별로 구매 이력 출력
-- 모든 컬럼 출력
-- 구매 이력 없는 정보 출력X
select *
from buytbl
join usertbl on buytbl.userID = usertbl.userID;

-- 앞의 결과에서 userID = 'JYP'인 데이터만 출력
select *
from buytbl
join usertbl on buytbl.userID = usertbl.userID
where buytbl.userID = 'JYP';

-- 각 사용자별 구매 이력 출력
-- 연결 컬럼: userID
-- userID 오름차순 정렬
-- 구매이력 없는 사용자 포함 출력
-- 출력 컬럼: userID, name, prodName, addr, 연락처
select u.userID as userID,
       u.name as name,
       b.prodName as prodName,
       u.addr as addr,
       concat(u.mobile1, u.mobile2) as 연락처
from usertbl u
left join buytbl b on u.userID = b.userID
order by u.userID;

-- sqldb 사용자 모두 조회, 전화없는 사람 제외
select *
from usertbl u
join buytbl b on u.userID = b.userID
where u.mobile1 IS NOT NULL;

-- sqldb 사용자 모두 조회, 전화없는 사람만 출력
select *
from usertbl u
join buytbl b on u.userID = b.userID
where u.mobile1 IS NULL;