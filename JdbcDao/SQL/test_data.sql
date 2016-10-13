insert into cars (car_name, mileage, owner_id) values
('Lada', 150, ),
('BMW', 50, 9),
('Scoda', 100, 3),
('Audi', 25, 5),
('Chevrolett', 15, 6),
('Lada', 10, 4),
('Mazda', 50, 7),
('Toyota', 10, 2),
('Honda', 115, 8),
('KIA', 35, 9),
('Hyundai', 60, 9);

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

insert into car_owner_link (owner_id, car_id) values
(2, 9),
(3, 3),
(6, 4),
(4, 5),
(5, 6),
(7, 7),
(8, 2),
(9, 8),
(10, 10),
(10, 11);