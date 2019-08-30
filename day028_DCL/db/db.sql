-- 创建部门表
CREATE TABLE dept(
	-- 部门编号
	id INT PRIMARY KEY AUTO_INCREMENT,
	-- 部门名字
	NAME VARCHAR(20)
);


-- 创建员工表
CREATE TABLE emp(
	-- id
	id INT PRIMARY KEY AUTO_INCREMENT,
	-- 姓名
	NAME VARCHAR(20),
	-- 性别
	gender CHAR(1),
	-- 工资
	salary DOUBLE,
	-- 入职日期
	join_date DATE,
	-- 部门编号
	dept_id INT,
	-- 外键,关联部门表dept.id
	FOREIGN KEY(dept_id) REFERENCES dept(id)
);

-- 插入部门数据
INSERT INTO dept(NAME) VALUES
("公关部"),
("财务部"),
("人事部");

-- 插入员工数据
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('孙悟空','男',7200,'2013-02-24',1);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('猪八戒','男',3600,'2010-12-02',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('唐僧','男',9000,'2008-08-08',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('白骨精','女',5000,'2015-10-07',3);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('蜘蛛精','女',4500,'2011-03-14',1);

-- 查询是否插入成功
SELECT *FROM dept;
SELECT *FROM emp;


-- 查询所有员工信息和对应的部门信息
SELECT
t1.*,t2.`name`
FROM 
emp t1,dept t2
WHERE
t1.`dept_id`=t2.`id`;


-- 查询员工的姓名，性别,部门
SELECT
t1.`name`,t1.`gender`
FROM
emp t1,dept t2
WHERE
t1.`dept_id`=t2.`id`;

-- 显式内连接查询
-- 1.查询所有员工信息和对应的部门信息
SELECT
* FROM emp
JOIN
dept
ON
emp.`dept_id`=dept.`id`;


-- 左外连接查询
-- 查询所有员工信息，如果员工有部门，则查询部门名称，
-- 没有部门，则不显示部门名称
SELECT
* FROM emp
LEFT JOIN
dept
ON
emp.`dept_id`=dept.`id`;


-- 子查询
-- 查询工资最高的员工信息
SELECT
*
FROM
emp
WHERE
salary=(SELECT	MAX(salary) FROM emp);



-- 创建部门表
CREATE TABLE practice01_dept(
  -- id
  id INT PRIMARY KEY AUTO_INCREMENT,
  -- 部门名称
  NAME VARCHAR(50),
  -- 部门所在地
  address VARCHAR(50)
);

-- 添加四个部门
INSERT INTO practice01_dept(id,NAME,address) 
VALUES
(10,'教研部','北京'),
(20,'学工部','上海'),
(30,'销售部','广州'),
(40,'财务部','深圳');

-- 查看是否添加成功
SELECT
*
FROM
practice01_dept;


-- 创建职务表并添加四个职务
CREATE TABLE practice01_job(
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(20),-- 职务名称
  description VARCHAR(50)-- 职务描述
);

-- 添加职务
INSERT INTO practice01_job(id,NAME,description)
VALUES
(1, '董事长', '管理整个公司，接单'),
(2, '经理', '管理部门员工'),
(3, '销售员', '向客人推销产品'),
(4, '文员', '使用办公软件');


-- 员工表
CREATE TABLE practice01_emp(
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50), -- 姓名
  job_id INT,-- 职务id
  mgr INT,-- 上级领导id
  join_date DATE,-- 入职日期
  salary DECIMAL(7,2),  -- 工资
  bonus DECIMAL(7,2), -- 奖金
  dept_id INT,-- 所在部门编号
  CONSTRAINT emp_job_fk FOREIGN KEY (job_id) REFERENCES practice01_job(id),
  CONSTRAINT emp_dept_fk FOREIGN KEY (dept_id) REFERENCES practice01_dept(id)
);

-- 添加员工
INSERT INTO practice01_emp
(id,NAME,job_id,mgr,join_date,salary,bonus,dept_id)
VALUES
(1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),
(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),
(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),
(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),
(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),
(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),
(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),
(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),
(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),
(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),
(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),
(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),
(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),
(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);

-- 查询是否添加成功
SELECT * FROM practice01_emp;

-- 工资等级表
CREATE TABLE practice01_salary_grade(
 id INT PRIMARY KEY AUTO_INCREMENT,
 -- 最低工资
 low INT,
 -- 最高工资
 high INT
);

-- 添加五个工资等级
INSERT INTO practice01_salary_grade
(id,low,high)
VALUES
(1,7000,12000),
(2,12010,14000),
(3,14010,20000),
(4,20010,30000),
(5,30010,99990);

-- 查看是否添加成功
SELECT * FROM practice01_salary_grade;


-- 查询员工编号，员工姓名，工资，职务名称，职务描述
/*
分析:
  1.员工编号,姓名,工资 在practice01_emp表
  2.职务名称和职务描述 在practice01_job表
  3.where条件 emp.job_id=job.id
*/
SELECT
t1.`id`,t1.`name`,t1.`salary`,
t2.`name`,t2.`description`
FROM
practice01_emp t1,practice01_job t2
WHERE
t1.`job_id`=t2.`id`;


-- 2.查询员工编号，员工姓名，工资，职务名称，
-- 职务描述，部门名称，部门位置
/*
分析:
  1.员工编号,姓名,工资 在emp
  2.职务名称,描述 在job
  3.部门名称,位置 在dept
  4.条件是 emp.job_id=job.id and emp.dept_id=dept.id
*/
SELECT
t1.`id`,t1.`name`,t1.`salary`,
t2.`name`,t2.`description`,
t3.`name`,t3.`address`
FROM
practice01_emp t1,
practice01_job t2,
practice01_dept t3
WHERE
t1.`job_id`=t2.`id`
AND
t1.`dept_id`=t3.`id`;

-- 3.查询员工姓名，工资，工资等级
/*
分析:
  1.姓名 工资  emp
  2.工资等级 grade
  3.where条件  between
*/
SELECT
t1.`name` 员工姓名,
t1.`salary` 员工工资,
t2.`id` 工资等级
FROM
practice01_emp t1,
practice01_salary_grade t2
WHERE
t1.`salary` BETWEEN t2.`low` AND t2.`high`;


-- 4.查询员工姓名，工资，职务名称，职务描述，
-- 部门名称，部门位置，工资等级
/*
分析:
  1.员工姓名,工资 emp
  2.职务名称,描述 job
  3.部门名称,位置 dept
  4.工资等级 grade
  5.条件 = and  between
*/
SELECT
t1.`name` 姓名,
t1.`salary` 工资,
t2.`name` 职位,
t2.`description` 工作内容,
t3.`name` 部门,
t3.`address` 工作地点,
t4.`id` 工资等级
FROM
practice01_emp t1,
practice01_job t2,
practice01_dept t3,
practice01_salary_grade t4
WHERE
t1.`job_id`=t2.`id`
AND
t1.`dept_id`=t3.`id`
AND
(t1.`salary` BETWEEN t4.`low` AND t4.`high`);


-- 5.查询出部门编号、部门名称、部门位置、部门人数
/*
分析:
  1.部门编号,名称,位置 dept
  2.部门人数 count(id)
  3.条件
      1.emp.dept_id=dept.id
      2.group by(dept_id)
*/
SELECT
t2.`id` 部门编号,
t2.`name` 部门名称,
t2.`address` 部门位置,
COUNT(t1.`id`) 部门人数
FROM
practice01_emp t1,
practice01_dept t2
WHERE
t1.`dept_id`=t2.`id`
GROUP BY
t1.`dept_id`;
-- 检查
SELECT * FROM practice01_dept;
-- 发现没有财务部的人
-- 再次检查
SELECT * FROM practice01_emp;
SELECT * FROM practice01_emp t1
WHERE
t1.`dept_id`=(SELECT id FROM practice01_dept
WHERE NAME LIKE "财务部"
);
-- 发现的确没有



