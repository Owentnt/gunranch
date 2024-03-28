
--DROP TABLE IF EXISTS COMPETITIONS;
-- CREATE TABLE Users (
--                        ID INT PRIMARY KEY,
--                        FIRST_NAME VARCHAR(50),
--                        LAST_NAME VARCHAR(50),
--                        GENDER CHAR(1),
--                        USERNAME VARCHAR(50),
--                        EMAIL_ADDRESS VARCHAR(100),
--                        PHONE_NUMBER VARCHAR(15),
--                        PASSWORD VARCHAR(100),
--                        ADDRESS VARCHAR(100),
--                        POSTAL_CODE VARCHAR(10),
--                        CITY VARCHAR(50),
--                        SS_ID VARCHAR(20),
--                        enabled BOOLEAN
-- );

CREATE TABLE authorities
(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);

-- CREATE TABLE COMPETITIONS (
--                               ID INT PRIMARY KEY,
--                               TITLE VARCHAR(255),
--                               STARTING_HOUR TIME,
--                               ENDING_HOUR TIME,
--                               DATE DATE,
--                               PARTICIPATION_PRICE DECIMAL(10, 2),
--                               BIO TEXT,
--                               OBJECTIVE TEXT
-- );



create unique index ix_auth_username on authorities (username,authority);

