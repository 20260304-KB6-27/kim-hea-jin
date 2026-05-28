CREATE DATABASE IF NOT exists testdb;

USE testdb;

/*
 클러스터형 인덱스
 - 테이블의 기본키(PK)가 자동으로 클러스터형 인덱스가 됨
 - 데이터가 기본키 순서대로 정렬(클러스터형 인덱스 순으로 정렬되어 저장)
 - 한 데이블에 하나의 클러스터형 인덱스만 존재 가능

 보조 인덱스
 - PRIMARY KEY가 아닌 모든 인덱스
 - 인덱스 직접 생성 가능
 - UNIQUE 제약조건을 넣으면 고유 인덱스 생성
 */

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
    userID CHAR(8) NOT NULL PRIMARY KEY,  -- 클러스터형 인덱스
    name VARCHAR(10) NOT NULL UNIQUE,  -- 보조 인덱스
    birthYear INT NOT NULL,
    addr NCHAR(2) NOT NULL
);

SHOW INDEX FROM usertbl;

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('ANA', '성시경', 1979, '서울');

select *
from usertbl;  -- userID 기준 정렬

-- primary key userID -> name으로 변경
alter table usertbl drop primary key;
alter table usertbl
    add constraint pk_name primary key (name);

show index from usertbl;

select *
from usertbl;  -- name 기준 정렬