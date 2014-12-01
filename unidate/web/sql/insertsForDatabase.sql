USE `unidate` ;
INSERT INTO `skills` (`personID`, `name`, `department`, `studium`, `about`) VALUES (NULL, 'Brianna Fraser', 'Angewandte Linguistik', NULL, 'Dreamer 
Du bist ein großer Champion,
wenn du Galoppierst bebt die Erde,
der Himmel öffnet sich und der Weg ist frei.
Der Weg zum Sieg!
Nach dem Rennen treffen wir uns im Kreise der Gewinner
und ich hülle dich in eine Decke aus Blumen.');


INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `interests`, `registrated`, `completedProfile`) 
VALUES ('Brianna', 'Fraser', 'fraserui','briana@zhaw.ch', '123456' , 23, 'woman', true, true)

INSERT INTO `candidate` (`s`, `firstname`, `lastname`, `like`, `interests`) 
VALUES (1, 'Brianna', 'Fraser', true,'woman');

SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE my_first_table_to_drop; 
DROP TABLE my_second_table_to_drop; 
SET FOREIGN_KEY_CHECKS=1; 
