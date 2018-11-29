create table users(
   id varchar2(50 char) primary key,
   username varchar2(50 char),
   password varchar2(50 char)
);


insert into users values('0001','admin','123456');

commit;
