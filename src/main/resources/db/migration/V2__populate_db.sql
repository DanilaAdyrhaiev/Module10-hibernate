insert into client(id, name)
values(1, "Dan"),
(2, "Vika"),
(3, "Vlad"),
(4, "Anna"),
(5, "Gena"),
(6, "Vitalik"),
(7, "Mark"),
(8, "Egor"),
(9, "Skot"),
(10, "Batman");

insert into planet(id, name)
values ('MARS', 'Mars'),
('VEN', 'Venus'),
('EARTH', 'Earth'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');

insert into ticket(created_at, client_id, from_planet_id, to_planet_id) VALUES
(NOW(), 1, 'EARTH', 'MARS'),
(NOW(), 2, 'MARS', 'SAT'),
(NOW(), 3, 'EARTH', 'VEN'),
(NOW(), 4, 'VEN', 'JUP'),
(NOW(), 5, 'JUP', 'EARTH'),
(NOW(), 6, 'EARTH', 'MARS'),
(NOW(), 7, 'MARS', 'VEN'),
(NOW(), 8, 'EARTH', 'SAT'),
(NOW(), 9, 'SAT', 'JUP'),
(NOW(), 10, 'JUP', 'MARS');