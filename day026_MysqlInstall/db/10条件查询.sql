show tables;

#案例1：查询工资>10000的员工信息
#where

#关键字 不加括号
#函数  加括号()
select concat(last_name,first_name) as name,salary
from employees
where salary>20000;

#案例2：查询部门编号不等于90号的员工名和部门编号
select concat(last_name,first_name) as name , department_id
from employees
where department_id !=90;


#查询工资在10000到20000之间的员工名、工资以及奖金
desc employees;
select concat(last_name,first_name) as name,salary,commission_pct
from employees
where salary>=10000 and salary<=20000;

#查询部门编号不是在90到110之间，或者工资高于15000的员工信息
select *
from employees
where (department_id>=90 and department_id<=110)
   or salary>1500;

#查询员工名中包含字符a的员工信息
select *
from employees
where last_name like '%a%';

#查询员工名中第三个字符为n，第五个字符为l的 员工名和工资
select last_name,salary
from employees
where last_name like '__n_l%';

# 查询员工名中第二个字符为_的员工名
select *
from employees
where last_name like '_\_%';

# 查询 员工编号在100到120 之间的   员工信息
select *
from employees
where employee_id between 100 and 120;

select *
from  employees
where employee_id>=100 and employee_id<=120;


# 查询员工的 工种编号是 IT_PROG、AD_VP、AD_PRES中的一个  员工名和工种编号
desc employees;
select last_name,job_id
from employees
where job_id in ('IT_PROG','AD_VP','AD_PRES');


# 查询有奖金的  员工名和奖金率
select *
from employees;

select last_name,commission_pct
from employees
where commission_pct is not null;

# 查询  工资为12000  的    员工信息
select *
from employees
where salary=12000;

