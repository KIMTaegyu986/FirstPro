show tables;
----유저 테이블 생성
create table user (
u_id varchar(30) primary key,
u_pass varchar(30) not null,
u_name varchar(10) not null,
u_gender varchar(5) check (u_gender in ('남', '여') ),
u_birth date,
u_pno varchar(30) not null,
constraint uni_pno unique(u_pno)
);

insert into user values('root', '1234', '김태규', '남', '1111-11-11', '010-1234-1234');

delete from user where u_id = 'qwe';

select * from user;
----팀 테이블 생성
drop table team;

create table team(
t_code varchar(30),
t_name varchar(50),
t_coach varchar(50),
t_loc varchar(50),
t_year varchar(10),
primary key(t_code)
);
insert into team values('K1','한화','수베로','대전','1986-03-08');
insert into team values('K2','두산','김태형','서울','1982-01-15');




select * from team;

----선수 테이블 생성
drop table player;

create table player(
p_code int not null auto_increment primary key,
p_no int (30),
t_code varchar(30),
p_backno int(10),
p_name varchar(50),
p_birth varchar(10),
p_length int(10),
p_weight int(10),
p_pos varchar(20)
);

insert into player values (default,'1','K1','1','문동주','2003/12/23','188','92','투수');
insert into player values (default,'2','K1','5','윤대경','1994/04/09','179','75','투수');
insert into player values (default,'3','K1','11','남지민','2001/02/12','181','95','투수');
insert into player values (default,'4','K1','15','김기중','2002/11/16','187','90','투수');
insert into player values (default,'5','K1','13','최재훈','1989/08/27','178','80','포수');
insert into player values (default,'6','K1','26','허관회','1999/02/12','176','83','포수');
insert into player values (default,'7','K1','2','김민기','1999/06/12','175','75','내야수');
insert into player values (default,'8','K1','4','송호정','2002/03/10','186','80','내야수');
insert into player values (default,'9','K1','6','김현민','2000/02/23','183','82','내야수');
insert into player values (default,'10','K1','7','이도윤','1996/10/07','173','71','내야수');
insert into player values (default,'11','K1','8','노시환','2000/12/03','185','96','내야수');
insert into player values (default,'12','K1','10','박정현','2001/07/27','183','85','내야수');
insert into player values (default,'13','K1','16','이성곤','1992/03/25','186','93','내야수');
insert into player values (default,'14','K1','37','하주석','1994/02/25','184','81','내야수');
insert into player values (default,'15','K1','12','터크먼','1990/12/03','188','95','외야수');
insert into player values (default,'16','K1','14','강상원','1997/05/05','175','64','외야수');
insert into player values (default,'17','K1','17','노수광','1990/08/06','180','80','외야수');
insert into player values (default,'18','K1','24','임종찬','2001/09/28','184','85','외야수');
insert into player values (default,'19','K1','25','김태연','1997/06/10','178','100','외야수');
insert into player values (default,'20','K1','30','장운호','1994/02/20','183','85','외야수');

insert into player values (default,'1','K2','1','문동주','2003/12/23','188','92','투수');
insert into player values (default,'2','K2','5','윤대경','1994/04/09','179','75','투수');
insert into player values (default,'3','K2','11','남지민','2001/02/12','181','95','투수');
insert into player values (default,'4','K2','15','김기중','2002/11/16','187','90','투수');
insert into player values (default,'5','K2','13','최재훈','1989/08/27','178','80','포수');
insert into player values (default,'6','K2','26','허관회','1999/02/12','176','83','포수');
insert into player values (default,'7','K2','2','김민기','1999/06/12','175','75','내야수');
insert into player values (default,'8','K2','4','송호정','2002/03/10','186','80','내야수');
insert into player values (default,'9','K2','6','김현민','2000/02/23','183','82','내야수');
insert into player values (default,'10','K2','7','이도윤','1996/10/07','173','71','내야수');
insert into player values (default,'11','K2','8','노시환','2000/12/03','185','96','내야수');
insert into player values (default,'12','K2','10','박정현','2001/07/27','183','85','내야수');
insert into player values (default,'13','K2','16','이성곤','1992/03/25','186','93','내야수');
insert into player values (default,'14','K2','37','하주석','1994/02/25','184','81','내야수');
insert into player values (default,'15','K2','12','터크먼','1990/12/03','188','95','외야수');
insert into player values (default,'16','K2','14','강상원','1997/05/05','175','64','외야수');
insert into player values (default,'17','K2','17','노수광','1990/08/06','180','80','외야수');
insert into player values (default,'18','K2','24','임종찬','2001/09/28','184','85','외야수');
insert into player values (default,'19','K2','25','김태연','1997/06/10','178','100','외야수');
insert into player values (default,'20','K2','30','장운호','1994/02/20','183','85','외야수');

select * from player;

delete from player;
delete from player where p_no = 21;

select * from player order by p_no desc limit 5;
select * from player limit 20;

select p_no from player order by p_no desc limit 1;

select * from player where p_name = '김기중';

select * from player where t_code = 'K1';

select *
from player p,team t
where p.t_code = t.t_code
and t.t_code = 'K1';

select * from player where p_code = 40;

update player set p_backno='30', p_name='장운호', p_birth='1994/02/20', p_length='199', p_weight='85', p_pos='외야수' where p_no = '" + p_no +"' "

