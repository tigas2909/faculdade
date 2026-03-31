create table IF NOT EXISTS vendedor(
    codigo int not null primary key,
    nome varchar(50) not null,
    email varchar(80) not null,
    vendas int not null,
    status_vendedor enum('ativo', 'inativo') not null DEFAULT 'ativo'
);