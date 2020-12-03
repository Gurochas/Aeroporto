CREATE DATABASE aeroporto
GO 
USE aeroporto

CREATE TABLE cliente (
cpf			CHAR(11)		PRIMARY KEY,
nome		VARCHAR(100)	NOT NULL,
sobrenome	VARCHAR(100)	NOT NULL,
data_nasc	DATETIME		NOT NULL	CHECK(data_nasc <= GETDATE()),
email		VARCHAR(200)	NOT NULL	UNIQUE,
logradouro	VARCHAR(200)	NOT NULL,
numero		INT				NOT NULL	CHECK(numero > 0),
bairro		VARCHAR(100)	NOT NULL,
cep			CHAR(8)			NOT NULL
)
GO
CREATE TABLE usuario (
usuario		VARCHAR(200)	NOT NULL,
senha		VARCHAR(30)		NOT NULL,
permissao	INT				DEFAULT(1) 
PRIMARY KEY (usuario)
FOREIGN KEY (usuario) REFERENCES cliente(email)
)	
GO
CREATE TABLE compra (
codigo			INT			PRIMARY KEY		IDENTITY(1000,1),
data_compra		DATETIME	NOT NULL		CHECK(data_compra <= GETDATE()),
cpf_cliente		CHAR(11)	NOT NULL,
FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf)
)
GO
CREATE TABLE classe(
tipo	VARCHAR(50)  NOT NULL PRIMARY KEY,
preco	DECIMAL(7,2) NOT NULL	CHECK(preco > 0)
)
GO
CREATE TABLE aviao (
codigo			INT				PRIMARY KEY	IDENTITY(10000,1),
empresa			VARCHAR(100)	NOT NULL,
modelo			VARCHAR(100)	NOT NULL,
qtd_lugares		INT				NOT NULL,
preco			DECIMAL(7,2)	NOT NULL	CHECK(preco > 0)
)
GO
CREATE TABLE destino (
codigo      INT				PRIMARY KEY IDENTITY(100,1),  
destino		VARCHAR(100)	NOT NULL,  
preco       DECIMAL(7,2)	NOT NULL	CHECK(preco > 0)  
)
GO
CREATE TABLE viagem(
codigo			INT				PRIMARY KEY  IDENTITY(1000,1),
data            DATETIME		NOT NULL     CHECK(data <= GETDATE()),
hora			DATETIME		NOT NULL,
aviao_codigo    INT				NOT NULL,
destino_codigo  INT				NOT NULL
FOREIGN KEY (destino_codigo) REFERENCES destino(codigo),
FOREIGN KEY (aviao_codigo) REFERENCES aviao(codigo)
)
GO
CREATE TABLE passagem (
codigo			INT			PRIMARY KEY,
preco_total		INT			NOT NULL	 CHECK(preco_total > 0),
portao			INT			NOT NULL,
lugar			INT			NOT NULL,
cliente_cpf		CHAR(11)	NOT NULL,
codigo_viagem	INT			NOT NULL,
tipo_classe		VARCHAR(50)	NOT NULL,
tipo_viagem     VARCHAR(50)	NOT NULL,
codigo_compra	INT			NOT NULL
FOREIGN KEY (cliente_cpf) REFERENCES cliente(cpf),
FOREIGN KEY (codigo_viagem) REFERENCES viagem(codigo),
FOREIGN KEY (codigo_compra) REFERENCES compra(codigo),
FOREIGN KEY (tipo_classe) REFERENCES classe(tipo)
)

INSERT INTO classe (tipo, preco) VALUES 
('Economica', 1.0),
('Executiva', 1.35),
('Primeira Classe', 1.75)

INSERT INTO cliente (cpf, nome, sobrenome, data_nasc, email, numero, logradouro, bairro, cep) VALUES
('29749653123', 'Diego', 'd', '2001-02-07', 'cliente', 14, 'Rua dos Tubarão', 'Jd das Prima', '08560698'),
('89784185521', 'Darbone', 'Danone', '1996-08-13', 'admin', 14, 'Rua dos Guarana', 'Jd das Oliveira', '04100041'),
('55226243537', 'Madaline', 'Picott', '1999-02-01', 'm.picott@gmail.com', 3512, 'Rua Towne Squares', 'Charla Lane', '48136405'),
('05731461872', 'Isabella', 'Carroll',	'2000-01-18', 'i.carroll@gmail.com', 3649, 'Rua Funk Squares', 'Hidden Valley Road', '48723234'),
('39552514894', 'Jonnhy', 'Silverhand', '1960-12-10', 'f.carroll@gmail.com', 144, 'Av Little Brooks', 'Laurel Lane', '87283793'),
('07578851446', 'Adam', 'Ross', '1980-01-24', 'a.ross@gmail.com', 1036, 'Rua Corkery Summit', 'Memory Lane', '46688594'),
('79501511960', 'Eric', 'Dixon', '1982-09-21',	'e.dixon@gmail.com', 4618, 'Rua Shanahan Isle', 'Bartlett Avenue', '21335802'),
('12686888350', 'Wilson', 'Williams', '1965-02-27', 'w.williams@gmail.com', 234, 'Rua Blanda Spurs', 'Kincheloe Road', '52145220'),
('41276539304', 'Jasmine', 'Hill', '1979-06-29', 'j.hill@gmail.com', 4732, 'Rua Madaline Port', 'Pringle Drive', '92468751'),
('75802135590', 'Abigail', 'Martin', '1992-06-20', 'a.martin@gmail.com', 71, 'Rua Stroman Light', 'Bates Brothers Road', '08231064'),
('56951236585', 'Cherry', 'Fowler', '1968-10-26', 'c.fowler@gmail.com', 595, 'Rua Schoen Summit', 'Hurry Street', '43013500'),
('90462327604', 'Charlie', 'Elliott', '1999-02-23', 'c.elliott@gmail.com', 2800, 'Rua Frankie Corner', 'Cerullo Road', '01186091'),
('76337843509', 'Preston', 'Ferguson',	'1977-07-24', 'p.ferguson@gmail.com', 1021, 'Rua Beer Rapid', 'Sumner Street', '64964684'),
('05272365437', 'Edith', 'Kelley', '1993-01-10', 'e.kelley@gmail.com', 4562, 'Rua Davin Rue', 'Hardesty Street', '57844100'),
('47628833870', 'Jacob', 'Foster', '2000-05-20', 'j.foster@gmail.com', 49, 'Rua Tiara Prairie', 'Nelm Street', '62502795'),
('19158145702', 'Patrick', 'Cole', '1986-12-25', 'p.cole@gmail.com', 389, 'Rua Cronin Village', 'Wood Duck Drive', '87755445'),
('05130528875', 'Frederick', 'Spencer', '1987-09-24', 'f.spencer@gmail.com', 2671, 'Rua Jammie Estate', 'Custer Street', '28416087'),
('79678408872', 'Michelle', 'Scott', '1976-11-13', 'm.scott@gmail.com', 3253, 'Rua Brendan Land', 'Gateway Road', '97899718'),
('09650226176', 'Daisy', 'Barrett', '1997-01-12', 'd.barrett@gmail.com', 128, 'Rua Dach Street', 'Poplar Avenue', '71822787'),
('64761947551', 'Agata', 'Johnston', '2001-03-26', 'a.johnston@gmail.com', 924, 'Rua Lizzie Mountains', 'Augusta Park', '45822496'),
('38291571260', 'April', 'Gray', '1976-02-23', 'a.gray@gmail.com', 272, 'Rua Blick Village', 'Carriage Court', '36236811'),
('08787596890', 'Blake', 'Morgan', '1967-04-29', 'b.morgan@gmail.com', 2803, 'Rua Fahey Expressway', 'Charles Street', '80830127'),
('11524319198', 'Sabrina', 'Douglas', '1970-08-18', 's.douglas@gmail.com', 3602, 'Rua Schmitt Expressway', 'Lighthouse Drive', '48556455'),
('42579755551', 'Elian', 'Bennett', '1972-06-14', 'e.bennett@gmail.com', 3295, 'Rua Friesen Turnpike', 'Boundary Street', '11871613'),
('50141851007', 'Paul', 'Elliott', '1961-05-18', 'p.elliott@gmail.com', 178, 'Rua Natalia Wells', 'Traders Alley', '58844612'),
('59148412082', 'Daniel', 'Myers', '1950-10-19', 'j.chapman@gmail.com', 5412, 'Rua Jalen Key', 'College Street', '97546063'),
('22465476793', 'Richard', 'Montgomery', '1999-07-18', 'r.montgomery@gmail.com', 78, 'Rua Harber Branch', 'High Meadow Lane', '67627747'),
('01613454333', 'April', 'Mason', '1981-09-23', 'a.mason@gmail.com', 348, 'Av Amie Haven', 'Peck Court', '69979801'),
('61786848198', 'Aiden', 'Sunningham',	'1974-05-27', 'a.sunningham@gmail.com', 667, 'Av Senger Lodge', 'Hummingbird Way', '40514039'),
('14181716627', 'Alan', 'Foster', '1992-02-28', 'a.foster@gmail.com', 630, 'Av Hermiston Mews', 'Arrowood Drive', '12384140'),
('40173598250', 'Amber', 'Nelson', '1966-01-20', 'a.nelson@gmail.com', 3456, 'Rua Keely Field', 'Levy Court', '85566770'),
('21556532393', 'Reid', 'Bennett', '1997-07-24', 'r.bennett@gmail.com', 3524, 'Rua Gianni Cliff', 'Eagle Lane', '36929038'),
('75722742775', 'Patrick', 'Thompson',	'2001-11-27', 'p.thompson@gmail.com', 2743, 'Rua Yasmeen Course', 'Ventura Drive', '56485082'),
('68877778350', 'Anna', 'Cunningham', '1984-12-19', 'a.cunningham@gmail.com', 1929, 'Rua Hobart Forges', 'Lyndon Street', '64519760'),
('09243316230', 'Kate', 'Andrews', '1996-09-26', 'k.andrews@gmail.com', 3836, 'Av Dell Springs', 'Strother Street', '35607403'),
('85482122689', 'Kirsten', 'Johnston',	'1973-02-19', 'k.johnston@gmail.com', 1811, 'Rua Rowe Drive', 'Midway Road', '45068743'),
('36937271719', 'Rosie', 'Ross', '2000-10-01',	'r.ross@gmail.com', 4406, 'Rua Jessyca Brooks', 'Hillside Street', '94939561'),
('21714732746', 'Adele', 'Cole', '1988-12-21',	'a.cole@gmail.com', 4936, 'Rua Cheyenne Groves', 'Lynn Avenue', '07402421'),
('37152246653', 'Joyce', 'Richardson',	'1999-11-21', 'j.richardson@gmail.com', 3448, 'Av Brown Islands', 'Providence Lane', '84994262'),
('25933985589', 'Alen', 'Roberts', '1976-04-20', 'a.roberts@gmail.com', 3984, 'Rua Russel Ramp', 'Moonlight Drive', '87803192'),
('83788585617', 'Nicholas', 'Hamilton', '1970-01-20', 'n.hamilton@gmail.com', 1967, 'Av Herzog River', 'Barnes Street', '17366666'),
('31705026702', 'Lydia', 'Ryan', '1990-02-09',	'l.ryan@gmail.com', 1872, 'Rua Wyman Lakes', 'Stiles Street', '81446145'),
('63446715649', 'Amy',	'Rogers', '1994-05-02',	'a.rogers@gmail.com', 837, 'Av Darron Lights', 'Red Bud Lane', '52330741'),
('15652802707', 'Emily', 'Johnson', '1950-02-19', 'e.johnson@gmail.com', 111, 'Rua Patrick Canyon', 'Hiney Road', '81275548'),
('45848640556', 'Jenna', 'Johnston', '1991-02-02', 'j.johnston@gmail.com', 519, 'Av Richard Squares', 'Freed Drive', '33892124'),
('91142656721', 'Eddy', 'Morrison', '1992-03-23', 'e.morrison@gmail.com', 2780, 'Av Brekke Prairie', 'Lynn Ogden Lane', '88596756'),
('56382767000', 'Ted',	'Holmes', '2001-02-09',	't.holmes@gmail.com', 25, 'Rua Laury Mission', 'Alexander Drive', '92564586'),
('54042313434', 'Alen', 'Richardson', '1976-09-18', 'a.richardson@gmail.com', 215, 'Av Zelma Plains', 'Weekley Street', '88119175'),
('81133313108', 'Arthur', 'Bennett', '1983-04-06', 'a.bennett@gmail.com', 1432, 'Rua Green Row', 'Findley Avenue', '65689912'),
('53036558819', 'Samyra', 'Scott', '1990-02-07',	's.scott@gmail.com', 2526, 'Rua McClure Squares', 'Java Lane', '43588487'),
('38948114395', 'Darcy', 'Smith', '1998-03-01', 'd.smith@gmail.com', 2495, 'Rua Billie Manors', 'Blackwell Street', '92686369')

INSERT INTO usuario (usuario, senha, permissao) VALUES
('admin', 'admin', 2),
('cliente', 'cliente', 1),
('j.foster@gmail.com', '123', 1),
('m.picott@gmail.com',  'elo' ,1),
('i.carroll@gmail.com',  'cfkwfow4' ,1),
('f.carroll@gmail.com',  'TUuKb4DQ' ,1),
('a.ross@gmail.com',  'uAC77QRH' ,1),
('e.dixon@gmail.com',  'TM8GMETF' ,1),
('w.williams@gmail.com',  'QuaMUz7c' ,1),
('j.hill@gmail.com',  'bD2FX6Gx' ,1),
('a.martin@gmail.com',  'DwSP7YpL' ,1),
('c.fowler@gmail.com',  'N2LtArBj' ,1),
('c.elliott@gmail.com',  'ScAGktK4' ,1),
('p.ferguson@gmail.com',  'x2WSgBnV' ,1),
('e.kelley@gmail.com',  'CMQnagqj' ,1),
('p.cole@gmail.com',  '2XDxeuZa' ,1),
('f.spencer@gmail.com',  'nqvbtvxg' ,1),
('m.scott@gmail.com',  'MsuzRKjv',1),
('d.barrett@gmail.com',  'xaWtYdx8' ,1),
('a.johnston@gmail.com',  'uUHTHGm6' ,1),
('a.gray@gmail.com',  'XpdVD2V6' ,1),
('b.morgan@gmail.com', 'eUshkmML' ,1),
('s.douglas@gmail.com',  '49L8N4Sk' ,1),
('e.bennett@gmail.com',  'd9F9W3HE' ,1),
('p.elliott@gmail.com',  'jaB5qtxA' ,1),
('j.chapman@gmail.com',  'ajnLyDeS' ,1),
('r.montgomery@gmail.com',  'VMnQcW68' ,1),
('a.mason@gmail.com',  '6uSQyz4N' ,1),
('a.sunningham@gmail.com',  'FmPH5SAS' ,1),
('a.foster@gmail.com',  'bHu2PgNZ' ,1),
('a.nelson@gmail.com',  'JQbZvYmc' ,1),
('r.bennett@gmail.com',  'sk2Fbzn8' ,1),
('p.thompson@gmail.com',  'ExEJc7uJ' ,1),
('a.cunningham@gmail.com',  'dwE9gDW2' ,1),
('k.andrews@gmail.com',  'QBDAnpSR' ,1),
('k.johnston@gmail.com',  'RRFzUJxR' ,1),
('r.ross@gmail.com',  'UbjdQFaE' ,1),
('a.cole@gmail.com',  'cPs78ewZ' ,1),
('j.richardson@gmail.com',  'GcXznLEr' ,1),
('a.roberts@gmail.com',  'q68U8tjK' ,1),
('n.hamilton@gmail.com',  'm9cs7vyj' ,1),
('l.ryan@gmail.com',  'uGmaMJRZ' ,1),
('a.rogers@gmail.com',  'cVwgkbvw' ,1),
('e.johnson@gmail.com',  'NMh7ZdM4' ,1),
('j.johnston@gmail.com',  'TVTnx38m' ,1),
('e.morrison@gmail.com',  'GhrMdjvZ' ,1),
('t.holmes@gmail.com',  '2m5TPYSF' ,1),
('a.richardson@gmail.com',  'PGgHD5eA' ,1),
('a.bennett@gmail.com',  '5ZCdhype' ,1),
('s.scott@gmail.com',  'nSbCHzF5' ,1),
('d.smith@gmail.com',  'GpbMrFRj' ,1)

INSERT INTO destino (destino, preco) VALUES
('Rio de Janeiro', 600),
('Night City', 2500),
('São Paulo', 3500),
('Los Santos', 900),
('Summoners Rift', 1800),
('Nova York', 2000),
('California', 1700),
('Dubai', 3500),
('Lima', 1500),
('Austin', 2500),
('Barcelona', 3000),  
('Varsóvia', 1900),
('Bruxelas', 1500),
('Kingston', 1925),
('Santiago', 550),
('La Paz', 1235),
('Lima', 2000), 
('Berlim', 2890),
('Santo Domingo', 1500),
('Copenhagen', 550),
('Madrid', 1500),
('Dublim', 1500),
('Oslo', 1980),
('Berna', 1950),
('Lisboa', 3500),
('Quieve', 800),
('Cairo', 2300),
('Pequim', 400),
('Tóquio', 1000),
('Kuwait', 2500),
('Damasco', 2500),
('Hyrule', 1550),
('Rivia', 1920),
('Demacia', 600),
('Estocolmo', 900),
('Cairo', 1500),
('Jerusalém', 1500),
('Berna', 1200),
('Curitiba', 1000)

INSERT INTO aviao (empresa, modelo, qtd_lugares, preco)	VALUES
('TAM', 'FX150', '190', 1.6),
('TAM', 'TR100', '230', 1.8),
('TAM', 'R2D2', '300', 2.1),
('TAM', 'H20', '250', 2.0),
('AZUL', 'RTX3090', '500', 4.0),
('AZUL', 'TR100', '230', 1.8),
('AZUL', 'C3PO', '180', 1.5),
('GOL', 'TR100', '230', 1.8),
('GOL', 'TR100', '230', 1.8),
('MILLENIUM', 'C3PO', '180', 1.5),
('MILLENIUM', 'R2D2', '300', 2.1),
('MILLENIUM', 'GTAV', '200', 2.0),
('MILLENIUM', 'RDR', '400', 3.5)
USE aeroporto
SELECT nome + ' ' + sobrenome AS nome_completo FROM cliente ORDER BY LEN(nome + sobrenome) desc 
SELECT d.destino FROM destino d ORDER BY LEN(d.destino) DESC
SELECT * FROM cliente WHERE email = 'cliente'
SELECT * FROM usuario WHERE usuario = 'r.montgomery@gmail.com'ORDER BY usuario asc
SELECT cpf, nome, sobrenome, data_nasc, email, numero, logradouro, bairro, cep FROM cliente WHERE email = 'admin'
SELECT * FROM destino
SELECT * FROM aviao 
SELECT * FROM usuario
SELECT * FROM classe
SELECT * FROM tipo_viagem
SELECT * FROM viagem
SELECT * FROM passagem

-- Usuario
-- Buscar Usuario
SELECT usuario, senha, permissao FROM usuario WHERE usuario = 'admin'

-- Passagem
-- Update Passagem
UPDATE passagem 
SET codigo = '?', preco_total = '?', portao = '?', lugar = '?', cliente_cpf = '?', codigo_viagem = '?', tipo_classe = '?', tipo_viagem = '?', codigo_compra = '?' 
WHERE codigo = '?'

-- Busca passagem 
SELECT p.codigo AS codigo_passagem, p.preco_total, p.portao, p.lugar, tipo_viagem,
cl.preco AS classe_preco, cl.tipo AS classe_tipo,
codigo_viagem, codigo_compra
FROM passagem p, cliente c, classe cl
WHERE p.cliente_cpf = c.cpf 
AND p.tipo_classe = cl.tipo
AND c.cpf = '?'

-- Busca Passagens
SELECT p.codigo AS codigo_passagem, p.preco_total, p.portao, p.lugar, tipo_viagem,
cl.preco AS classe_preco, cl.tipo AS classe_tipo,
codigo_viagem, codigo_compra
FROM passagem p, cliente c, classe cl
WHERE p.cliente_cpf = c.cpf 
AND p.tipo_classe = cl.tipo



-- Viagem
--Busca viagem 
SELECT v.codigo, v.data, v.hora, v.aviao_codigo, v.destino_codigo
FROM viagem v, passagem p, cliente c
WHERE p.cliente_cpf = c.cpf 
AND p.codigo_viagem = v.codigo
AND p.codigo_viagem	 = '?'

--Buscar Viagens
SELECT v.codigo, v.data, v.hora, v.aviao_codigo, v.destino_codigo
FROM viagem v, passagem p, cliente c
WHERE p.cliente_cpf = c.cpf 
AND p.codigo_viagem = v.codigo


-- Compras
-- Listar compras
SELECT co.codigo AS codigo_compra, p.tipo_classe AS classe, 
co.data_compra AS data_compra, p.preco_total AS valor
FROM compra co, cliente c, passagem p
WHERE c.cpf = co.cpf_cliente
AND co.codigo = p.codigo_compra
AND c.cpf = '?'

--Buscar compra
SELECT codigo, data_compra
FROM compra 
WHERE codigo = '?'

-- Busca compras
SELECT codigo, data_compra
FROM compra 

-- Destino
-- Busca Destino
SELECT codigo, destino, preco 
FROM destino 
WHERE codigo = '?'

-- Busca Destinos
SELECT codigo, destino, preco 
FROM destino 


-- Aviao
-- Busca aviao 
SELECT codigo, empresa, modelo, qtd_lugares, preco, qtd_lugares 
FROM Aviao
WHERE codigo = '?'

-- Buscar avioes
SELECT codigo, empresa, modelo, qtd_lugares, preco, qtd_lugares 
FROM Aviao