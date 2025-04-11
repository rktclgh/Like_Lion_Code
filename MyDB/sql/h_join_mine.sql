/*
1. INNER JOIN (교집합):
두 테이블에서 일치하는 값만 출력되며, NULL과 False는 모두 제외된다.
ON 또는 USING을 사용하여 조인 조건을 명시한다.

2. LEFT OUTER JOIN (왼쪽 기준 차집합):
왼쪽 테이블의 모든 데이터는 출력하고, 오른쪽 테이블에서 일치하는 값만 출력된다.
일치하지 않는 오른쪽 데이터는 NULL로 채워진다.

3. RIGHT OUTER JOIN (오른쪽 기준 차집합):
오른쪽 테이블의 모든 데이터는 출력하고, 왼쪽 테이블에서 일치하는 값만 출력된다.
일치하지 않는 왼쪽 데이터는 NULL로 채워진다.

4. FULL OUTER JOIN (합집합):
왼쪽과 오른쪽 테이블의 모든 데이터를 출력하고,
일치하지 않는 부분은 NULL로 채워진다.
MySQL에서는 LEFT JOIN과 RIGHT JOIN을 UNION으로 합쳐 구현한다.

5. CROSS JOIN (데카르트 곱):
두 테이블의 모든 데이터를 서로 곱해서 조합한 결과를 출력한다.
결과 행 수가 첫 번째 테이블 행 수 × 두 번째 테이블 행 수가 된다.

6. SELF JOIN (자기자신 조인):
한 테이블을 자기 자신과 조인하여 상위-하위 관계나 계층 구조를 표현할 때 사용한다.

7. NATURAL JOIN:
두 테이블에서 컬럼명이 같은 컬럼들을 자동으로 조인하며,
명시적으로 ON이나 USING 없이 동작하지만 명확성이 떨어져 실무에서는 잘 사용하지 않는다.

8. EQUI JOIN (동등 조인):
=(동등 연산자)를 사용하여 조건을 지정하고,
테이블 간 일치하는 값만 추출하는 방식으로, 사실상 INNER JOIN과 동일하게 동작한다.



- inner join, outer join,cross join,[full outer join,Equi join,self join] 
조인 : 테이블의 컬럼 값에 공통값  (value)를 추출하는 것  
using (같은컬럼명) ,  on (다른 컬럼명)  


1) 내부 조인(inner join) : 같은값만 추출 / false, null  추출 되지 않는다. 
두 테이블 모두에 일치하는 항목이 있으면 행을 반환
조인된 테이블의 행이 일치하지 않으면 행이 반환되지 않는다.

SELECT columns
FROM table1
INNER JOIN table2
ON table1.common_column = table2.common_column;

2)외부 조인(OUTER JOIN): 주종 관계를 만들어서 주 테이블은 전체출력, 종테이블은 True값만 출력된다.
OUTER JOIN에는 LEFT, RIGHT, FULL의 세 가지 유형
한 테이블의 모든 행과 다른 테이블의 일치하는 행을 반환하는 데 사용. 
일치하는 항목이 없으면 NULL 값을 사용하여 일치 항목이 없는 테이블의 열을 채운다

2-1) LEFT OUTER JOIN 구문
SELECT columns
FROM table1
LEFT OUTER JOIN table2
ON table1.common_column = table2.common_column;
- 왼쪽 테이블의 모든 레코드를 반환하고, 오른쪽 테이블의 일치하는 레코드를 반환한다.  
- 일치하는 항목이 없으면 오른쪽 부터 NULL이 된다.  
EX) 주테이블의 모든 항목에 따라 종테이블의  원하는 레코드를 추출할 때 사용 

2-2) RIGHT OUTER JOIN은 비슷하지만 두 번째 테이블의 모든 행과 첫 번째 테이블의 일치하는 행을 반환
- 일치하는 항목이 없으면 왼쪽 부터 NULL이 된다.  
SELECT columns
FROM table1
RIGHT  OUTER JOIN table2
ON table1.common_column = table2.common_column;

2-3 FULL OUTER JOIN은 LEFT 및 RIGHT 외부 조인의 결과를 결합한다.  = UNION을 사용한다.  
--------------------------------------------------------------
- USING 
SELECT columns
FROM table1
JOIN table2
USING (common_column);

- 열 이름이 다른 ON 절
SELECT columns
FROM table1
JOIN table2
ON table1.column_name = table2.other_column_name;

3)CROSS JOIN은 두 테이블의 데카르트 곱을 반환. 
즉, 첫 번째 테이블의 모든 행을 두 번째 테이블의 모든 행과 조인한다 
일반적으로 생성할 수 있는 행 수가 많기 때문에 덜 자주 사용된다.
SELECT columns
FROM table1
CROSS JOIN table2;
*/

use my_emp;


-- Q1. 사원의 이름과 사원이 속한 부서이름을 출력하자. inner join 같은 값만 추출
-- SQL
select ename, dept.dname
from emp, dept
where emp.deptno = dept.deptno;


-- ANSI
explain
select ename, dept.dname
from emp
inner join dept using(deptno);


-- Q2 간단한 테이블을 생성해서 확인하자

create table x(x1 varchar(5), x2 varchar(5));

create table y(y1 varchar(5), y2 varchar(5));

insert into x values ('a', 'd');

insert into y values ('a','1');
insert into y values ('b','2');
insert into y values ('c','3');
insert into y values (NULL,'1');


select * from y;
select * from x;
desc y;
desc x;

-- Q3. x, y 테이블에서 x1, y1 컬럼을 조인해보자 = true 행 리턴

-- ANSI
select *
from x join y on x1 = y1; -- 두 테이블의 속성명이 다른 값은 값을 추출할때 on
-- sql
explain  -- type all 이 나온다면 인덱스를 설정한다. -> where 조건문, on, using 컬럼에서 인덱스 확인!!
select *
from x,y
where x1=y1;


-- Q4 주종관계를 만들어서 조인을 해보자 outer join에서는 left, right, full의 세가지 유형
-- 주테이블의 전체 출력, 종테이블은 true 리턴하고, false는 null 리턴

-- Q4-1 y를 주테이블로 만들고 x를 종테이블로 지정하자. right outer join
-- ansi
select *
from x right outer join y
on x1=y1;

-- sql

-- Q4-2 y를 주테이블로 만들고 x를 종테이블로 지정하자. right outer join
-- ansi
select *
from y left outer join x
                        on x1=y1;

/*
      FULL OUTER JOIN =  RIGHT OUTER JOIN  + LEFT OUTER JOIN     / UNION(중복항목x ), UNION ALL(중복항목 O)
 1) UNION 앞의 쿼리에서  Y의 모든 레코드를 검색하고 X테이블에 일치하는 레코드를 검색한다.
 2) UNION 뒤의 쿼리에서  Y의 모든 레코드를 검색하고 X테이블에 일치하는 레코드를 검색한다.
 3) UNION은 두개의 결과 레코드를 결합해서 리턴한다.
 4) UNION 쿼리는 두개 쿼리 결과 부분에서 열의 개수와 유형일치를 확인한다.
 5) 중복행 제거 후 결합한다.
 */


-- Q4-3 FULL OUTER JOIN 을 해보자 RIGHT OUTER JOIN + LEFT OUTER JOIN
-- ANSI
explain
select  *
from x right outer join y on x1 = y1
union

select  *
from y left outer join x on x1= y1;


-- Q4-4 확인 해보자

