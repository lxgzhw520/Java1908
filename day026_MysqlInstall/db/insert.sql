-- 向学生表插入数据
use db1;
desc students;

-- 同时插入多条数据
insert into students (name ,age,math,english,chinese,birthday)
values
("张大鹏",22,99,33,88,"1993-8-29")
;

select *from students;


insert into students (name ,age,math,english,chinese,birthday)
values 
("刘国兵",22,69,63,78,"1993-8-29"),
("刘国梁",21,79,73,78,"1993-8-29"),
("刘国栋",21,99,73,78,"1993-8-29");