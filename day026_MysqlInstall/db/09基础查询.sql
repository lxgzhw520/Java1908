show tables;

#1.查询表中的单个字段
# 查看一张表的结构
desc employees;
# 想要查询员工表中所有的名字 last_name
select last_name from employees;

#2.查询表中的多个字段
select last_name,salary,email from employees;


select last_name as '名字',salary as 工资,email as 邮箱 from employees;


select last_name  '名字',salary  工资,email  邮箱 from employees;


#3.查询表中的所有字段
select *from employees;

#案例：查询salary，显示结果为 out put
select salary as 'out put' from employees;


#案例：查询员工表中涉及到的所有的部门编号
# 不去重
select *from employees;
select department_id from employees;

#去重用一个关键字 distinct
select distinct department_id
from employees;

#案例：查询员工名和姓连接成一个字段，并显示为 姓名
select *from employees;

#另一个函数 concat()

select concat('Zhang','Dapeng') as name;


select concat(last_name,first_name) as name
from employees;

