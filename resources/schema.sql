CREATE DATABASE  IF NOT EXISTS emprestou;
USE emprestou;

drop table if exists emprestimo;
drop table if exists cliente;

create table cliente (
	id int auto_increment not null primary key,
    nome varchar(40) not null,
    email varchar(40) not null,
    cpf varchar(12) not null,
    rg varchar(12),
    endereco varchar(60) not null,
    renda Double (11,2)not null,
    senha varchar(8) not null,
    valorEmprestimo decimal(11, 2),
    qtdParcela int
);

create table emprestimo (
	cod int auto_increment not null primary key,
    dataTrasacao datetime not null default current_timestamp,
    dataPrimeiraParc varchar(10) not null,
    valorTotalEmprestimo decimal(11, 2) default 0,
    id_cliente int
);

alter table emprestimo add constraint
foreign key fk_id_cliente (id_cliente) references cliente (id)  ON DELETE CASCADE ON UPDATE CASCADE;

insert into cliente (nome, email, cpf, rg, endereco, renda, senha, valorEmprestimo, qtdParcela) values ('junior','junior@junior.com','32444567898','4345667823', 'Rua Exercicio 1 nota 10', 30000, '1234', null,null);
insert into cliente (nome, email, cpf, rg, endereco, renda, senha, valorEmprestimo,qtdParcela) values ('Carlos','carlos@carlos.com','324225233498','4345127823', 'Rua Exercicio 2 nota 9', 20000, '4321', null,null);
insert into cliente (nome, email, cpf, rg, endereco, renda, senha, valorEmprestimo,qtdParcela) values ('Rodrigo','rodrigo@rodrigo.com','32433578698','4345677823', 'Rua Exercicio 3 nota 8', 25000, '4312', null,null);
insert into cliente (nome, email, cpf, rg, endereco, renda, senha, valorEmprestimo,qtdParcela) values ('junior','junior@junior.com','32444567898','4345667823', 'Rua Exercicio 1 nota 10', 30000, '1234', null,null);

UPDATE cliente SET nome = ?, email = ? , cpf = ?, rg = ?, endereco = ?, renda = ?, senha = "1234" WHERE Id = ?;

DELETE FROM cliente WHERE id = 3;

select * from cliente;

insert into emprestimo (dataPrimeiraParc,valorTotalEmprestimo, id_cliente) values('12-05-2021',30000,1);
insert into emprestimo (dataPrimeiraParc,valorTotalEmprestimo, id_cliente) values('28-07-2021',40000, 2);
insert into emprestimo (dataPrimeiraParc,valorTotalEmprestimo, id_cliente) values('29-10-2021',50000, 3);
insert into emprestimo (dataPrimeiraParc,valorTotalEmprestimo, id_cliente) values('29-08-2021',80000, 4);

select * from emprestimo;

delete from emprestimo where cod = 2 ;

update emprestimo set valorTotalEmprestimo = 30000 where cod = 1;

Select * from cliente order by nome;
select * from emprestimo order by id_cliente;

SELECT c.nome, e.dataPrimeiraParc, e.valorTotalEmprestimo FROM cliente c INNER JOIN emprestimo e ON c.id = e.id_cliente WHERE c.id = 2;

SELECT c.nome, c.renda , e.dataPrimeiraParc , e.valorTotalEmprestimo FROM cliente c INNER JOIN emprestimo e ON c.id = e.id_cliente order by c.nome;
