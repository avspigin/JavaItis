create table owners (
    owner_id serial primary key,
    fio varchar(50) not null,
    age integer not null,
    city varchar(50) not null
);

create table cars (
	car_id serial primary key,
	car_name character varying(50) not null,
	mileage integer not null,
	owner_id integer REFERENCES owners(owner_id)
);

create table cars_owners_link (
	car_id integer not null,
	owner_id integer not null,
	primary key(car_id, owner_id)
); 
