create table medicos (
    id bigserial not null,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    documento varchar(6) not null unique,
    especialidad varchar(100) not null,
    calle varchar(100) not null,
    distrito varchar(100),
    complemento varchar(100) ,
    numero varchar(20) not null,
    ciudad varchar(100) not null,
    primary key (id)
);

