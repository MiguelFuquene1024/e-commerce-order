CREATE TABLE IF NOT EXISTS pedido  (
                                     id INT  auto_increment NOT NULL,
                                     name varchar(100) NOT NULL,
                                     products varchar(100) NOT NULL,
                                     cost FLOAT NULL,
                                     state INT NOT NULL,
                                     date INT NOT NULL
                                     CONSTRAINT pedido_pk PRIMARY KEY (id),
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;