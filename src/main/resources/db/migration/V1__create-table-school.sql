create table openschool_school.school
(
    id              uuid not null primary key,
    name            varchar(255) not null,
    street          varchar(255) not null,
    street_number   varchar(255) not null,
    city            varchar(255) not null,
    postal_code     varchar(255) not null,
    federal_state   varchar(255) not null,
    locale          varchar(2) not null
);