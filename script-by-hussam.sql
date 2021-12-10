DROP TABLE IF EXISTS USERGROUPS CASCADE;
DROP TABLE IF EXISTS ACREDENTIALS CASCADE;
DROP TABLE IF EXISTS AUSER CASCADE;
DROP TABLE IF EXISTS CONTACT CASCADE;
DROP TABLE IF EXISTS EGENDER CASCADE;
DROP TABLE IF EXISTS ETITLE CASCADE;
DROP TABLE IF EXISTS EDOMAIN CASCADE;
DROP TABLE IF EXISTS EGROUP CASCADE;
DROP TABLE IF EXISTS EMETHOD CASCADE;
DROP TABLE IF EXISTS IDDOCUMENT CASCADE;
DROP TABLE IF EXISTS primarylanguage CASCADE;
DROP TABLE IF EXISTS maritalstatus CASCADE;
DROP TABLE IF EXISTS CITIZENSHIP CASCADE;
DROP TABLE IF EXISTS APENDINGREQUEST CASCADE;
DROP TABLE IF EXISTS EPREQUESTSTATUS CASCADE;
DROP TABLE IF EXISTS RTYPE CASCADE;
DROP TABLE IF EXISTS NUIDSEQUESNCENUMBER CASCADE;
DROP TABLE IF EXISTS MMESAGE CASCADE;
DROP TABLE IF EXISTS STOKEN CASCADE;

CREATE TABLE IF NOT EXISTS maritalstatus (
  MID varchar(128)  PRIMARY KEY,
  STATUS varchar(128) NOT NULL  
);

INSERT INTO maritalstatus (MID, STATUS) VALUES
('Married', 'Married'),
('Single', 'Single');

CREATE TABLE IF NOT EXISTS primarylanguage (
  GID varchar(128) PRIMARY KEY,
  LANGUAGE varchar(128) NOT NULL
);

INSERT INTO primarylanguage (GID, LANGUAGE) VALUES
('ARABIC', 'ARABIC'),
('ENGLISH', 'ENGLISH'),
('FRENCH', 'FRENCH');



CREATE TABLE IF NOT exists IDDOCUMENT (
  CID varchar(128) PRIMARY KEY,
  IDPHOTO varchar(128) NOT NULL
);

CREATE TABLE EGENDER (
GID VARCHAR(32) PRIMARY key,
GLABEL VARCHAR(32) NOT NULL
);
INSERT INTO EGENDER (GID,GLABEL) VALUES ('Male','Male');
INSERT INTO EGENDER (GID,GLABEL) VALUES ('Female','Female');

CREATE TABLE ETITLE (
TID VARCHAR(128) PRIMARY KEY,
TLABEL VARCHAR(128) NOT NULL
);
INSERT INTO ETITLE (TID, TLABEL) VALUES ('Mr', 'Mr');
INSERT INTO ETITLE (TID, TLABEL) VALUES ('Mrs', 'Mrs');
INSERT INTO ETITLE (TID, TLABEL) VALUES ('Ms', 'Ms');
INSERT INTO ETITLE (TID, TLABEL) VALUES ('Dr', 'Dr');

CREATE TABLE EDOMAIN (
DID VARCHAR(128) PRIMARY KEY,
DLABEL VARCHAR(128) NOT NULL
);
INSERT INTO EDOMAIN (DID, DLABEL) VALUES ('NUVERSITY', 'NUVERSITY');

CREATE TABLE EGROUP (
GID VARCHAR(128) PRIMARY KEY,
GLABEL VARCHAR(128) NOT NULL
);
INSERT INTO EGROUP (GID, GLABEL) VALUES ('APPLICANT', 'APPLICANT');
INSERT INTO EGROUP (GID, GLABEL) VALUES ('STUDENT', 'STUDENT');
INSERT INTO EGROUP (GID, GLABEL) VALUES ('TEACHER', 'TEACHER');
INSERT INTO EGROUP (GID, GLABEL) VALUES ('DEAN', 'DEAN');
INSERT INTO EGROUP (GID, GLABEL) VALUES ('COORDINATOR', 'COORDINATOR');
INSERT INTO EGROUP (GID, GLABEL) VALUES ('MGMT', 'MGMT');
INSERT INTO EGROUP (GID, GLABEL) VALUES ('ADMIN', 'ADMIN');


CREATE TABLE CITIZENSHIP (
GID VARCHAR(128) PRIMARY KEY,
COUNTRY VARCHAR(128) NOT NULL
);

INSERT INTO CITIZENSHIP (GID, COUNTRY) VALUES ('AUSTRALIA', 'AUSTRALIA');
INSERT INTO CITIZENSHIP (GID, COUNTRY) VALUES ('LEBANON', 'LEBANON');
INSERT INTO CITIZENSHIP (GID, COUNTRY) VALUES ('USA', 'USA');
INSERT INTO CITIZENSHIP (GID, COUNTRY) VALUES ('FRANCE', 'FRANCE');
INSERT INTO CITIZENSHIP (GID, COUNTRY) VALUES ('CANADA', 'CANADA');
INSERT INTO CITIZENSHIP (GID, COUNTRY) VALUES ('RUSSIA', 'RUSSIA');

CREATE TABLE EMETHOD (
MTDID VARCHAR(128) PRIMARY KEY,
MTDLABEL VARCHAR(128) NOT NULL
);

INSERT INTO EMETHOD(MTDID, MTDLABEL) VALUES('PASSWORD', 'PASSWORD');
INSERT INTO EMETHOD(MTDID, MTDLABEL) VALUES('FACE ID', 'FACE ID');

CREATE TABLE ACREDENTIALS (
CRED_ID VARCHAR(128) PRIMARY KEY,
CMETHOD VARCHAR(128) NOT NULL,
LOGINID VARCHAR(128) NOT NULL,
PWDDATA VARCHAR(256) NOT NULL,
EXPIRE_BY TIMESTAMP NOT NULL,
TRY_COUNT INT NOT NULL,
BLOCKED BOOLEAN NOT NULL,
CONSTRAINT FK_CRD_MTD
      FOREIGN KEY(CMETHOD)
 REFERENCES EMETHOD(MTDID)
);


CREATE TABLE CONTACT (
EMAIL VARCHAR(128) PRIMARY KEY,
FIRSTNAME VARCHAR(128) NOT NULL,
MIDDLENAME VARCHAR(128),
LASTNAME VARCHAR(128) NOT NULL,
DOB DATE NOT NULL,
GENDER VARCHAR(32) NOT NULL,
TITLE VARCHAR(32) NOT NULL,
PHONE VARCHAR(128),
CADDRESS VARCHAR(256),
PHOTO VARCHAR(128),
CITIZENSHIP VARCHAR(128),
PRIMARYLANGUAGE varchar(128) NOT NULL,
LANDLINE varchar(128),
MARITALSTATUS varchar(128),
IDDOCUMENT varchar(128),

CONSTRAINT FK_CTT_GDR
      FOREIGN KEY(GENDER)
 REFERENCES EGENDER(GID),
CONSTRAINT FK_CTT_TTL
      FOREIGN KEY(TITLE)
 REFERENCES ETITLE(TID),
CONSTRAINT FK_CTT_PLA
      FOREIGN KEY(PRIMARYLANGUAGE)
 REFERENCES primarylanguage(GID),
CONSTRAINT FK_CTT_CID
      FOREIGN KEY(IDDOCUMENT)
 REFERENCES IDDOCUMENT(CID),
CONSTRAINT FK_CTT_MST
      FOREIGN KEY(MARITALSTATUS)
 REFERENCES maritalstatus(MID),
CONSTRAINT FK_CTT_CTZ
 FOREIGN KEY(CITIZENSHIP)
 REFERENCES CITIZENSHIP(GID)
);

CREATE TABLE AUSER (
USERID VARCHAR(128) PRIMARY KEY,
CONTACTID VARCHAR(128) NOT NULL,
NUMAIL VARCHAR(128),
JOINING_DATE TIMESTAMP NOT NULL,
DOMAINID VARCHAR(128),
CREDENTIAL VARCHAR(128),
CONSTRAINT FK_USR_CTT
      FOREIGN KEY(CONTACTID)
 REFERENCES CONTACT(EMAIL),
CONSTRAINT FK_USR_DOMAIN
      FOREIGN KEY(DOMAINID)
 REFERENCES EDOMAIN(DID),
 CONSTRAINT FK_USR_CREDENT
      FOREIGN KEY(CREDENTIAL)
 REFERENCES ACREDENTIALS(cred_id)
);
CREATE UNIQUE INDEX NUMAIL_IDX on AUSER(NUMAIL);

create table STOKEN (
IID VARCHAR(128) PRIMARY KEY,
USRID VARCHAR(128) NOT NULL,
TOKENS VARCHAR(128) NOT NULL,
EXPIRYDATE TIME not null,

CONSTRAINT FK_STOKEN_UID
      FOREIGN KEY(USRID)
 REFERENCES AUSER(USERID)
);


CREATE TABLE USERGROUPS (
EID VARCHAR(128) PRIMARY KEY,
USRID VARCHAR(128) NOT NULL,
GRPID VARCHAR(128) NOT NULL,
CONSTRAINT FK_USRGRP_UID
      FOREIGN KEY(USRID)
 REFERENCES AUSER(USERID),
CONSTRAINT FK_USRGRP_GID
      FOREIGN KEY(GRPID)
 REFERENCES EGROUP(GID)
);

CREATE TABLE MMESAGE (
	uid varchar(128) primary key,
	msg_subject varchar(1024) NOT NULL,
	msg_body varchar(4096) NOT NULL
);

INSERT INTO mmesage (uid, msg_subject, msg_body) VALUES('M001', 'Forget Password', '$username$ open the link to reset your password $link$');
INSERT INTO mmesage (uid, msg_subject, msg_body) VALUES('M003', 'Student Accepted', 'You are student now, you can login with your NUmail $numail$');

INSERT INTO mmesage (uid, msg_subject, msg_body) VALUES('M002', 'Set Password', '$username$ open the link to set your password $link$. Your nuid is $nuid$');
create table RTYPE (
UID VARCHAR(128) primary key,
ELABEL VARCHAR(128) not NULL
);

INSERT INTO RTYPE (UID, ELABEL) VALUES ('INVITATION', 'INVITATION');
INSERT INTO RTYPE (UID, ELABEL) VALUES ('UPDATE_PASSWORD', 'UPDATE_PASSWORD');
INSERT INTO RTYPE (UID, ELABEL) VALUES ('SET_PASSWORD', 'SET_PASSWORD');
INSERT INTO RTYPE (UID, ELABEL) VALUES ('MAKE_STUDENT', 'MAKE_STUDENT');

create table EPREQUESTSTATUS (
UID VARCHAR(128) primary key,
ELABEL VARCHAR(128) not NULL
);

INSERT INTO EPREQUESTSTATUS (UID, ELABEL) VALUES ('CONFIRMED', 'CONFIRMED');
INSERT INTO EPREQUESTSTATUS (UID, ELABEL) VALUES ('EXPIRED', 'EXPIRED');
INSERT INTO EPREQUESTSTATUS (UID, ELABEL) VALUES ('PENDING', 'PENDING');


CREATE TABLE APENDINGREQUEST (
RLINK VARCHAR(128) PRIMARY KEY,
USRID VARCHAR(128) NOT NULL,
RSTATUS VARCHAR(128) NOT NULL,
ISSUEDATE TIME NOT NULL,
EXPIRYDATE TIME not null,
RTYPE VARCHAR(128) not null,
CONSTRAINT FK_PRQ_USR
      FOREIGN KEY(USRID)
 REFERENCES AUSER(USERID),
CONSTRAINT FK_PRQ_RST
      FOREIGN KEY(RSTATUS)
 REFERENCES EPREQUESTSTATUS(UID),
 CONSTRAINT FK_PRQ_RTY
      FOREIGN KEY(RTYPE)
 REFERENCES RTYPE(UID)
);

CREATE TABLE NUIDSEQUESNCENUMBER (
GROUPE VARCHAR(128) PRIMARY KEY,
SQUENCE VARCHAR(128) NOT null,
NYEAR varchar(128) not Null
);

INSERT INTO NUIDSEQUESNCENUMBER (GROUPE, SQUENCE,NYEAR) values ('ADMIN', '0000','21');
INSERT INTO NUIDSEQUESNCENUMBER (GROUPE, SQUENCE,NYEAR) values ('TEACHER', '0000','21');
INSERT INTO NUIDSEQUESNCENUMBER (GROUPE, SQUENCE,NYEAR) values ('STUDENT','0000','21');
INSERT INTO NUIDSEQUESNCENUMBER (GROUPE, SQUENCE,NYEAR) values ('OTHER','0000','21');