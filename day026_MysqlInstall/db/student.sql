-- 创建数据库
create database if not exists db1 character set utf8;

-- 使用数据库
use db1;

-- 查看当前正使用的数据库
select database();

-- 创建学生表
create table students(
  id int primary key auto_increment,
  name varchar (32),
  age int,
  math double (4,1),
  english double (4,1),
  chinese double (4,1),
  birthday date,
  insert_time timestamp
);

-- 删除学生表
drop table students;