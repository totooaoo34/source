create table comic_remeng
(
  comicId         NUMBER primary key,--��������id
  comicFmImgUrl        VARCHAR2(10),--����������ַ
  comicName        VARCHAR2(20),--��������
  comicFmJiesao       VARCHAR2(50),--�����������ֽ���
  comicJqJiesao VARCHAR2(100),--�����������
  comicAuthor        VARCHAR2(10),--��������
  comicComat       VARCHAR2(10),--����ս����
  comicSource VARCHAR2(10),--������Դ
  comicUpdateTime        VARCHAR2(10),--����������ʱ��
  comicIma01Url       VARCHAR2(10),--����01
  comicIma02Url VARCHAR2(10),--����02
  comicIma03Url        VARCHAR2(10),--����03
  comicIma04Url       VARCHAR2(10),--����04
  comicIma05Url VARCHAR2(10),--����05
  comicIma06Url        VARCHAR2(10),--����06
  comicIma07Url       VARCHAR2(10),--����07
  comicIma08Url VARCHAR2(10),--����08
  comicIma09Url VARCHAR2(10),--����09
  comicIma10Url VARCHAR2(10)--����10
)

select * from comic_remeng;
select * from comic_remeng for update;
delete comic_remeng where comicId = 6

create table comic_jingcai
(
  comicId         NUMBER primary key,--��������id
  comicFmImgUrl        VARCHAR2(10),--����������ַ
  comicName        VARCHAR2(20),--��������
  comicFmJiesao       VARCHAR2(50),--�����������ֽ���
  comicJqJiesao VARCHAR2(100),--�����������
  comicAuthor        VARCHAR2(10),--��������
  comicComat       VARCHAR2(10),--����ս����
  comicSource VARCHAR2(10),--������Դ
  comicUpdateTime        VARCHAR2(10),--����������ʱ��
  comicIma01Url       VARCHAR2(10),--����01
  comicIma02Url VARCHAR2(10),--����02
  comicIma03Url        VARCHAR2(10),--����03
  comicIma04Url       VARCHAR2(10),--����04
  comicIma05Url VARCHAR2(10),--����05
  comicIma06Url        VARCHAR2(10),--����06
  comicIma07Url       VARCHAR2(10),--����07
  comicIma08Url VARCHAR2(10),--����08
  comicIma09Url VARCHAR2(10),--����09
  comicIma10Url VARCHAR2(10)--����10
)
select comicuserb0_.userId as userId2_, comicuserb0_.userName as userName2_, comicuserb0_.userPassword as userPass3_2_ from comic_user comicuserb0_ where comicuserb0_.userName='y' and comicuserb0_.userPassword='y'
create table comic_type
(
  typesId         NUMBER primary key,--��������id
  typeFmImgUrl        VARCHAR2(30),--�������ͷ����ַ
  typeName        VARCHAR2(30),--������������
  foreignId       NUMBER not null--�����������id
)

create table comic_user
(
  userId         NUMBER primary key,--�û�id
  userName        VARCHAR2(20),--�û�����
  userPassword        VARCHAR2(10)--�û�����
)

select * from comic_user;

select * from comic_user where userName='q' and userPassword='q'



select * from comic_type; 
select * from comic_type for update;

insert into comic_jingcai values(comic_sequences.nextval,'yaohu.png','����x��SS','������˫��',
'�ڹ��µ��У��ǳ���ɫ�ȷ����࣬Ҳ�Ǵ�Ѫ���֡�','��ԭ�ɿ���','7784','������','2014-07-19',
'yaoh01.jpg','yaoh02.jpg','yaoh03.jpg','yaoh04.jpg','yaoh05.jpg','yaoh06.jpg',
'yaoh07.jpg','yaoh08.jpg','yaoh09.jpg','yaoh10.jpg');

select * from comic_jingcai;

create sequence comic_sequences
increment by 1    -- ÿ�ε���1
start with 1       -- ��1��ʼ
nomaxvalue      -- û�����ֵ
minvalue 1      -- ��Сֵ=1


insert into comic_remeng values(comic_sequences.nextval,'shenfm.jpg','���ڵ�������','�������',
'��������һ��������,������������������','�뽭����','5574','������','2014-07-24',
'shen01.jpg','shen02.jpg','shen03.jpg','shen04.jpg','shen05.jpg','shen06.jpg',
'shen07.jpg','shen08.jpg','shen09.jpg','shen10.jpg');

 
