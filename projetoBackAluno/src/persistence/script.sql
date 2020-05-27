 create database bdAlunoRest;
use bdAlunoRest;

 drop table aluno;
create table aluno(id int primary key auto_increment,
 nome varchar(50),
 email varchar (50) unique,
 disciplina varchar (50),
 nota1 double,
 nota2 double,
 senha varchar (250),
 situacao varchar (20),
  foto varchar (250)
  );
 

  insert into aluno values (null,'lu','lu@gmail.com','java',9, 10,
'123456', 'aprovado', 'imagem');
 
 




