create table usuarios (
    id bigserial not null,
    login varchar(100) not null,
    clave varchar(300) not null,

    primary key (id)
);
