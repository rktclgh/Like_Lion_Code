create definer = 'mydb'@'%' procedure '01_getemp_res'()
begin
WITH RECURSIVE getemp_res AS (
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

end;
