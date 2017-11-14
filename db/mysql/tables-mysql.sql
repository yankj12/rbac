
--=============================================================
--һЩ��������RBACģ���к��ı�����Ϊ�˸��ÿ�������Ҫ�ı�
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
--������RBACȨ��ģ���еĺ��ı�
--=============================================================


--�û���
CREATE TABLE
    rbac_user
    (
        userId VARCHAR(20) NOT NULL,
        userName VARCHAR(60),
        validStatus VARCHAR(2) DEFAULT '1',
        insertTime DATETIME,
        updateTime DATETIME,
        PRIMARY KEY (userId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��ɫ��
CREATE TABLE
    rbac_role
    (
        roleId VARCHAR(20) NOT NULL,
        roleName VARCHAR(40),
        validStatus VARCHAR(2) DEFAULT '1',
        insertTime DATETIME,
        updateTime DATETIME,
        PRIMARY KEY (roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�û����
CREATE TABLE
    rbac_group
    (
        groupId VARCHAR(20) NOT NULL,
        groupName VARCHAR(60),
        validStatus VARCHAR(2) DEFAULT '1',
        insertTime DATETIME,
        updateTime DATETIME,
        PRIMARY KEY (groupId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

--���ɫ��ϵ��
CREATE TABLE
    rbac_group_role
    (
        groupId VARCHAR(20) NOT NULL,
        groupName VARCHAR(60),
        roleId VARCHAR(20) NOT NULL,
        roleName VARCHAR(60),
        validStatus VARCHAR(2) DEFAULT '1',
        insertTime DATETIME,
        updateTime DATETIME,
        PRIMARY KEY (groupId, roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�û����ϵ��
CREATE TABLE
    rbac_user_group
    (
        userId VARCHAR(20) NOT NULL,
        userName VARCHAR(60),
        groupId VARCHAR(20) NOT NULL,
        groupName VARCHAR(60),
        validStatus VARCHAR(2) DEFAULT '1',
        insertTime DATETIME,
        updateTime DATETIME,
        PRIMARY KEY (userId, groupId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�û���ɫ��ϵ��
CREATE TABLE
    rbac_user_role
    (
        userId VARCHAR(20) NOT NULL,
        userName VARCHAR(60),
        roleId VARCHAR(20) NOT NULL,
        roleName VARCHAR(60),
        validStatus VARCHAR(2) DEFAULT '1',
        insertTime DATETIME,
        updateTime DATETIME,
        PRIMARY KEY (userId, roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

