create database alunos;

use database alunos;

create table aluno (
	id int AUTO_INCREMENT PRIMARY KEY,
	ra char(10) unique,
	nome varchar(100),
	cidade varchar(30),
	genero smallint );