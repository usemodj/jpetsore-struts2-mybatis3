DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS author;
--DROP PROCEDURE selectTwoSetsOfAuthors;
--DROP PROCEDURE insertAuthor;
--DROP PROCEDURE selectAuthorViaOutParams;

CREATE TABLE author (
id                INT NOT NULL AUTO_INCREMENT,
username          VARCHAR(255) NOT NULL,
password          VARCHAR(255) NOT NULL,
email             VARCHAR(255) NOT NULL,
bio               LONG VARCHAR,
favourite_section VARCHAR(25),
PRIMARY KEY (id)
);

ALTER TABLE author AUTO_INCREMENT = 10000;


CREATE TABLE blog (
id          INT NOT NULL AUTO_INCREMENT,
author_id   INT NOT NULL,
title       VARCHAR(255),
PRIMARY KEY (id)
);
ALTER TABLE blog AUTO_INCREMENT = 10000;

CREATE TABLE post (
id          INT NOT NULL AUTO_INCREMENT,
blog_id     INT,
author_id   INT NOT NULL,
created_on  TIMESTAMP NOT NULL,
section     VARCHAR(25) NOT NULL,
subject     VARCHAR(255) NOT NULL,
body        TEXT NOT NULL,
draft       INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (blog_id) REFERENCES blog(id)
);
ALTER TABLE post AUTO_INCREMENT = 10000;

CREATE TABLE tag (
id          INT NOT NULL AUTO_INCREMENT,
name        VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);
ALTER TABLE tag AUTO_INCREMENT = 10000;

CREATE TABLE post_tag (
post_id     INT NOT NULL,
tag_id      INT NOT NULL,
PRIMARY KEY (post_id, tag_id)
);

CREATE TABLE comment (
id          INT NOT NULL AUTO_INCREMENT,
post_id     INT NOT NULL,
name        LONG VARCHAR NOT NULL,
comment     LONG VARCHAR NOT NULL,
PRIMARY KEY (id)
);
ALTER TABLE comment AUTO_INCREMENT = 10000;

CREATE TABLE node (
id  INT NOT NULL,
parent_id INT,
PRIMARY KEY(id)
);

--CREATE PROCEDURE selectTwoSetsOfAuthors(DP1 INTEGER, DP2 INTEGER)
--PARAMETER STYLE JAVA
--LANGUAGE JAVA
--READS SQL DATA
--DYNAMIC RESULT SETS 2
--EXTERNAL NAME 'databases.blog.StoredProcedures.selectTwoSetsOfTwoAuthors';

--CREATE PROCEDURE insertAuthor(DP1 INTEGER, DP2 VARCHAR(255), DP3 VARCHAR(255), DP4 VARCHAR(255))
--PARAMETER STYLE JAVA
--LANGUAGE JAVA
--EXTERNAL NAME 'databases.blog.StoredProcedures.insertAuthor';

--CREATE PROCEDURE selectAuthorViaOutParams(ID INTEGER, OUT USERNAME VARCHAR(255), OUT PASSWORD VARCHAR(255), OUT EMAIL VARCHAR(255), OUT BIO VARCHAR(255))
--PARAMETER STYLE JAVA
--LANGUAGE JAVA
--EXTERNAL NAME 'databases.blog.StoredProcedures.selectAuthorViaOutParams';
