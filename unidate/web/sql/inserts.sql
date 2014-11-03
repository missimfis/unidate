
USE lemas;

INSERT INTO `lemas`.`Klasse` (`K`, `Kname`) VALUES ('121', 'IT13a');
INSERT INTO `lemas`.`Klasse` (`K`, `Kname`) VALUES ('122', 'IT13b');
INSERT INTO `lemas`.`Klasse` (`K`, `Kname`) VALUES ('123', 'MT08c');
INSERT INTO `lemas`.`Klasse` (`K`, `Kname`) VALUES ('124', 'ET11x');

INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('100','lemas@gmail.com','System','System','System','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('121','Test1@gmail.com','Admin1','Hans','Meier','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('122','Test2@gmail.com','Mitglied11','Ueli','Roesti','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('123','Test3@gmail.com','Mitglied12','Vreni','Müller','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('124','Test4@gmail.com','Admin2','Xavier','Sonne','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('125','Test5@gmail.com','Mitglied21','Carlos','Wuest','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('126','Test6@gmail.com','Mitglied22','Beat','Wolf','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('127','Test7@gmail.com','Admin3','Jan','Ulrich','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('128','Test8@gmail.com','Mitglied31','Dave','Froehlich','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('129','Test9@gmail.com','Mitglied32','Nick','Avatar','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('130','Test10@gmail.com','Admin4','Florian','Harrer','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('131','Test11@gmail.com','Antrag1','Tobias','Moser','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('132','Test12@gmail.com','Antrag2','Mike','Schiesser','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('133','Test13@gmail.com','Einladung1','Fred','Schmied','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('134','Test14@gmail.com','Einladung2','Boris','Blanc','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('135','Test15@gmail.com','Einladung3','Matthias','Bleibler','Test');
INSERT INTO `Person`(`P`, `Email`, `Pusername`, `Pvorname`, `Pnachname`, `Pw`) VALUES ('136','Test16@gmail.com','Einladung4','Mischa','Wirt','Test');


INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('121', '121');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('122', '121');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('123', '121');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('124', '122');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('125', '122');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('126', '122');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('127', '123');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('128', '123');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('129', '123');
INSERT INTO `lemas`.`Mitglied` (`P`, `K`) VALUES ('130', '124');

INSERT INTO `lemas`.`Klassenadministrator` (`P`, `K`) VALUES ('121', '121');
INSERT INTO `lemas`.`Klassenadministrator` (`P`, `K`) VALUES ('124', '122');
INSERT INTO `lemas`.`Klassenadministrator` (`P`, `K`) VALUES ('127', '123');
INSERT INTO `lemas`.`Klassenadministrator` (`P`, `K`) VALUES ('130', '124');

INSERT INTO `lemas`.`Antrag` (`P`, `K`) VALUES ('131', '121');
INSERT INTO `lemas`.`Antrag` (`P`, `K`) VALUES ('132', '122');

INSERT INTO `lemas`.`Einladung` (`P`, `K`) VALUES ('133', '121');
INSERT INTO `lemas`.`Einladung` (`P`, `K`) VALUES ('134', '122');

INSERT INTO `lemas`.`Termin` (`T`,`Tname`,`Beschreibung`,`Datum`) VALUES ('80','Auffahrt','Heute kein Unterricht','2014-05-29 08:00:00');
INSERT INTO `lemas`.`Termin` (`T`,`Tname`,`Beschreibung`,`Datum`) VALUES ('81','Pfingsmontag','Heute kein Unterricht','2014-06-09 08:00:00');
INSERT INTO `lemas`.`Termin` (`T`,`Tname`,`Beschreibung`,`Datum`) VALUES ('82','Ende Frühlingssemester','Die Prüfungszeit steht bevor','2014-06-20 08:00:00');
INSERT INTO `lemas`.`Termin` (`T`,`Tname`,`Beschreibung`,`Datum`) VALUES ('83','Beginn Herbstsemester','Die Ferien sind vorbei','2014-09-15 08:00:00');
INSERT INTO `lemas`.`Termin` (`T`,`Tname`,`Beschreibung`,`Datum`) VALUES ('84','Ende Herbstsemester','Die Prüfungszeit steht bevor','2014-12-19 08:00:00');
INSERT INTO `lemas`.`Termin` (`T`,`Tname`,`Beschreibung`,`Datum`) VALUES ('85','Semesterprüfungen','Zwei Wochen Prüfungen','2015-01-31 08:00:00');

INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('121','80');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('122','80');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('123','80');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('121','81');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('122','81');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('123','81');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('121','82');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('122','82');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('123','82');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('121','83');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('122','83');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('123','83');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('121','84');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('122','84');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('123','84');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('121','85');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('122','85');
INSERT INTO `lemas`.`Betrifft` (`P`,`T`) VALUES ('123','85');

INSERT INTO `lemas`.`Nachricht` (`N`,`gelesen`,`gesendet`,`Text`,`Titel`) VALUES ('101','0','2014-03-01 16:24:12','Hoi Hans! Hast du nächste Woche mal Zeit mir beim Vorbereiten für die Mathe Prüfung zu helfen? \n Grüsse Xavier','Mathe Prüfung');
INSERT INTO `lemas`.`Nachricht` (`N`,`gelesen`,`gesendet`,`Text`,`Titel`) VALUES ('102','1','2014-02-28 08:10:22','Nicht vergessen: Newtonsches Tangentenverfahren Üben!!!','Memo');
INSERT INTO `lemas`.`Nachricht` (`N`,`gelesen`,`gesendet`,`Text`,`Titel`) VALUES ('103','1','2014-02-24 09:22:46','Hey Hansli, weisst du noch wie das Buch heisst, welches wir für ADS kaufen sollen? Merci','Frage wegen ADS Buch');

INSERT INTO `lemas`.`Sender` (`N`,`P`) VALUES ('101','124');
INSERT INTO `lemas`.`Sender` (`N`,`P`) VALUES ('102','121');
INSERT INTO `lemas`.`Sender` (`N`,`P`) VALUES ('103','125');

INSERT INTO `lemas`.`Empfaenger` (`N`,`P`) VALUES ('101','121');
INSERT INTO `lemas`.`Empfaenger` (`N`,`P`) VALUES ('102','121');
INSERT INTO `lemas`.`Empfaenger` (`N`,`P`) VALUES ('103','121');

