CREATE PROCEDURE `02_gugudan` ()
BEGIN
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
END
