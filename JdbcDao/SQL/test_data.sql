<<<<<<< HEAD
insert into owners (fio, age, city) values
=======
﻿insert into owners (fio, age, city) values
>>>>>>> a07149e7e0cc46bb32643c923cdc7c576f3fae8e
('Виталий', 28, 'Казань'),
('Кирилл', 18, 'Уфа'),
('Антон', 45, 'Челны'),
('Евгений', 20, 'Казань'),
('Марсель', 19, 'Питер'),
('Виктор', 55, 'Москва'),
('Елена', 25, 'Казань'),
('Аркадий', 29, 'Казань'),
('Владимир', 23, 'Казань');

<<<<<<< HEAD
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
=======
insert into cars (car_name, mileage, owner_id) values
('Lada', 150, 1),
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

insert into cars_owners_link (owner_id, car_id) values
(1, 19),
(3, 13),
(6, 14),
(4, 15),
(5, 16),
(7, 17),
(8, 12),
(9, 18),
(2, 20),
(9, 21);
>>>>>>> a07149e7e0cc46bb32643c923cdc7c576f3fae8e
