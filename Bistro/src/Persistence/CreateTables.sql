/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Felipe
 * Created: 16/09/2016
 */

-- Criando as Tabelas 
-- Tabela de Produtos
CREATE TABLE produtos (
    cod_produto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100),
    unit_price FLOAT,
    qtd_estoque INT
)  ENGINE=INNODB;

-- Tabela de vendas
CREATE TABLE vendas (
    cod_venda INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_venda TIMESTAMP,
    vlr_total FLOAT
)  ENGINE=INNODB;

-- Tabela de itens_venda
CREATE TABLE itens_venda (
    cod_itens_venda INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cod_venda INT,
    cod_produto INT,
    qtd_produto INT,
    valor_unit FLOAT
)  ENGINE=INNODB;

-- Criando as chaves e constraints da Tabela itens Venda 
alter table itens_venda add constraint fk_itens_venda_produto 
foreign key (cod_produto) references produtos (cod_produto);
alter table itens_venda add constraint fk_itens_venda_tbvenda
foreign key (cod_venda) references vendas (cod_venda);