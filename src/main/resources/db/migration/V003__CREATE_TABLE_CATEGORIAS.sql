CREATE TABLE categorias (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL
)ENGINE=INNODB;

CREATE UNIQUE INDEX IDX_NAME ON categorias (NAME);