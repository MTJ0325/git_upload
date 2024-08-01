--------------------------------------------------------
--  已建立檔案 - 星期四-八月-01-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table 類別資料表
--------------------------------------------------------

  CREATE TABLE "STUDENT"."類別資料表" 
   (	"類別編號" VARCHAR2(20 BYTE), 
	"類別" NVARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into STUDENT."類別資料表"
SET DEFINE OFF;
Insert into STUDENT."類別資料表" ("類別編號","類別") values ('H001','公寓');
Insert into STUDENT."類別資料表" ("類別編號","類別") values ('H002','大樓');
Insert into STUDENT."類別資料表" ("類別編號","類別") values ('H003','公共設施');
Insert into STUDENT."類別資料表" ("類別編號","類別") values ('H004','私營單位');
