use world;

select sum(Population)
from city
where CountryCode = 'KOR';

select min(Population) as 최소값
from city
where CountryCode = 'KOR';

select avg(Population)
from city
where CountryCode = 'KOR';

select max(Population) as 최대값
from city
where CountryCode = 'KOR';

select length(Name)
from country;

select concat(
       upper(substr(Name, 1, 3)),  -- 앞 3글자 대문자
       substr(Name, 4)             -- 나머지 그대로
       ) as Name
from country;

select round(LifeExpectancy)
from city;