use employees;

show index from employees;

-- EXPLAIN 실행계획 확인
/*
 type (접근방식)
 - ALL: 전체 테이블 다 읽음
 - index: 인덱스 다 읽음
 - range: 인덱스 일부 탐색
 - ref: 인덱스 통해 특정 값 탐색
 - const: 기본키, 유일값으로 한 줄만 찾는 경우

 key (사용된 인덱스)
 - 쿼리에서 사용되는 인덱스의 이름 (NULL: 인덱스 없음)

 rows (예상되는 읽을 행의 수)
 - 적게 읽을 수록 성능이 좋음(빠름)
 */
-- SELECT 쿼리 실행 전 MYSQL이 내부적으로 어떻게 데이터 가져올지 확인
-- rows: 읽어올 행 수
explain select * from employees where last_name = 'Peha';
explain select * from employees where emp_no = '10018';  -- 클러스터형 인덱스로 찾음 -> 더 빠름

-- 인덱스 생성
create index idx_lastname on employees(last_name);

show index from employees;

-- 테이블의 인덱스 통계정보 갱신
ANALYZE TABLE employees;

explain select * from employees where last_name = 'Peha';

-- 인덱스 삭제
drop index idx_lastname on employees;

show index from employees;