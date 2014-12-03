CREATE DATABASE IF NOT EXISTS unidate;
USE `unidate` ;

CREATE TABLE IF NOT EXISTS `student` (
    `s` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(255) NOT NULL DEFAULT '',
    `lastname` VARCHAR(255) NOT NULL DEFAULT '',
    `username` VARCHAR(255) NOT NULL DEFAULT '',
    `gender` VARCHAR(255) NOT NULL DEFAULT '',
    `department` VARCHAR(255) NULL DEFAULT '',
    `studium` VARCHAR(255) NULL DEFAULT '',
    `about` TEXT NULL DEFAULT '',
    `email` VARCHAR(255) NOT NULL DEFAULT '',
    `password`  VARCHAR(255) NOT NULL,
    `age`  INT NOT NULL,
    `interests` VARCHAR(255) NOT NULL DEFAULT '',
    `registrated` BOOLEAN NOT NULL DEFAULT false,
    `completedProfile` BOOLEAN NOT NULL DEFAULT false,
    PRIMARY KEY (`s`)
);

CREATE TABLE IF NOT EXISTS `blockedStudent` (
    `studentid` INT NOT NULL,
    `blockedstudentid` INT NOT NULL,
    PRIMARY KEY (`studentid`,`blockedstudentid`),
    FOREIGN KEY (`studentid`) REFERENCES `student`(`s`),
    FOREIGN KEY (`blockedstudentid`) REFERENCES `student`(`s`)
);

CREATE TABLE IF NOT EXISTS `likedStudent` (
    `studentid` INT NOT NULL,
    `likedstudentid` INT NOT NULL,
    PRIMARY KEY (`studentid`,`likedstudentid`),
    FOREIGN KEY (`studentid`) REFERENCES `student`(`s`),
    FOREIGN KEY (`likedstudentid`) REFERENCES `student`(`s`)
);

CREATE TABLE IF NOT EXISTS `matchedStudent` (
    `ms` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(255) NOT NULL DEFAULT '',
    `lastname` VARCHAR(255) NOT NULL DEFAULT '',
    `interests` VARCHAR(255) NOT NULL DEFAULT '',
    `student1`  INT NOT NULL,
    `student2`  INT NOT NULL,
    PRIMARY KEY (`ms`),
    FOREIGN KEY (`student1`) REFERENCES `student`(`s`),
    FOREIGN KEY (`student2`) REFERENCES `student`(`s`)
);

CREATE TABLE IF NOT EXISTS `message` (
    `msg` INT NOT NULL AUTO_INCREMENT,
    `ms` INT NOT NULL,
    `text` TEXT NOT NULL,
    `from` int NOT NULL,
    `sentdate` DATETIME NOT NULL,
    `read` BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY (`msg`),
    FOREIGN KEY (`ms`) REFERENCES `matchedStudent`(`ms`)
);
