create table owners (
    user_id serial primary key,
    user_login varchar(50) unique not null,
    user_password varchar(50) not null,
    fio varchar(50) not null,
    age INTEGER NULL,
    token varchar(50) null
)
    
create table cars (
	car_id serial primary key,
    car_name varchar(50) not null,
    mileage integer not null,
    user_id integer references owners(user_id)
)