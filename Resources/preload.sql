
DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
                               id INT NOT NULL AUTO_INCREMENT,
                               title VARCHAR(150) NOT NULL,
                               isbn VARCHAR(50),
                               price DOUBLE,
                               stock INT,
                               CHECK (stock > 0),
                               publishedDate DATE,
                               author VARCHAR(100),
                               category VARCHAR(100),
                               PRIMARY KEY (isbn)
                   );
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Unlocking Android','1933988673',65.057,24,'2009-04-01','W. Frank Ableson','Open Source');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Android in Action, Second Edition','1935182722',69.511,2,'2011-01-14','W. Frank Ableson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Specification by Example','1617290084',27.847,3,'2011-06-03','Gojko Adzic','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flex 3 in Action','1933988746',115.974,13,'2009-02-02','Tariq Ahmed with Jon Hirschi','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flex 4 in Action','1935182420',61.843,7,'2010-11-15','Tariq Ahmed','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Collective Intelligence in Action','1933988312',87.092,14,'2008-10-01','Satnam Alag','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Zend Framework in Action','1933988320',22.604,10,'2008-12-01','Rob Allen','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flex on Java','1933988797',41.735,10,'2010-10-15','Bernerd Allmon','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Griffon in Action','1935182234',69.773,12,'2012-06-04','Andres Almiray','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('OSGi in Depth','193518217X',118.511,12,'2011-12-12','Alexandre de Castro Alves','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flexible Rails','1933988509',119.270,18,'2008-01-01','Peter Armstrong','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hello! Flex 4','1933988762',54.236,19,'2009-11-01','Peter Armstrong','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Coffeehouse','1884777384',29.253,20,'1997-07-01','Levi Asher','Miscellaneous');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Team Foundation Server 2008 in Action','1933988592',32.591,19,'2008-12-01','Jamil Azher','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Brownfield Application Development in .NET','1933988711',68.436,2,'2010-04-16','Kyle Baley','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('MongoDB in Action','1935182870',59.794,14,'2011-12-12','Kyle Banker','Next Generation Databases');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Distributed Application Development with PowerBuilder 6.0','1884777685',67.744,14,'1998-06-01','Michael J. Barlotta','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Jaguar Development with PowerBuilder 7','1884777864',117.257,20,'1999-08-01','Michael Barlotta','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Taming Jaguar','1884777686',105.409,24,'2000-07-01','Michael J. Barlotta','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('3D User Interfaces with Java 3D','1884777902',26.236,20,'2000-08-01','Jon Barrilleaux','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hibernate in Action','193239415X',73.476,17,'2004-08-01','Christian Bauer','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Persistence with Hibernate','1932394885',112.713,21,'2006-11-01','Christian Bauer','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JSTL in Action','1930110529',50.200,10,'2002-07-01','Shawn Bayern','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iBATIS in Action','1932394826',103.930,8,'2007-01-01','Clinton Begin','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Designing Hard Software','133046192',77.771,22,'1997-02-01','Douglas W. Bennett','Object-Oriented Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hibernate Search in Action','1933988649',62.538,15,'2008-12-21','Emmanuel Bernard','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('jQuery in Action','1933988355',92.094,3,'2008-01-01','Bear Bibeault','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('jQuery in Action, Second Edition','1935182323',44.572,16,'2010-06-01','Bear Bibeault','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Building Secure and Reliable Network Applications','1884777295',93.876,7,'1996-01-01','Kenneth P. Birman','Networking');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Ruby for Rails','1932394699',23.856,4,'2006-05-01','David A. Black','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Well-Grounded Rubyist','1933988657',83.267,12,'2009-04-01','David A. Black','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Website Owner''s Manual','1933988452',66.870,13,'2009-10-01','Paul A. Boag','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('ASP.NET 4.0 in Practice','1935182463',59.051,8,'2011-05-15','Daniele Bochicchio','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hello! Python','1935182080',33.582,10,'2012-02-13','Anthony Briggs','Python');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('PFC Programmer''s Reference Manual','1884777554',36.441,20,'1998-06-01','Richard Brooks','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Graphics File Formats','133034054',76.259,21,'1995-06-01','C. Wayne Brown','Computer Graphics');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Visual Object Oriented Programming','131723979',40.990,14,'1995-02-01','Margaret M. Burnett','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iOS in Practice','1617291269',72.083,2,'2013-11-01','Bear P. Cahill','Mobile Technology');

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER (
                            customerid VARCHAR(70) NOT NULL,
                            name VARCHAR(70) NOT NULL,
                            age INT ,
                            email VARCHAR(80),
                            phone VARCHAR(20),
                            address VARCHAR(150),
                             PRIMARY KEY (customerid)
                      );
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1865bd12e28911536e2','Jami Pittman',24,'jamipittman@sdccd.edu','+1 (840) 486-3880','782 Tilden Avenue, Ryderwood, Georgia, 140');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186adf48fa8807e7347','Velazquez Mason',26,'velazquezmason@sdccd.edu','+1 (941) 409-2547','954 Malta Street, Bridgetown, Montana, 7763');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1863ee78333932878c5','Melton Lynn',23,'meltonlynn@sdccd.edu','+1 (898) 531-2319','841 Roder Avenue, Ruffin, Mississippi, 3486');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186ff3d271a37670d73','Palmer Wong',29,'palmerwong@sdccd.edu','+1 (875) 559-3441','904 Independence Avenue, Tioga, Tennessee, 3181');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1867705d8321bb64a32','Janine Spence',33,'janinespence@sdccd.edu','+1 (840) 424-3269','106 Dewey Place, Knowlton, Arkansas, 1499');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186c7cc8f47d5018015','Decker Nguyen',33,'deckernguyen@sdccd.edu','+1 (920) 580-2203','605 Riverdale Avenue, Courtland, Texas, 9230');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186032a7fe62c94a91c','Buckley Slater',20,'buckleyslater@sdccd.edu','+1 (988) 553-2650','927 River Street, Abrams, Nebraska, 2130');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186d327a36cb57fa729','Burris Elliott',27,'burriselliott@sdccd.edu','+1 (805) 439-2356','109 Madison Street, Watrous, Indiana, 7699');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1863350326ed0fe55f7','Harrell Noble',25,'harrellnoble@sdccd.edu','+1 (958) 416-2141','107 Story Street, Carlos, California, 4082');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc18621c1ea1a3e50b6c8','Spencer Dotson',24,'spencerdotson@sdccd.edu','+1 (925) 442-3212','657 Gold Street, Lumberton, Ohio, 9350');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186186cf7c902f9a664','Malinda Rivas',25,'malindarivas@sdccd.edu','+1 (948) 401-2297','306 Blake Avenue, Graball, Connecticut, 3863');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc18602287179112d9fed','Franks Blankenship',20,'franksblankenship@sdccd.edu','+1 (878) 535-2788','955 Lincoln Avenue, Faxon, New York, 2165');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1867fbb9a4ab0d51a4f','Morris Moran',31,'morrismoran@sdccd.edu','+1 (837) 530-2905','658 Dank Court, Eureka, Vermont, 7761');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc186eeb70daac64a4975','Katheryn Beasley',26,'katherynbeasley@sdccd.edu','+1 (970) 470-2725','570 Newport Street, Catherine, Maryland, 3996');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1863dc955683e9f3e07','Hope Frost',26,'hopefrost@sdccd.edu','+1 (868) 559-3180','621 Nelson Street, Tedrow, Florida, 3208');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc18620989244d51f4e6c','Thelma Knapp',33,'thelmaknapp@sdccd.edu','+1 (935) 500-2439','459 Sullivan Place, Coldiron, Nevada, 4783');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('5fbdc1864b9ca214993407d4','Lula Guzman',28,'lulaguzman@sdccd.edu','+1 (907) 401-2678','255 Broadway , Omar, West Virginia, 2632');


DROP TABLE IF EXISTS ORDERS;
CREATE TABLE ORDERS (
                        orderid VARCHAR(50) NOT NULL PRIMARY KEY ,
                        customerid VARCHAR(50) NOT NULL,
                        orderdate DATE NOT NULL,
                        CONSTRAINT fk_customer_id
                            FOREIGN KEY(customerid) REFERENCES CUSTOMER(customerid)
                            ON UPDATE NO ACTION
                            ON DELETE NO ACTION
);
DROP TABLE IF EXISTS ORDEREDITEMS;
CREATE TABLE ORDEREDITEMS (
                        ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        orderid VARCHAR(50) NOT NULL,
                        CONSTRAINT fk_order_id
                            FOREIGN KEY (orderid) REFERENCES ORDERS(orderid)
                                ON UPDATE NO ACTION
                                ON DELETE NO ACTION,
                        isbn VARCHAR(50) NOT NULL,
                        CONSTRAINT fk_book_isbn
                            FOREIGN KEY (isbn) REFERENCES BOOKS(isbn)
                                ON UPDATE NO ACTION
                                ON DELETE NO ACTION,
                        quantity INT,
                        CHECK (quantity >= 1),
);
