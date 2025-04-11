use my_emp;
select * from my_emp.emp;


-- Q1. 사원 테이블에서 '부서번호'와 '사원 이름'을 모두 출력해보자. 단 별칭으로 출력하자.

    select ename, deptno from my_emp.emp;

-- Q2. 부서번호가 10번인 사원의 모든 정보를 출력해보자.

    select * from emp where deptno = 10;

-- Q3. 급여가 3000 이상인 사원의 사번(empno), 이름(ename), 급여(sal)를 출력해보자.
    select empno, ename, format(sal, 0), ROUND(sal, 0)
    from emp
    where (sal>=3000);

-- Q4. 직업이 'MANAGER'인 사원의 이름과 직업를 출력해보자.
    select ename,job
    from my_emp.emp
    where job = 'MANAGER';

-- Q5. 입사일이 1985년 이후인 사원의 이름과 입사일을 출력해보자.
-- date_format(Now(), '오늘은 %Y년 %월 %d일 %w 입니다')
    select  emp.ename, date_format(hiredate, '입사일은 %Y년 %월 %d일 %w 입니다')
    from emp
    where hiredate > '1985-01-01';

-- Q6. 급여가 2000 이상이면서 직무가 'SALESMAN'인 사원의 이름과 급여, 직업를 출력해보자.

    select emp.ename, emp.sal,emp.job
    from emp
    where sal>=2000 and job = 'SALESMAN';
# 없다

-- Q7. 커미션이 NULL이거나 급여가 5000 이상인 사원의 이름과 급여, 커미션을 출력해보자.

select ename,format(sal,0),ifnull(format(comm,0), '없음')as '커미션'
from emp;

-- Q8. 사원의 이름과 매니저를 출력하자, 단 매니저가 없으면 '없음' 으로 출력 해줘

select ename, ifnull(mgr,'없음') as 매니저

from emp;


-- Q8. 사원의 이름과 매니저를 출력하자, 단 매니저가 없으면 '없음' 으로 출력 해줘 [case when then]

select ename,
     case when mgr is null then '없음'
        else cast(mgr as char) -- 숫자를 문자로 변환
    end as 매니저
from emp;


/*
 having group by 조건문
 order by 정렬
 limit[옵션] 결과 제한

 from -> where -> group by -> having -> select ->order by-> limit


 where는 group by 이전에 실행 -> 일반 필터링
 having 은 group by 이후에 실행 -> 그룹핑 결과 필터링
 ------------------------------
 숫자함수, 문자합수, 날짜함수
 집계 함수 count,max, min, sum, avg..

 */

    -- Q1. 사원 테이블의 봉급을 이용해서 집계함수를 출력 해보자.
    select count(sal), max(sal), min(sal), sum(sal), avg(sal)
    from emp;

select count(null), max(null), min(null), sum(null), avg(null);

select count(comm)
from emp;


select count(*)
from emp;



# where (comm is null or sal>5000);
# 없다


 -- %k 24시간 1자리 표시







/*   실행순서  
SELECT  컬럼리스트   -----------------------------------------------5
FROM    테이블 리스트          ------------------------------------ 1
WHERE   조건문 [숫자비교, 문자비교, 대소문자비교, NULL, 날짜비교,,]-------  2
GROUP BY   그룹화( 집계연산 SUM, MAX, MIN, AVG, MEAN, STD,,,,)------------  3
HAVING    GROUP BY 조건문    -----------------------------------  4
ORDER BY  정렬  ----------------------------------------------- 6 
LIMIT[옵션]  결과 제한  ---------------------------------------------7  
 
  FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT 
*/
 
-- WHERE는 GROUP BY 이전에 실행 → 일반 필터링
-- HAVING은 GROUP BY 이후에 실행 → 그룹핑 결과 필터링



--  Q1
--  Q2 사원 테이블에서 부서 번호가 10번인 사원의 평균 월급을 구해보자.
    select avg(sal)
    from emp
    where deptno = 10;
--  Q3 사원 테이블에서 부서 번호가 10, 30번인 사원의 월급의 합을 구하자ㅓ
    select sum(sal)
    from emp
    where deptno in (10, 30);
--  Q4 직업이 세일즈맨인 사원의 평균 월급과 월급의 합을 구해보자
    select avg(sal), sum(sal)
    from emp
    where job = 'SALESMAN';
--  Q5 봉급이 3000 이상 5000 이하의 월급을 몇명이 받는지 개수를 출력해보자
select count(*) As '사원 수'
from emp
where sal between 3000 and 5000;



/*
SELECT
FROM
GROUP BY
ORDER BY

-GROUP BY 절에서는 테이블의 칼럼이나 변수만 사용할 수 있으며, { 그룹 함수는 사용할 수 없다}
-SELECT 리스트에는 GROUP BY에 명시된 표현식과 그룹 함수만 사용할 수 있으며, *는 사용할 수 없다
-ORDER BY 절에서는 SELECT 리스트에 명시된 칼럼, 표현식, 별칭, 또는 칼럼 번호를 사용할 수 있다.
-FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT
-WITH ROLLUP  =  그룹의 총계, 부분 소계를 나타낸다. ROLLUP 연산자는 GROUP BY 문과 함께 사용되며
             GROUP BY 문에서 명시된 컬럼 순서대로 추가적인 요약 정보를 단계적으로 만들어 준다.
*/


-- Q1. 부서별 평균 월급을 구하자.
    select  avg(sal)
    from emp
    group by deptno;
-- Q1-1. 부서별 평균 월급을 구하자. 별칭으로 NO을 주자

select deptno as no, avg(sal)
    from emp
    group by deptno;
-- Q1-2. 부서별 평균 월급을 구하자. 별칭으로 그룹핑 해보자

select deptno as no, avg(sal)
    from emp
    group by no;
-- Q1-3. 부서별 평균 월급을 구하자. 문자열의 별칭으로 그룹핑 해보자 -> 안된다

# select deptno as "번호", avg(sal)
#     from emp
#     group by "번호";   이건 안된다. 문자열 그룹핑 어쩌구 그거땜에 안됨

-- Q1-4. 부서별 평균 월급을 구하자. 속성명의 위치로 그룹핑 해보자.

select deptno as "번호", avg(sal)
    from emp
    group by 1;

-- Q1-4. 부서별 평균 월급을 구하자. 속성명의 위치로 그룹핑 해보자.

select deptno as "번호", avg(sal)
from emp
group by 1;

-- Q1-5. Q1-3의 번외편을 만들어서 실행해보자

select deptno as "번호", avg(sal)
from emp
group by 번호;


-- Q2.  직업별 평균 월급을 구하자.
    select job, format(avg(sal),2)
    from emp
    group by job; -- select 의 속성명 위치
-- Q3.  부서별 평균 월급을 구하되 10번 부서의 평균 월급만 출력하자.
select deptno, format(avg(sal),2)
from emp
where deptno = 10;
-- Q4. 직업별 월급의 합을 구하자
    select job, round(sum(sal), 0) as res
    from emp
    group by job;
-- Q5.직업이 SALESMAN인 사원의 월급의 합을 구하라.
select job,sum(sal)
from emp
where job = 'SALESMAN';
-- Q6. 사원 테이블에서 사원의 최대 월급을 출력하자.
    select  max(sal)
    from emp;
-- Q7. 사원테이블에서 사원 최소 월급을 출력하자.
    select min(sal)
    from emp;
-- Q8. 각 부서별 최대 월급을 출력하자.
    select deptno, max(sal)
    from emp
    group by deptno;
-- Q9. 사원 테이블에서 커미션이 책정되어 있는 사원의 이름과 커미션을 출력하라
    select ename, emp.comm
    from emp
    where comm is not NUlL;
-- Q10. 사원 테이블에서 커미션이 책정되지 않은 사원의 이름과 커미션을 출력하라.
select ename, emp.comm
from emp
where comm is NULL;


-- Q1. 직업별 월급의 합을 구하고, 월급이 5000 이상인 사원만 출력해보자.
select job, sum(sal)
from emp
where sal>=5000
group by job;

-- Q2. 직업별 월급의 합을 구하고, 월급의 합이 5000 이상인 사원만 출력해보자.

select job, sum(sal)
from emp
group by job;
having sum(sal)>=5000;

-- Q3. 부서별 월급의 합, 전체 종합 및 세부내역을 출력 해보자. with rollup
select emp.deptno, ename, sum(sal)
from emp
group by deptno, ename with rollup ;

-- Q4. 직업별 사원의 이름과 월급의 합, 전체 종합 및 세부내역을 출력 해보자. with rollup
select job, ename, sum(sal)
from emp
group by job, ename with rollup
order by 1 desc;
/*
select job, ename, sum(sal)
from emp
group by rollup( job, ename) -- 긷타 프로그램은 함수로
order by 1 desc;
*/
/*

select deptno, job, avg(sal)
from emp
group by grouping sets((deptno), (job), (deptno,job));
*/


show variables like 'collation_server';

show create database my_emp;





