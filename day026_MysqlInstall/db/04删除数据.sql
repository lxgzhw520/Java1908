#删除数据
insert into python001 (name ,age,gender,class_no) value(
'要删除的数据',333,'男','啊啊啊'
);

#查看表的数据
select *from python001;

#删除语句  根据id删除
delete from python001 where id=9;