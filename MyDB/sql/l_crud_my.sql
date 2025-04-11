/*
1)CRUD
Create (삽입)	INSERT INTO 테이블명 (열1, 열2, ...) VALUES (값1, 값2, ...);	
Read (조회)	SELECT 열1, 열2 FROM 테이블명 [WHERE 조건];	
Update (수정)	UPDATE 테이블명 SET 열1 = 값1, 열2 = 값2 WHERE 조건;	
Delete (삭제)	DELETE FROM 테이블명 WHERE 조건;	

2)트랜잭션 제어 명령어
START TRANSACTION;	트랜잭션 시작 (명시적으로 시작하고 싶을 때 사용)
COMMIT;	트랜잭션 완료 후 변경 사항을 영구 저장
ROLLBACK;	트랜잭션 내의 모든 변경 사항을 취소하고 되돌림
SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
ROLLBACK TO SAVEPOINT 포인트명;	특정 지점까지 롤백

3) 트랜잭션 특징 (ACID 원칙 요약)
Atomicity (원자성)	: 모든 작업이 모두 수행되거나, 하나도 수행되지 않아야 함
Consistency (일관성)	: 트랜잭션 완료 후에도 데이터의 일관성 유지
Isolation (고립성)	:트랜잭션끼리 서로 간섭하지 않아야 함
Durability (지속성)	:COMMIT 후 변경 내용은 영구 저장되어야 함
*/
USE MY_EMP;
CREATE TABLE MY_EMP  -- EMP의 테이블 구조와 데이터로만 테이블 생성   
AS
SELECT  * FROM EMP;   -- 제약 구조는 리턴되지 않음  

SELECT  * FROM MY_EMP;
DESC MY_EMP;

CREATE TABLE MY_DEPT
AS
SELECT * FROM DEPT;

SELECT  * FROM MY_DEPT;
DESC MY_DEPT;

-- 1(자동 커밋활성화)  ,  0 (자동 커밋 비활성화 )
SET  autocommit= 0;  -- mysql 서버에  변경한다.
SET  global autocommit= 0;  -- mysql 서버에  변경한다.
-- SELECT @@autocommit;  -- 세션수준의 변수값 확인
 SELECT @@global.autocommit;  -- 글로벌 수준의 변수값 확인


start transaction; -- 명시 선언
-- dml 실행
commit;

####################  dml 연습 해보자 #################
    -- 1) 간단 테이블 생성
drop table test;
    create table test(
        id int,
        name varchar(20)
    );
desc test;

-- 2) 입력
    insert into test values (1,1);
insert into test values(2,2);
select * from test;

commit;
select * from test;

rollback ;

#####################################################################
-- SAVEPOINT 포인트명; 중간 저장점 지정 - ROLLBACK TO SAVEPOINT로 일부 취소 가능
-- ROLLBACK TO SAVEPOINT 포인트명; 특정 지점까지롤백
DROP TABLE TEST;
CREATE TABLE TEST(
    ID INT, NAME VARCHAR (20));
START TRANSACTION;
-- 데이터 추가
INSERT INTO TEST VALUES (1, 'A');
INSERT INTO TEST VALUES(2,'B');

-- 중간 저장 지점 설정

savepoint sp01;
insert into test values(3,'c');
insert into test values(4,'D');

select * from test;

rollback to sp01;

commit;

-- Q1) 사원 테이블에서 사원의 번호가 7499인 사원의 월급을 700으로 변경하자.
-- Q2) 부서 번호가 20번인 사원의 월급을 2000으로 변경하자.
-- Q3) MY_DEPT 테이블에 50번, RESERCH, BOSTON 데이터를 입력하자.
-- Q4) MY_DEPT 테이블에서 부서번호 50번 데이터를 삭제하자.
-- Q5) FORD의 월급을 4000으로, 부서번호를 30으로 변경하자.
-- Q6) 사원번호 7698의 부서번호를 사원번호 7934의 부서번호로 변경하자.
-- Q7) 사번이 0001인 홍길동 사원 데이터를 여러 개 추가한 후, 다양한 UPDATE 및 DELETE 작업을 수행하자.
-- Q7-1) 사원번호 1이고 매니저가 7785인 홍길동을 삭제하자.
-- Q7-2) 사번 0001의 부서번호를 20으로 변경하자.
-- Q7-3) 홍길동의 직업을 SALESMAN으로 변경하자.
-- Q7-4) 홍길동의 봉급을 KING과 같게 변경하자.
-- Q7-5) 매니저가 7785인 홍길동의 봉급을 0으로 수정하자.
-- Q7-6) 매니저가 7784인 홍길동의 커미션을 1000으로 수정하자.
-- Q8) 서브쿼리를 이용한 INSERT, DELETE, UPDATE를 활용해보자.
-- Q8-1) WARD와 같은 직업을 가진 사원을 삭제하자.
-- Q8-2) WARD의 월급을 SMITH의 월급과 같게 수정하자.
-- Q8-3) KING의 직업을 SMITH와 같게 수정하자.
-- Q8-4) 사원번호 7499와 같은 직업을 가진 사원의 입사일을 오늘 날짜로 수정하자.
-- Q9) MY_EMP, MY_DEPT 테이블에 PRIMARY KEY를 추가하자.
-- Q10) MY_EMP 테이블에 외래키를 설정하고 ON DELETE/UPDATE CASCADE 옵션을 추가하자.
-- Q11) MY_DEPT에서 DEPTNO 10을 삭제한 후, MY_EMP에서 DEPTNO 10을 확인하자.
-- Q12) MY_DEPT에서 DEPTNO 20을 200으로 변경한 후, MY_EMP에서 DEPTNO 200을 확인하자.





