create database if not exists `cloud_order` default charset utf8mb4 collate utf8mb4_general_ci;

use `cloud_order`;

drop table if exists `tb_order`;

create table `tb_order` (
    `id` bigint(20) auto_increment primary key comment '订单id',
    `user_id` bigint(20) not null comment '用户id',
    `name` varchar(100) comment '商品名称',
    `price` bigint(20) comment '商品价格',
    `num` int(10) not null default 0 comment '商品数量'
) engine = innodb;

insert into `tb_order` values (101, 1, 'apple 苹果 iphone 12 ', 699900, 1);
insert into `tb_order` values (102, 2, '雅迪 yadea 新国标电动车', 209900, 1);
insert into `tb_order` values (103, 3, '骆驼（camel）休闲运动鞋女', 43900, 1);
insert into `tb_order` values (104, 4, '小米10 双模5g 骁龙865', 359900, 1);
insert into `tb_order` values (105, 5, 'oppo reno3 pro 双模5g 视频双防抖', 299900, 1);
insert into `tb_order` values (106, 6, '美的（midea) 新能效 冷静星ii ', 544900, 1);
insert into `tb_order` values (107, 2, '西昊/sihoo 人体工学电脑椅子', 79900, 1);
insert into `tb_order` values (108, 3, '梵班（famdbann）休闲男鞋', 31900, 1);
