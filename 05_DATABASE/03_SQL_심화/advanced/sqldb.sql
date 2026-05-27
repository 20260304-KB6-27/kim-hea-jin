USE sqldb;

CREATE TABLE stdtbl (
                        stdName  VARCHAR(10) NOT NULL PRIMARY KEY,
                        addr     CHAR(4) NOT NULL
);

CREATE TABLE clubtbl (
                         clubName  VARCHAR(10) NOT NULL PRIMARY KEY,
                         roomNo    CHAR(4) NOT NULL
);

CREATE TABLE stdclubtbl (
                            num       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                            stdName   VARCHAR(10) NOT NULL,
                            clubName  VARCHAR(10) NOT NULL,
                            FOREIGN KEY(stdName)  REFERENCES stdtbl(stdName),
                            FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

INSERT INTO stdtbl VALUES
                       ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'), ('바비킴','서울');

INSERT INTO clubtbl VALUES
                        ('수영','101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');

INSERT INTO stdclubtbl VALUES
                           (NULL,'김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'),
                           (NULL,'은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');


-- 1. 학생 테이블, 동아리 테이블, 학생동아리 테이블을 이용해 학생 기준으로 학생 이름/지역/가입한 동아리/동아리방을 출력하세요.
select s.stdName, s.addr, sc.clubName, c.roomNo
from stdtbl s
join stdclubtbl sc on s.stdName = sc.stdName
join clubtbl c on sc.clubName = c.clubName;

-- 2. 동아리 기준으로 가입한 학생의 목록을 출력하세요. 출력정보: clubName, roomNo, stdName, addr
select c.clubName, c.roomNo, s.stdName, s.addr
from clubtbl c
join stdclubtbl sc on c.clubName = sc.clubName
join stdtbl s on sc.stdName = s.stdName;


CREATE TABLE empTbl (
                        emp     CHAR(3),
                        manager CHAR(3),
                        empTel  VARCHAR(8)
);

INSERT INTO empTbl VALUES
                       ('나사장', NULL,   '0000'),
                       ('김재무', '나사장','2222'),
                       ('김부장', '김재무','2222-1'),
                       ('이부장', '김재무','2222-2'),
                       ('우대리', '이부장','2222-2-1'),
                       ('지사원', '이부장','2222-2-2'),
                       ('이영업', '나사장','1111'),
                       ('한과장', '이영업','1111-1'),
                       ('최정보', '나사장','3333'),
                       ('윤차장', '최정보','3333-1'),
                       ('이주임', '윤차장','3333-1-1');


-- 3. '우대리'의 상관 연락처 정보를 확인하세요. 출력 항목: 부하직원, 직속상관, 직속상관연락처
select e.emp as 부하직원, e.manager as 직속상관, e1.empTel as 직속상관연락처
from empTbl e
join empTbl e1 on e.manager = e1.emp
where e.emp = '우대리';












