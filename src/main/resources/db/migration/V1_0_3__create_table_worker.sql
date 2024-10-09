create table if not exists worker (
    id serial primary key not null,
    worker_name varchar(50) not null,
    phone_number varchar(50) not null unique,
    email varchar(50) not null unique
);
