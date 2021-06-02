/* JDBC Authentication schema */

drop table if exists users cascade;
drop table if exists authorities cascade;   

/* default schema */

/*
create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

insert into users (username,password,enabled) values ('user','pass',1);
insert into users (username,password,enabled) values ('admin','pass',1);
insert into authorities (username, authority) values ('user','ROLE_USER');
insert into authorities (username, authority) values ('admin','ROLE_ADMIN');
insert into authorities (username, authority) values ('admin','ROLE_USER');
*/


/* custom schema */


CREATE TABLE users (
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (email)
);
  
CREATE TABLE authorities (
  email VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES users(email)
);

CREATE UNIQUE INDEX ix_auth_email on authorities (email,authority);

-- User user@email.pass/pass
/*
INSERT INTO bael_users (name, email, password, enabled)
  values ('user',
    'user@email.com',
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
    1);  */


INSERT INTO users (name, email, password, enabled)
  values ('user',
    'user@email.com',
    'pass',
    1);

INSERT INTO authorities (email, authority)
  values ('user@email.com', 'ROLE_USER');  

/*     End    */

drop table AppUser if exists;


create table AppUser 
(Id bigint not null, email varchar(255), firstName varchar(255), 
lastName varchar(255), role varchar(255), username varchar(255), password varchar(255), primary key (Id));



insert into AppUser (email, firstName, lastName, role, username,password, Id) values ('hakula@jakula.com', 'Hakula', 'Fakula', 'ROLE_USER', 'john','$2a$10$UB956BfymabRVmQnRy9nFO4Gaq.HWu7XpsaFMNmOxunxg51QbsenK', 100);

insert into AppUser (email, firstName, lastName, role, username,password, Id) values ('jane@jakula.com', 'Jane', 'Tarzan', 'ROLE_ADMIN', 'jane','$2a$10$UB956BfymabRVmQnRy9nFO4Gaq.HWu7XpsaFMNmOxunxg51QbsenK', 200);