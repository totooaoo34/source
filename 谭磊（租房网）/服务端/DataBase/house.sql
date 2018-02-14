--房屋类型
select * from dbo.TBL_FWLX
--房屋信息
select * from dbo.TBL_FWXX
update dbo.TBL_FWXX  set img='06.PNG' where fwid=79 OR fwid<=78
delete dbo.TBL_FWXX where fwid=68 or fwid=69 or fwid=72
--街道
select * from dbo.TBL_JD
--区县
select * from dbo.TBL_QX
--用户
select * from dbo.TBL_USER
update dbo.TBL_USER set usessionid=null where uid=19
delete from dbo.TBL_USER where uid>=13 and uid<=18
--修改区县的数据回显  首先查询出所有街道匹配的街道ID 然后根据房屋信息表中已有的街道的ID来查询街道表中的qxid进行回显