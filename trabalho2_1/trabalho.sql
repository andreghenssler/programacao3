create database aulas;
use aulas;
drop table contato;
create table aulas.contato(
	idContato int not null auto_increment,
    primary key (idContato),
    nome varchar(90),
    eMail varchar(125),
	telefone char(16)
);

INSERT INTO contato (nome, eMail, telefone ) values('Andre', 'andrehenssler@gmail.com','51995262803');
select * from contato;