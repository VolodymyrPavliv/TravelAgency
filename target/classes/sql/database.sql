-- Add roles

insert into roles (name) values ('CUSTOMER');
insert into roles (name) values ('MANAGER');

-- Add countries


insert into countries (name) values ('Ukraine');
insert into countries (name) values ('USA');
insert into countries (name) values ('France');
insert into countries (name) values ('Canada');
insert into countries (name) values ('China');
insert into countries (name) values ('Spain');
insert into countries (name) values ('Australia');

-- Add admin

insert into users (email, name, password) VALUES ('adminTravel_agency@gmail.com','admin','$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');
insert into user_roles (user_id, role_id) values (1,2);

-- Add Hotels

insert into hotels (name, description, country) values ('some hotel1','some description1','China');
insert into hotels (name, description, country) values ('some hotel2','some description2','Spain');
insert into hotels (name, description, country) values ('some hotel3','some description3','France');