create table client(
                       id int primary key auto_increment,
                       name varchar(50));

create table planet(
                       id varchar(25) primary key,
                       name varchar(500),
                       CONSTRAINT chk_id_format CHECK (id REGEXP '^[A-Z0-9]*$'));

create table ticket(
                       id int auto_increment primary key,
                       created_at timestamp not null,
                       client_id int not null,
                       from_planet_id varchar(25) not null,
                       to_planet_id varchar(25)not null,
                       FOREIGN KEY (client_id) REFERENCES client(id),
                       FOREIGN KEY (from_planet_id) REFERENCES planet(id),
                       FOREIGN KEY (to_planet_id) REFERENCES planet(id))