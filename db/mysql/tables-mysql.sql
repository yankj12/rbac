
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
DROP TABLE IF EXISTS rbac_user;
CREATE TABLE
    rbac_user
    (
        userId VARCHAR(20) NOT NULL COMMENT '�û�Id',
        userName VARCHAR(60) COMMENT '�û�����',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '��Ч״̬',
        insertTime DATETIME COMMENT '����ʱ��',
        updateTime DATETIME COMMENT '����ʱ��',
        PRIMARY KEY (userId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';

--��ɫ��
DROP TABLE IF EXISTS rbac_role;
CREATE TABLE
    rbac_role
    (
        roleId VARCHAR(20) NOT NULL COMMENT '��ɫId',
        roleName VARCHAR(40) COMMENT '��ɫ����',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '��Ч״̬',
        insertTime DATETIME COMMENT '����ʱ��',
        updateTime DATETIME COMMENT '�޸�ʱ��',
        PRIMARY KEY (roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';

--�û����
DROP TABLE IF EXISTS rbac_group;
CREATE TABLE
    rbac_group
    (
        groupId VARCHAR(20) NOT NULL COMMENT '��Id',
        groupName VARCHAR(60) COMMENT '������',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '��Ч״̬',
        insertTime DATETIME COMMENT '����ʱ��',
        updateTime DATETIME COMMENT '�޸�ʱ��',
        PRIMARY KEY (groupId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û����';

--���ɫ��ϵ��
DROP TABLE IF EXISTS rbac_group_role;
CREATE TABLE
    rbac_group_role
    (
        groupId VARCHAR(20) NOT NULL COMMENT '��Id',
        groupName VARCHAR(60) COMMENT '������',
        roleId VARCHAR(20) NOT NULL COMMENT '��ɫId',
        roleName VARCHAR(60) COMMENT '��ɫ����',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '��Ч״̬',
        insertTime DATETIME COMMENT '����ʱ��',
        updateTime DATETIME COMMENT '�޸�ʱ��',
        PRIMARY KEY (groupId, roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���ɫ��ϵ��';

--�û����ϵ��
DROP TABLE IF EXISTS rbac_user_group;
CREATE TABLE
    rbac_user_group
    (
        userId VARCHAR(20) NOT NULL COMMENT '�û�Id',
        userName VARCHAR(60) COMMENT '�û�����',
        groupId VARCHAR(20) NOT NULL COMMENT '��Id',
        groupName VARCHAR(60) COMMENT '������',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '��Ч״̬',
        insertTime DATETIME COMMENT '����ʱ��',
        updateTime DATETIME COMMENT '�޸�ʱ��',
        PRIMARY KEY (userId, groupId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û����ϵ��';

--�û���ɫ��ϵ��
DROP TABLE IF EXISTS rbac_user_role;
CREATE TABLE
    rbac_user_role
    (
        userId VARCHAR(20) NOT NULL COMMENT '�û�Id',
        userName VARCHAR(60) COMMENT '�û�����',
        roleId VARCHAR(20) NOT NULL COMMENT '��ɫId',
        roleName VARCHAR(60) COMMENT '��ɫ����',
        validStatus VARCHAR(2) DEFAULT '1' COMMENT '��Ч״̬',
        insertTime DATETIME COMMENT '����ʱ��',
        updateTime DATETIME COMMENT '�޸�ʱ��',
        PRIMARY KEY (userId, roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���ɫ��ϵ��';

