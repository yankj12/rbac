
--=============================================================
--一些基础表，非RBAC模型中核心表，但是为了更好开发而需要的表
--=============================================================

CREATE TABLE
    sequence
    (
        name VARCHAR(50) NOT NULL,
        current_value bigint NOT NULL,
        increment INT DEFAULT '1' NOT NULL,
        PRIMARY KEY (name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

--=============================================================
--以下是RBAC权限模型中的核心表
--=============================================================


--用户表
DROP TABLE IF EXISTS rbac_user;
CREATE TABLE
    rbac_user
    (
        userId VARCHAR(20) NOT NULL COMMENT '用户Id',
        userName VARCHAR(60) COMMENT '用户名称',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '有效状态',
        insertTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '创建时间',
        PRIMARY KEY (userId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--角色表
DROP TABLE IF EXISTS rbac_role;
CREATE TABLE
    rbac_role
    (
        roleId VARCHAR(20) NOT NULL COMMENT '角色Id',
        roleName VARCHAR(40) COMMENT '角色名称',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '有效状态',
        insertTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '修改时间',
        PRIMARY KEY (roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

--用户组表
DROP TABLE IF EXISTS rbac_group;
CREATE TABLE
    rbac_group
    (
        groupId VARCHAR(20) NOT NULL COMMENT '组Id',
        groupName VARCHAR(60) COMMENT '组名称',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '有效状态',
        insertTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '修改时间',
        PRIMARY KEY (groupId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组表';

--组角色关系表
DROP TABLE IF EXISTS rbac_group_role;
CREATE TABLE
    rbac_group_role
    (
        groupId VARCHAR(20) NOT NULL COMMENT '组Id',
        groupName VARCHAR(60) COMMENT '组名称',
        roleId VARCHAR(20) NOT NULL COMMENT '角色Id',
        roleName VARCHAR(60) COMMENT '角色名称',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '有效状态',
        insertTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '修改时间',
        PRIMARY KEY (groupId, roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组角色关系表';

--用户组关系表
DROP TABLE IF EXISTS rbac_user_group;
CREATE TABLE
    rbac_user_group
    (
        userId VARCHAR(20) NOT NULL COMMENT '用户Id',
        userName VARCHAR(60) COMMENT '用户名称',
        groupId VARCHAR(20) NOT NULL COMMENT '组Id',
        groupName VARCHAR(60) COMMENT '组名称',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '有效状态',
        insertTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '修改时间',
        PRIMARY KEY (userId, groupId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组关系表';

--用户角色关系表
DROP TABLE IF EXISTS rbac_user_role;
CREATE TABLE
    rbac_user_role
    (
        userId VARCHAR(20) NOT NULL COMMENT '用户Id',
        userName VARCHAR(60) COMMENT '用户名称',
        roleId VARCHAR(20) NOT NULL COMMENT '角色Id',
        roleName VARCHAR(60) COMMENT '角色名称',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '有效状态',
        insertTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '修改时间',
        PRIMARY KEY (userId, roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

--在rbac_user表增加一列id，用id来做主键
alter table rbac_user add column id varchar(20) first;

--修改rbac_user表的主键
ALTER TABLE rbac_user MODIFY COLUMN id varchar(20) NOT NULL;
ALTER TABLE rbac_user DROP PRIMARY KEY;
ALTER TABLE rbac_user ADD CONSTRAINT rbac_user_pk PRIMARY KEY (id);
commit;

--修改rbac_role表的主键
alter table rbac_role add column id varchar(20) first;
ALTER TABLE rbac_role MODIFY COLUMN id varchar(20) NOT NULL;
ALTER TABLE rbac_role DROP PRIMARY KEY;
ALTER TABLE rbac_role ADD CONSTRAINT rbac_role_pk PRIMARY KEY (id);

--修改rbac_group表的主键
alter table rbac_group add column id varchar(20) first;
ALTER TABLE rbac_group MODIFY COLUMN id varchar(20) NOT NULL;
ALTER TABLE rbac_group DROP PRIMARY KEY;
ALTER TABLE rbac_group ADD CONSTRAINT rbac_group_pk PRIMARY KEY (id);

--修改rbac_user_group表的主键
alter table rbac_user_group add column id varchar(20) first;
ALTER TABLE rbac_user_group MODIFY COLUMN id varchar(20) NOT NULL;
ALTER TABLE rbac_user_group DROP PRIMARY KEY;
ALTER TABLE rbac_user_group ADD CONSTRAINT rbac_user_group_pk PRIMARY KEY (id);

--修改rbac_user_role表的主键
alter table rbac_user_role add column id varchar(20) first;
ALTER TABLE rbac_user_role MODIFY COLUMN id varchar(20) NOT NULL;
ALTER TABLE rbac_user_role DROP PRIMARY KEY;
ALTER TABLE rbac_user_role ADD CONSTRAINT rbac_user_role_pk PRIMARY KEY (id);
