--��������
select * from dbo.TBL_FWLX
--������Ϣ
select * from dbo.TBL_FWXX
update dbo.TBL_FWXX  set img='06.PNG' where fwid=79 OR fwid<=78
delete dbo.TBL_FWXX where fwid=68 or fwid=69 or fwid=72
--�ֵ�
select * from dbo.TBL_JD
--����
select * from dbo.TBL_QX
--�û�
select * from dbo.TBL_USER
update dbo.TBL_USER set usessionid=null where uid=19
delete from dbo.TBL_USER where uid>=13 and uid<=18
--�޸����ص����ݻ���  ���Ȳ�ѯ�����нֵ�ƥ��Ľֵ�ID Ȼ����ݷ�����Ϣ�������еĽֵ���ID����ѯ�ֵ����е�qxid���л���