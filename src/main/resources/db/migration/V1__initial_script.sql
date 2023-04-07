DROP SCHEMA IF EXISTS rosgian cascade;
CREATE SCHEMA rosgian;

CREATE TABLE rosgian.PHONES (
                               phone_id uuid,
                               phone_name varchar(150),
                               brand_name varchar(150),
                               price int,
                               PRIMARY KEY (phone_id)
);



