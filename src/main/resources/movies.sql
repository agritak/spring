CREATE DATABASE bootcamp;
CREATE TABLE if not exists movies (
id VARCHAR(255) PRIMARY KEY,
title VARCHAR(255) NOT NULL,
rating SMALLINT NOT NULL,
plot VARCHAR(255),
link VARCHAR(255)
);