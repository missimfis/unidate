CREATE DATABASE IF NOT EXISTS unidate;
USE `unidate` ;
  
CREATE TABLE IF NOT EXISTS `skills` (
    `personID` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    `department` VARCHAR(255) NULL,
    `studium` VARCHAR(255) NULL,
    `about` TEXT NULL,
    PRIMARY KEY (`personID`)
);

CREATE TABLE IF NOT EXISTS `student` (
    `s` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(255) NOT NULL DEFAULT '',
    `lastname` VARCHAR(255) NOT NULL DEFAULT '',
    `username` VARCHAR(255) NOT NULL DEFAULT '',
    `email` VARCHAR(255) NOT NULL DEFAULT '',
    `password`  VARCHAR(255) NOT NULL,
    `age`  INT NOT NULL,
    `interests` VARCHAR(255) NOT NULL DEFAULT '',
    `registrated` BOOLEAN NOT NULL DEFAULT false,
    `completedProfile` BOOLEAN NOT NULL DEFAULT false,
    PRIMARY KEY (`s`)
);

CREATE TABLE IF NOT EXISTS `candidate` (
    `c` INT NOT NULL AUTO_INCREMENT,
    `s` INT NOT NULL,
    `firstname` VARCHAR(255) NOT NULL DEFAULT '',
    `lastname` VARCHAR(255) NOT NULL DEFAULT '',
    `like` BOOLEAN NOT NULL DEFAULT false,
    `interests` VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY (`c`),
    FOREIGN KEY (`s`) REFERENCES `student`(`s`)
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
    `lastname` VARCHAR(255) NOT NULL DEFAULT '',
    `interests` VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY (`msg`),
    FOREIGN KEY (`ms`) REFERENCES `matchedStudent`(`ms`)
);
