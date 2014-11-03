
    CREATE DATABASE lemas;
    USE lemas;
	
    CREATE TABLE Person
                (	P  		INT			NOT NULL AUTO_INCREMENT,
			Email		VARCHAR(255)		NOT NULL,
			Pusername	VARCHAR(255)		NOT NULL,
			Pvorname	VARCHAR(255)		NOT NULL,
  			Pnachname	VARCHAR(255)		NOT NULL,
			Pw		VARCHAR(255)		NOT NULL,
                 	PRIMARY KEY (P)					)
			ENGINE=InnoDB;	
	
    CREATE TABLE Klasse
                (	K		INT	                NOT NULL AUTO_INCREMENT,
			Kname		VARCHAR(255)     	NOT NULL,							
                  	PRIMARY KEY (K)					)
			ENGINE=InnoDB;
	
    CREATE TABLE Mitglied
                (	P  		INT               	NOT NULL,
			K      		INT  	                NOT NULL,
                  	FOREIGN KEY (P)  REFERENCES Person (P),
			FOREIGN KEY (K)  REFERENCES Klasse (K),
                  	UNIQUE (P)					)
			ENGINE=InnoDB;
 
    CREATE TABLE Administratorwechsel
                  (	Pneu  		INT                	NOT NULL,
                   	Palt  		INT            		NOT NULL,
			K      	        INT	                NOT NULL,
                  	FOREIGN KEY (Pneu)  REFERENCES Person (P),
			FOREIGN KEY (Palt)  REFERENCES Person (P),
                  	FOREIGN KEY (K)  REFERENCES Klasse (K),
                  	UNIQUE (K)					)
			ENGINE=InnoDB;    
    
    CREATE TABLE Antrag
                  (	P  		INT                 	NOT NULL,
			K      	     	INT                 	NOT NULL,
                  	FOREIGN KEY (P)  REFERENCES Person (P),
			FOREIGN KEY (K)  REFERENCES Klasse (K),
                  	UNIQUE (P,K)					)
			ENGINE=InnoDB;
    
    CREATE TABLE Einladung
                  (	P  		INT                 	NOT NULL,
			K      	      	INT                 	NOT NULL,
                  	FOREIGN KEY (P)  REFERENCES Person (P),
			FOREIGN KEY (K)  REFERENCES Klasse (K),
                  	UNIQUE (P,K)					)
			ENGINE=InnoDB;

    CREATE TABLE Klassenadministrator
                  (	P  		INT                 	NOT NULL,
			K     	      	INT                 	NOT NULL,
                  	FOREIGN KEY (P)  REFERENCES Person (P),
			FOREIGN KEY (K)  REFERENCES Klasse (K),
                  	UNIQUE (K),							
                  	UNIQUE (P)					)
			ENGINE=InnoDB;	
	
    CREATE TABLE Nachricht
                  (	N  		INT                 	NOT NULL AUTO_INCREMENT,
			gelesen       	BOOLEAN     	    	NOT NULL,
			gesendet	DATETIME		NOT NULL,
			Text     	VARCHAR(10000)      	NOT NULL,
			Titel     	VARCHAR(255)  	      	NOT NULL,
                  	UNIQUE (N)					)
			ENGINE=InnoDB;					
 	
    CREATE TABLE Sender
                  (	N  		INT                	NOT NULL,
			P             	INT              	NOT NULL,
                  	FOREIGN KEY (P)  REFERENCES Person (P),
                  	FOREIGN KEY (N)  REFERENCES Nachricht (N),                 
                  	UNIQUE (P,N)					)
			ENGINE=InnoDB;		
                  
    CREATE TABLE Empfaenger
                  (	N  		INT                 	NOT NULL,
			P             	INT              	NOT NULL,
                  	FOREIGN KEY (P)  REFERENCES Person (P),
                  	FOREIGN KEY (N)  REFERENCES Nachricht (N),   
                  	UNIQUE (P,N)					)
			ENGINE=InnoDB;		                

    CREATE TABLE Termin
                    (	T  		INT                 	NOT NULL AUTO_INCREMENT,
			Tname      	VARCHAR(255)        	NOT NULL,
			Beschreibung  	VARCHAR(10000)      	NOT NULL,
                    	Datum       	DATETIME		NOT NULL,											
                    	UNIQUE (T)					)
			ENGINE=InnoDB;
	
    CREATE TABLE Betrifft
                    (	P 		INT                 	NOT NULL,
			T      	      	INT                 	NOT NULL,
                    	FOREIGN KEY (P)  REFERENCES Person (P),
			FOREIGN KEY (T)  REFERENCES Termin (T),							
                    	UNIQUE (P,T)					)
			ENGINE=InnoDB;			
	
    CREATE TABLE Reminder
                    (	T  		INT                 	NOT NULL,
                    	Datum         	DATETIME		NOT NULL,
                      Checked   INT               NOT NULL,
                    	FOREIGN KEY (T)  REFERENCES Termin (T),							
                    	UNIQUE (T)					)
			ENGINE=InnoDB;	
	
    CREATE TABLE Ordner
                    (	O  		INT                 	NOT NULL AUTO_INCREMENT,						
                    	UNIQUE (O)					)
			ENGINE=InnoDB;	
	
    CREATE TABLE Datei
                    (	O  		INT                  	NOT NULL,
			Dname  		VARCHAR(255)         	NOT NULL,
			D  		INT                  	NOT NULL,
                    	Webpfad       	VARCHAR(255)         	NOT NULL,
                    	Root          	VARCHAR(255)         	NOT NULL,
			FOREIGN KEY (O)  REFERENCES Ordner (O),							
                    	UNIQUE (O,D)					)
			ENGINE=InnoDB;	
                    
    CREATE TABLE Zugriff
                    (	O  		INT                 	NOT NULL,
			K  		INT                  	NOT NULL,						   
			FOREIGN KEY (K)  REFERENCES Klasse (K),							
                    	UNIQUE (K)					)
			ENGINE=InnoDB;
		
	  CREATE TABLE Text
                  (	Tno		INT                 	NOT NULL AUTO_INCREMENT,
			Text		VARCHAR(5000)        	NOT NULL,							
                  	UNIQUE (Tno)					)
			ENGINE=InnoDB;
                  
    grant select on Person       		to public;
    grant select on Mitglied     		to public;
    grant select on Antrag     	  		to public;
    grant select on Einladung     		to public;    
    grant select on Klassenadministrator	to public;
    grant select on Nachricht     		to public;
    grant select on Sender        		to public;    
    grant select on Empfaenger    		to public;     
    grant select on Klasse  			to public;
    grant select on Betrifft 			to public;
    grant select on Termin	      		to public;
    grant select on Reminder      		to public;
    grant select on Ordner  		  	to public;
    grant select on Datei	  		to public;
    grant select on Zugriff  		  	to public;
    grant select on Text    		  	to public;
