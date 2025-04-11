/*
서브쿼리의 특징  15.2.15 Subqueries

1) 서브쿼리는 내부 쿼리(Subqueries)와 외부 쿼리(Main query)로 구성된다.

2) 서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서 WHERE, HAVING, FROM, SELECT절 등
            위치에 사용
           - WHERE	조건절로 사용	WHERE SAL > (SELECT ...)
           -SELECT	출력 컬럼으로 사용	SELECT ENAME, (SELECT COUNT(*) ...) AS CNT
           - FROM	임시 테이블로 사용	FROM (SELECT ... ) AS TEMP


3) 단일 행 또는 다중 행 결과를 반환할 수 있고, 사용되는 연산자가 달라진다.
     - 단일 행     :  서브쿼리 결과가 1개의 행만 리턴
                       연산자: =, >, <, >=, <=, != 등 일반 비교 연산자
	 - 다중행    : 서브쿼리 결과가 여러 개의 행을 리턴
                연산자: IN, NOT IN, ANY, ALL, EXISTS, NOT EXISTS 등

    - 서브쿼리 연산자
        IN	:서브쿼리 결과 목록 중 포함된 값이면 참
		NOT IN	:서브쿼리 결과 목록 중 포함되지 않으면 참
		> ANY	:서브쿼리 결과 중 하나라도 초과하면 참
		< ALL	:서브쿼리 결과 모두보다 작으면 참
		EXISTS	:서브쿼리 결과가 존재하면 참
		NOT EXISTS:	서브쿼리 결과가 없으면 참

4) 일반적으로 서브쿼리는 주 쿼리의 실행에 의존적이며, 외부 쿼리의 컬럼을 참조할 수 있다.

5) EXISTS와 NOT EXISTS를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트를 수행한다.

6) Correlated subqueries: 서브쿼리가 외부 쿼리의 컬럼을 참조하는 경우를 말하며
   서브쿼리는 외부 쿼리의 각 행에 대해 반복적으로 실행된다.

7)서브쿼리 내에서 LIMIT 절의 사용이 제한될 수 있다.
*/

    use my_emp;
select * from emp;
-- Q1. JONES의 월급보다 더 많은 월급을 받는 사원의 이름과 봉급을 출력하시오.
select  emp.sal
from emp
where ename ='JONES';

select ename, emp.sal
from emp
where sal> (
    select sal
    from emp
    where ename = 'jones'
);
/*
-- 단일 행 : 서브쿼리 결과가 1개의 행만 리턴
-- 연산자: =.>, <,>=, <=,!= 등 일반 비교 연산자
-- 다중 행 : 서브쿼리 결과가 여러 개의 행을 리턴
    -- 연산자: in, not in, any, all. exists. not exists 등
-- 서브쿼리 연산자
    IN: 서브쿼리 결과 목록 중 포함된 값이면 참
    NOT IN: 서브쿼리 결과 중 하나라도 초과하면 참
    ?

    */
-- Q2. 직업이 'SALESMAN'인 사원과 같은 월급을 받는 사원의 이름과 월급을 출력하시오.
select ename, emp.sal
from emp
where sal in (select sal
             from emp
             where job = 'salesman');

-- Q3. 부서번호가 10번인 사원들과 같은 월급을 받는 사원의 이름과 월급을 출력하시오.
select ename, sal
from emp
where sal in (select sal from emp where deptno = 10);


-- Q4. 직업이 'CLERK'인 사원과 같은 부서에서 근무하는 사원의 이름, 월급, 부서번호를 출력하시오.
select ename, sal, emp.deptno
from emp
where deptno in (select deptno from emp where job = 'CLERK');


-- Q5. 'CHICAGO'에서 근무하는 사원들과 같은 부서에서 근무하는 사원의 이름과 월급을 출력하시오.

select  ename, emp.sal
from emp
where deptno in (select deptno
                 from dept
                 where loc = 'chicago');


SELECT
    ENAME, SAL , ( SELECT COUNT(*)
                   FROM EMP
                   WHERE DEPTNO IN (SELECT DEPTNO
                                    FROM DEPT
                                    WHERE LOC ='CHICAGO'
                   )) AS CNT
FROM EMP

WHERE DEPTNO IN (SELECT DEPTNO
                 FROM DEPT
                 WHERE LOC ='CHICAGO');

-- Q6. 부하직원이 있는 사원의 사원 번호와 이름을 출력하자. -> 자기자신(empno)이 관리자(mgr) 이면 된다
select empno, emp.ename
from emp
where empno in(select mgr
               from emp);


select empno, emp.ename
from emp
where empno = any(select ifnull(mgr,0)
                  from emp);
/*
  ANY ( DATA OR DATA OR ....NULL)
 = ANY      하나라도 만족하는 값이 있으면 결과를 리턴하며 IN과 동일함
ANY      값들 중 최소값 보다 크면 결과를 리턴
 >= ANY  값들 중 최소값 보다 크거나 같으면 결과를 리턴
 < ANY      값들 중 최대값 보다 작으면 결과를 리턴
 <= ANY  값들 중 최대값 보다 작거나 같으면 결과를 리턴
 <> ANY  모든 값들 중 다른 값만 리턴, 값이 하나일 때만 가능함

ALL( DATA  AND DATA AND ....NULL)
ALL      값들 중 최대값 보다 크면 결과를 리턴
 >= ALL  값들 중 최대값 보다 크거나 같으면 결과를 리턴
 < ALL      값들 중 최소값 보다 작으면 결과를 리턴
 <= ALL  값들 중 최소값 보다 작거나 같으면 결과를 리턴
 = ALL      모든 값들과 같아야 결과를 리턴, 값이 하나일 때만 가능함
 <> ALL  모든 값들과 다르면 결과를 리턴
 */

 -- Q7. 부하직원이 없는 사원의 사원 번호와 이름을 출력하자. -> 자기자신(empno)이 관리자(mgr) 이면 된다의 반대
select empno, emp.ename
from emp
where empno not in(select ifnull(mgr,0)
                   from emp);

select empno, emp.ename
from emp
where empno not in(select ifnull(mgr, 0)
                   from emp);

select empno, emp.ename
from emp
where empno not in(select mgr
                   from emp
                   where mgr is not null);

select empno, emp.ename
from emp
where empno !=All(select ifnull(mgr, 0)
                  from emp);


-- Q8. 'KING'에게 보고하는 사원의 이름과 월급을 출력하자.
-- 직속상관이 (mgr)이 'king'인 사람의 이름과 월급

select ename, emp.sal
from emp
where mgr = (select empno
             from emp
             where ename = 'KING');

-- Q9. 20번 부서의 사원중 가장 많은 월급을 받는 사원들 보다 더 많은 월급을 받는 사원의 이름과 월급을 출력하자.
-- max 사용

select ename, emp.sal
from emp
where sal>
      (select max(sal) from emp where deptno = 20)

-- Q9-1 20번 부서의 사원 중 가장 많은 월급을 받는 사원들보다 더 많은 월급을 받는 사원의 이름과 월급을 출력하자.
-- max 사용

select ename, sal
from emp
where sal>all(
select sal
from emp
where deptno=20);

-- Q10. 20번 부서의 사원 중 가장 적으 ㄴ월급을 받은 사원들보다 더 많은 월급을 받는 사원의 이름과 월급을 출력하자.
-- (ALl, any 둘 중 하나 사용하자. min max 사용해서 2개의 쿼를 만들자)

select ename, emp.sal
from emp
where sal>(select min(sal)
           from emp
           where deptno = 20);


select ename, sal
from emp
where sal> any(select sal
               from emp
               where deptno = 20);

-- Q11) 직업이 'salesman'인 사원 중 가장 많은 월급을 받는 사원보다 더 많은 월급을 받는 사원의 이름과 월급을 출력하자
-- min max 사용 x
select ename, sal
from emp
where sal> any(select sal
               from emp
               where job = 'salesman');


-- Q12) 직업이 'salesman인 사원중 가장 적은 월급을 받는 사원보다 더 적은 월급을 받는 사원의 이름과 월급을 출력하자.
-- min max 사용하지 말자

select ename, emp.sal
from emp
where sal<all(select sal
           from emp
           where job = 'salesman');

/*
  Recursive Common Table Expressions [계층 구조를 재귀적으로 탐색할 때 사용]   :  재귀적 CTE
  WITH RECURSIVE cte (n) AS
(
  SELECT 1
  UNION ALL
  SELECT n + 1 FROM cte WHERE n < 5
)
SELECT * FROM cte;
  */


-- Q13) 1~5까지 CTE를 활용해서 값을 출력해보자

WITH RECURSIVE cte (n) AS
                   (
                       SELECT 1
                       UNION ALL
                       SELECT n + 1 FROM cte WHERE n < 5
                   )
SELECT * FROM cte;

-- Q14) CTE를 활용해서 mgr 상관부터 말단까지 구조를 탐색해보자,

WITH RECURSIVE emp_res AS (
    -- [1] 최상위 관리자(MGR이 NULL인 사원) 정보를 가져옴
    SELECT empno, ename, mgr, 1 AS level
    FROM emp
    WHERE mgr IS NULL

    UNION ALL

    -- [2] 재귀적으로 각 사원의 부하직원을 가져옴
    SELECT e.empno, e.ename, e.mgr, et.level + 1
    FROM emp e
             JOIN emp_res et ON e.mgr = et.empno
)
SELECT empno, ename, mgr,level FROM emp_res order by level, mgr,empno;


-- Q14-1 위 내용을 GetMep_Res()로 프로시저로 만들어 호출 해보자.  = static void method형과 같다
    call GetEmp_Res();



-- Q15) cte로 구구단 3단을 출력해보자
with recursive  gugudan as(
    -- 1) 초기값 지정 3* 1
    select 3 as dan, 1 as num, 3*1 as result

    union all

    -- 2) 재귀적으로 num을 1씩 증가 시키면서 9까지 반복
    select dan, num +1, dan *(num +1)
    from gugudan
    where num<9
)
-- 3)전체 출력
select concat(dan," * ", num, " = ", result) as gugudan_prn
from gugudan;


-- Q16) cte를 활용해서 피보나치 수열 계산해보자. : 두 숫자를 더해서 다음 숫자를 만드는 수열
-- 0,1,1,2,3,5,8,13,,,
-- 첫번째와 두번째 항은 각각 0과 1이고, 그 이후에 각 항은 이전 두항의 합이다.

with recursive Fibonacci_CTE as (
    -- 1초기값
    select 0 as N, 0 as FIB, 1 as prev_fib
    union all
    -- 2 재귀적으로 피보나치 수열을 계산하자
    select n+1, prev_fib as fib, fib + prev_fib as prev_fib
    from Fibonacci_CTE
    where N<10
)
select *
from Fibonacci_CTe;

call 04_Fibonacci_cte(11);

-- MULTI COLUMN SUBQUERY
-- Q1) 직업이 'salesman'인 사원과 같은 부서에서 근무하고(AND)
-- (직업이 'salesman'인 사원과 같은) 같은 월급을 받는 사원들의 이름, 월급, 부서번호를 출력하자.

select ename, sal, emp.deptno
from emp
where deptno  in(select deptno
                 from emp
                 where job = 'salesman')
and
    sal in (select sal
            from emp
            where job = 'salesman')

-- 서브 쿼리 사용법
-- 2)서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서  WHERE, HAVING, FROM, SELECT절 등  위치에 사용
-- SELECT절  서브 쿼리 사용방법
/*
WHERE     :조건 비교용 하위 질의
HAVING     : 그룹 조건에 대한 비교
FROM     : 인라인 뷰(하위 결과셋을 테이블처럼)
SELECT     : 선택된 컬럼 값을 계산 또는 비교용
*/

--  CASE 1 ) 각 사원의 봉급이  그 사원이 속한  부서의 평균급여보다 얼마나 높은지 출력 해보자.
SELECT ENAME,  SAL-( SELECT AVG(SAL)
                     FROM EMP
                     WHERE DEPTNO  = E.DEPTNO)  AS RES
FROM EMP E;
-- CASE 2)  사원의 이름과 모든 사원의 봉급의 합을  출력한 결과
SELECT ENAME ,  (SELECT  SUM(SAL)   FROM EMP   ) AS "TOTAL SAL"
FROM EMP;

-- CASE 3) 사원의 이름과 모든 사원의 봉급의 평균을 출력한 결과
SELECT ENAME ,  (SELECT  AVG(SAL)   FROM EMP   ) AS "AVG SAL"
FROM EMP;

-- CASE 4)  SELECT에서 계산된 'SAL'의 별칭을 WHERE 절에서 사용하고 싶다.  -> 쿼리를 재구성해야 한다.


 -- 4-1) 서브쿼리  재구성
   SELECT *
   FROM (SELECT ENAME, (SELECT  SUM(SAL) FROM EMP) AS MYSAL
         FROM EMP )   AS SUBQUERY
   WHERE  MYSAL  > 2000 ;

 -- 4-2)  cte 사용
 WITH  CTE AS (
     SELECT ENAME, SAL AS MYSAL
     FROM EMP
)
SELECT *
FROM CTE
WHERE MYSAL > 2000 ;


-- 5) EXISTS와 NOT EXISTS를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트를 수행한다.
-- EXISTS를 사용해서 부서에 사원이 존재 하는지  확인 후 부서명을 출력 해보자.
SELECT DNAME
FROM dept d
WHERE EXISTS (SELECT 1
             FROM emp
             WHERE DEPTNO = d.DEPTNO);

SELECT DNAME
FROM dept d
WHERE EXISTS (SELECT *
             FROM emp
             WHERE DEPTNO = d.DEPTNO);

-- 6) Correlated subqueries: 서브쿼리가 외부 쿼리의 컬럼을 참조하는 경우를 말하며
-- 서브쿼리는 외부 쿼리의 각 행에 대해 반복적으로 실행된다.
-- 각 부서에서 가장 높은 급여를 받는 사원의 모든 내용을 출력 해보자.
SELECT  *
FROM EMP E1
WHERE  SAL  =  (
    SELECT MAX(SAL)
    FROM EMP  E2
    WHERE  E1.DEPTNO = E2.DEPTNO -- E1.DEPTNO 주쿼리 = 외부쿼리
) ;
/*
1. emp 테이블의 첫번째 행 (E1) 읽음 ( E1.DEPTNO = 10)
2. 서브쿼리 실행
3. 주 쿼리 행의 sal과 비교 E1.sal = 5000이면 통과, 아니면 제외
4. EMP 테이블의 두번째 행(E1) 읽음 (E1.deptno = 20) -> 서브쿼리 -> sal = (max(sal))
-> 행마다 다른 deptno 가 들어가 있다.-> 서브쿼리가 매번 다른 결과를 낸다. -> 결과에 따라 주쿼리 조건이 동적으로 계산된다.




*/
-- 6-1 상관쿼리를 조인으로 바꿔보자 join+ group by
select e1.ename, e1.sal, e1.deptno
from emp e1 join(
    select deptno, max(sal) as max_sal
    from emp
    group by deptno) e2 on e1.deptno = e2.deptno and e1.sal  = e2.max_sal;


-- 6-2 윈도우 함수

select ename, sal, deptno
from (
         select ename, sal, deptno, rank()over( partition by deptno order by sal desc) as rnk
         from emp
     )t
where rnk = 1;



###############################################
SELECT  *
FROM EMP E1
WHERE  SAL  =  (
    SELECT MAX(SAL)
    FROM EMP
    WHERE  E1.DEPTNO = DEPTNO
) ;
#####################  서브쿼리 안에서 JOIN하면 안돼요?
SELECT  *
FROM EMP E1
WHERE  SAL  =  (
    SELECT MAX(SAL)
    FROM EMP  E2
             JOIN E1 USING(DEPTNO)
);

-- 안된다!!!!!!!!!!!!


-- 7) 서브쿼리 내에서 limit 절의 사용이 제한될 수 있다.
-- 각 부서에서 월급이 가장 높은 상위 3명의 사원번호, 이름, 봉급, 부서번호를 출력해보자.
-- 각 부서별로 월급이 높은 순으로 정렬된 사원의 목록을 만든다 -> 상위 3명 추출

select empno,ename,sal,deptno
from emp e
where(
select count(*)
from emp e2
where e2.sal>e.sal and e2.deptno = e.deptno
    ) <3

order by 4, 3 desc;


####### HAVING 서브 쿼리를 확인 해보자.
-- Q1. HAVING 서브 쿼리
-- 평균 급여가 전체 평균 보다 더 높은 부서를 찾아 보자.
-- (각 부서의 평균 급여를 전체 평균 급여와 비교하여, 전체 평균보다 높은 부서를 출력하자)
SELECT DEPTNO, AVG(SAL) as avg_salary
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) > (SELECT AVG(SAL)
                   FROM EMP );

-- Q2. HAVING 서브 쿼리
--  부서별로 사원 수가 전체 사원 수의 평균 보다 많은 부서를 찾아 부서번호, 직원수를 출력 해보자
SELECT DEPTNO, COUNT(EMPNO) AS NUM_COUNT
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(EMPNO)  >  ( SELECT AVG(NUM_COUNT)
                          FROM (SELECT COUNT(EMPNO) NUM_COUNT
                                FROM EMP
                                GROUP BY DEPTNO ) as AVG_DEPT);

-- 1 . 모든 부서별 사원 수를 계산
SELECT COUNT(EMPNO) NUM_COUNT
FROM EMP
GROUP BY DEPTNO;   -- 결과   3, 5, 6
-- 2. 평균 값을 구한다.
SELECT AVG(NUM_COUNT)  -- AVG(3,5,6 )   -> 4.6667
FROM (SELECT COUNT(EMPNO) NUM_COUNT
      FROM EMP
      GROUP BY DEPTNO
     ) as AVG_DEPT;


-- Q3. HAVING 서브 쿼리
-- 부서별 사원들의  최고 급여가  각 부서별 최고 급여의 평균보다  부서를 찾아 부서번호, 최고급여를 출력 해보자
-- 주 쿼리 EMP 테이블에서 부서별 그룹화하고 각 그룹의 최고 급여를 계산한 다음 비교한다.
-- HAVING 절에서 사용된 서브쿼리는 먼저 모든 부서의 최고 급여를 계산하고 -> 평균값을 계산한다.

-- 1. 모든 부서의 최고 급여를 계산
SELECT MAX(SAL) as max_salary
FROM EMP GROUP BY DEPTNO;  -- 5000, 3000, 2850

-- 2. 평균값을 계산한다.
SELECT AVG(max_salary)
FROM
    (SELECT MAX(SAL) as max_salary
     FROM EMP GROUP BY DEPTNO) AS  DEPT_AVG_SAL ;  -- 3616

-- 3. 병합
SELECT DEPTNO, MAX(SAL) as hi_sal  -- 10 , 5000
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL) > ( SELECT AVG(max_salary)
                    FROM (SELECT MAX(SAL) as max_salary
                          FROM EMP
                          GROUP BY DEPTNO) AS  DEPT_AVG_SAL);

#--------------------------INLINE VIEW--------------------------------

-- 13.2.15.7 : FROM 절에서 사용되는  INLINE VIEW
/*
INLINE VIEW? -> FROM 절에 사용하는 서브쿼리, 일시적인 가상테이블을 생성해서 주쿼리(외부)에서 사용

서브쿼리의 일종으로 From 절 뒤에 사용된다.
임시 테이블 처럼 사용된다. 단, {별칭}을 반드시 붙여야 한다.
주쿼리의 From 절에 포함된 서브쿼리의 결과를 임시테이블로 간주하여 !조인하거나!
!추가적인 연산!을 수행한다.
집계함수와 group by 같은 구문을 사용하여 중간결과를 생성한 후 쿼리에서 조인하거나 필터링하게 된다.
*/
-- 각 부서의 최대 급여를 출력 해보자. 부서의 이름과 최대급여를 출력 해보자.
-- 단, 조건이 dept와 emp의 인라인 뷰를 사용해보자.


SELECT  D.DNAME, E.MAX_SAL
FROM DEPT D
JOIN
 (SELECT DEPTNO  , MAX(SAL)  AS MAX_SAL
      FROM EMP
      GROUP BY DEPTNO) E
ON  D.DEPTNO  = E.DEPTNO;

SELECT DEPTNO  , MAX(SAL)  AS MAX_SAL
FROM EMP
GROUP BY DEPTNO;

-- Q2. 임시테이블 생성 후 인라인 확인 해보자

DROP TABLE T1;

CREATE TABLE t1 (s1 INT, s2 CHAR(5), s3 FLOAT);

-- 구조확인
desc t1;

INSERT INTO t1 VALUES (1,'1',1.0);
INSERT INTO t1 VALUES (2,'2',2.0);


SELECT *
FROM  T1 ;

SELECT sb1,sb2,sb3
FROM (SELECT s1 AS sb1, s2 AS sb2, s3*2 AS sb3
      FROM t1) AS sb  -- 가상 테이블 객체를 SB 생성후
WHERE sb1 > 1;  --  ;를 만나면  자동  소멸 된다.


SELECT *
FROM SB;

-- Q3. 각 부서별 평균 급여를 구하고 = dept_avg, 평균 급여가 2000 이상인 부서의 부서번호와 평균 급여를 출력하자.

select dept_avg.deptno, dept_avg.avg_sal
from (select deptno ,avg(sal) as avg_sal
      from emp
      group by deptno

     ) dept_avg
where dept_avg.avg_sal>= 2000;

-- Q4. 인라인 뷰를 사용해서 사원의 이름, 급여 emp
 -- 전체 사원의 평균 월급을 출력해보자. AA


select e.ename, e.sal, AA.avg_sal
from emp e
join(select avg(sal) as avg_sal
     from emp)AA;

-- 1) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정
-- 3) CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정
-- 4) CREATE TABLE에서 검사 (CHECK) 제약 조건 지정
-- 5) CREATE TABLE에서 열에 기본값 지정  DEFAULT
-- 6) CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정

--  << 학생 정보를 유지하기 위한 students 테이블 생성 >>-

CREATE DATABASE  STUDENTS;
USE STUDENTS;
DROP TABLE STUDENTS;
-- 1) CREATE TABLE로 새 테이블 만들기
-- <<학생 정보를 유지하기 위한 students 테이블 생성>> --
create table students
(
    student_id      INT,
    student_number  VARCHAR(10),
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    middle_name     VARCHAR(50) ,
    birthday        DATE ,
    gender          ENUM ('M', 'F'),
    paid_flag       BOOL
    );


desc students;


delete from students;
-- q1-1 데이터 입력
insert into students
values
    (1,'1','1','1','1', now(),'M', TRUE),
    (2,'1','1','1','1', now(),'F', 0),
    (3,'1','1','1','1', now(),'F', false),
    (4,'1','1','1','1', now(),'M', TRUE);


-- q1-2 전체 내용 확인
select * from students;

select true, false;

##############################################################################


-- q2) CREATE TABLE로 새 테이블 만들기
-- create table에서 기본 키(primary key) 제약 조건 지정 _ 식별키
-- 테이블당 하나만 지정할 수 있다. (단일키, 복합키) = u + nn

create table students02
(
    student_id      INT,
    student_number  VARCHAR(10),
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    middle_name     VARCHAR(50) ,
    birthday        DATE ,
    gender          ENUM ('M', 'F'),
    paid_flag       BOOL,
primary key (student_id)
);


desc students02;
-- Q2-1 데이터 입력
-- 중복 데이터 x + not null = pk



-- q2-1 데이터 입력
insert into students02
values
    (1,'1','1','1','1', now(),'M', TRUE),
    (2,'1','1','1','1', now(),'F', 0),
    (3,'1','1','1','1', now(),'F', false),
    (4,'1','1','1','1', now(),'M', TRUE);

select * from students02;

-- q2-3 pk 확인
insert into students02
values
    (NULL,'1','1','1','1', now(),'M', TRUE)

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'students' AND TABLE_NAME = 'students';

-- q3 pk 복합키를 확인 해보자

create table students03(
       student_id int,
    student_number varchar(10),
    primary key (student_id,student_number)
);
desc students03;

-- q3-1 데이터를 입력해보자
insert into students03
values (1,1), (1,2),
(1,3), (1,4);

insert into students03
values (2,1),(2,2),(2,3),(2,4);

select *
from students03;

insert into students03
values (3,1),
       (3,2),
       (3,3),
       (3,NULL); -- 1048 error

select *
from students03;

insert into students03
values (1,'1'),
       (1,'2'),
       (1,'3'),
       (1,'4'); -- 1062 error

-- Q3-2 제약조건 확인
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'students' AND TABLE_NAME = 'students03';


-- Q4) 자동증가구현하는 제약조건을 확인 해보자.

create table STUDENTS04(
    student_id int auto_increment,
    student_number varchar(10),
    primary key (student_id)
);

desc STUDENTS04;

insert into STUDENTS04(student_number)
values (10),(20),(30),(40);

-- Q)4-1 테이블 수정 -> 자동증가 초기값 100으로
ALTER table STUDENTS04
auto_increment=  100;


insert into STUDENTS04(student_number)
values (10),(20),(30),(40);

select *
from STUDENTS04;


-- Q5) 자동증가구현하는 제약조건을 확인 해보자.

create table STUDENTS05(
                           student_id int auto_increment,
                           student_number varchar(10) default 'abc',
                           primary key (student_id,student_number)
);

desc STUDENTS05;

insert into STUDENTS05
values (1, 10), (2,20),(3,30),(4,40);

insert into STUDENTS05(student_id) values (1);

select * from STUDENTS05;


-- Q6) 복합키,. 자동증가, 기본값으로 지정하고 각 제약조건을 삭제 해보자

create table STUDENTS06(
                                student_id int auto_increment,
                               student_number varchar(10) default 'abc',
                                student_name varchar(50),
                               primary key (student_id,student_number)
);

desc STUDENTS06;

insert into STUDENTS06 (student_name)
values (1);

select * from students06;


-- Q6-1 기본키 삭제
alter table students06
modify column student_id int; -- 자동증가 속성 해제 = 컬럼 수정한다

alter table STUDENTS06
drop primary key;

-- 06-2 default 삭제 -> 컬럼 레벨
alter table STUDENTS06
alter student_number
drop default;


desc STUDENTS.students06;


-- Q06-3 삭제된 default를 추가해보자

alter table STUDENTS.students06
alter student_number set default 'abc';

-- Q7 제약조건을 생성해보자.
-- create table에서 고유 키(unique key) 제약 조건 지정: 중복데이터 x + null 허용
-- create table에서 검사(check) wpdir whrjs wlwjd: qjadnlwlwjd

create table students07

    (
        student_id int,
        student_number varchar(10),
        birthday    date,
        unique key(student_id),
        check (birthday >= '2001-01-01') -- 범위지정
    );

desc STUDENTS.students07;

insert into students07(student_id) values(null);
insert into students07(student_id, birthday) values(1, now());
insert into students07(student_id, birthday) values(2, now());
insert into students07(student_id, birthday) values(3, '1999-01-01');-- student07_chk_1 err 3819

select *
from students07;


-- 체크 제약조건 확인

select constraint_name, check_clause
from information_schema.CHECK_CONSTRAINTS;

-- q7-1 테이블의 제약조건을 삭제하자
ALTER TABLE students071
    DROP CHECK students071_CHK_1;
ALTER TABLE students071
    DROP CHECK students071_CHK_2;
DESC students071;

-- q7-2 테이블의 제약조건을 확인 후 남아있는 키값을 삭제하자
select constraint_name, constraint_type
from information_schema.TABLE_CONSTRAINTS
where table_name = 'students071';

alter table students071
drop index student_id;


show keys from students05;


-- Q8 참조형 테이블을 생성해보자.
-- create table에서 외래 키(foreign key) 제약 조건 지정
drop table STUDENTS05;
create table STUDENTS05(
                           student_id int auto_increment,
                           student_number varchar(10) default 'abc',
                           primary key (student_id)
);

desc students05;

insert into students05 values (1,1);
insert into students05 values (2,1);

select * from students05;

-- 현재 student_my 테이블의 student_id를 students05의 student_id로 참조 시키자

create table student_my(
    student_id  int,
    foreign key(student_id) references STUDENTS05(student_id)
);

show keys from student_my;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM information_schema. TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'student_MY';



SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE, REFERENCED_TABLE_NAME
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE TABLE_NAME = 'student_MY';


desc information_schema.REFERENTIAL_CONSTRAINTS;
-- 데이터 입력 후 확인!!
insert into student_my values(1);
insert into student_my values(null);
insert into student_my values(3); -- err 1452
select * from student_my;



