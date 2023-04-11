drop table if exists questions;
drop table if exists answer_base;
drop table if exists messaging;

create table questions
(
    id       integer primary key generated always as identity,
    question varchar not null,
    option_1 varchar not null,
    option_2 varchar not null,
    option_3 varchar not null
);

create table answer_base
(
    id           integer primary key generated always as identity,
    score        integer   not null,
    sender       varchar   not null,
    age          integer   not null,
    created_date timestamp not null
);

create table messaging
(
    id           integer primary key generated always as identity,
    name         varchar   not null,
    phone_number varchar,
    email        varchar,
    message      varchar,
    sent_date    timestamp not null
);