USE `unidate` ;

INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `gender`, `interests`, `registrated`, `minage`, `maxage`, `completedProfile`, `about`, `department`, `studium`) 
VALUES ('Brianna', 'Fraser', 'fraserui','briana@zhaw.ch', '123456' , 23, 'women', 'men', true, 18, 30, true,'something interesting about me' ,'Gesundheit', 'Physio');

INSERT INTO `student`(`firstname`, `lastname`, `username`, `email`, `password`, `age`, `gender`, `interests`, `registrated`, `minage`, `maxage`, `completedProfile`, `about`, `department`, `studium`) 
VALUES ('Peter', 'Pan', 'asd','panpet@students.zhaw.ch', 'asd' , 24, 'men', 'woman', true, 18, 30, true,'something interesting about me' ,'Technikum', 'Physio');

INSERT INTO `likedStudent` ( `studentid`, `likedstudentid` )
VALUES (2,1);
