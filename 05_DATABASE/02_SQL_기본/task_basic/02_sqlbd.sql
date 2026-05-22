use sqldb;

-- usertbl에서 이름이 '김경호'인 행 출력
select *
from usertbl
where name = '김경호';

-- usertbl에서 생년이 1970이상, 키가 182이상인 데이터 출력
select *
from usertbl
where birthYear >= 1970 and height >= 182;

-- usertbl에서 키 180~183인 데이터 출력
select *
from usertbl
where height between 180 and 183;

-- usertbl에서 주소가 '경남' 또는 '전남' 또는 '경북'인 데이터 출력
select *
from usertbl
where addr = '경남' or addr = '전남' or addr = '경북';

-- usertbl에서 이름이 '김'으로 시작하는 데이터 출력
select *
from usertbl
where name like '김%';

-- usertbl에서 김경호보다 큰 사람들의 이름, 키 출력 (subquery 사용)
select name, height
from usertbl
where height > (select height
                from usertbl
                where name = '김경호');

-- usertbl을 mDate의 오름차순으로 정렬해 출력
select *
from usertbl
order by mDate;

-- usertbl을 mDate의 내림차순으로 정렬해 출력
select *
from usertbl
order by mDate desc;

-- usertbl을 height 내림차순 정렬, 같을경우 name 내림차순 정렬
select *
from usertbl
order by height desc, name desc;

-- usertbl의 addr 중복없이 오름차순 출력
select distinct addr
from usertbl
order by addr;