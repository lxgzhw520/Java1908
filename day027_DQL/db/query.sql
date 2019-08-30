-- 同时插入多条数据
INSERT INTO students (NAME,age,math,english,chinese,birthday) VALUES
("萃萃",18,100,100,100,"1996-5-20"),
;

-- 排序查询
-- 按数学分数从低到高
SELECT NAME,math FROM students ORDER BY math;

-- 按语文分数从高到低
SELECT NAME,chinese FROM students ORDER BY chinese DESC;


/*
1. count：计算个数
    1. 一般选择非空的列：主键
    2. count(*)
2. max：计算最大值
3. min：计算最小值
4. sum：计算和
5. avg：计算平均值
*/
-- 查询学生人数
SELECT COUNT(id) 总人数 FROM students;
-- 计算各科成绩最高分
SELECT MAX(chinese) 语文最高分,MAX(math) 数学最高分,
MAX(english) 英语最高分
FROM students;
-- 计算各科成绩的平均分
SELECT AVG(math),AVG(chinese),AVG(english)
FROM students;
