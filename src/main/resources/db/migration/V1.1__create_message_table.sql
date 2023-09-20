CREATE TABLE Message (
    messageid int NOT NULL AUTO_INCREMENT,
    sender varchar(255) ,
    recipient varchar(255) ,
    content varchar(255),
    PRIMARY KEY (messageid)
);