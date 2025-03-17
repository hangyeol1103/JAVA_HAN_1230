DROP DATABASE IF EXISTS WINDOW_FUNC;

CREATE DATABASE WINDOW_FUNC;

USE WINDOW_FUNC;

CREATE TABLE TEAM_SCORE(
	TS_TEAM CHAR(1) PRIMARY KEY,
    TS_SCORE INT NOT NULL DEFAULT 0
);
# A : 10, B : 5, C : 10, D : 10, E : 10, F : 9, G : 8
INSERT INTO TEAM_SCORE VALUES("A", 10), ("B", 5), ("C", 10), ("D", 10), ("E", 10), ("F", 9), ("G", 8);