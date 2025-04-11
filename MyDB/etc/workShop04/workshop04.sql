use workshop01;
select * from book;
select * from CODE;
select * from MEMBER;
select * from MEMBER_INFO;
select * from RENT_BOOK;
select * from RENT_MASTER;
desc book;
desc RENT_MASTER;
-- 1. 2023년 6월 18일에 대출된 도서의 제목을 조회합니다.
select BOOK.TITLE
from book
where book.TITLE in
      (select RENT_MASTER.TITLE
       from RENT_MASTER
       where RENT_MASTER.REG_DATE = '2023-06-18'
       );
-- 2. 2023년 6월 30일에 반납된 도서의 작가를 조회합니다.

select BOOK.AUTHOR
from BOOK
where book.BK_IDX in
(
    select BK_IDX
    from RENT_BOOK
    where return_date ='2023-06-30'
    )

-- 3.2023년 6월 28일에 대출되고 RENT_CNT가 1보다 큰 도서의 제목을 조회합니다.

select BOOK.TITLE
from book
where RENT_CNT>1
    and book.bk_idx in
(
    select BK_IDX
    from RENT_BOOK
    where REG_DATE = '2023-06-28'
    );


-- 4 연체상태(RE01)인 대출도서의 카테고리를 조회합니다.
select BOOK.CATEGORY
from book
where BK_IDX in
(
    select BK_IDX
    from RENT_BOOK
    where STATE = 're01'
    );

-- 05 대출일과 반납일이 동일한 도서의 제목을 조회합니다.
select BOOK.TITLE
from BOOK
where BK_IDX in(
    select RENT_BOOK.BK_IDX
    from RENT_BOOK
    where BOOK.REG_DATE = RETURN_DATE
    );


-- 06 2023년 6월 7일에 대출되고 6월 11일에 반납된 도서의 작가를 조회합니다.
select BOOK.AUTHOR
from BOOK
where BK_IDX in(
    select BK_IDX
    from RENT_BOOK
    where RENT_BOOK.REG_DATE = '2023-06-07' and RETURN_DATE = '2023-06-11'
    );

-- 07 2023년 6월 15일에 대출된 도서의 제목을 조회합니다.
select BOOK.TITLE
from BOOK
where BK_IDX in (
    select BK_IDX
    from RENT_BOOK
    where RENT_BOOK.REG_DATE = '2023-06-15'
    )


-- 08 2023년 6월 30일에 대출된 도서들 중 누적 대출 횟수가 가장 적은 책 제목을를 조회합니다.

select BOOK.TITLE
from book
where TITLE in (
    select TITLE
    from RENT_MASTER
    where rank() over (rent_boo)
    )
# ??


-- 9 2023년 6월에 대출되고 누적 대출 횟수가 평균보다 작은 도서의 제목과 대출 횟수를 조회합니다.

select * from RENT_MASTER;
select * from RENT_BOOK;
select * from book;
select title, RENT_MASTER.RENT_BOOK_CNT
from RENT_MASTER
where reg_date>='2023-06-01' and reg_date<'2023-07-01'
and RENT_BOOK_CNT <(
    select avg(RENT_BOOK_CNT)
    from RENT_MASTER
           where  reg_date>='2023-06-01' and reg_date<'2023-07-01'
    )


-- 10) 연체 상태인 대출도서의 식별자와 상태를 조회합니다..
select distinct RENT_BOOK.BK_IDX, state as 상태
from RENT_BOOK
where state  = 're02';


-- 11. 사용자가 작성한 게시글 중에서 가장 긴 글의 제목과 글자 수를 조회합니다.
select * from BOARD;
select title, length(CONTENT) as content_length
from BOARD
order by length(CONTENT) desc
limit 1;

-- 12. 게시글을 가장 많이 작성한 사용자의 이름과 작성된 게시글 수를 조회합니다.
select * from BOARD

select user_id, count(user_id)
from board
group by user_id
order by count(USER_ID) desc
limit 1;


-- 13. 가장 최근에 작성된 게시글의 제목과 작성일을 조회합니다.

select title, BOARD.REG_DATE
from BOARD
order by REG_DATE desc
limit 2;

-- 14 가장 오래된 사용자의 이름과 등록일을 조회합니다.

select * from MEMBER

select MEMBER_INFO.USER_ID, MEMBER_INFO.REG_DATE
from MEMBER_INFO
order by REG_DATE asc
limit 1;

-- 15. 평균 게시글 길이가 가장 긴 사용자의 이름과 평균 게시글 길이 조회합니다.

select BOARD.USER_ID, avg(length(BOARD.CONTENT)) as avg
from BOARD
group by USER_ID
order by avg desc
limit 1;


-- 16 게시글을 가장 많이 작성한 사용자의 이름과 게시글 수 조회합니다.
select BOARD.USER_ID, count(BOARD.CONTENT) as count
from BOARD
group by USER_ID
order by count desc
limit 1;


-- 17. 각 사용자별로 작성한 게시글 수와 함께 모든 사용자 아이디를 게시글 수를 내림차순으로 정렬하여 조회합니다.

