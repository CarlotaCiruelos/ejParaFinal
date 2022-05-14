DROP TABLE IF EXISTS USER;

CREATE TABLE  "USER" (
                          "USER_ID" integer identity NOT NULL PRIMARY KEY,
                          "USER" VARCHAR2(40) NOT NULL,
                          "COMMENT" VARCHAR2(35) NOT NULL
);

DROP TABLE IF EXISTS DOCUMENTS;

CREATE TABLE  "DOCUMENT" (
                              "DOC_ID" NUMBER NOT NULL PRIMARY KEY,
                              "DOC" VARCHAR2(40) NOT NULL,
                              "USER_ID" NUMBER NOT NULL
);