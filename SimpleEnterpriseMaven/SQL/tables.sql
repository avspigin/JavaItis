create table owner_car (
    owner_id integer not null,
    user_login varchar(50) not null unique,
    fio varchar(50) not null,
    age integer not null,
    city varchar(50) not null,
    primary key (owner_id)
);

create table car (
	car_id integer not null,
	car_name character varying(50) not null,
	mileage integer not null,
	primary key(car_id)	
);

create table car_owner_link (
	car_id integer not null,
	owner_id integer not null,
	primary key(car_id, owner_id)
); 
