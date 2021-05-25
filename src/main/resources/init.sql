drop table AppUser if exists;


create table AppUser 
(Id bigint not null, email varchar(255), firstName varchar(255), 
lastName varchar(255), role varchar(255), username varchar(255), password varchar(255), primary key (Id));



insert into AppUser (email, firstName, lastName, role, username,password, Id) values ('hakula@jakula.com', 'Hakula', 'Fakula', 'ROLE_USER', 'john','pass', 100);

insert into AppUser (email, firstName, lastName, role, username,password, Id) values ('jane@jakula.com', 'Jane', 'Tarzan', 'ROLE_ADMIN', 'jane','pass', 200);