use my_emp;
show databases ;
use workshop01;

-- q1) 게시판에서 사용자 ID, 등록 날짜, 게시판 제목, 내용을 조회하세요.

select * from BOARD;

select BOARD.USER_ID, BOARD.REG_DATE, BOARD.TITLE,BOARD.CONTENT
from BOARD;

-- q2) 사용자 ID, 등급, 게시판 제목, 내용을 조회하되, 삭제되지 않은 게시글만 조회하세요.


select BOARD.USER_ID, BOARD.REG_DATE, BOARD.TITLE,BOARD.CONTENT
from BOARD
where IS_DEL = 0;

-- q3) 사용자 ID, 역할, 게시판 제목, 내용을 조회하되, Socrates가 작성한 게시글만 조회하세요.

select BOARD.USER_ID, BOARD.REG_DATE, BOARD.TITLE,BOARD.CONTENT
from BOARD
where USER_ID = 'Socrates';

-- q4) 2023년 12월에 탈퇴한 회원들의 회원 아이디(User ID), 이메일(Email), 그리고 회원 등급(Grade)을 조회하세요.

select * from MEMBER;
select * from MEMBER_INFO;
select * from book;
select * from BOARD;
select * from code;
select * from RENT_BOOK;
select * from RENT_MASTER;


# select MEMBER_INFO.USER_ID, MEMBER.EMAIL, MEMBER.GRADE
# from MEMBER_INFO, MEMBER
# where LEAVE_DATE between 20231201 and 20231231
SELECT MI.USER_ID, M.EMAIL, M.GRADE
FROM MEMBER_INFO MI
         JOIN MEMBER M ON MI.USER_ID = M.USER_ID
WHERE MI.LEAVE_DATE BETWEEN '2023-12-01' AND '2023-12-31';


-- q5 회원들 중에서 '디디의 우산 :황정은 연작소설'를 대출한 이력이 있는 회원의 회원 아이디(User ID),대출 도서 수를 조회하세요.

# select USER_ID,


-- q6. 대출 도서 중에서 등록일이 2023년 6월 10일 이후인 도서의 대출 번호(Rent Master Index),대출자 이름(User ID), 대출자 가입일자, 대출건 제목(Title)을 조회하세요.