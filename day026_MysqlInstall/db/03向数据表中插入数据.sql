#怎么查看数据 ctrl+c 能够快速选中一行
select *from python001;

#添加一个新的学生
#id name age gender  class_no
#张文才 24 男  Python001班
insert into python001(name,age,gender,class_no) value(
'张文才',24,'男','Python001'
)

#查询
select *from python001;

#插入多行数据
#吕新克 33 男 Python001班
#曲建振 22 男 Python001班

insert into python001(name,age,gender,class_no) values
('吕新克',33,'男','Python001'),
('曲建振',22,'男','Python001');

#查询所有数据
select *from python001;