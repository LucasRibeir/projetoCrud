drop database brRaio;
#nao ensinei
create database bdRaio;
use bdRaio;

create table usuario(id int primary key auto_increment,
nome varchar (50), login varchar (50),
senha varchar (250));


insert into usuario values (null,'alexandre','ale@gmail.com','123');
insert into usuario values (null,'valdir','valdir@gmail.com','123');
insert into usuario values (null,'matheus','matheus@gmail.com','123');

select * from usuario;