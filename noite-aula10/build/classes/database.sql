create database sorveteria;

use sorveteria;

create table sorvetes (

	id int PRIMARY KEY AUTO_INCREMENT,
	sabor char(100),
	tipo char(10),
	cobertura char(15),
	preco decimal(6, 2),
	imagem varchar(255)
);