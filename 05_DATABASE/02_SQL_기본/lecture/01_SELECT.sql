-- SELECT
-- 특정 테이블에서 원하는 데이터 조회

select
    userID  -- userID column 조회
from buytbl;  -- buytbl table에서

select * from buytbl;  -- 모든 column 조회

/*
 select 단독활용
 - from 없이 단독사용 가능
 - 단순한 텍스트 출력
 */
select (5 + 5);
select now();  -- MYSQL 내장함수
select concat('a', 'b', 'c') as name;  -- 문자열 합치기, 별칭 지정
select concat('a', 'b', 'c') as 'Full name';  -- 별칭 공백 -> '' 사용

select
    name,
    concat(mobile1, ' ', mobile2) as 전화번호
from usertbl;