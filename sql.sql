-- auto-generated definition
create table performinfo
(
    id               bigint auto_increment comment 'id'
        primary key,
    title            varchar(512)                       not null comment '标题',
    perfortype       int      default 0                 null comment '演出类型',
    performstar      varchar(128)                       not null comment '演出明星',
    performpice      int      default 0                 null comment '演出价格',
    performshows     varchar(512)                       not null comment '演出简介',
    performplace     varchar(128)                       not null comment '演出地点',
    performstarttime datetime default CURRENT_TIMESTAMP null comment '演出开始时间',
    performendtime   datetime default CURRENT_TIMESTAMP null comment '演出结束时间',
    performheat      int      default 0                 null comment '演出热度',
    performposters   varchar(512)                       null comment '演出海报(url)',
    performdiscount  float                              null comment '演出价格折扣',
    isDelete         tinyint  default 0                 not null comment '是否删除'
)
    comment '演出信息' collate = utf8mb4_unicode_ci;

create index idx_place
    on performinfo (performplace);

-- auto-generated definition
create table shopcar
(
    id        bigint auto_increment comment 'id'
        primary key,
    userId    bigint            not null comment '标题',
    performId bigint            not null comment '用户昵称',
    isDelete  tinyint default 0 not null comment '是否删除'
)
    comment '购物车表' collate = utf8mb4_unicode_ci;

create index idx_place
    on shopcar (userId);

-- auto-generated definition
create table userinfo
(
    id        bigint auto_increment comment 'id'
        primary key,
    openid    varchar(512)      not null comment '标题',
    nickname  varchar(512)      not null comment '用户昵称',
    avatarUrl varchar(512)      not null comment '用户头像',
    userrole  tinyint default 0 not null comment '用户权限',
    isDelete  tinyint default 0 not null comment '是否删除'
)
    comment '用户表' collate = utf8mb4_unicode_ci;

create index idx_place
    on userinfo (openid);

