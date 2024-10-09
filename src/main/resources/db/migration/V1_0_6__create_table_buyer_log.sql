create table if not exists buyer_log (
    id serial primary key,
    buyer varchar(50),
    product_id varchar(50),
    date_sell timestamp with time zone not null
);