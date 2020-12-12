
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
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Android in Action, Second Edition','1935182722',69.511,20,'2011-01-14','W. Frank Ableson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Specification by Example','1617290084',27.847,30,'2011-06-03','Gojko Adzic','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flex 3 in Action','1933988746',115.974,13,'2009-02-02','Tariq Ahmed with Jon Hirschi','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flex 4 in Action','1935182420',61.843,17,'2010-11-15','Tariq Ahmed','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Collective Intelligence in Action','1933988312',87.092,14,'2008-10-01','Satnam Alag','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Zend Framework in Action','1933988320',22.604,10,'2008-12-01','Rob Allen','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flex on Java','1933988797',41.735,10,'2010-10-15','Bernerd Allmon','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Griffon in Action','1935182234',69.773,12,'2012-06-04','Andres Almiray','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('OSGi in Depth','193518217X',118.511,12,'2011-12-12','Alexandre de Castro Alves','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Flexible Rails','1933988509',119.270,18,'2008-01-01','Peter Armstrong','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hello! Flex 4','1933988762',54.236,19,'2009-11-01','Peter Armstrong','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Coffeehouse','1884777384',29.253,20,'1997-07-01','Levi Asher','Miscellaneous');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Team Foundation Server 2008 in Action','1933988592',32.591,19,'2008-12-01','Jamil Azher','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Brownfield Application Development in .NET','1933988711',68.436,12,'2010-04-16','Kyle Baley','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('ASP.NET MVC 4 in Action','1617290416',99.677,19,'2012-05-25','Jeffrey Palermo','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('EJB 3 in Action','1933988347',83.044,17,'2007-04-01','Debu Panda','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('EJB 3 in Action, Second Edition','1935182994',7.316,17,'2014-04-07','Debu Panda','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Explorer''s Guide to the Semantic Web','1932394206',97.657,19,'2004-06-01','Thomas B. Passin','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Practical LotusScript','1884777767',83.861,13,'1999-05-01','Anthony Patton','Business');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Domino Development with Java','1930110049',27.379,17,'2000-08-01','Anthony Patton','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Windows PowerShell in Action','1932394907',31.300,13,'2007-02-01','Bruce Payette','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Windows PowerShell in Action, Second Edition','1935182137',53.748,22,'2011-05-15','Bruce Payette','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Silverlight 4 in Action, Revised Edition','1935182374',81.399,12,'2010-10-04','Pete Brown','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Silverlight 5 in Action','1617290319',92.279,13,'2012-06-01','Pete Brown','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hibernate Quickly','1932394419',46.902,15,'2005-08-01','Patrick Peak','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Generative Art','1935182625',16.602,19,'2011-06-30','Matt Pearson','Algorithmic Art');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Windows Phone 7 in Action','1617290092',83.717,18,'2012-08-21','Timothy Binkley-Jones','Mobile Technology');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Lift in Action','1935182803',73.467,13,'2011-11-18','Timothy Perrett','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Web Development with Apache and Perl','1930110065',54.558,17,'2002-04-01','Theo Petersen','Perl');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Real-World Functional Programming','1933988924',36.486,22,'2009-12-01','Tomas Petricek with Jon Skeet','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Machine Learning in Action','1617290181',70.981,18,'2012-04-04','Peter Harrington','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Dependency Injection','193398855X',65.314,12,'2009-08-01','Dhanji R. Prasanna','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Understanding Enterprise SOA','1932394591',45.586,15,'2005-11-01','Eric Pulier and Hugh Taylor','Theory');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Open-Source ESBs in Action','1933988215',68.465,12,'2008-09-01','Tijs Rademakers','Business');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Activiti in Action','1617290122',20.343,17,'2012-07-12','Tijs Rademakers','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('DSLs in Boo: Domain-Specific Languages in .NET','1933988606',88.404,15,'2010-01-01','Oren Eini writing as Ayende Rahien','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JUnit Recipes','1932394230',74.587,14,'2004-07-01','J. B. Rainsberger with contributions by Scott Stirling','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('wxPython in Action','1932394621',93.419,21,'2006-03-01','Noel Rappin','Python');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Clojure in Action','1935182595',63.951,17,'2011-11-15','Amit Rathore','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Scala in Action','1935182757',90.033,22,'2013-04-09','Nilanjan Raychaudhuri','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Working with Objects','134529308',49.449,22,'1995-08-01','Trygve Reenskaug','Object-Oriented Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('PHP in Action','1932394753',44.888,23,'2007-07-01','Dagfinn Reiersøl with Marcus Baker','PHP');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Secrets of the JavaScript Ninja','193398869X',55.275,12,'2012-12-27','John Resig','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Microsoft Office Essentials','132623129',71.521,15,'1996-07-01','Ronny Richardson','Business');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Swing','1884777848',99.256,13,'1999-12-01','Matthew Robinson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Awesome Power of Java Beans','1884777562',83.375,12,'1998-05-01','Lawrence H. Rodrigues','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Personal Videoconferencing','013268327X',57.259,12,'1996-06-01','Evan Rosen','Networking');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Cloud at Your Service','1935182528',41.238,13,'2010-11-22','Jothy Rosenberg','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Implementing Elliptic Curve Cryptography','1884777694',10.551,19,'1998-11-01','Michael Rosing','Theory');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SOA Patterns','1933988266',64.022,13,'2012-09-12','Arnon Rotem-Gal-Oz','SOA');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hello World!','1933988495',84.545,13,'2009-03-01','Warren D. Sande','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SCBCD Exam Study Kit','1932394400',30.332,13,'2005-06-01','Paul Sanghera','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Portlets in Action','1935182544',14.063,14,'2011-09-16','Ashish Sarin','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SWT/JFace in Action','1932394273',24.221,22,'2004-11-01','Matthew Scarpino','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('OpenCL in Action','1617290173',88.422,20,'2011-11-14','Matthew Scarpino','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Multiprotocol over ATM','138892709',51.334,21,'1998-03-01','Andrew Schmidt','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Dependency Injection in .NET','1935182501',0.333,16,'2011-10-03','Mark Seemann','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java 3D Programming','1930110359',19.940,11,'2002-03-01','Daniel Selman','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Liferay in Action','193518282X',53.457,17,'2011-09-20','Richard Sezov','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JSP Tag Libraries','193011009X',17.542,11,'2001-05-01','Gal Shachor','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Instant Messaging in Java','1930110464',20.117,18,'2002-03-01','Iain Shigeoka','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Applets and Channels Without Programming','1884777392',77.158,15,'1999-12-01','Ronny Richardson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('PowerShell in Practice','1935182005',50.350,15,'2010-06-08','Richard Siddaway','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('PowerShell and WMI','1617290114',66.439,17,'2012-04-30','Richard Siddaway','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Making Sense of Java','132632942',67.311,15,'1996-06-01','Bruce Simpson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('C++/CLI in Action','1932394818',38.947,12,'2007-04-01','Nishant Sivakumar','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('C# in Depth','1933988363',10.573,19,'2008-04-01','Jon Skeet','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Magical A-Life Avatars','1884777589',18.076,12,'2000-12-01','Peter Small','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Becoming Agile','1933988258',43.299,18,'2009-05-01','Greg Smith','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('ActiveMQ in Action','1933988940',92.523,17,'2011-03-31','Bruce Snyder','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Implementing PeopleSoft Financials','138411808',78.653,11,'1997-01-01','Early Stephens','Business');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SQL Server DMVs in Action','1935182730',76.137,20,'2011-05-09','Ian W. Stirk','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Scala in Depth','1935182706',80.734,16,'2012-05-14','Joshua D. Suereth','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JMX in Action','1930110561',15.970,22,'2002-09-01','Benjamin G. Sullins','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('EJB Cookbook','1930110944',82.211,18,'2003-05-01','Benjamin G. Sullins','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('GWT in Action, Second Edition','1935182846',71.656,15,'2013-01-21','Adam Tacy','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JUnit in Action, Second Edition','1935182021',87.216,16,'2010-07-01','Petar Tahchiev','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Bitter Java','193011043X',75.075,10,'2002-03-01','Bruce A. Tate','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Bitter EJB','1930110952',89.777,16,'2003-05-01','Bruce Tate','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring Batch in Action','1935182951',51.628,16,'2011-10-01','Arnaud Cogoluegnes','In Action');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JDK 1.4 Tutorial','1930110456',64.777,19,'2002-03-01','Gregory M. Travis','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iPhone and iPad in Action','1935182587',10.965,12,'2010-08-01','Brandon Trebitowski','Mobile Technology');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SQL Server 2005 Reporting Services in Action','1932394761',8.684,11,'2006-11-01','Bret Updegraff','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Ten Years of UserFriendly.Org','1935182129',65.343,21,'2008-12-01','JD','Miscellaneous');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Graphics Programming with Perl','1930110022',82.627,12,'2002-05-01','Martien Verbruggen','Computer Graphics');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('RabbitMQ in Action','1935182978',69.945,21,'2012-04-20','Alvaro Videla','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('XDoclet in Action','1932394052',11.653,10,'2003-11-01','Craig Walls','XML');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring in Action','1932394354',6.303,18,'2005-02-01','Craig Walls','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring in Action, Second Edition','1933988134',86.455,18,'2007-08-01','Craig Walls with Ryan Breidenbach','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring in Action, Third Edition','1935182358',72.062,17,'2011-06-21','Craig Walls','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring in Practice','1935182056',85.185,13,'2013-05-09','Willie Wheeler with Joshua White','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java 2 Micro Edition','1930110332',93.817,14,'2002-03-01','James P. White','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SharePoint 2010 Workflows in Action','1935182714',51.379,17,'2011-02-07','Phil Wicklund','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SharePoint 2010 Web Parts in Action','1935182773',26.009,10,'2011-04-24','Wictor Wilén','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('C++ Concurrency in Action','1933988770',61.948,12,'2012-02-24','Anthony Williams','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Servlets by Example','188477766X',28.805,14,'2002-12-01','Alan R. Williamson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('XML Programming with VB and ASP','1884777872',54.838,17,'1999-12-01','Mark Wilson','XML');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Oracle8i Database Administration','1884777783',45.550,23,'1999-11-01','Noel Yuhanna','Client-Server');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Node.js in Action','1617290572',11.072,23,'2013-10-15','Mike Cantelon','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('MongoDB in Action','1935182870',85.917,18,'2011-12-12','Kyle Banker','Next Generation Databases');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Taming Jaguar','1884777686',99.924,11,'2000-07-01','Michael J. Barlotta','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('3D User Interfaces with Java 3D','1884777902',27.306,18,'2000-08-01','Jon Barrilleaux','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hibernate in Action','193239415X',97.987,18,'2004-08-01','Christian Bauer','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Persistence with Hibernate','1932394885',97.410,14,'2006-11-01','Christian Bauer','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JSTL in Action','1930110529',72.915,10,'2002-07-01','Shawn Bayern','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iBATIS in Action','1932394826',96.428,19,'2007-01-01','Clinton Begin','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Designing Hard Software','133046192',44.293,13,'1997-02-01','Douglas W. Bennett','Object-Oriented Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hibernate Search in Action','1933988649',115.327,15,'2008-12-21','Emmanuel Bernard','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('jQuery in Action','1933988355',30.752,20,'2008-01-01','Bear Bibeault','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('jQuery in Action, Second Edition','1935182323',52.325,18,'2010-06-01','Bear Bibeault','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Building Secure and Reliable Network Applications','1884777295',45.296,19,'1996-01-01','Kenneth P. Birman','Networking');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Ruby for Rails','1932394699',22.057,10,'2006-05-01','David A. Black','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Well-Grounded Rubyist','1933988657',64.068,14,'2009-04-01','David A. Black','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Website Owner''s Manual','1933988452',114.327,24,'2009-10-01','Paul A. Boag','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('ASP.NET 4.0 in Practice','1935182463',52.026,22,'2011-05-15','Daniele Bochicchio','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hello! Python','1935182080',72.697,17,'2012-02-13','Anthony Briggs','Python');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('PFC Programmer''s Reference Manual','1884777554',88.668,16,'1998-06-01','Richard Brooks','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Graphics File Formats','133034054',113.834,16,'1995-06-01','C. Wayne Brown','Computer Graphics');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Visual Object Oriented Programming','131723979',68.518,18,'1995-02-01','Margaret M. Burnett','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iOS in Practice','1617291269',53.978,11,'2013-11-01','Bear P. Cahill','Mobile Technology');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iPhone in Action','193398886X',94.872,12,'2008-12-01','Christopher Allen','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Silverlight 2 in Action','1933988428',42.706,15,'2008-10-31','Chad A. Campbell','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Quick Python Book, Second Edition','193518220X',24.923,11,'2010-01-01','Naomi R. Ceder','Python');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Internet and Intranet Applications with PowerBuilder 6','1884777600',59.892,18,'2000-12-01','Tom Cervenka','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Practical Methods for Your Year 2000 Problem','188477752X',25.137,12,'1998-01-01','Robert Chapman','Business');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Mobile Agents','1884777368',41.365,17,'1997-03-01','William R. Cockayne and Michael Zyda','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring Dynamic Modules in Action','1935182307',66.990,14,'2010-09-04','Arnaud Cogoluegnes','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SQL Server 2008 Administration in Action','193398872X',24.271,11,'2009-08-01','Rod Colledge','Microsoft');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Android in Practice','1935182927',46.012,19,'2011-09-30','Charlie Collins','Mobile Technology');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Object Oriented Perl','1884777791',71.246,12,'1999-08-01','Damian Conway','Object-Oriented Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('GWT in Practice','1933988290',38.697,18,'2008-04-01','Robert Cooper','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Ajax in Action','1932394613',99.331,24,'2005-10-01','Dave Crane','XML');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Ajax in Practice','1932394990',62.216,14,'2007-06-01','Dave Crane','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Prototype and Scriptaculous in Action','1933988037',81.624,14,'2007-04-01','Dave Crane','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('POJOs in Action','1932394583',103.142,17,'2006-01-01','Chris Richardson','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Data Munging with Perl','1930110006',65.600,14,'2001-01-01','David Cross','Perl');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Hello! HTML5 & CSS3','1935182897',72.041,13,'2012-10-17','Rob Crowther','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Seam in Action','1933988401',59.741,13,'2008-08-01','Dan Allen','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Wicket in Action','1932394982',23.944,18,'2008-08-01','Martijn Dashorst','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Open Source SOA','1933988541',47.130,12,'2009-05-01','Jeff Davis','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Struts 2 in Action','193398807X',38.571,18,'2008-05-01','Donald Brown','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Essential Guide to Peoplesoft Development and Customization','1884777929',78.067,18,'2000-08-01','Tony DeLia','Client-Server');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('.NET Multithreading','1930110545',103.942,18,'2002-11-01','Alan Dennis','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SCWCD Exam Study Kit Second Edition','1932394389',92.204,16,'2005-05-01','Hanumant Deshmukh','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Spring Roo in Action','193518296X',89.023,18,'2012-04-13','Ken Rimple','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SOA Governance in Action','1617290270',77.938,11,'2012-07-27','Jos Dirksen','java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('RSS and Atom in Action','1932394494',29.408,12,'2006-03-01','Dave Johnson','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('LDAP Programming, Management and Integration','1930110405',105.365,14,'2002-11-01','Clayton Donley','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Mule in Action','1933988967',84.142,16,'2009-07-01','David Dossot','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Foundation Classes','1884777678',79.379,20,'2001-10-01','Stephen C. Drye','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Managing Components with Modeler','1932394524k-e',103.287,12,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Command-line Processing with CLI','1932394524l-e',110.563,15,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Understanding and Using Chain','1932394524m-e',105.008,20,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Working with the Logging and Discovery Components','1932394524n-e',25.390,17,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Uploading files with FileUpload','1932394524b-e',36.075,22,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Handling Protocols with the Net Component','1932394524c-e',67.644,16,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('XML Parsing with Digester','1932394524d-e',118.901,14,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JXPath and Betwixt: Working with XML','1932394524e-e',90.409,12,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Validating Data with Validator','1932394524f-e',34.496,12,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Enhancing Java Core Libraries with Collections','1932394524g-e',65.569,21,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Enhancing Java Core Libraries with BeanUtils and Lang','1932394524h-e',44.072,15,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Pool and DBCP: Creating and Using Object Pools','1932394524i-e',103.472,12,'2005-03-01','Vikram Goyal','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Python and Tkinter Programming','1884777813',55.718,16,'2000-01-01','John E. Grayson','Python');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Microsoft.NET for Programmers','1930110197',102.349,20,'2002-12-01','Fergal Grimes','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Grails in Action','1933988932',86.689,18,'2009-05-01','Glen Smith','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Up to Speed with Swing, Second Edition','1884777759',113.227,12,'1999-10-01','Steven Gutz','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('OSGi in Action','1933988916',26.098,12,'2011-04-06','Richard S. Hall','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('GWT in Action','1933988231',32.165,17,'2007-06-01','Robert Hanson','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Quick Python Book','1884777740',105.665,18,'1999-10-01','Daryl Harms','Python');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SharePoint 2010 Site Owner''s Manual','1933988754',80.550,20,'2012-02-13','Yvonne M. Harryman','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Development with Ant','1930110588',29.459,18,'2002-08-01','Erik Hatcher','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Lucene in Action','1932394281',76.958,11,'2004-12-01','Erik Hatcher','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Lucene in Action, Second Edition','1933988177',72.571,11,'2010-07-09','Erik Hatcher','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('PowerBuilder 6.0 Questions & Answers','1884777708',104.658,22,'1998-07-01','Tim Hatton','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Awesome Power of PowerJ','1884777538',27.080,19,'1998-05-01','Tim Hatton','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Awesome Power of Power++','1884777546',117.099,12,'1998-06-01','Tim Hatton','PowerBuilder');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Azure in Action','193518248X',65.555,13,'2010-10-22','Chris Hay','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Metaprogramming in .NET','1617290262',65.269,11,'2012-12-31','Kevin Hazzard','Microsoft/.NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Code Generation in Action','1930110979',22.149,13,'2003-07-01','Jack Herrington','Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Illustrated Guide to HTTP','138582262',44.028,18,'1997-03-01','Paul S. Hethmon','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Agile ALM','1935182633',72.392,17,'2011-08-20','Michael Hüttermann','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Java Network Programming, Second Edition','188477749X',24.567,22,'1999-05-01','Merlin Hughes','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Struts in Action','1932394249',91.538,18,'2002-10-01','Ted N. Husted','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Camel in Action','1935182366',39.662,12,'2011-01-04','Claus Ibsen','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Taming Text','193398838X',91.475,15,'2012-12-31','Grant S. Ingersoll','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('JBoss in Action','1933988029',25.888,22,'2009-01-01','Javid Jamae','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Gnuplot in Action','1933988398',43.616,18,'2009-08-01','Philipp K. Janert','Computer Graphics');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Extending and Embedding Perl','1930110820',43.142,14,'2002-08-01','Tim Jenness','Perl');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('iOS 4 in Action','1617290017',72.749,7,'2011-06-09','Jocelyn Harrington','Mobile Technology');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Elements of Programming with Perl','1884777805',43.175,12,'1999-10-01','Andrew L. Johnson','Perl');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Learn Windows PowerShell in a Month of Lunches','1617290211',85.478,18,'2011-04-15','Don Jones','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('R in Action','1935182390',61.906,18,'2011-08-15','Robert I. Kabacoff','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('SOA Security','1932394680',76.961,13,'2007-12-01','Ramarao Kanneganti','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Rails 3 in Action','1935182277',44.583,12,'2011-09-20','Ryan Bigg','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Continuous Integration in .NET','1935182552',96.211,15,'2011-03-14','Marcin Kawalerowicz','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Technology Paradise Lost','1932394133',39.833,11,'2004-03-01','Erik Keller','Business');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Kermit 95+','1930110057',85.399,19,'2003-01-01','Kermit Project at Columbia University','Internet');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Laszlo in Action','1932394834',71.320,12,'2008-01-01','Norman Klein','Web Development');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Groovy in Action','1932394842',36.138,19,'2007-01-01','Dierk Koenig with Andrew Glover','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Object Technology Centers of Excellence','132612313',79.846,16,'1996-06-01','Timothy D. Korson','Object-Technology Programming');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Test Driven','1932394850',29.626,22,'2007-09-01','Lasse Koskela','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Effective Unit Testing','1935182579',115.610,13,'2013-02-04','Lasse Koskela','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Making Java Groovy','1935182943',24.175,17,'2013-09-19','Kenneth A. Kousen','Java');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('The Awesome Power of Direct3D/DirectX','1884777473',31.803,18,'2002-12-01','Peter J. Kovach','Computer Graphics');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Practical Software Requirements','1884777597',116.771,10,'1998-09-01','Benjamin L. Kovitz','Software Engineering');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('NHibernate in Action','1932394923',42.297,19,'2009-02-01','Pierre Henri Kuate','Microsoft .NET');
INSERT INTO BOOKS(title,isbn,price,stock,publishedDate,author,category) VALUES ('Microsoft Reporting Services in Action','1932394222',90.766,16,'2004-08-01','Teo Lachev','Microsoft .NET');

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
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635734dae759','Rasmussen Miranda',25,'rasmussenmiranda@sdccd.edu','+1 (845) 462-3520','706 Richardson Street, Chestnut, Michigan, 6553');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635798f7e67b','Riley Carter',31,'rileycarter@sdccd.edu','+1 (893) 562-2356','371 Sackman Street, Snyderville, Pennsylvania, 2262');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163562a4bd32c','Tina Gray',18,'tinagray@sdccd.edu','+1 (861) 446-2237','700 Lincoln Terrace, Deltaville, Arizona, 9511');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163566f4be42e','Ferrell Heath',32,'ferrellheath@sdccd.edu','+1 (923) 443-2423','485 Falmouth Street, Orviston, Marshall Islands, 3728');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16351482af62f','Christian Thompson',29,'christianthompson@sdccd.edu','+1 (821) 485-2619','937 Ash Street, Riviera, North Dakota, 2008');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635aa00f06c6','Antonia Russo',25,'antoniarusso@sdccd.edu','+1 (961) 540-2392','584 Railroad Avenue, Detroit, South Dakota, 5122');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16350d7c82fd9','Allison Molina',19,'allisonmolina@sdccd.edu','+1 (909) 406-2113','699 Danforth Street, Kraemer, Georgia, 5187');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163544090e0ec','Wells Melton',20,'wellsmelton@sdccd.edu','+1 (811) 446-2527','339 Ditmars Street, Moquino, Montana, 9976');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16353c2ededf6','Bertie Saunders',21,'bertiesaunders@sdccd.edu','+1 (926) 431-3823','780 Adams Street, Libertytown, Mississippi, 627');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635e09e1171b','Rios Wooten',31,'rioswooten@sdccd.edu','+1 (957) 535-2163','820 Rogers Avenue, Kennedyville, Tennessee, 4489');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16351489bbc64','Reba Larsen',30,'rebalarsen@sdccd.edu','+1 (831) 522-2086','366 Russell Street, Twilight, Arkansas, 7360');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16353c2f9f72a','Lynette Hall',25,'lynettehall@sdccd.edu','+1 (994) 481-3496','670 Fleet Walk, Chemung, Texas, 4382');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635311fc3ce1','Jeanette Garrett',23,'jeanettegarrett@sdccd.edu','+1 (885) 400-2198','437 Bedford Place, Harleigh, Nebraska, 8016');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635d93475d2d','Freda Ashley',33,'fredaashley@sdccd.edu','+1 (834) 425-2708','226 Norfolk Street, Deputy, Indiana, 8712');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163538019c785','Lara Mcintosh',20,'laramcintosh@sdccd.edu','+1 (946) 547-3043','883 Homecrest Avenue, Salvo, California, 8835');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163594163f262','Elsie Morgan',30,'elsiemorgan@sdccd.edu','+1 (987) 448-3513','715 Manhattan Avenue, Deercroft, Ohio, 3277');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635746863486','Flowers Gibson',26,'flowersgibson@sdccd.edu','+1 (824) 535-3801','921 Tapscott Avenue, Montura, Connecticut, 2227');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163588def38a2','Sarah Dudley',25,'sarahdudley@sdccd.edu','+1 (975) 582-3433','449 Lewis Place, Centerville, New York, 2396');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635ad02f516f','Klein Thornton',21,'kleinthornton@sdccd.edu','+1 (863) 461-3662','872 Oxford Walk, Leroy, Vermont, 5927');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635b3648af27','Velma Dawson',34,'velmadawson@sdccd.edu','+1 (961) 503-2977','293 Remsen Street, Cloverdale, Maryland, 9454');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635260a4cc61','Shaw Morrow',29,'shawmorrow@sdccd.edu','+1 (990) 526-2145','218 Roosevelt Place, Blodgett, Florida, 7744');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635751788f5a','Carmen Lowery',25,'carmenlowery@sdccd.edu','+1 (996) 551-2409','302 Harrison Avenue, Beason, Nevada, 3989');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163566df477e3','Terry Cummings',21,'terrycummings@sdccd.edu','+1 (908) 549-3451','890 Macdougal Street, Barclay, West Virginia, 7816');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16356e592e07a','Brandie Langley',27,'brandielangley@sdccd.edu','+1 (947) 475-3421','764 Hall Street, Freelandville, Wisconsin, 6097');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16351f668341a','Mejia Marshall',21,'mejiamarshall@sdccd.edu','+1 (977) 595-2662','317 Humboldt Street, Avoca, Louisiana, 9342');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163568ce88b65','Mildred Lester',26,'mildredlester@sdccd.edu','+1 (858) 491-3701','914 Guernsey Street, Grayhawk, Virgin Islands, 7183');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a163579befdc98','Franklin Rush',25,'franklinrush@sdccd.edu','+1 (874) 414-3424','297 Exeter Street, Whitehaven, New Mexico, 6773');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635c7265a83e','Concetta Lindsay',19,'concettalindsay@sdccd.edu','+1 (920) 567-2218','799 Hubbard Street, Dupuyer, Minnesota, 9463');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16354289c32e6','Sophia Delacruz',26,'sophiadelacruz@sdccd.edu','+1 (919) 409-2740','217 Micieli Place, Linwood, Oklahoma, 518');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635dc0d400c1','Katy Pena',30,'katypena@sdccd.edu','+1 (979) 419-2815','389 Howard Alley, Edenburg, Palau, 374');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16350c81b9ba0','Olivia Atkinson',34,'oliviaatkinson@sdccd.edu','+1 (888) 412-2724','130 Kimball Street, Navarre, Federated States Of Micronesia, 6508');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635686891a07','Edwards Goodman',25,'edwardsgoodman@sdccd.edu','+1 (985) 580-3066','188 Woodrow Court, Lindisfarne, Kentucky, 6345');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a16356bd7e1eed','Rush Mueller',30,'rushmueller@sdccd.edu','+1 (825) 511-2583','314 Turnbull Avenue, Teasdale, North Carolina, 8480');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635fa1b6dcfa','Lloyd Hancock',34,'lloydhancock@sdccd.edu','+1 (923) 509-2267','525 Strong Place, Chesapeake, South Carolina, 1028');
INSERT INTO CUSTOMER(customerid,name,age,email,phone,address) VALUES ('2bf033c305a1635e67f35a34','Yesenia Higgins',35,'yeseniahiggins@sdccd.edu','+1 (826) 473-2052','805 Clarkson Avenue, Bluetown, Alaska, 5719');


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
