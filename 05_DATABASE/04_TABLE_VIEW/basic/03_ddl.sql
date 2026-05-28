use tabledb;

create table userTbl (
    userID char(8) not null,
    name varchar(10) not null,
    birthYear int not null,

    -- constraint: 제약조건 명시적 정의
    CONSTRAINT PRIMARY KEY PK_userTbl(userID)
);

create table prodTbl (
    prodCode char(8) not null,
    prodID varchar(10) not null,
    prodDate int not null,
    prodCur int not null,

    -- 복합키: 여러 컬럼을 묶어서 하나의 키로 사용
    -- 복합키는 컬럼 단위에서 정의 불가
    CONSTRAINT PRIMARY KEY PK_prodCode_prodID(prodCode, prodID)
);