use world;

-- 국가코드 'KOR'인 도시 찾아 인구수 역순 출력
select *
from city
where CountryCode = 'KOR'
order by Population desc;

-- city table에서 국가코드, 인구수 출력
-- 정렬: 국가코드 오름차순, 인구수 내림차순
select CountryCode, Population
from city
order by CountryCode, Population desc;

-- city table에서 국가코드 'KOR'인 도시 수 출력
select count(*) as 도시수
from city
where CountryCode = 'KOR';

-- city table에서 국가코드 'KOR', 'CHN', 'JPN'인 도시 출력
select *
from city
where CountryCode in ('KOR', 'CHN', 'JPN');

-- 국가코드 'KOR'이면서 인구 100만 이상인 도시 출력
select *
from city
where CountryCode = 'KOR' and Population >= 1000000;

-- 국가코드 'KOR'인 도시 중 인구수 많은 순 상위 10개 출력
select *
from city
where CountryCode = 'KOR'
order by Population desc
limit 10;

-- city table에서 국가코드 'KOR'이고, 인구 100만 이상 500만 이하 도시 출력
select *
from city
where CountryCode = 'KOR' and Population between 1000000 and 5000000;