CREATE DATABASE  IF NOT EXISTS emprestou;
USE emprestou;

drop table if exists transacao;
drop table if exists emprestimo;
drop table if exists cliente;

create table cliente (
	id int auto_increment not null primary key,
    nome varchar(40) not null,
    email varchar(16) not null,
    cpf varchar(12) not null,
    rg varchar(12),
    endereco varchar(40),
    renda Double (11,2),
    senha varchar(8) not null
);
;
create table emprestimo (
	numero int not null primary key,
    valor decimal(11,2) default 0,
    parcela int not null,
    id_cliente int
);

alter table emprestimo add constraint
foreign key cliente_fk (id_cliente) references pessoa (id);


create table transacao (
	id int auto_increment not null primary key,
    dataPrimeiraParc datetime not null default current_timestamp,
    valor decimal(11, 2) not null,
    parcela int,
    id_Emprestimo int
);

alter table transacao add constraint
foreign key idEmprestimo_fk (id_Emprestimo) references emprestimo (numero);