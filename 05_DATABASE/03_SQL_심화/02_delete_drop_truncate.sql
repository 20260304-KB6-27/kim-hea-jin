/*
 safe mode
 - 한 번의 쿼리 실수로 모든 데이터가 수정되거나 삭제되는 것을 방지하기 위해
 조건문이 없을 때 update, delete 동작 막는 기능
 */

use sqldb;

-- Unsafe query: 'Update' statement without 'where' updates all table rows at once
-- where 조건 없으면 경고창 뜸
-- execute and suppress: 그래도 실행 & 이후에 경고창 안 뜸
update buytbl
set price = price * 1.5;  -- 모든 가격 1.5배

set sql_safe_updates = 1;  -- mysql safe mode 킴
set sql_safe_updates = 0;  -- mysql safe mode 끔

use testdb;

DROP TABLE IF EXISTS board;

CREATE TABLE board (
                       post_no    INT          NOT NULL AUTO_INCREMENT,
                       title      VARCHAR(100) NOT NULL,
                       author     VARCHAR(50)  NOT NULL,
                       PRIMARY KEY (post_no)
);

INSERT INTO board (title, author) VALUES ('첫 번째 글', '홍길동');
INSERT INTO board (title, author) VALUES ('두 번째 글', '김철수');
INSERT INTO board (title, author) VALUES ('세 번째 글', '이영희');
INSERT INTO board (title, author) VALUES ('네 번째 글', '박민준');
INSERT INTO board (title, author) VALUES ('다섯 번째 글', '최지수');


/*
 DELETE
 - 테이블의 행(row)을 삭제하는 DML 명령어
 - where 조건으로 특정 행 삭제 가능
 - 트랜잭션(ROLLBACK)으로 복구 가능
 */

 delete from board where post_no = 5;

-- auto increment 값 초기화X 이어서 증가 (연속성X)
INSERT INTO board (title, author) VALUES ('여섯 번째 글', '최지수');


/*
 TRUNCATE
 - 테이블의 전체 행을 한번에 삭제하는 DDL 명령어
 - WHERE 사용불가
 - 트랜잭션(ROLLBACK) 불가
 - DELETE 보다 처리속도 빠름
 - 테이블 구조(column, constraint) 유지, auto_increment 초기화
 */

truncate table board;

INSERT INTO board (title, author) VALUES ('첫 번째 글', '홍길동');


/*
 DROP
 - 테이블 자체를 DB에서 완전히 제거하는 DDL 명령어
 - 트랜잭션(ROLLBACK) 복구 불가능
 */

-- table 없으면 에러발생
 drop table board;
-- 일반적으로 if exists 붙여서 사용
 drop table if exists board;