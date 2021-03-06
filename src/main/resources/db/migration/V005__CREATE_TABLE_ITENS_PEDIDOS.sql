CREATE TABLE itens_pedidos(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    PEDIDO_ID BIGINT NOT NULL,
    PRODUTO_ID BIGINT NOT NULL,
    VALOR_UNITARIO DECIMAL(10, 2) NOT NULL,
    CONSTRAINT FK_PEDIDO FOREIGN KEY (PEDIDO_ID) REFERENCES pedidos(ID),
    CONSTRAINT FK_PRODUTO FOREIGN KEY (PRODUTO_ID) REFERENCES produtos(ID)
)ENGINE=INNODB;

CREATE UNIQUE INDEX IDX_PEDIDO_PRODUTO ON itens_pedidos(PEDIDO_ID, PRODUTO_ID);