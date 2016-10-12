select car.car_name from owner_car, car, car_owner_link
where (owner_car.city = 'Казань')
and (car_owner_link.car_id = car.car_id) 
and (car_owner_link.owner_id = owner_car.owner_id);

select * from owner_car, car, car_owner_link 
where (owner_car.age > 20) and (car.mileage = 50) 
and (car_owner_link.car_id = car.car_id) 
and (car_owner_link.owner_id = owner_car.owner_id);

select fio from owner_car
where owner_id in 
(select owner_id from car_owner_link where car_id in
(select car_id from car where mileage > 100));