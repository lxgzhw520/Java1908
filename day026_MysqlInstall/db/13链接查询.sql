# 女神的男朋友
show tables;
select *from beauty;
select *from boys;

select name,boyName
from beauty,boys
where beauty.boyfriend_id=boys.id;

# 查询员工名和对应的部门名
select last_name,department_name
from employees,departments
where employees.department_id=departments.department_id;

#查询员工名、工种号、工种名
select e.last_name,e.job_id,j.job_title
from jobs j,employees e
where e.job_id=j.job_id;


# 查询 有奖金 的  员工名、部门名
select e.last_name,d.department_name
from employees e,departments d
where e.commission_pct is not null and
      e.department_id=d.department_id;

# 查询城市名中第二个字符为o的  部门名和城市名
select *from departments;
select *from locations;

select l.city,d.department_name
from locations l,departments d
where l.location_id=d.location_id;


# 查询 每个城市 的部门个数
select count(*) count,l.city
from departments d,locations l
where d.location_id=l.location_id
group by l.city
order by count desc ;


# 查询有奖金的 每个部门的部门名 和部门的领导编号 和该部门的最低工资
select d.department_name,d.manager_id,round(min(e.salary)) min_salary
from departments d,employees e
where e.manager_id=d.manager_id and commission_pct is not null
group by d.department_name, d.manager_id
order by min_salary;

# 查询每个工种的工种名和员工的个数，并且按员工个数降序
select j.job_title,count(*) count
from employees e,jobs j
where j.job_id=e.job_id
group by j.job_title
order by count desc ;

# 查询员工名、部门名
select last_name,department_name
from departments d  join employees e on d.department_id = e.department_id;


# 查询名字中包含e的 员工名和工种名（添加筛选)
select last_name,job_title
from employees e join jobs j on e.job_id = j.job_id
where e.last_name like '%e%';

# 查询部门个数>3的 城市名和部门个数，（添加分组+筛选）
select count(*) count,city
from departments d join locations l on d.location_id = l.location_id
group by city
having count>3;


# 查询员工名、部门名、工种名，并按部门名降序（添加三表连接）
select last_name,department_name,job_title
from employees e join jobs j on e.job_id = j.job_id  join departments d on e.department_id = d.department_id
order by department_name desc ;

#查询员工的工资级别
select salary,grade_level
from employees e join job_grades g on e.salary between g.lowest_sal and highest_sal;

#查询每个工资级别 的个数>20的个数，并且按工资级别降序
select count(*) count,grade_level
from employees e join job_grades g on e.salary between g.lowest_sal and highest_sal
group by grade_level
having count>20
order by grade_level desc ;


#查询 员工的名字、 上级的名字
#自连接
select e.last_name,m.last_name
from employees e
join employees m on e.manager_id=m.employee_id;

#查询姓名中包含字符k的员工的名字、上级的名字
select e.last_name,m.last_name
from employees e
join employees m on e.manager_id=m.employee_id
where e.last_name like '%k%';




