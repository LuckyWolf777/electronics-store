create table if not exists buyer (
    id serial primary key not null,
    buyer_name varchar(30) not null,
    phone_number varchar(50) not null,
    email character varying not null unique,
    bill int not null
);

