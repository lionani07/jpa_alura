CREATE TABLE clientes (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    CPF VARCHAR(20) NOT NULL
)ENGINE=INNODB;