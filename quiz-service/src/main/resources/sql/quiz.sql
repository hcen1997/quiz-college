PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE user (
                        id integer PRIMARY KEY AUTOINCREMENT,
                        username varchar(255) DEFAULT NULL,
                    password varchar(255) DEFAULT NULL,
                        usergroup int(10) DEFAULT NULL
);
INSERT INTO user VALUES(1,'test1','12311231',NULL);
INSERT INTO user VALUES(2,'test1','12311231',NULL);
CREATE TABLE `person` (
                          `id` integer PRIMARY KEY AUTOINCREMENT,
                          `name` varchar(255) NOT NULL,
                          `exp` int(11) DEFAULT NULL,
                          `hint` int(11) DEFAULT NULL,
                          `heart` int(11) DEFAULT NULL,
                          `heartp` int(11) DEFAULT NULL,
                          `medle` int(11) DEFAULT NULL,
                          `treastrl` int(11) DEFAULT NULL,
                          `ranking` int(11) DEFAULT NULL
);
INSERT INTO person VALUES(1,'hcen',355,29,5,30,1,4,12000);
INSERT INTO person VALUES(2,'xiaoming',0,20,5,15,0,0,999);
INSERT INTO person VALUES(3,'testNull中文',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('user',2);
INSERT INTO sqlite_sequence VALUES('person',3);
COMMIT;
