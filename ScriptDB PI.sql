CREATE DATABASE Cordas_e_Musica;
USE Cordas_e_Musica;


-- ________________________Tabelas____________________

-- Tabela Guitarras
CREATE TABLE Guitarras (
GuitarrasID INT NOT NULL AUTO_INCREMENT,
Nome VARCHAR(100),
Marca VARCHAR(20),
Modelo VARCHAR(100),
Fabricacao YEAR,
Cor VARCHAR(20),
Preco INT,
PRIMARY KEY (GuitarrasID)
);

-- Tabela Clientes
CREATE TABLE Clientes (
ClientesID INT NOT NULL AUTO_INCREMENT,
Nome VARCHAR(100),
CPF VARCHAR(20),
Telefone VARCHAR(20),
Email VARCHAR(100),
PRIMARY KEY (ClientesID)
);

-- Tabela Vendas (relacionamento N:N entre Clientes e Guitarras)
CREATE TABLE Vendas (
Vendas_GuitarrasID INT,
Vendas_ClientesID INT,
Data_venda DATE,
PRIMARY KEY (Vendas_GuitarrasID, Vendas_ClientesID),
FOREIGN KEY (Vendas_GuitarrasID) REFERENCES Guitarras (GuitarrasID),
FOREIGN KEY (Vendas_ClientesID) REFERENCES Clientes (ClientesID)
);

-- Inserindo dados na tabela Guitarras
INSERT INTO Guitarras (nome, marca, modelo, fabricacao, cor, preco) VALUES
('gsa60', 'ibanez', 'super strato', '2010', 'sunburst', '1200'),
('custom24', 'prs', 'les paul', '2008', 'vinho', '8000'),
('ja3', 'tagima', 'strato caster', '2020', 'marrom', '2000'),
('rg350', 'ibanez', 'super strato', '2015', 'azul', '2500'),
('se standard', 'prs', 'les paul', '2017', 'verde', '8500'),
('standard', 'fender', 'strato caster', '2012', 'preto', '5650');

-- Inserindo dados na tabela Clientes
INSERT INTO Clientes (Nome, CPF, Telefone, Email) VALUES
('Lucas', '123.456.789-09','11 91234-5678', 'lucas@emailteste.com'),
('Mariana', '987.654.321-00', '21 99876-5432', 'mariana@emailteste.com'),
('Bruno', '741.852.963-10', '81 98765-4321', 'bruno@emailteste.com'),
('Ana', '369.258.147-20', '31 99999-0000', 'ana@emailteste.com'),
('Rafael', '111.222.333-44', '51 91111-2222', 'rafael@emailteste.com'),
('Camila', '555.666.777-88', '61 98888-7777', 'camila@emailteste.com');

-- Colocando dados na tabela Vendas
INSERT INTO Vendas (Vendas_GuitarrasID, Vendas_ClientesID, Data_venda) VALUES
('1', '1', '2020-08-14'),
('2', '2', '2021-03-27'),
('3', '3', '2022-11-09'),
('4', '4', '2023-05-22'),
('5', '5', '2024-01-30'),
('6', '6', '2025-07-19');

-- Exibindo registros das tabelas (SELECT)
SELECT * FROM Clientes;
SELECT * FROM Guitarras;
SELECT * FROM Vendas;
SELECT Nome, Marca FROM Guitarras WHERE Fabricacao > 2015;
SELECT Vendas_GuitarrasID, Vendas_ClientesID FROM Vendas WHERE Data_venda = '2024-01-30';

-- Atualizando registros de tabelas (UPDATE)
UPDATE Clientes SET
Telefone = '99 99999-9999'
WHERE ClientesID = 6;

UPDATE Vendas SET
Data_venda = '2024-06-30'
WHERE Vendas_ClientesID = 6;

UPDATE Guitarras SET
Fabricacao = 1998,
Cor = 'Branco'
WHERE GuitarrasID = 6;

-- Removendo registros de tabelas (DELETE)
DELETE FROM Vendas WHERE Vendas_ClientesID =5;
DELETE FROM Clientes WHERE ClientesID = 5;
DELETE FROM Guitarras WHERE GuitarrasID = 5;
