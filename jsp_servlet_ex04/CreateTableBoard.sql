-- private Long seq;
-- private String title;
-- private String content;
-- private Date writeDate = new Date();
-- private String writer;
-- private Long cnt;

create table IF NOT EXISTS BOARD (
SEQ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
TITLE VARCHAR2(50) NOT NULL,
CONTENT VARCHAR2(256),
WRITEDATE DATE,
WRITER VARCHAR2(20),
CNT BIGINT
);

INSERT INTO BOARD(TITLE, CONTENT, WRITEDATE, WRITER, CNT)
VALUES('글쓰기 연습','게시판 글쓰기 연습입니다...',NOW(),'관리자',0);

SELECT * FROM BOARD;

COMMIT;