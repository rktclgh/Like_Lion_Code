/*
TRIGGER  : 특정테이블에서 데이터가 INSERT | UPDATE | DELETE 될때 자동으로 실행되는 SQL 코드 블록이다. 
CREATE
    [DEFINER = user]
    TRIGGER [IF NOT EXISTS] trigger_name
    trigger_time trigger_event
    ON tbl_name FOR EACH ROW
    [trigger_order]
    trigger_body

trigger_time: { BEFORE | AFTER }
trigger_event: { INSERT | UPDATE | DELETE }
trigger_order: { FOLLOWS | PRECEDES } other_trigger_name
*/
-- Q1) BEFORE_EMP_INSERT  라는 트리거를 만들어서 봉급이 음수값이 입력되면 오류를 발생하자  
use my_emp;

DELIMITER //

CREATE TRIGGER BEFORE_EMP_INSERT
BEFORE INSERT  
ON EMP FOR EACH ROW 
BEGIN
    IF NEW.SAL < 0 THEN
        SIGNAL SQLSTATE '45000'  
        SET MESSAGE_TEXT = '봉급이 음수잖아';
    END IF;
END; //

DELIMITER ;


INSERT INTO EMP(EMPNO, SAL) VALUES (1,-1000) ;

-- Q2) BEFORE_EMP_UPDATE 라는  데이터를 수정할 때 특정 조건을 트리거 하자.  
--  봉급이 수정될 때 ,  이전봉급은 커미션에다 입력하자. 
/*
조건 1: NEW.SAL이 OLD.SAL과 다를 경우 → COMM에 OLD.SAL 저장
조건 2: NEW.SAL < 0일 경우 오류 발생
오류 메시지: '봉급이 음수잖아'
*/

DELIMITER //
CREATE TRIGGER BEFORE_EMP_UPDATE
BEFORE update
ON EMP FOR EACH ROW 
BEGIN
    IF NEW.SAL <> OLD.SAL THEN
        SET NEW.COMM = OLD.SAL;
    END IF;

    IF NEW.SAL < 0 THEN
        SIGNAL SQLSTATE '45000'  
        SET MESSAGE_TEXT = '봉급이 음수잖아';
    END IF;
END; //

DELIMITER ;

UPDATE  EMP SET  SAL   = 90;  -- 업데이트 실행 

SELECT  * FROM EMP;   -- 확인 

 -- Q3) 트리거 확인 및 메타 정보 조회
SHOW CREATE TRIGGER  BEFORE_EMP_UPDATE;

SELECT * FROM INFORMATION_SCHEMA.TRIGGERS
       WHERE TRIGGER_SCHEMA='MY_EMP' AND TRIGGER_NAME='BEFORE_EMP_UPDATE';


-- Q4) AFTER_EMP_INSERT 라는 트리거를 생성하시오.
-- EMP 테이블에 INSERT가 발생한 후 새로 입력된 사원의 이름(ENAME)과 봉급(SAL)을 로그 테이블(EMP_LOG)에 기록하시오.

CREATE TABLE IF NOT EXISTS EMP_LOG (
    LOG_ID INT AUTO_INCREMENT PRIMARY KEY,
    LOG_ENAME VARCHAR(50),
    LOG_SAL DECIMAL(10,2),
    LOG_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER AFTER_EMP_INSERT
    after INSERT
    ON EMP FOR EACH ROW
BEGIN
    insert into EMP_LOG(log_ename, log_sal)
    values (new.ename, new.sal);
END; //

DELIMITER ;

insert into emp(empno, ename, sal, deptno) values(17,'홍길동',1000, 10);

select * from emp_log;

-- Q5)BEFORE_EMP_DELETE 라는 트리거를 생성하시오.
-- 사원이 삭제되기 전에  삭제 대상의 이름(ENAME)과 봉급(SAL)을 EMP_DELETE_LOG 테이블 저장하자. 
CREATE TABLE IF NOT EXISTS EMP_DELETE_LOG (
    DEL_ID INT AUTO_INCREMENT PRIMARY KEY,
    ENAME VARCHAR(50),
    SAL DECIMAL(10,2),
    DELETED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER BEFORE_EMP_DELETE
    after delete
    ON EMP FOR EACH ROW
BEGIN
    insert into EMP_DELETE_LOG(ENAME, sal)
    values (old.ename, old.sal);
END; //

DELIMITER ;


select * from EMP_DELETE_LOG;

delete from emp where empno = 15;


-- Q6)  AFTER_EMP_UPDATE 라는 트리거를 생성하시오.
-- EMP 테이블에서 UPDATE가 발생한 후 SAL이 이전보다 증가한 경우만 EMP_UPDATE_LOG 테이블에 변경 내용을 기록하시오.
CREATE TABLE IF NOT EXISTS EMP_UPDATE_LOG (
    UPDATE_ID INT AUTO_INCREMENT PRIMARY KEY,
    EMPNO INT,
    OLD_SAL DECIMAL(10,2),
    NEW_SAL DECIMAL(10,2),
    CHANGED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

select * from EMP_UPDATE_LOG;

# DELIMITER //
# CREATE DEFINER=`root`@`localhost` TRIGGER `emp_AFTER_UPDATE` AFTER UPDATE ON `emp` FOR EACH ROW BEGIN
#     if new.sal > old.sal then
#         insert into my_emp.emp_update_log
#         values(old.empno,old.sal,new.sal);
#     end if;
# END
-- 증가
update my_emp.emp
set sal = sal*1.10
where empno = 17;

-- 감소
update my_emp.emp
set sal = sal*0.90
where empno = 17;








-- Q7) BEFORE_EMP_UPDATE_SAL 트리거를 생성하시오.
--  EMP 테이블에서 봉급(SAL)이 변경될 때  기존 봉급보다 낮은 값으로 수정하려는 경우 오류를 발생시키시오.
--  오류 메시지: '봉급은 안돼!! 줄어들 수 없어!!'





















