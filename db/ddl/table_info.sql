create table caat.board
(
    id   varchar(20) not null comment '게시판_유형'
        primary key,
    name varchar(50) null comment '게시판_유형명'
)
    comment '게시판';

create table caat.board_article
(
    id         bigint auto_increment comment '게시글_일련번호'
        primary key,
    board_id   varchar(20)   not null comment '게시판_유형_FK',
    user_id    bigint        not null comment '회원_PK',
    title      varchar(255)  null comment '제목',
    contents   text          not null comment '내용',
    created_at datetime      null comment '생성일',
    created_id bigint        not null comment '생성자',
    updated_at datetime      null comment '수정일',
    updated_id bigint        null comment '수정자',
    view_count int default 0 not null comment '조회수'
)
    comment '게시글';



create table caat.board_comment
(
    id               bigint auto_increment comment '게시판_댓글_PK'
        primary key,
    board_article_id bigint not null comment '게시글_PK',
    user_id          bigint not null comment '작성자_PK',
    contents         text   null comment '내용'
)
    comment '게시판_댓글';

