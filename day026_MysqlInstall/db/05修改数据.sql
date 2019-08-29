#插入一行数据
insert into python001(name,age,gender,class_no) value(
'要更新的数据',333,'女','Python001'
);

#查询
select *from python001;

#修改名字
update python001 set name='女神' where id=10;