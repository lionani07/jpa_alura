CREATE TABLE produtos(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    CATEGORIA_ID BIGINT NOT NULL,
    NOME VARCHAR(100) NOT NULL,
    VALOR DECIMAL(10, 2) NOT NULL,
    CONSTRAINT FK_CATEGORIA FOREIGN KEY (CATEGORIA_ID) REFERENCES categorias(ID)
)ENGINE=INNODB;