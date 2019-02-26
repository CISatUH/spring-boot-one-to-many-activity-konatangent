create table customer
(
  customer_id serial not null constraint customer_pkey primary key,
  last_name varchar(20) not null,
  first_name varchar(20) not null
);

CREATE TABLE Address
( id serial primary key,
  street_name varchar(20),
  street_number varchar(10),
  state varchar(20),
  zipcode int,
  customer_id integer references customer(customer_id)
);