--------------------------------------------------------
--  已建立檔案 - 星期四-八月-01-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table 轄管分局資料表
--------------------------------------------------------

  CREATE TABLE "STUDENT"."轄管分局資料表" 
   (	"轄管分局代碼" VARCHAR2(20 BYTE), 
	"轄管分局" NVARCHAR2(20), 
	"分局地址" NVARCHAR2(20), 
	"分局電話" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into STUDENT."轄管分局資料表"
SET DEFINE OFF;
Insert into STUDENT."轄管分局資料表" ("轄管分局代碼","轄管分局","分局地址","分局電話") values ('M001','竹南分局','苗栗縣竹南鎮民族街72號','03 747 4796');
Insert into STUDENT."轄管分局資料表" ("轄管分局代碼","轄管分局","分局地址","分局電話") values ('M002','苗栗分局','苗栗縣苗栗市金鳳街109號','03 732 0059');
Insert into STUDENT."轄管分局資料表" ("轄管分局代碼","轄管分局","分局地址","分局電話") values ('M003','頭份分局','苗栗縣頭份市中興路503號','03 766 3004');
