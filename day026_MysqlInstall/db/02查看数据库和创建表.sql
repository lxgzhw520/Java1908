#选择数据库
use mysql_tutorial;

#查看表
show tables;

#创建表
#列表 其实就是数据表 字典,就是数据表中的每一行数据
#创建Python001班的表
 create table if not exists python001(
 id int primary key auto_increment,
 name varchar (24) not null ,
 age int not null,
 gender char(1) not null ,
 class_no varchar (24) not null
 )