use employees;

-- WHERE
-- 특정 조건에 맞는 행만 선택하여 사용

select *
from employees
where
    gender = 'F';  -- gender가 F인 데이터만 출력

-- select 조회컬럼이 아니더라도 where 조건컬럼으로 사용가능
select
    first_name,
    last_name
from employees
where
    gender = 'F';

-- ColumnA != B: 컬럼의 내용 중 B와 같지 않은 데이터만 보여주기 (확장문법)
-- ColumnA <> B: "" (표준문법)
select
    first_name,
    last_name,
    gender
from employees
where
    gender <> 'F';

-- AND 연산자와 함께 where절 사용
-- 두 조건 모두 참인 데이터만 출력
select
    first_name,
    last_name,
    gender
from employees
where
    gender = 'F' AND first_name = 'Aamod';

select
    emp_no,
    first_name,
    last_name,
    gender
from employees
where
    gender = 'F' OR emp_no < '10050';

/*
 AND, OR 우선순위
 - AND > OR
 - 괄호로 묶으면 괄호먼저 실행
 */
 select true OR false AND false;  -- 1
 select (true OR false) AND false;  -- 0

select *
from employees
where
    emp_no >= 10050 and emp_no <= 10060;


/*
 BETWEEN
 - 경계값을 포함한 두 값 사이의 데이터 추출
 */
 select *
 from employees
 where emp_no between 10050 AND 10060;  -- 10050~10060

-- NOT BETWEEN: 경계값 포함X
select *
from employees
where emp_no NOT between 10050 AND 499995;  -- ~10049, 49996~


/*
 LIKE
 - 특정 패턴과 일치하는 행 검색
 - 느림 -> 검색엔진 사용

 패턴
 % : 0개 이상의 문자
 '%apple%' -> apple 포함하는 모든 문자열

 _ : 1개 문자
 'a_k' -> 'a'로 시작하고 'k'로 끝나는 3글자 문자열
 */
select
    first_name
from
    employees
where
    first_name like 'Aa%';  -- first_name이 Aa로 시작하는 모든 data

select
    first_name
from
    employees
where
    first_name like 'Aa__d';  -- first_name이 Aa로 시작하고 d로 끝나는 5글자

/*
 IN 연산자
 - 특정 열의 값이 지정된 목록 중 하나와 일치하는 데이터
 */
select *
from employees
where
    emp_no in (2, 3, 55333, 19525)

/*
 is Null
 - 값의 null 유무 조회
 */
select *
from buytbl
where groupName is null;