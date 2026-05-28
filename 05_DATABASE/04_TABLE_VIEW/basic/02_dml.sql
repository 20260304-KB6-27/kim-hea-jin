use tabledb;

insert into usertbl values ('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-02-21');

-- default 제약조건
insert into usertbl values ('KKH', '김경호', 1987, '서울', '011', '11111111', 182, default);

-- CHECK 제약조건 확인 (height < 500)
insert into usertbl values ('NBJ', '나비족', 1987, '서울', '011', '11111111', 600, default);

select *
from usertbl;

-- buytbl
insert into buytbl
values (null, 'LSG', '운동화', null, 30, 2);

-- 참조 무결성: 외래키가 참조하는 데이터는 반드시 존재해야 함
insert into buytbl
values (null, 'NBJ', '운동화', null, 30, 2);

delete from buytbl
where prodName = '운동화';

delete from usertbl
where userID = 'LSG';

drop table if exists buytbl;  -- 참조 테이블 먼저
drop table if exists usertbl;  -- 원본 테이블 나중에
