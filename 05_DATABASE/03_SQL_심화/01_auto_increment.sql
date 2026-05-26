use testdb;

/*
 AUTO INCREMENT
 - 고유한 아이디 생성기
 - 행이 INSERT 될 때마다 자동으로 1씩 증가하는 고유번호 생성
 - 조건: PK(PRIMARY KEY) 또는 UNIQUE INDEX이어야 함
 */

 create table board (
   board_no int not null auto_increment,  -- 형식: column type 제약조건
   title varchar(100) not null,
   content text,
   author varchar(50) not null,
   created_at datetime default now(),
   primary key (board_no)
 );

insert into board (title, content, author)
values ('첫번째 글', '첫번째 게시글', '작가');

insert into board (title, content, author)
values ('두번째 글', '두번째 게시글', '작가');

insert into board (title, content, author)
values ('세번째 글', '세번째 게시글', '작가');

-- null 또는 0을 넣어도 auto_increment 동작함
insert into board
values (null, '네번째 글', '네번째 게시글', '작가', now());

insert into board
values (0, '다섯번째 글', '다섯번째 게시글', '작가', now());

insert into board  -- 숫자 지정가능
values (25, '여섯번째 글', '여섯번째 게시글', '작가', now());

-- auto increment의 시작값 변경
alter table board auto_increment = 100;

insert into board (title, content, author)
values ('100부터 시작', '시작값 100으로 변경 후 삽입', '작가');

select * from board;

-- last_insert_id()
-- 현재 세션에서 마지막으로 insert된 auto_increment 값 반환
select last_insert_id();
