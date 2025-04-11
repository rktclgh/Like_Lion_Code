/*
DELIMITER $$
CREATE PROCEDURE 프로시저명 ( [매개변수 목록] )
BEGIN
    -- SQL 문들
END$$
DELIMITER ;

매개변수 
IN : 입력값 전달
OUT : 출력값 반환
INOUT : 입력도 하고 수정된 값도 반환
CRUD 문법 (프로시저 안에서도 동일하게 사용 가능)

ex)
CREATE PROCEDURE sample_proc(IN param1 INT, OUT result INT)
BEGIN
   SELECT param1 * 2 INTO result;
END;
*/



-- 1(자동 커밋활성화)  ,  0 (자동 커밋 비활성화 )
SET  autocommit= 0;  -- mysql 서버에  변경한다.  _자동커밋 해제  DML 할때 COMMIT 명시전까지 반영되지 않음
SET  global autocommit= 0;  -- mysql 서버에  변경한다.
-- SELECT @@autocommit;  -- 세션수준의 변수값 확인    =  세션이란? 클라이언트 객체를 생성해서 서버가 관리하는 인스턴스
-- SELECT @@global.autocommit;  -- 글로벌 수준의 변수값 확인

START TRANSACTION;  -- 명시 선언


use my_emp;
SELECT  * 
FROM EMP;

DROP TABLE EMP_TEST;

-- sample_proc를 호출해보자
    set @OUTPUT = 0;
    call sample_proc(5, @output);
    select @output as result;


-- 02. 두수를 입력받아 사칙연산 프로시저를 호출해보자.

    set @a =10;
    set @b =5;
    set @hap =0;
    set @sub = 0;
    set @mul =0;
    set @r_div =0;
-- 2-1프로시저 호출
    call my_calc(@a, @b, @hap,@sub,@mul,@r_div);
-- 2-2 결과
    select @hap as '+', @sub as '-',@mul as '*', @r_div as '/';

-- 3 호출해보자
    call my_emp.doiterate(6);
    select @x;

create table my_temp(a int);
call dorepeat(10);
select * from my_temp;

-- Q1) 제약 조건이 없는 사원 테이블 `EMP_TEST`를 생성해보자.
create table emp_test
as
select *
from emp;


select *
from emp_test;





-- Q2) `PRO01_INSERT`() 프로시저를 작성하여, `EMP_TEST`에 사원의 번호, 이름, 부서번호를 여러 건 입력하자.
    
insert into emp_test(empno, ename, deptno)
values (1, '1111',10),
       (2, '2222',20),
       (3, '3333',30);

call pro01_insert();

rollback


-- Q3) `PRO02_DELETE`(IN E_NO INT) 프로시저를 작성하여, 사원 번호를 입력받아 해당 사원을 삭제해보자.
call pro02_delete(3);

desc emp_test;

-- Q4) `PRO03_UPDATE`(IN E_NO INT, IN E_NAME VARCHAR(50)) 프로시저를 작성하여, 사번에 해당하는 사원의 이름을 수정하자.

    call pro03_update(2,'홍길동');

-- Q5) `PRO04_SELECT`(IN EMP_NAME VARCHAR(50)) 프로시저를 작성하여, 사원 이름으로 해당 사원의 정보를 조회하자.




-- 5-1 프로시저 전체 확인 해보자.
    show procedure status where db = "my_emp";

-- 5-2 특정 프로시저의 선언된 내용을 확인 해보자
    show create procedure my_emp.pro01_insert;
-- Q6) `PRO05_COUNT`(OUT CNT INT) 프로시저를 작성하여, EMP_TEST 테이블의 총 사원 수를 반환하자.
call pro05_count(@res);
select @res;



-- Q7) `PRO06_SELECTALL`() 프로시저를 작성하여, EMP_TEST 테이블의 모든 데이터를 조회하자.
call pro06_SELECTALL();
    
    
-- Q8) `PRO07_IF`(IN ENO INT) 프로시저를 작성하여,
--      사원이 존재하면 해당 사원의 월급을 2배로 인상하고, 
--      존재하지 않으면 메시지를 출력하자.

set @eno = 7369;
call pro07_if(@eno);

-- Q9) `PRO08_IF`(IN IN_SAL DECIMAL) 프로시저를 작성하여,
--      입력받은 월급보다 많이 받는 사원의 이름과 급여를 출력하되, 
--      존재하지 않으면 메시지를 출력하자.

    call pro09_if(4000);

/*  <<예외>>
1) DECLARE ... HANDLER : CONTINUE, EXIT, UNDO 핸들러를 통해 오류 발생 후의 흐름 제어
         -DECLARE CONTINUE HANDLER FOR condition action: 지정된 조건이 발생하면 현재 실행 중인 구문을 완료하고 다음 구문을 계속 실행
         -DECLARE EXIT HANDLER FOR condition action: 지정된 조건이 발생하면 현재 블록(BEGIN ... END)을 즉시 종료
         -DECLARE UNDO HANDLER FOR condition action: (트랜잭션 스토리지 엔진에서) 지정된 조건이 발생하면 현재 트랜잭션을 롤백

condition 부분 지정  옵션 = SQLSTATE value: 특정 SQLSTATE 값 (5자리 문자열, 예를 들어 '45000').=SQLEXCEPTION: 모든 SQLSTATE 값 중에서 일반적인 오류를 나타내는 클래스=SQLWARNING: 모든 SQLSTATE 값 중에서 경고를 나타내는 클래스= NOT FOUND: 커서 작업에서 더 이상 행이 없을 때 발생하는 조건 (SQLSTATE '02000').=specific_error_code: 특정 MySQL 오류 코드 (정수).
2) SIGNAL SQLSTATE :SQL 예외 발생
3) GET DIAGNOSTICS:발생한 오류에 대한 자세한 정보(SQLSTATE, 오류 코드, 메시지 등)확인

*/

-- Q10) 모든 사원의 급여를 입력받은 비율만큼 인상하는 프로시저를 작성하자. (예: 비율 1.1 → 10% 인상)


-- 10-1) docs에 있는 코드를 테스트 하자.
    -- 테이블 생성
    drop table t;
create table t(
    s1 int,
    primary key (s1)
);

desc t;

-- 프로시저 호출
    call handlerdemo();
select @x;

select * from t;
call p();


-- 10-2) 예외가 발생된 정보를 리턴 받아서 출력 해보자.
DROP TABLE no_such_table;
-- ERROR 1051 (42S02): Unknown table 'test.no_such_table'
GET DIAGNOSTICS CONDITION 1
    @p1 = RETURNED_SQLSTATE,
    @p2 = MESSAGE_TEXT;
SELECT @p1, @p2;
-- 10-3) 예외 처리를 포함한 진단 정보(GET DIAGNOSTICS)를 출력하자.
CALL do_insert (100);


-- 10-4) pro10_do_insert(1); 실행했을 경우 트랜잭션 구현코드를 추가해서

-- Q11) `DO` 문을 활용하여 반복 또는 조건문 기반 로직을 실습해보자.

    create table if not exists random_members(
        id int auto_increment primary key ,
        name varchar(50),
        phone varchar(20),
        join_date date
    );

select datediff('2024-12-31', '2020-01-01')
call pro11_insert_random_memebrs();


select * from random_members;

-- 위 테이블에 wed 컬럼 추가 후 요일 계산 해서 넣어보자.

-- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여,
    call PRO12_CURSOR_SELECT();

-- Q13) `CURSOR`(커서)를 이용한 프로시저를 작성하여, 부서번호가 10번인 사원들을 순차적으로 출력하자.



 
 
 
 
 
 
 
 
 
 


