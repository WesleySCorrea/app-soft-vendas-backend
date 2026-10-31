CREATE TABLE pedido (
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id   VARCHAR(64) NOT NULL,
    status       VARCHAR(20) NOT NULL,
    total        NUMERIC(10,2),
    criado_em    TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE item_pedido (
     id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
     pedido_id       BIGINT NOT NULL REFERENCES pedido(id),
     produto_id      BIGINT NOT NULL,
     nome_produto    VARCHAR(120),
     preco_unitario  NUMERIC(10,2),
     quantidade      INTEGER NOT NULL CHECK (quantidade > 0)
);