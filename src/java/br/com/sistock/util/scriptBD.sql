CREATE TABLE contagem(
	id int AUTO_INCREMENT,
	produto varchar(250),
	data_contagem date,
    tipo_movimentacao varchar(250),
    qtd_movimentacao int, 
    saldo int,
    contagem int, 
    diferenca int, 
    usuario varchar(250),
    data_string varchar(15),
    data_alteracao date,
	PRIMARY KEY (id)
);

CREATE TABLE diferenca(
	id int AUTO_INCREMENT,
	descricao varchar(250),
	data_diferenca varchar(250),
    familia varchar(250),
    total_contagem int, 
    diferenca int,
	PRIMARY KEY (id)
);

CREATE TABLE movimentacao(
	id_movimentacao int AUTO_INCREMENT,
	produto varchar(250),
	tipo_movimentacao varchar(250),
	romaneio varchar(250),
	qtd_pacote int,
	qtd_unidade int,
	data_hora date,
	usuario varchar(250),
	motivo varchar(250),
	data_string varchar(15),
	PRIMARY KEY (id_movimentacao)
);

CREATE TABLE produto(
	id int AUTO_INCREMENT,
	descricao varchar(250),
	familia varchar(250),
	saldo_estoque int,
	codigo varchar(250),
	PRIMARY KEY (id)
);

CREATE TABLE total_entrada(
	id int AUTO_INCREMENT,
	descricao varchar(250),
	data_entrada varchar(250),
	total_pacote int,
	familia varchar(250),
	codigo varchar(250),
	PRIMARY KEY (id)
);

CREATE TABLE total_saida(
	id int AUTO_INCREMENT,
	descricao varchar(250),
	data_saida varchar(250),
	total_pacote int,
	familia varchar(250),
	codigo varchar(250),
	PRIMARY KEY (id)
);

CREATE TABLE usuario(
	id int AUTO_INCREMENT,
	nome varchar(250),
	cpf varchar(250),
	senha varchar(250),
	cargo varchar(250),
	email varchar(250),
	usuario varchar(250),
	PRIMARY KEY (id)
)