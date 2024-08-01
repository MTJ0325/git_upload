--------------------------------------------------------
--  已建立檔案 - 星期四-八月-01-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table 村里別資料表
--------------------------------------------------------

  CREATE TABLE "STUDENT"."村里別資料表" 
   (	"村里別代號" VARCHAR2(20 BYTE), 
	"村里別" NVARCHAR2(20), 
	"村里辦公室" NVARCHAR2(20), 
	"村里辦公室電話" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into STUDENT."村里別資料表"
SET DEFINE OFF;
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C001','大埔里','竹南鎮公義路1035號','037-581072');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C002','竹南里','竹南鎮竹南里中山路 103 號','037-472735');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C003','山佳里','竹南鎮山佳里國光街 14 號','037-614186');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C004','埔頂里','後龍鎮埔頂里中興路136-1號','037-724839');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C005','綠苗里','苗栗市綠苗里中正路 766 號','037-333240');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C006','民族里','民族里民族路96號','037-660001');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C007','忠孝里','忠孝里光大街82號','037-661145');
Insert into STUDENT."村里別資料表" ("村里別代號","村里別","村里辦公室","村里辦公室電話") values ('C008','信義里','信義里信義路53巷1號','037-616072');
