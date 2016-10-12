create table owner_car (
    owner_id serial primary key,
    fio varchar(50) not null,
    age integer not null,
    city varchar(50) not null
);

create table car (
	car_id serial primary key,
	car_name character varying(50) not null,
	mileage integer not null,
	owner_id integer REFERENCES owner_car(owner_id)
);

create table car_owner_link (
	car_id integer not null,
	owner_id integer not null,
	primary key(car_id, owner_id)
); 
