-- 同时插入多条数据
INSERT INTO students (NAME,age,math,english,chinese,birthday) VALUES
("萃萃",18,100,100,100,"1996-5-20"),
;

-- 排序查询
-- 按数学分数从低到高
SELECT NAME,math FROM students ORDER BY math;

-- 按语文分数从高到低
SELECT NAME,chinese FROM students ORDER BY chinese DESC;