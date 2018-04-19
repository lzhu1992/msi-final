--------------------------------------------------------
--  File created - Wednesday-April-18-2018   
--------------------------------------------------------
DROP TABLE "LZHU"."BANK_TRANSACTION" cascade constraints;
--------------------------------------------------------
--  DDL for Table BANK_TRANSACTION
--------------------------------------------------------

  CREATE TABLE "LZHU"."BANK_TRANSACTION" 
   (	"TDATE" VARCHAR2(20 BYTE), 
	"RECIPIENT" VARCHAR2(200 BYTE), 
	"AMOUNT" NUMBER, 
	"ID" NUMBER, 
	"DEPOSIT" NUMBER, 
	"ACCOUNT" NUMBER, 
	"DESCRIBE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into LZHU.BANK_TRANSACTION
SET DEFINE OFF;
Insert into LZHU.BANK_TRANSACTION (TDATE,RECIPIENT,AMOUNT,ID,DEPOSIT,ACCOUNT,DESCRIBE) values ('20180417','Xiexie',300,1,88970,890,'happy');
Insert into LZHU.BANK_TRANSACTION (TDATE,RECIPIENT,AMOUNT,ID,DEPOSIT,ACCOUNT,DESCRIBE) values ('2018-04-18','lzhu@stevens.edu',88,5,12252,111,'online transfer');
Insert into LZHU.BANK_TRANSACTION (TDATE,RECIPIENT,AMOUNT,ID,DEPOSIT,ACCOUNT,DESCRIBE) values ('2018-04-18','evezhu@gmail.com',-88,6,79748,890,'online transfer');
Insert into LZHU.BANK_TRANSACTION (TDATE,RECIPIENT,AMOUNT,ID,DEPOSIT,ACCOUNT,DESCRIBE) values ('20180418','evezhu@gmail.com',-222,11,79890,890,'online transfer');
Insert into LZHU.BANK_TRANSACTION (TDATE,RECIPIENT,AMOUNT,ID,DEPOSIT,ACCOUNT,DESCRIBE) values ('2018-04-18','lzhu@stevens.edu',54,3,12164,111,'online transfer');
Insert into LZHU.BANK_TRANSACTION (TDATE,RECIPIENT,AMOUNT,ID,DEPOSIT,ACCOUNT,DESCRIBE) values ('2018-04-18','evezhu@gmail.com',-54,4,79836,890,'online transfer');
--------------------------------------------------------
--  DDL for Index BANK_TRANSACTION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LZHU"."BANK_TRANSACTION_PK" ON "LZHU"."BANK_TRANSACTION" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BANK_TRANSACTION
--------------------------------------------------------

  ALTER TABLE "LZHU"."BANK_TRANSACTION" ADD CONSTRAINT "BANK_TRANSACTION_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LZHU"."BANK_TRANSACTION" MODIFY ("ID" NOT NULL ENABLE);
