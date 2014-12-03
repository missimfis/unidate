USE `unidate` ;

INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `gender`, `interests`, `registrated`, `minage`, `maxage`, `completedProfile`, `about`, `department`, `studium`) 
VALUES ('Brianna', 'Fraser', 'fraserui','briana@zhaw.ch', '123456' , 23, 'women', 'men', true, 18, 30, true,'something interesting about me' ,'Gesundheit', 'Physio');

INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `gender`, `interests`, `registrated`, `minage`, `maxage`, `completedProfile`, `about`, `department`, `studium`) 
VALUES ('Peter', 'Pan', 'asd','panpet@students.zhaw.ch', 'asd' , 24, 'men', 'woman', true, 18, 30, true,'something interesting about me' ,'Technikum', 'Physio');

INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `gender`, `interests`, `registrated`, `minage`, `maxage`, `completedProfile`, `about`, `department`, `studium`) 
VALUES ('Mary', 'Stuart', 'stuart','stuart@students.zhaw.ch', '1234' , 23, 'women', 'women', true, 18, 30, true,'something interesting about me' ,'Gesundheit', 'Physio');

INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `gender`, `interests`, `registrated`, `minage`, `maxage`, `completedProfile`, `about`, `department`, `studium`) 
VALUES ('Henna', 'Frau', 'test','test@students.zhaw.ch', 'testtest5' , 22, 'women', 'woman', true, 18, 30, true,'something interesting about me' ,'Technikum', 'Physio');

INSERT INTO `likedStudent` ( `studentid`, `likedstudentid` )
VALUES (2,1);
INSERT INTO `matchedStudent` ( `student1`, `student2` )
VALUES (4,3);
