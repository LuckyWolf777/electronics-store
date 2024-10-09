create table if not exists product (
    id serial primary key not null,
    brand varchar(50) not null,
    model varchar(50) not null unique,
    serial_number character varying not null unique,
    storage_capacity integer not null,
    description character varying not null,
    color varchar(50),
    screen_size varchar(20),
    ram int,
    category varchar(50),
    quantity int not null,
    price int not null
);


