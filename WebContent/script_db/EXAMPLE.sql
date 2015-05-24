
INSERT INTO mydb. author (NAME, LAST_NAME, EMAIL, PHONE, NATIONALITY, DATA_BIRTH, GENDER, ADDRESS, SPOUSE) VALUES ('Maria', 'de Alencar', 'maria.alencar@teste.com.br', '1114984646', 'Americana', '1981-08-15', 'Feminino', 'Rua Teste 2', 'Robson');

INSERT INTO mydb. author (NAME, LAST_NAME, EMAIL, PHONE, NATIONALITY, DATA_BIRTH, GENDER, ADDRESS, SPOUSE) VALUES ('Pedro', 'Paulo', 'pedro.paulo@teste.com.br', '1186445641', 'Italiano', '1986-08-19', 'Masculino', 'Rua teste 3', 'Josefa');


INSERT INTO mydb. publishing_house (NAME, COMPANY_NAME, EMAIL, CNPJ, IE, SITE, PHONE, ADDRESS) VALUES ('Abril', 'Companhia de Livros Educaticos', 'abril.contato@teste.com.br', '321135411358131', '112', 'http://www.abril.com.br', '119999051', 'Pinheiros');

INSERT INTO mydb. category (DESCRIPTION) VALUES ('Aventura');

INSERT INTO mydb. category (DESCRIPTION) VALUES ('Terror');

INSERT INTO mydb. category (DESCRIPTION) VALUES ('Drama');

INSERT INTO mydb. category (DESCRIPTION) VALUES ('Ficcao Cientifica');


INSERT INTO mydb. book (TITLE, PRICE, ISBN, NUMBER_PAGES, DESCRIPTION, IMAGE_DIRETORY, LIKEBOOK, ID_AUTHOR, ID_PUBLISHING_HOUSE, ID_CATEGORY) VALUES ('The book of trees', '149.99', '1513', '1300', 'See more snippets like this online store item at <a', 'the_book_of_trees.jpg', '3', '1', '1', '3');

INSERT INTO mydb. book (TITLE, PRICE, ISBN, NUMBER_PAGES, DESCRIPTION, IMAGE_DIRETORY, LIKEBOOK, ID_AUTHOR, ID_PUBLISHING_HOUSE, ID_CATEGORY) VALUES ('Game of Thrones', '256.99', '151', '500', 'See more snippets like this online store item at <a', 'danca_dos_dragoes.jpg', '51', '1', '1', '2');

INSERT INTO mydb. book (TITLE, PRICE, ISBN, NUMBER_PAGES, DESCRIPTION, IMAGE_DIRETORY, LIKEBOOK, ID_AUTHOR, ID_PUBLISHING_HOUSE, ID_CATEGORY) VALUES ('Harry Potter', '79.00', '3246', '452', 'See more snippets like this online store item at <a', 'harry_potter_1.jpg', '1451', '1', '1', '1');

INSERT INTO mydb. customer (IS_ADMIN, LOGIN, PASSWORD, NAME, EMAIL, GENDER, PHONE, ADDRESS) VALUES ('1', 'admin', '123', 'Administrator', 'admin@hotmail.com', 'M', '11111111', 'Rua Admins');




