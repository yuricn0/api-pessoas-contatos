INSERT INTO tb_pessoas (nome, endereco, cep, cidade, uf) 
VALUES ('Carlos Pereira', 'Rua C, 789', '03030-000', 'Belo Horizonte', 'MG');

INSERT INTO tb_pessoas (nome, endereco, cep, cidade, uf) 
VALUES ('Ana Oliveira', 'Av. D, 101', '04040-000', 'Curitiba', 'PR');

INSERT INTO tb_pessoas (nome, endereco, cep, cidade, uf) 
VALUES ('Lucas Fernandes', 'Rua E, 202', '05050-000', 'Porto Alegre', 'RS');

INSERT INTO tb_pessoas (nome, endereco, cep, cidade, uf) 
VALUES ('Mariana Santos', 'Travessa F, 303', '06060-000', 'Salvador', 'BA');

INSERT INTO tb_pessoas (nome, endereco, cep, cidade, uf) 
VALUES ('Fernando Costa', 'Praça G, 404', '07070-000', 'Recife', 'PE');

INSERT INTO tb_pessoas (nome, endereco, cep, cidade, uf) 
VALUES ('Maria Souza', 'Av. B, 456', '02020-000', 'Rio de Janeiro', 'RJ');


-- Contatos de Carlos Pereira (ID 1)
INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (1, '(21) 988408788', 1);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (4, 'github.com/carlosp10', 1);

-- Contatos de Ana Oliveira (ID 2)
INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (3, 'linkedin.com/ana-oliveira', 2);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (2, 'ana@email.com', 2);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (1, '(54) 987644554', 2);

-- Contatos de Lucas Fernandes (ID 3)
INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (0, '26298957', 3);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (2, 'fernandes.lucas@email.com', 3);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (4, 'github.com/luquinhas', 3);

-- Contatos de Mariana Santos (ID 4)
INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (1, '(71) 954852635', 4);

-- Contatos de Fernando Costa (ID 5)
INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (0, '45554555', 5);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (1, '(83) 991076124', 5);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (2, 'fernando@email.com', 5);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (3, 'linkedin.com/fernandocosta', 5);

INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (4, 'github.com/fernandocosta', 5);

-- Contatos de Maria Souza (ID 6)
INSERT INTO tb_contatos (tipo_contato, contato, pessoa_id) 
VALUES (1, '(21) 991078736', 6);
