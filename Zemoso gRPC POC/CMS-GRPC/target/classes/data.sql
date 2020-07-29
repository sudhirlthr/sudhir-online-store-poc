/*drop table if exists COMMENTS CASCADE;
drop table if exists BLOG CASCADE;
drop table if exists POST CASCADE;
drop table if exists USERS CASCADE;*/

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS authorities CASCADE;

create table users(
	userid IDENTITY NOT NULL PRIMARY KEY, 
	username varchar_ignorecase(50),
	password varchar_ignorecase(200) not null,
	enabled boolean not null
);

create table authorities (
	roleid IDENTITY NOT NULL PRIMARY KEY,
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);


insert into users (username, password, enabled) values ('bob', '{noop}123', true);
insert into authorities (username, authority) values ('bob', 'ROLE_USER');
insert into users (username, password, enabled) values ('sara', '{noop}234', true);
insert into authorities (username, authority) values ('sara', 'ROLE_ADMIN');
