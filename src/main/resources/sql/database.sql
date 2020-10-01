insert into roles (name) value ('CUSTOMER');
insert into roles (name) value ('MANAGER');

insert into countries (name) value ('Ukraine');
insert into countries (name) value ('Poland');
insert into countries (name) value ('Czech Republic');
insert into countries (name) value ('UK');
insert into countries (name) value ('France');
insert into countries (name) value ('Spain');
insert into countries (name) value ('Italy');
insert into countries (name) value ('Turkey');

insert into users (email, name, password) VALUES ('adminTravel_agency@gmail.com','admin','$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');
insert into user_roles (user_id, role_id) values (1,2);
