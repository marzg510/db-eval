create table t1 (
 c1 char(10) primary key
,c2 varchar(100)
);

insert into t1 values ( '001','test001');
insert into t1 values ( '002','test002');
insert into t1 values ( '003','test003');
commit;

select * from t1;

update t1 set c2 = 'test002-upd' where c1 = '002';
commit;


select * from t1;

delete from t1 where c1='003';
commit;

select * from t1;

create index t1_i1 on t1 ( c2 );

explain
select * from t1 where c2='test001';

create table t2 (
 c1 char(10) primary key
,c2 varchar(100)
);


insert into t2 values ( '001','test001-t2');
insert into t2 values ( '002','test002-t2');
insert into t2 values ( '003','test003-t2');
insert into t2 values ( '004','test004-t2');
insert into t2 values ( '005','test005-t2');
insert into t2 values ( '006','test006-t2');
insert into t2 values ( '007','test007-t2');
insert into t2 values ( '008','test007-t2');
commit;

explain
select *
from t1
 inner join t2 on (t1.c1 = t2.c1)
;

