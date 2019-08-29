-- 查询所有学生的成绩
use db1;
show tables;
select *from students;
select name,math,english,chinese,math+english+chinese as 总分 from students;