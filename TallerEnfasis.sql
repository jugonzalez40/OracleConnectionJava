create table departamento (
    id_departamento numeric(12,0) primary key,
    nombre_departamento varchar2(150)
);


create table empleado (
    id_empleado numeric(12,0) primary key,
    nombre_empleado varchar2(150),
    fk_id_departamento numeric(12,0),
    constraint foranea_departamento foreign key (fk_id_departamento) references departamento (id_departamento)
);


drop table departamento;
drop table empleado;