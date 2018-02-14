create table comic_remeng
(
  comicId         NUMBER primary key,--封面漫画id
  comicFmImgUrl        VARCHAR2(10),--封面漫画地址
  comicName        VARCHAR2(20),--漫画名称
  comicFmJiesao       VARCHAR2(50),--漫画封面文字介绍
  comicJqJiesao VARCHAR2(100),--漫画剧情介绍
  comicAuthor        VARCHAR2(10),--漫画作者
  comicComat       VARCHAR2(10),--漫画战斗力
  comicSource VARCHAR2(10),--漫画来源
  comicUpdateTime        VARCHAR2(10),--漫画最后更新时间
  comicIma01Url       VARCHAR2(10),--漫画01
  comicIma02Url VARCHAR2(10),--漫画02
  comicIma03Url        VARCHAR2(10),--漫画03
  comicIma04Url       VARCHAR2(10),--漫画04
  comicIma05Url VARCHAR2(10),--漫画05
  comicIma06Url        VARCHAR2(10),--漫画06
  comicIma07Url       VARCHAR2(10),--漫画07
  comicIma08Url VARCHAR2(10),--漫画08
  comicIma09Url VARCHAR2(10),--漫画09
  comicIma10Url VARCHAR2(10)--漫画10
)

select * from comic_remeng;
select * from comic_remeng for update;
delete comic_remeng where comicId = 6

create table comic_jingcai
(
  comicId         NUMBER primary key,--封面漫画id
  comicFmImgUrl        VARCHAR2(10),--封面漫画地址
  comicName        VARCHAR2(20),--漫画名称
  comicFmJiesao       VARCHAR2(50),--漫画封面文字介绍
  comicJqJiesao VARCHAR2(100),--漫画剧情介绍
  comicAuthor        VARCHAR2(10),--漫画作者
  comicComat       VARCHAR2(10),--漫画战斗力
  comicSource VARCHAR2(10),--漫画来源
  comicUpdateTime        VARCHAR2(10),--漫画最后更新时间
  comicIma01Url       VARCHAR2(10),--漫画01
  comicIma02Url VARCHAR2(10),--漫画02
  comicIma03Url        VARCHAR2(10),--漫画03
  comicIma04Url       VARCHAR2(10),--漫画04
  comicIma05Url VARCHAR2(10),--漫画05
  comicIma06Url        VARCHAR2(10),--漫画06
  comicIma07Url       VARCHAR2(10),--漫画07
  comicIma08Url VARCHAR2(10),--漫画08
  comicIma09Url VARCHAR2(10),--漫画09
  comicIma10Url VARCHAR2(10)--漫画10
)
select comicuserb0_.userId as userId2_, comicuserb0_.userName as userName2_, comicuserb0_.userPassword as userPass3_2_ from comic_user comicuserb0_ where comicuserb0_.userName='y' and comicuserb0_.userPassword='y'
create table comic_type
(
  typesId         NUMBER primary key,--漫画类型id
  typeFmImgUrl        VARCHAR2(30),--漫画类型封面地址
  typeName        VARCHAR2(30),--漫画类型名称
  foreignId       NUMBER not null--漫画类型外键id
)

create table comic_user
(
  userId         NUMBER primary key,--用户id
  userName        VARCHAR2(20),--用户名称
  userPassword        VARCHAR2(10)--用户密码
)

select * from comic_user;

select * from comic_user where userName='q' and userPassword='q'



select * from comic_type; 
select * from comic_type for update;

insert into comic_jingcai values(comic_sequences.nextval,'yaohu.png','妖狐x仆SS','御狐神双炽',
'在故事当中，登场角色既非人类，也非纯血妖怪。','藤原可可亚','7784','互联网','2014-07-19',
'yaoh01.jpg','yaoh02.jpg','yaoh03.jpg','yaoh04.jpg','yaoh05.jpg','yaoh06.jpg',
'yaoh07.jpg','yaoh08.jpg','yaoh09.jpg','yaoh10.jpg');

select * from comic_jingcai;

create sequence comic_sequences
increment by 1    -- 每次递增1
start with 1       -- 从1开始
nomaxvalue      -- 没有最大值
minvalue 1      -- 最小值=1


insert into comic_remeng values(comic_sequences.nextval,'shenfm.jpg','神不在的星期天','神的世界',
'神在星期一创造世界,又在星期日舍弃世界','入江君人','5574','互联网','2014-07-24',
'shen01.jpg','shen02.jpg','shen03.jpg','shen04.jpg','shen05.jpg','shen06.jpg',
'shen07.jpg','shen08.jpg','shen09.jpg','shen10.jpg');

 
