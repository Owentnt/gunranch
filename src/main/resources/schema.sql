

CREATE TABLE members
(
    username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);

CREATE TABLE authorities
(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES members (username)
);


create unique index ix_auth_username on authorities (username,authority);
