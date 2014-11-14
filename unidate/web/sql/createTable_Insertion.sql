USE `unidate` ;
  
  CREATE TABLE `student` (
  `personID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL,
  `department` VARCHAR(30) NULL,
  `studium` VARCHAR(50) NULL,
  `about` VARCHAR(255) NULL,
  PRIMARY KEY (`personID`));
  

INSERT INTO `student` (`personID`, `name`, `department`, `studium`, `about`) VALUES (NULL, 'Brianna Fraser', 'Angewandte Linguistik', NULL, 'Dreamer 
Du bist ein großer Champion,
wenn du Galoppierst bebt die Erde,
der Himmel öffnet sich und der Weg ist frei.
Der Weg zum Sieg!
Nach dem Rennen treffen wir uns im Kreise der Gewinner
und ich hülle dich in eine Decke aus Blumen.');
