select cars.car_name from owners, cars, car_owner_link
where (owners.city = '������')
and (car_owner_link.car_id = cars.car_id)
and (car_owner_link.owner_id = owners.owner_id);

select * from owners, cars, car_owner_link
where (owners.age > 20) and (cars.mileage = 50)
and (car_owner_link.car_id = cars.car_id)
and (car_owner_link.owner_id = owners.owner_id);

select fio from owners
where owner_id in 
(select owner_id from car_owner_link where car_id in
(select car_id from cars where mileage > 100));