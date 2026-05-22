use sqldb;

select userID as `사용자 아이디`, sum(amount) as `총 구매 개수`
from buytbl
group by userID;

select userID as `사용자 아이디`, sum(price * amount) as `총 구매액`
from buytbl
group by userID;

select avg(amount) as `평균 구매 개수`
from buytbl;

select userID, avg(amount) as `평균 구매 개수`
from buytbl
group by userID;

select name, height
from usertbl
where height in (
        (select max(height) from usertbl),
        (select min(height) from usertbl)
);

select count(*) as `휴대폰이 있는 사용자`
from usertbl
where mobile1 is not null and mobile2 is not null;

-- 사용자별 총 구매액 출력
select userID as 사용자, sum(price * amount) as 총구매액
from buytbl
group by userID;

-- 총 구매액 1000이상인 사용자 출력
select userID as 사용자, sum(price * amount) as 총구매액
from buytbl
group by userID
having 총구매액 >= 1000;