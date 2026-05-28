/*
 트랜잭션(Transaction)
 - 데이터베이스 작업을 하나의 논리적인 작업 단위로 묶은 것
 */

select @@autocommit;  -- 현재 세션의 자동커밋상태 (쿼리 하나 실행될 때마다 자동커밋)

set autocommit = false;  -- autocommit 비활성화

-- 트랜젝션 시작
start transaction;

-- 아후에 동작하는 query들은 하나의 작업 단위로 묶임
use sqldb;

delete from buytbl where num  = 1;
delete from buytbl where num  = 2;

-- 현재 트랜잭션 세션 안에서는 삭제된 것으로 보이나 실제 데이터베이스에 반영X
select * from buytbl;

rollback;  -- transaction 시작 이전 중 가장 최근의 commit 시점으로 되돌림

commit;  -- commit 시 데이터베이스에 반영됨

-- autocommit 원복
set autocommit = true;

select @@autocommit;