insert into owners (fio, age, city) values
('Виталий', 28, 'Казань'),
('Кирилл', 18, 'Уфа'),
('Антон', 45, 'Челны'),
('Евгений', 20, 'Казань'),
('Марсель', 19, 'Питер'),
('Виктор', 55, 'Москва'),
('Елена', 25, 'Казань'),
('Аркадий', 29, 'Казань'),
('Владимир', 23, 'Казань');

insert into cars (car_name, mileage) values
('Lada', 150),
('BMW', 50),
('Scoda', 100),
('Audi', 25),
('Chevrolett', 15),
('Lada', 10),
('Mazda', 50),
('Toyota', 10),
('Honda', 115),
('KIA', 35),
('Hyundai', 60);

insert into cars_owners_link (owner_id, car_id) values
(1, 9),
(3, 3),
(6, 4),
(4, 5),
(5, 6),
(7, 7),
(8, 2),
(9, 8),
(2, 0),
(9, 1);