# 查询员工  的   姓名和部门号和年薪   ，按年薪降序 按姓名升序
show tables;
desc employees;
select concat(last_name,first_name) as name,department_id,salary*12 as year_salary
from employees
order by year_salary desc ,name asc ;

#选择工资 不在 8000到17000的    员工  的  姓名和工资  ，按工资降序
select concat(last_name,first_name) as name,salary
from employees
where salary not between 8000 and 17000
order by salary desc ;


# 查询 邮箱中包含e  的 员工信息  ，并先  按邮箱的字节数  降序，再按 部门号 升序
select *
from employees
where email like '%e%'
order by length(email) desc ,department_id asc ;



#查询 员工信息  按  年薪降序
select *,salary*12 as year_salary
from employees
order by year_salary desc ;



# 查询 员工名，并且按 名字的长度 降序
select last_name
from employees
order by length(last_name) desc ;

# 查询  员工信息  ，要求  先按工资降序，再按employee_id升序
select *
from employees
order by salary desc ,employee_id asc ;

