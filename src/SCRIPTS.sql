create database universidade;

CREATE TABLE curso (
	iden int ,
    ano int,
    nome varchar(255),
    PRIMARY KEY (iden, nome)
);

create table disciplina(
	nome varchar(255) primary key,
    ch int,
    iden_curso int,
	foreign key (iden_curso) references curso(iden)
);

/*auxiliares*/

select * from curso order by iden;
select * from disciplina order by iden_curso;

TRUNCATE TABLE disciplina;
TRUNCATE TABLE curso;
