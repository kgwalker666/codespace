create database if not exists `cloud_user` default charset utf8mb4 collate utf8mb4_general_ci;

use `cloud_user`;

drop table if exists `tb_user`;

create table `tb_user`  (
  `id` bigint(20) auto_increment primary key comment '用户id',
  `username` varchar(100) comment '收件人',
  `address` varchar(255) comment '地址'
) engine = innodb;

insert into `tb_user` values (1, '柳岩', '湖南省衡阳市');
insert into `tb_user` values (2, '文二狗', '陕西省西安市');
insert into `tb_user` values (3, '华沉鱼', '湖北省十堰市');
insert into `tb_user` values (4, '张必沉', '天津市');
insert into `tb_user` values (5, '郑爽爽', '辽宁省沈阳市大东区');
insert into `tb_user` values (6, '范兵兵', '山东省青岛市');
