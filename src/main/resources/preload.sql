DROP SCHEMA IF EXISTS CISC191 CASCADE;
CREATE SCHEMA CISC191;

DROP TABLE IF EXISTS CISC191.books;
CREATE TABLE CISC191.books (
	isbn VARCHAR(70),
	title VARCHAR(200) NOT NULL,
	price DOUBLE,
	stock INT NOT NULL CHECK (stock >= 0),
	publishedDate DATE,
	author VARCHAR(500),
	category VARCHAR(500),
PRIMARY KEY (isbn));

INSERT INTO CISC191.books VALUES ('1933988673','Unlocking Android',88.576,2,'2009-04-01','W. Frank Ableson','Open Source');
INSERT INTO CISC191.books VALUES ('1935182722','Android in Action, Second Edition',54.618,20,'2011-01-14','W. Frank Ableson','Java');
INSERT INTO CISC191.books VALUES ('1617290084','Specification by Example',39.129,17,'2011-06-03','Gojko Adzic','Software Engineering');
INSERT INTO CISC191.books VALUES ('1933988746','Flex 3 in Action',48.018,1,'2009-02-02','Tariq Ahmed with Jon Hirschi','Internet');
INSERT INTO CISC191.books VALUES ('1935182420','Flex 4 in Action',46.167,22,'2010-11-15','Tariq Ahmed','Internet');
INSERT INTO CISC191.books VALUES ('1933988312','Collective Intelligence in Action',78.096,17,'2008-10-01','Satnam Alag','Internet');
INSERT INTO CISC191.books VALUES ('1933988320','Zend Framework in Action',72.357,0,'2008-12-01','Rob Allen','Web Development');
INSERT INTO CISC191.books VALUES ('1933988797','Flex on Java',41.080,3,'2010-10-15','Bernerd Allmon','Internet');
INSERT INTO CISC191.books VALUES ('1935182234','Griffon in Action',27.951,3,'2012-06-04','Andres Almiray','Java');
INSERT INTO CISC191.books VALUES ('193518217X','OSGi in Depth',83.293,0,'2011-12-12','Alexandre de Castro Alves','Java');
INSERT INTO CISC191.books VALUES ('1933988509','Flexible Rails',32.390,1,'2008-01-01','Peter Armstrong','Web Development');
INSERT INTO CISC191.books VALUES ('1933988762','Hello! Flex 4',88.890,8,'2009-11-01','Peter Armstrong','Internet');
INSERT INTO CISC191.books VALUES ('1884777384','Coffeehouse',104.341,12,'1997-07-01','Levi Asher','Miscellaneous');
INSERT INTO CISC191.books VALUES ('1933988592','Team Foundation Server 2008 in Action',71.071,7,'2008-12-01','Jamil Azher','Microsoft .NET');
INSERT INTO CISC191.books VALUES ('1933988711','Brownfield Application Development in .NET',61.217,11,'2010-04-16','Kyle Baley','Microsoft');
INSERT INTO CISC191.books VALUES ('1935182870','MongoDB in Action',115.885,8,'2011-12-12','Kyle Banker','Next Generation Databases');
INSERT INTO CISC191.books VALUES ('1884777686','Distributed Application Development with PowerBuilder 6.0',24.786,18,'1998-06-01','Michael J. Barlotta','PowerBuilder');
INSERT INTO CISC191.books VALUES ('1884777864','Jaguar Development with PowerBuilder 7',65.935,12,'1999-08-01','Michael Barlotta','PowerBuilder');
INSERT INTO CISC191.books VALUES ('1884777902','3D User Interfaces with Java 3D',79.753,6,'2000-08-01','Jon Barrilleaux','Java');
INSERT INTO CISC191.books VALUES ('193239415X','Hibernate in Action',59.370,2,'2004-08-01','Christian Bauer','Java');
INSERT INTO CISC191.books VALUES ('1932394885','Java Persistence with Hibernate',25.879,3,'2006-11-01','Christian Bauer','Java');
INSERT INTO CISC191.books VALUES ('1930110529','JSTL in Action',115.041,8,'2002-07-01','Shawn Bayern','Internet');
INSERT INTO CISC191.books VALUES ('1932394826','iBATIS in Action',98.961,6,'2007-01-01','Clinton Begin','Web Development');
INSERT INTO CISC191.books VALUES ('133046192','Designing Hard Software',86.421,4,'1997-02-01','Douglas W. Bennett','Object-Oriented Programming');
INSERT INTO CISC191.books VALUES ('1933988649','Hibernate Search in Action',59.859,24,'2008-12-21','Emmanuel Bernard','Java');
INSERT INTO CISC191.books VALUES ('1933988355','jQuery in Action',118.195,2,'2008-01-01','Bear Bibeault','Web Development');
INSERT INTO CISC191.books VALUES ('1935182323','jQuery in Action, Second Edition',48.960,10,'2010-06-01','Bear Bibeault','Java');
INSERT INTO CISC191.books VALUES ('1884777295','Building Secure and Reliable Network Applications',58.053,7,'1996-01-01','Kenneth P. Birman','Networking');
INSERT INTO CISC191.books VALUES ('1932394699','Ruby for Rails',108.465,3,'2006-05-01','David A. Black','Web Development');
INSERT INTO CISC191.books VALUES ('1933988657','The Well-Grounded Rubyist',25.203,3,'2009-04-01','David A. Black','Programming');
INSERT INTO CISC191.books VALUES ('1933988452','Website Owner''s Manual',68.384,14,'2009-10-01','Paul A. Boag','Internet');
INSERT INTO CISC191.books VALUES ('1935182463','ASP.NET 4.0 in Practice',103.488,3,'2011-05-15','Daniele Bochicchio','Microsoft .NET');
INSERT INTO CISC191.books VALUES ('1935182080','Hello! Python',57.442,1,'2012-02-13','Anthony Briggs','Python');
INSERT INTO CISC191.books VALUES ('1884777554','PFC Programmer''s Reference Manual',86.671,18,'1998-06-01','Richard Brooks','PowerBuilder');
INSERT INTO CISC191.books VALUES ('133034054','Graphics File Formats',36.658,8,'1995-06-01','C. Wayne Brown','Computer Graphics');
INSERT INTO CISC191.books VALUES ('131723979','Visual Object Oriented Programming',97.505,4,'1995-02-01','Margaret M. Burnett','Programming');
INSERT INTO CISC191.books VALUES ('1617291269','iOS in Practice',20.573,15,'2013-11-01','Bear P. Cahill','Mobile Technology');
INSERT INTO CISC191.books VALUES ('193398886X','iPhone in Action',74.750,19,'2008-12-01','Christopher Allen','Web Development');
INSERT INTO CISC191.books VALUES ('1933988428','Silverlight 2 in Action',45.641,17,'2008-10-31','Chad A. Campbell','Microsoft .NET');
INSERT INTO CISC191.books VALUES ('193518220X','The Quick Python Book, Second Edition',35.672,2,'2010-01-01','Naomi R. Ceder','Python');
INSERT INTO CISC191.books VALUES ('1884777600','Internet and Intranet Applications with PowerBuilder 6',54.387,17,'2000-12-01','Tom Cervenka','PowerBuilder');
INSERT INTO CISC191.books VALUES ('188477752X','Practical Methods for Your Year 2000 Problem',112.393,23,'1998-01-01','Robert Chapman','Business');
INSERT INTO CISC191.books VALUES ('1884777368','Mobile Agents',68.892,11,'1997-03-01','William R. Cockayne and Michael Zyda','Internet');
INSERT INTO CISC191.books VALUES ('1935182307','Spring Dynamic Modules in Action',105.088,4,'2010-09-04','Arnaud Cogoluegnes','Java');
INSERT INTO CISC191.books VALUES ('193398872X','SQL Server 2008 Administration in Action',69.133,5,'2009-08-01','Rod Colledge','Microsoft');
INSERT INTO CISC191.books VALUES ('1935182927','Android in Practice',79.673,5,'2011-09-30','Charlie Collins','Mobile Technology');
INSERT INTO CISC191.books VALUES ('1884777791','Object Oriented Perl',118.988,10,'1999-08-01','Damian Conway','Object-Oriented Programming');
INSERT INTO CISC191.books VALUES ('1933988290','GWT in Practice',21.517,7,'2008-04-01','Robert Cooper','Web Development');
INSERT INTO CISC191.books VALUES ('1932394613','Ajax in Action',117.239,20,'2005-10-01','Dave Crane','XML');
INSERT INTO CISC191.books VALUES ('1932394990','Ajax in Practice',42.127,11,'2007-06-01','Dave Crane','Web Development');

DROP TABLE IF EXISTS CISC191.customers;
CREATE TABLE CISC191.customers (
  customer_id VARCHAR(70) NOT NULL,
  name VARCHAR(200) NOT NULL,
  age INT NOT NULL,
  email VARCHAR(150) UNIQUE,
  phone VARCHAR(150),
  address VARCHAR(150),
  PRIMARY KEY (customer_id));

INSERT INTO CISC191.customers VALUES ('8911536e2','Jami Pittman',24,'jamipittman@sdccd.edu','+1 (840) 486-3880','782 Tilden Avenue, Ryderwood, Georgia, 140');
INSERT INTO CISC191.customers VALUES ('8807e7347','Velazquez Mason',26,'velazquezmason@sdccd.edu','+1 (941) 409-2547','954 Malta Street, Bridgetown, Montana, 7763');
INSERT INTO CISC191.customers VALUES ('3932878c5','Melton Lynn',23,'meltonlynn@sdccd.edu','+1 (898) 531-2319','841 Roder Avenue, Ruffin, Mississippi, 3486');
INSERT INTO CISC191.customers VALUES ('a37670d73','Palmer Wong',29,'palmerwong@sdccd.edu','+1 (875) 559-3441','904 Independence Avenue, Tioga, Tennessee, 3181');
INSERT INTO CISC191.customers VALUES ('21bb64a32','Janine Spence',33,'janinespence@sdccd.edu','+1 (840) 424-3269','106 Dewey Place, Knowlton, Arkansas, 1499');
INSERT INTO CISC191.customers VALUES ('7d5018015','Decker Nguyen',33,'deckernguyen@sdccd.edu','+1 (920) 580-2203','605 Riverdale Avenue, Courtland, Texas, 9230');
INSERT INTO CISC191.customers VALUES ('62c94a91c','Buckley Slater',20,'buckleyslater@sdccd.edu','+1 (988) 553-2650','927 River Street, Abrams, Nebraska, 2130');
INSERT INTO CISC191.customers VALUES ('cb57fa729','Burris Elliott',27,'burriselliott@sdccd.edu','+1 (805) 439-2356','109 Madison Street, Watrous, Indiana, 7699');
INSERT INTO CISC191.customers VALUES ('ed0fe55f7','Harrell Noble',25,'harrellnoble@sdccd.edu','+1 (958) 416-2141','107 Story Street, Carlos, California, 4082');
INSERT INTO CISC191.customers VALUES ('a3e50b6c8','Spencer Dotson',24,'spencerdotson@sdccd.edu','+1 (925) 442-3212','657 Gold Street, Lumberton, Ohio, 9350');
INSERT INTO CISC191.customers VALUES ('902f9a664','Malinda Rivas',25,'malindarivas@sdccd.edu','+1 (948) 401-2297','306 Blake Avenue, Graball, Connecticut, 3863');
INSERT INTO CISC191.customers VALUES ('9112d9fed','Franks Blankenship',20,'franksblankenship@sdccd.edu','+1 (878) 535-2788','955 Lincoln Avenue, Faxon, New York, 2165');
INSERT INTO CISC191.customers VALUES ('ab0d51a4f','Morris Moran',31,'morrismoran@sdccd.edu','+1 (837) 530-2905','658 Dank Court, Eureka, Vermont, 7761');
INSERT INTO CISC191.customers VALUES ('ac64a4975','Katheryn Beasley',26,'katherynbeasley@sdccd.edu','+1 (970) 470-2725','570 Newport Street, Catherine, Maryland, 3996');
INSERT INTO CISC191.customers VALUES ('83e9f3e07','Hope Frost',26,'hopefrost@sdccd.edu','+1 (868) 559-3180','621 Nelson Street, Tedrow, Florida, 3208');
INSERT INTO CISC191.customers VALUES ('4d51f4e6c','Thelma Knapp',33,'thelmaknapp@sdccd.edu','+1 (935) 500-2439','459 Sullivan Place, Coldiron, Nevada, 4783');
INSERT INTO CISC191.customers VALUES ('4993407d4','Lula Guzman',28,'lulaguzman@sdccd.edu','+1 (907) 401-2678','255 Broadway , Omar, West Virginia, 2632');
INSERT INTO CISC191.customers VALUES ('90906f7ef','Dillon Patrick',25,'dillonpatrick@sdccd.edu','+1 (937) 434-2474','849 Coleridge Street, Guilford, Wisconsin, 8345');
INSERT INTO CISC191.customers VALUES ('3968346af','Fisher Padilla',29,'fisherpadilla@sdccd.edu','+1 (948) 593-2651','803 Williams Avenue, Cartwright, Louisiana, 323');
INSERT INTO CISC191.customers VALUES ('3434bb35f','Rhodes Vargas',22,'rhodesvargas@sdccd.edu','+1 (864) 408-3793','928 Losee Terrace, Allamuchy, Virgin Islands, 4029');
INSERT INTO CISC191.customers VALUES ('e28dfe8cd','Madden Black',29,'maddenblack@sdccd.edu','+1 (836) 498-2255','576 Roebling Street, Gerber, New Mexico, 1028');
INSERT INTO CISC191.customers VALUES ('64c493ae4','Alfreda Mcfadden',26,'alfredamcfadden@sdccd.edu','+1 (922) 496-2458','897 Fayette Street, Wedgewood, Minnesota, 7199');
INSERT INTO CISC191.customers VALUES ('237dfe35f','Turner Sampson',22,'turnersampson@sdccd.edu','+1 (958) 503-3668','975 Schermerhorn Street, Madrid, Oklahoma, 6344');
INSERT INTO CISC191.customers VALUES ('bce909261','Mayo Winters',25,'mayowinters@sdccd.edu','+1 (859) 433-2758','978 Decatur Street, Rutherford, Palau, 9254');
INSERT INTO CISC191.customers VALUES ('4bd82fa57','Mcdaniel Moreno',26,'mcdanielmoreno@sdccd.edu','+1 (880) 582-3198','192 Strauss Street, Brogan, Federated States Of Micronesia, 5953');
INSERT INTO CISC191.customers VALUES ('bb52aa76f','Mcbride Burch',30,'mcbrideburch@sdccd.edu','+1 (962) 422-2257','263 Rose Street, Noblestown, Kentucky, 9431');
INSERT INTO CISC191.customers VALUES ('047d215e2','Lavonne Morse',32,'lavonnemorse@sdccd.edu','+1 (812) 584-2047','882 Mill Avenue, Drytown, North Carolina, 673');
INSERT INTO CISC191.customers VALUES ('58ed1206f','Cherry Love',21,'cherrylove@sdccd.edu','+1 (982) 578-2339','489 Marconi Place, Gardiner, South Carolina, 6772');
INSERT INTO CISC191.customers VALUES ('13d6104ad','Adkins Bradford',18,'adkinsbradford@sdccd.edu','+1 (913) 470-3520','798 Brevoort Place, Brethren, Alaska, 7916');
INSERT INTO CISC191.customers VALUES ('381538c30','Katherine Duran',33,'katherineduran@sdccd.edu','+1 (969) 484-3063','880 Windsor Place, Wacissa, Illinois, 5464');
INSERT INTO CISC191.customers VALUES ('c7998ec4a','Spence Hebert',32,'spencehebert@sdccd.edu','+1 (904) 498-3809','414 Huntington Street, Kerby, Delaware, 3174');
INSERT INTO CISC191.customers VALUES ('f057c7423','Ellen Rivera',20,'ellenrivera@sdccd.edu','+1 (827) 583-2550','166 Conover Street, Harviell, Iowa, 7765');
INSERT INTO CISC191.customers VALUES ('7b47211fd','French Mcmillan',18,'frenchmcmillan@sdccd.edu','+1 (985) 513-3005','354 Etna Street, Glenville, Guam, 3802');
INSERT INTO CISC191.customers VALUES ('ab48f2e14','Lucas Good',33,'lucasgood@sdccd.edu','+1 (892) 438-2741','604 Nolans Lane, Tolu, Hawaii, 7055');
INSERT INTO CISC191.customers VALUES ('990240f8f','Jacklyn Sherman',35,'jacklynsherman@sdccd.edu','+1 (886) 438-3048','504 Remsen Avenue, Wright, District Of Columbia, 8200');
INSERT INTO CISC191.customers VALUES ('4e9e1fd6b','Mccarthy Hubbard',18,'mccarthyhubbard@sdccd.edu','+1 (936) 464-3467','597 Hendrix Street, Camas, Oregon, 852');
INSERT INTO CISC191.customers VALUES ('210393ba0','Vinson Steele',34,'vinsonsteele@sdccd.edu','+1 (853) 415-2975','446 Jodie Court, Floriston, New Hampshire, 1055');
INSERT INTO CISC191.customers VALUES ('d620ef98a','Florence Jordan',28,'florencejordan@sdccd.edu','+1 (946) 534-2044','410 Congress Street, Russellville, Wyoming, 8103');
INSERT INTO CISC191.customers VALUES ('27f34d49b','Stefanie Combs',34,'stefaniecombs@sdccd.edu','+1 (980) 599-2621','488 Coyle Street, Lupton, Utah, 9150');
INSERT INTO CISC191.customers VALUES ('0a31f23ed','Johanna Hardy',34,'johannahardy@sdccd.edu','+1 (910) 443-3149','507 Furman Street, Hayes, Virginia, 2565');
INSERT INTO CISC191.customers VALUES ('5b815c90b','Medina Owen',28,'medinaowen@sdccd.edu','+1 (899) 408-3636','734 Clinton Avenue, Urbana, Maine, 7154');
INSERT INTO CISC191.customers VALUES ('01acd27a9','Bowman Lara',35,'bowmanlara@sdccd.edu','+1 (932) 586-3508','791 Hill Street, Outlook, Missouri, 6982');
INSERT INTO CISC191.customers VALUES ('74ef1dc52','Rhea Fitzgerald',25,'rheafitzgerald@sdccd.edu','+1 (800) 463-2045','992 Cameron Court, Advance, Massachusetts, 4961');
INSERT INTO CISC191.customers VALUES ('6c59a712e','Opal Gaines',24,'opalgaines@sdccd.edu','+1 (832) 566-3226','675 Willoughby Avenue, Homeland, Idaho, 9014');
INSERT INTO CISC191.customers VALUES ('da87c43dc','Bowen Olson',27,'bowenolson@sdccd.edu','+1 (962) 561-2483','289 Stillwell Avenue, Tuttle, Washington, 6840');
INSERT INTO CISC191.customers VALUES ('909940e6f','Nicholson Mccullough',26,'nicholsonmccullough@sdccd.edu','+1 (952) 549-3286','688 Mersereau Court, Adelino, New Jersey, 1768');
INSERT INTO CISC191.customers VALUES ('6da3f7fa6','Isabel Page',27,'isabelpage@sdccd.edu','+1 (847) 591-2821','820 Prospect Avenue, Bladensburg, American Samoa, 1224');
INSERT INTO CISC191.customers VALUES ('cbc938e3d','Lynnette Hickman',21,'lynnettehickman@sdccd.edu','+1 (833) 590-3627','673 Brigham Street, Limestone, Rhode Island, 7932');
INSERT INTO CISC191.customers VALUES ('64bfade62','Darla Hess',23,'darlahess@sdccd.edu','+1 (952) 581-2120','385 Reed Street, Temperanceville, Puerto Rico, 8453');
INSERT INTO CISC191.customers VALUES ('a579288e8','Delaney Gonzales',27,'delaneygonzales@sdccd.edu','+1 (859) 445-3550','702 Seagate Terrace, Evergreen, Alabama, 304');
INSERT INTO CISC191.customers VALUES ('7691a256f','Inez Fields',24,'inezfields@sdccd.edu','+1 (913) 489-3210','378 Newton Street, Silkworth, Kansas, 8568');
INSERT INTO CISC191.customers VALUES ('253974fa4','Rocha Conley',30,'rochaconley@sdccd.edu','+1 (827) 535-2096','211 Rapelye Street, Wattsville, Colorado, 6899');
INSERT INTO CISC191.customers VALUES ('9ee04096d','Hayes Price',32,'hayesprice@sdccd.edu','+1 (967) 427-3207','639 Alabama Avenue, Collins, Michigan, 779');
INSERT INTO CISC191.customers VALUES ('e13b6b202','Bender Klein',35,'benderklein@sdccd.edu','+1 (943) 545-2764','419 Desmond Court, Hondah, Pennsylvania, 7955');
INSERT INTO CISC191.customers VALUES ('12c77ccb9','Trujillo Sloan',21,'trujillosloan@sdccd.edu','+1 (954) 574-3866','296 Arlington Avenue, Groveville, Arizona, 8285');
INSERT INTO CISC191.customers VALUES ('2f6815ca4','Petersen Bailey',19,'petersenbailey@sdccd.edu','+1 (831) 449-2802','547 Williams Place, Loma, Marshall Islands, 6072');
INSERT INTO CISC191.customers VALUES ('e202a6909','Sallie Roberson',28,'sallieroberson@sdccd.edu','+1 (866) 535-2351','722 Sumpter Street, Norfolk, North Dakota, 8478');
INSERT INTO CISC191.customers VALUES ('dcbc3a1d1','Jerry Valdez',20,'jerryvaldez@sdccd.edu','+1 (815) 477-3556','727 Bills Place, Greenwich, South Dakota, 4180');
INSERT INTO CISC191.customers VALUES ('f8b7e01ed','Snider Hahn',20,'sniderhahn@sdccd.edu','+1 (918) 589-2666','799 Hyman Court, Fairview, Georgia, 8232');
INSERT INTO CISC191.customers VALUES ('cbba05250','Alisha Dunn',24,'alishadunn@sdccd.edu','+1 (966) 402-2476','772 Frost Street, Westboro, Montana, 9590');
INSERT INTO CISC191.customers VALUES ('738c70925','Hopper Stevens',31,'hopperstevens@sdccd.edu','+1 (967) 495-3860','358 Wilson Avenue, Oceola, Mississippi, 8928');
INSERT INTO CISC191.customers VALUES ('49d63373d','Fowler Brewer',25,'fowlerbrewer@sdccd.edu','+1 (998) 410-3058','895 Pilling Street, Sheatown, Tennessee, 7900');
INSERT INTO CISC191.customers VALUES ('6b46f5694','Francisca Wynn',24,'franciscawynn@sdccd.edu','+1 (917) 409-3453','965 Harbor Court, Wheatfields, Arkansas, 6889');
INSERT INTO CISC191.customers VALUES ('8b511de06','Odessa Castillo',30,'odessacastillo@sdccd.edu','+1 (879) 568-3055','807 Knight Court, Sims, Texas, 3258');
INSERT INTO CISC191.customers VALUES ('221317b3e','Day Walls',19,'daywalls@sdccd.edu','+1 (856) 537-3288','391 Amity Street, Martinez, Nebraska, 2160');
INSERT INTO CISC191.customers VALUES ('a3e7d945a','Booker Vincent',26,'bookervincent@sdccd.edu','+1 (937) 426-3579','780 Grimes Road, Enlow, Indiana, 2809');
INSERT INTO CISC191.customers VALUES ('47176c156','Warren Collins',32,'warrencollins@sdccd.edu','+1 (988) 581-3461','157 Pierrepont Street, Celeryville, California, 2658');
INSERT INTO CISC191.customers VALUES ('4d6204704','Rachel Gates',22,'rachelgates@sdccd.edu','+1 (824) 549-3688','300 Battery Avenue, Century, Ohio, 7507');
INSERT INTO CISC191.customers VALUES ('16fa3db21','Geraldine Barr',32,'geraldinebarr@sdccd.edu','+1 (941) 415-3808','212 Seaview Court, Madaket, Connecticut, 158');
INSERT INTO CISC191.customers VALUES ('0988e95b7','Tammy Burnett',25,'tammyburnett@sdccd.edu','+1 (980) 420-3574','330 Terrace Place, Bowden, New York, 4357');
INSERT INTO CISC191.customers VALUES ('1d1c0e3e0','Jarvis Hicks',26,'jarvishicks@sdccd.edu','+1 (929) 492-3805','450 Reeve Place, Sisquoc, Vermont, 8508');
INSERT INTO CISC191.customers VALUES ('93ce2cc48','Porter Cruz',26,'portercruz@sdccd.edu','+1 (972) 530-2937','505 Lester Court, Hampstead, Maryland, 3960');
INSERT INTO CISC191.customers VALUES ('23b7933b8','Mcfarland Pollard',33,'mcfarlandpollard@sdccd.edu','+1 (818) 480-3984','569 Colin Place, Bascom, Florida, 3470');
INSERT INTO CISC191.customers VALUES ('946cc854a','Milagros Barnett',33,'milagrosbarnett@sdccd.edu','+1 (844) 496-3016','164 Dover Street, Coloma, Nevada, 893');
INSERT INTO CISC191.customers VALUES ('73630ef14','Carney Munoz',32,'carneymunoz@sdccd.edu','+1 (901) 417-3223','794 Love Lane, Brandermill, West Virginia, 8505');
INSERT INTO CISC191.customers VALUES ('0e4a8b5d9','April Gross',23,'aprilgross@sdccd.edu','+1 (931) 454-3050','453 Rochester Avenue, Watchtower, Wisconsin, 982');
INSERT INTO CISC191.customers VALUES ('41a19d2b8','Margarita Church',26,'margaritachurch@sdccd.edu','+1 (992) 494-3469','207 Georgia Avenue, Longoria, Louisiana, 8692');
INSERT INTO CISC191.customers VALUES ('f194c812b','Barry Gould',30,'barrygould@sdccd.edu','+1 (998) 517-2871','263 Grove Street, Bancroft, Virgin Islands, 9981');
INSERT INTO CISC191.customers VALUES ('da5a16357','Gardner Orr',19,'gardnerorr@sdccd.edu','+1 (998) 488-2198','772 Irving Avenue, Romeville, New Mexico, 9909');
INSERT INTO CISC191.customers VALUES ('413cf446a','Parks Wiley',26,'parkswiley@sdccd.edu','+1 (867) 540-2930','172 Hornell Loop, Shasta, Minnesota, 7880');
INSERT INTO CISC191.customers VALUES ('56b2755e2','Lilia Goodwin',26,'liliagoodwin@sdccd.edu','+1 (866) 444-2436','814 Columbia Place, Gilgo, Oklahoma, 1396');
INSERT INTO CISC191.customers VALUES ('623559382','Delgado Velazquez',28,'delgadovelazquez@sdccd.edu','+1 (820) 418-3279','346 Seagate Avenue, Devon, Palau, 1987');
INSERT INTO CISC191.customers VALUES ('87084f8cb','Lacy Bird',24,'lacybird@sdccd.edu','+1 (850) 549-2705','261 Leonard Street, Bendon, Federated States Of Micronesia, 8688');
INSERT INTO CISC191.customers VALUES ('4f8d2dfb9','Gilliam Banks',23,'gilliambanks@sdccd.edu','+1 (801) 592-3592','740 Bowne Street, Trexlertown, Kentucky, 9885');
INSERT INTO CISC191.customers VALUES ('db72b009c','Wheeler Horne',30,'wheelerhorne@sdccd.edu','+1 (860) 548-3013','299 Pioneer Street, Delwood, North Carolina, 2259');
INSERT INTO CISC191.customers VALUES ('c6db6fa5a','Barrett Vasquez',19,'barrettvasquez@sdccd.edu','+1 (969) 495-2598','703 Pierrepont Place, Williamson, South Carolina, 1285');
INSERT INTO CISC191.customers VALUES ('371f1aa08','Schneider Bauer',25,'schneiderbauer@sdccd.edu','+1 (898) 587-3323','645 Doone Court, Fredericktown, Alaska, 4267');
INSERT INTO CISC191.customers VALUES ('a05b04a0f','Todd Hobbs',20,'toddhobbs@sdccd.edu','+1 (828) 429-2421','652 Allen Avenue, Ballico, Illinois, 764');
INSERT INTO CISC191.customers VALUES ('56f36da20','Mae Johnson',23,'maejohnson@sdccd.edu','+1 (929) 458-2975','226 Holt Court, Jackpot, Delaware, 5999');
INSERT INTO CISC191.customers VALUES ('2bf033c30','Wilkerson Cotton',28,'wilkersoncotton@sdccd.edu','+1 (878) 557-3890','800 Merit Court, Connerton, Iowa, 9633');
INSERT INTO CISC191.customers VALUES ('7ecf417b7','Holloway Talley',28,'hollowaytalley@sdccd.edu','+1 (889) 579-2298','183 Meserole Avenue, Cochranville, Guam, 3885');
INSERT INTO CISC191.customers VALUES ('760b45fbd','Tricia Washington',34,'triciawashington@sdccd.edu','+1 (890) 426-2508','642 Kensington Street, Carbonville, Hawaii, 8679');
INSERT INTO CISC191.customers VALUES ('69ebafa98','Allen Donaldson',35,'allendonaldson@sdccd.edu','+1 (947) 584-2699','511 Gerald Court, Mansfield, District Of Columbia, 5887');
INSERT INTO CISC191.customers VALUES ('a5f5c92af','Carver Wilson',23,'carverwilson@sdccd.edu','+1 (901) 522-3472','457 Dunne Place, Wolcott, Oregon, 4156');
INSERT INTO CISC191.customers VALUES ('df1da324c','Sondra Chaney',29,'sondrachaney@sdccd.edu','+1 (859) 580-2281','513 Beacon Court, Santel, New Hampshire, 2718');
INSERT INTO CISC191.customers VALUES ('d216db778','Bernadine Nieves',26,'bernadinenieves@sdccd.edu','+1 (976) 456-3573','840 Metropolitan Avenue, Kent, Wyoming, 5683');
INSERT INTO CISC191.customers VALUES ('0cba1d5a3','Mccoy Schneider',18,'mccoyschneider@sdccd.edu','+1 (972) 569-3539','148 Ridgewood Place, Shepardsville, Utah, 2388');
INSERT INTO CISC191.customers VALUES ('2d457f03d','Aurora Woodward',35,'aurorawoodward@sdccd.edu','+1 (878) 481-2871','668 Dearborn Court, Trucksville, Virginia, 7151');
INSERT INTO CISC191.customers VALUES ('9ea150382','Mathews Pearson',35,'mathewspearson@sdccd.edu','+1 (947) 466-2691','248 Stuyvesant Avenue, Southview, Maine, 7235');
INSERT INTO CISC191.customers VALUES ('68c529207','Horne Branch',28,'hornebranch@sdccd.edu','+1 (986) 509-2677','941 Belvidere Street, Condon, Missouri, 1277');
INSERT INTO CISC191.customers VALUES ('8a3e5a4d2','Renee Finley',31,'reneefinley@sdccd.edu','+1 (893) 596-3225','250 Summit Street, Terlingua, Massachusetts, 5147');
INSERT INTO CISC191.customers VALUES ('352a5469f','Penelope Becker',33,'penelopebecker@sdccd.edu','+1 (962) 450-2814','609 Harwood Place, Forbestown, Idaho, 1660');
INSERT INTO CISC191.customers VALUES ('ef9614a47','Alexander Crane',19,'alexandercrane@sdccd.edu','+1 (841) 419-2115','763 Quincy Street, Whitestone, Washington, 1611');
INSERT INTO CISC191.customers VALUES ('069da62b9','Burgess Barrett',23,'burgessbarrett@sdccd.edu','+1 (951) 414-3261','648 Oliver Street, Elrama, New Jersey, 227');
INSERT INTO CISC191.customers VALUES ('5dc696ec6','Mariana Daniel',25,'marianadaniel@sdccd.edu','+1 (891) 518-3647','904 Gilmore Court, Mammoth, American Samoa, 969');
INSERT INTO CISC191.customers VALUES ('94ca15d08','Scott Noel',24,'scottnoel@sdccd.edu','+1 (969) 432-3915','565 Paerdegat Avenue, Dixonville, Rhode Island, 5882');
INSERT INTO CISC191.customers VALUES ('6980eb3b1','Wooten Le',27,'wootenle@sdccd.edu','+1 (822) 580-2043','881 Hendrickson Place, Hegins, Puerto Rico, 9353');
INSERT INTO CISC191.customers VALUES ('5390af252','Vaughan Crawford',23,'vaughancrawford@sdccd.edu','+1 (961) 568-3092','322 Bay Parkway, Malo, Alabama, 908');
INSERT INTO CISC191.customers VALUES ('ff1243856','Desiree Hendricks',24,'desireehendricks@sdccd.edu','+1 (971) 517-3629','411 Seeley Street, Clay, Kansas, 1310');
INSERT INTO CISC191.customers VALUES ('ba072e54a','Gould Cline',27,'gouldcline@sdccd.edu','+1 (980) 486-2138','865 Flatbush Avenue, Bowie, Colorado, 1452');
INSERT INTO CISC191.customers VALUES ('734dae759','Rasmussen Miranda',25,'rasmussenmiranda@sdccd.edu','+1 (845) 462-3520','706 Richardson Street, Chestnut, Michigan, 6553');
INSERT INTO CISC191.customers VALUES ('798f7e67b','Riley Carter',31,'rileycarter@sdccd.edu','+1 (893) 562-2356','371 Sackman Street, Snyderville, Pennsylvania, 2262');
INSERT INTO CISC191.customers VALUES ('62a4bd32c','Tina Gray',18,'tinagray@sdccd.edu','+1 (861) 446-2237','700 Lincoln Terrace, Deltaville, Arizona, 9511');
INSERT INTO CISC191.customers VALUES ('66f4be42e','Ferrell Heath',32,'ferrellheath@sdccd.edu','+1 (923) 443-2423','485 Falmouth Street, Orviston, Marshall Islands, 3728');
INSERT INTO CISC191.customers VALUES ('1482af62f','Christian Thompson',29,'christianthompson@sdccd.edu','+1 (821) 485-2619','937 Ash Street, Riviera, North Dakota, 2008');
INSERT INTO CISC191.customers VALUES ('aa00f06c6','Antonia Russo',25,'antoniarusso@sdccd.edu','+1 (961) 540-2392','584 Railroad Avenue, Detroit, South Dakota, 5122');
INSERT INTO CISC191.customers VALUES ('0d7c82fd9','Allison Molina',19,'allisonmolina@sdccd.edu','+1 (909) 406-2113','699 Danforth Street, Kraemer, Georgia, 5187');
INSERT INTO CISC191.customers VALUES ('44090e0ec','Wells Melton',20,'wellsmelton@sdccd.edu','+1 (811) 446-2527','339 Ditmars Street, Moquino, Montana, 9976');
INSERT INTO CISC191.customers VALUES ('3c2ededf6','Bertie Saunders',21,'bertiesaunders@sdccd.edu','+1 (926) 431-3823','780 Adams Street, Libertytown, Mississippi, 627');
INSERT INTO CISC191.customers VALUES ('e09e1171b','Rios Wooten',31,'rioswooten@sdccd.edu','+1 (957) 535-2163','820 Rogers Avenue, Kennedyville, Tennessee, 4489');
INSERT INTO CISC191.customers VALUES ('1489bbc64','Reba Larsen',30,'rebalarsen@sdccd.edu','+1 (831) 522-2086','366 Russell Street, Twilight, Arkansas, 7360');
INSERT INTO CISC191.customers VALUES ('3c2f9f72a','Lynette Hall',25,'lynettehall@sdccd.edu','+1 (994) 481-3496','670 Fleet Walk, Chemung, Texas, 4382');
INSERT INTO CISC191.customers VALUES ('311fc3ce1','Jeanette Garrett',23,'jeanettegarrett@sdccd.edu','+1 (885) 400-2198','437 Bedford Place, Harleigh, Nebraska, 8016');
INSERT INTO CISC191.customers VALUES ('d93475d2d','Freda Ashley',33,'fredaashley@sdccd.edu','+1 (834) 425-2708','226 Norfolk Street, Deputy, Indiana, 8712');
INSERT INTO CISC191.customers VALUES ('38019c785','Lara Mcintosh',20,'laramcintosh@sdccd.edu','+1 (946) 547-3043','883 Homecrest Avenue, Salvo, California, 8835');
INSERT INTO CISC191.customers VALUES ('94163f262','Elsie Morgan',30,'elsiemorgan@sdccd.edu','+1 (987) 448-3513','715 Manhattan Avenue, Deercroft, Ohio, 3277');
INSERT INTO CISC191.customers VALUES ('746863486','Flowers Gibson',26,'flowersgibson@sdccd.edu','+1 (824) 535-3801','921 Tapscott Avenue, Montura, Connecticut, 2227');
INSERT INTO CISC191.customers VALUES ('88def38a2','Sarah Dudley',25,'sarahdudley@sdccd.edu','+1 (975) 582-3433','449 Lewis Place, Centerville, New York, 2396');
INSERT INTO CISC191.customers VALUES ('ad02f516f','Klein Thornton',21,'kleinthornton@sdccd.edu','+1 (863) 461-3662','872 Oxford Walk, Leroy, Vermont, 5927');
INSERT INTO CISC191.customers VALUES ('b3648af27','Velma Dawson',34,'velmadawson@sdccd.edu','+1 (961) 503-2977','293 Remsen Street, Cloverdale, Maryland, 9454');
INSERT INTO CISC191.customers VALUES ('260a4cc61','Shaw Morrow',29,'shawmorrow@sdccd.edu','+1 (990) 526-2145','218 Roosevelt Place, Blodgett, Florida, 7744');
INSERT INTO CISC191.customers VALUES ('751788f5a','Carmen Lowery',25,'carmenlowery@sdccd.edu','+1 (996) 551-2409','302 Harrison Avenue, Beason, Nevada, 3989');
INSERT INTO CISC191.customers VALUES ('66df477e3','Terry Cummings',21,'terrycummings@sdccd.edu','+1 (908) 549-3451','890 Macdougal Street, Barclay, West Virginia, 7816');
INSERT INTO CISC191.customers VALUES ('6e592e07a','Brandie Langley',27,'brandielangley@sdccd.edu','+1 (947) 475-3421','764 Hall Street, Freelandville, Wisconsin, 6097');
INSERT INTO CISC191.customers VALUES ('1f668341a','Mejia Marshall',21,'mejiamarshall@sdccd.edu','+1 (977) 595-2662','317 Humboldt Street, Avoca, Louisiana, 9342');
INSERT INTO CISC191.customers VALUES ('68ce88b65','Mildred Lester',26,'mildredlester@sdccd.edu','+1 (858) 491-3701','914 Guernsey Street, Grayhawk, Virgin Islands, 7183');
INSERT INTO CISC191.customers VALUES ('79befdc98','Franklin Rush',25,'franklinrush@sdccd.edu','+1 (874) 414-3424','297 Exeter Street, Whitehaven, New Mexico, 6773');
INSERT INTO CISC191.customers VALUES ('c7265a83e','Concetta Lindsay',19,'concettalindsay@sdccd.edu','+1 (920) 567-2218','799 Hubbard Street, Dupuyer, Minnesota, 9463');
INSERT INTO CISC191.customers VALUES ('4289c32e6','Sophia Delacruz',26,'sophiadelacruz@sdccd.edu','+1 (919) 409-2740','217 Micieli Place, Linwood, Oklahoma, 518');
INSERT INTO CISC191.customers VALUES ('dc0d400c1','Katy Pena',30,'katypena@sdccd.edu','+1 (979) 419-2815','389 Howard Alley, Edenburg, Palau, 374');
INSERT INTO CISC191.customers VALUES ('0c81b9ba0','Olivia Atkinson',34,'oliviaatkinson@sdccd.edu','+1 (888) 412-2724','130 Kimball Street, Navarre, Federated States Of Micronesia, 6508');
INSERT INTO CISC191.customers VALUES ('686891a07','Edwards Goodman',25,'edwardsgoodman@sdccd.edu','+1 (985) 580-3066','188 Woodrow Court, Lindisfarne, Kentucky, 6345');
INSERT INTO CISC191.customers VALUES ('6bd7e1eed','Rush Mueller',30,'rushmueller@sdccd.edu','+1 (825) 511-2583','314 Turnbull Avenue, Teasdale, North Carolina, 8480');
INSERT INTO CISC191.customers VALUES ('fa1b6dcfa','Lloyd Hancock',34,'lloydhancock@sdccd.edu','+1 (923) 509-2267','525 Strong Place, Chesapeake, South Carolina, 1028');
INSERT INTO CISC191.customers VALUES ('e67f35a34','Yesenia Higgins',35,'yeseniahiggins@sdccd.edu','+1 (826) 473-2052','805 Clarkson Avenue, Bluetown, Alaska, 5719');

DROP TABLE IF EXISTS CISC191.orders;
CREATE TABLE cisc191.orders (
  order_id VARCHAR(15) NOT NULL PRIMARY KEY,
  customer_id VARCHAR(45) NOT NULL,
  date_ordered DATE,
  FOREIGN KEY (customer_id) REFERENCES CISC191.customers(customer_id) ON UPDATE NO ACTION  ON DELETE NO ACTION
  );

INSERT INTO CISC191.orders VALUES ('ae3b57d442b0','210393ba0','2020-09-04');
INSERT INTO CISC191.orders VALUES ('1111a07c77b8','7691a256f','2019-08-10');
INSERT INTO CISC191.orders VALUES ('929ceabcc747','3c2ededf6','2018-01-20');
INSERT INTO CISC191.orders VALUES ('8dd7d41c1b46','cbc938e3d','2019-07-10');
INSERT INTO CISC191.orders VALUES ('79ed934b371d','41a19d2b8','2019-01-14');
INSERT INTO CISC191.orders VALUES ('e19458638f3b','90906f7ef','2018-07-08');
INSERT INTO CISC191.orders VALUES ('45571c9e1ac3','a05b04a0f','2019-09-01');
INSERT INTO CISC191.orders VALUES ('7247151bdf06','b3648af27','2019-11-28');
INSERT INTO CISC191.orders VALUES ('051e9d0f93a1','a5f5c92af','2018-06-10');
INSERT INTO CISC191.orders VALUES ('3032b54bab7f','a5f5c92af','2018-08-12');
INSERT INTO CISC191.orders VALUES ('1d85dea84a53','f8b7e01ed','2018-07-19');
INSERT INTO CISC191.orders VALUES ('b80778a11297','38019c785','2018-07-16');
INSERT INTO CISC191.orders VALUES ('fedb1fc5314e','df1da324c','2020-01-15');
INSERT INTO CISC191.orders VALUES ('320eab8cada3','746863486','2020-02-03');
INSERT INTO CISC191.orders VALUES ('a42cde453bfa','237dfe35f','2018-05-28');
INSERT INTO CISC191.orders VALUES ('9f8634698ebe','734dae759','2019-06-14');
INSERT INTO CISC191.orders VALUES ('6866cdcd35dd','a579288e8','2020-06-26');
INSERT INTO CISC191.orders VALUES ('052f7647ff9a','2f6815ca4','2020-08-13');
INSERT INTO CISC191.orders VALUES ('d87bd7df8c6b','6bd7e1eed','2020-04-15');
INSERT INTO CISC191.orders VALUES ('9fc40b6d40c7','da5a16357','2018-12-06');
INSERT INTO CISC191.orders VALUES ('4912af0f5ca2','6b46f5694','2020-08-12');
INSERT INTO CISC191.orders VALUES ('e5120c8d4fcb','3434bb35f','2019-03-13');
INSERT INTO CISC191.orders VALUES ('b27cd55d19fc','413cf446a','2018-11-06');
INSERT INTO CISC191.orders VALUES ('c580b2912870','dcbc3a1d1','2018-03-13');
INSERT INTO CISC191.orders VALUES ('489ed10eb3bd','760b45fbd','2018-10-20');
INSERT INTO CISC191.orders VALUES ('deac7f67d35a','56b2755e2','2018-08-21');
INSERT INTO CISC191.orders VALUES ('c228ca698661','902f9a664','2020-10-09');
INSERT INTO CISC191.orders VALUES ('500cf37e354b','381538c30','2018-04-29');
INSERT INTO CISC191.orders VALUES ('aee396abe303','0c81b9ba0','2019-11-09');
INSERT INTO CISC191.orders VALUES ('f973a60b2dc3','210393ba0','2020-07-25');
INSERT INTO CISC191.orders VALUES ('c2f17f3c298f','352a5469f','2019-04-13');
INSERT INTO CISC191.orders VALUES ('9cb1d7943144','7ecf417b7','2018-08-10');
INSERT INTO CISC191.orders VALUES ('3849fb5b2e84','4e9e1fd6b','2018-03-06');
INSERT INTO CISC191.orders VALUES ('19d77d93049e','38019c785','2020-08-05');
INSERT INTO CISC191.orders VALUES ('a0816c358b1b','3434bb35f','2018-12-24');
INSERT INTO CISC191.orders VALUES ('56076110e3d7','6e592e07a','2019-07-11');
INSERT INTO CISC191.orders VALUES ('869dc55e9207','0d7c82fd9','2018-12-10');
INSERT INTO CISC191.orders VALUES ('a7c654f885b8','623559382','2018-07-23');
INSERT INTO CISC191.orders VALUES ('d9361581349c','49d63373d','2018-05-02');
INSERT INTO CISC191.orders VALUES ('540657fdd15c','b3648af27','2019-02-11');
INSERT INTO CISC191.orders VALUES ('3f35e70a1f03','946cc854a','2020-05-05');
INSERT INTO CISC191.orders VALUES ('be88d23f47b7','760b45fbd','2019-04-28');
INSERT INTO CISC191.orders VALUES ('1ca3870e98ce','4993407d4','2018-07-06');
INSERT INTO CISC191.orders VALUES ('653a6cf12d55','62c94a91c','2019-04-25');
INSERT INTO CISC191.orders VALUES ('8bb98bae1d8a','88def38a2','2019-09-24');
INSERT INTO CISC191.orders VALUES ('ff653cc3df4f','2bf033c30','2020-02-04');
INSERT INTO CISC191.orders VALUES ('58011a227c10','ba072e54a','2018-08-14');
INSERT INTO CISC191.orders VALUES ('a59148c0bf51','5390af252','2020-03-23');
INSERT INTO CISC191.orders VALUES ('ec4ec801c06b','87084f8cb','2020-09-08');
INSERT INTO CISC191.orders VALUES ('ec3a42efdc3b','d216db778','2018-03-23');

DROP TABLE IF EXISTS CISC191.order_items;
CREATE TABLE CISC191.order_items(
    order_id VARCHAR(50) NOT NULL,
    isbn VARCHAR(70) NOT NULL,
    quantity INT,
	CONSTRAINT fk_order_id
		FOREIGN KEY (order_id) REFERENCES ORDERS(order_id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_book_isbn
        FOREIGN KEY (isbn) REFERENCES BOOKS(isbn) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CHECK (quantity >= 1),
    PRIMARY KEY (order_id,isbn));

INSERT INTO CISC191.order_items VALUES ('aee396abe303','1935182722','3');
INSERT INTO CISC191.order_items VALUES ('aee396abe303','188477752X','3');
INSERT INTO CISC191.order_items VALUES ('869dc55e9207','1884777295','1');
INSERT INTO CISC191.order_items VALUES ('869dc55e9207','1933988290','2');
INSERT INTO CISC191.order_items VALUES ('ae3b57d442b0','1932394990','1');
INSERT INTO CISC191.order_items VALUES ('f973a60b2dc3','1933988649','4');
INSERT INTO CISC191.order_items VALUES ('a42cde453bfa','1932394699','1');
INSERT INTO CISC191.order_items VALUES ('a42cde453bfa','1933988509','2');
INSERT INTO CISC191.order_items VALUES ('ff653cc3df4f','1935182722','2');
INSERT INTO CISC191.order_items VALUES ('052f7647ff9a','1933988762','2');
INSERT INTO CISC191.order_items VALUES ('a0816c358b1b','1933988509','4');
INSERT INTO CISC191.order_items VALUES ('a0816c358b1b','1935182870','4');
INSERT INTO CISC191.order_items VALUES ('e5120c8d4fcb','1933988320','3');
INSERT INTO CISC191.order_items VALUES ('c2f17f3c298f','1884777600','3');
INSERT INTO CISC191.order_items VALUES ('c2f17f3c298f','1933988657','3');
INSERT INTO CISC191.order_items VALUES ('19d77d93049e','193239415X','3');
INSERT INTO CISC191.order_items VALUES ('b80778a11297','1884777791','4');
INSERT INTO CISC191.order_items VALUES ('500cf37e354b','1932394990','2');
INSERT INTO CISC191.order_items VALUES ('929ceabcc747','1935182323','3');
INSERT INTO CISC191.order_items VALUES ('b27cd55d19fc','1884777295','2');
INSERT INTO CISC191.order_items VALUES ('b27cd55d19fc','1884777600','2');
INSERT INTO CISC191.order_items VALUES ('79ed934b371d','1884777791','1');
INSERT INTO CISC191.order_items VALUES ('79ed934b371d','1935182307','4');
INSERT INTO CISC191.order_items VALUES ('1ca3870e98ce','1933988320','1');
INSERT INTO CISC191.order_items VALUES ('d9361581349c','1884777791','4');
INSERT INTO CISC191.order_items VALUES ('3849fb5b2e84','1884777384','2');
INSERT INTO CISC191.order_items VALUES ('a59148c0bf51','1933988649','1');
INSERT INTO CISC191.order_items VALUES ('a59148c0bf51','133046192','3');
INSERT INTO CISC191.order_items VALUES ('deac7f67d35a','1933988320','2');
INSERT INTO CISC191.order_items VALUES ('a7c654f885b8','1884777864','3');
INSERT INTO CISC191.order_items VALUES ('a7c654f885b8','1933988592','4');
INSERT INTO CISC191.order_items VALUES ('653a6cf12d55','1932394699','3');
INSERT INTO CISC191.order_items VALUES ('653a6cf12d55','1930110529','2');
INSERT INTO CISC191.order_items VALUES ('4912af0f5ca2','1932394826','3');
INSERT INTO CISC191.order_items VALUES ('d87bd7df8c6b','1932394613','4');
INSERT INTO CISC191.order_items VALUES ('56076110e3d7','1930110529','4');
INSERT INTO CISC191.order_items VALUES ('9f8634698ebe','1884777368','3');
INSERT INTO CISC191.order_items VALUES ('320eab8cada3','1932394990','1');
INSERT INTO CISC191.order_items VALUES ('320eab8cada3','1932394826','4');
INSERT INTO CISC191.order_items VALUES ('489ed10eb3bd','1932394699','3');
INSERT INTO CISC191.order_items VALUES ('489ed10eb3bd','1617290084','2');
INSERT INTO CISC191.order_items VALUES ('be88d23f47b7','1932394613','1');
INSERT INTO CISC191.order_items VALUES ('be88d23f47b7','1935182722','4');
INSERT INTO CISC191.order_items VALUES ('1111a07c77b8','1884777384','2');
INSERT INTO CISC191.order_items VALUES ('9cb1d7943144','193398886X','3');
INSERT INTO CISC191.order_items VALUES ('9cb1d7943144','1935182080','3');
INSERT INTO CISC191.order_items VALUES ('ec4ec801c06b','1884777368','2');
INSERT INTO CISC191.order_items VALUES ('8bb98bae1d8a','193398886X','3');
INSERT INTO CISC191.order_items VALUES ('8bb98bae1d8a','1935182323','3');
INSERT INTO CISC191.order_items VALUES ('c228ca698661','1884777864','1');
INSERT INTO CISC191.order_items VALUES ('e19458638f3b','1933988762','3');
INSERT INTO CISC191.order_items VALUES ('e19458638f3b','1933988320','2');
INSERT INTO CISC191.order_items VALUES ('3f35e70a1f03','1884777686','4');
INSERT INTO CISC191.order_items VALUES ('3f35e70a1f03','193239415X','3');
INSERT INTO CISC191.order_items VALUES ('45571c9e1ac3','1933988711','4');
INSERT INTO CISC191.order_items VALUES ('45571c9e1ac3','1884777791','1');
INSERT INTO CISC191.order_items VALUES ('6866cdcd35dd','1935182323','1');
INSERT INTO CISC191.order_items VALUES ('6866cdcd35dd','1933988452','2');
INSERT INTO CISC191.order_items VALUES ('051e9d0f93a1','1932394990','1');
INSERT INTO CISC191.order_items VALUES ('3032b54bab7f','1884777295','2');
INSERT INTO CISC191.order_items VALUES ('3032b54bab7f','1884777600','4');
INSERT INTO CISC191.order_items VALUES ('540657fdd15c','1935182463','4');
INSERT INTO CISC191.order_items VALUES ('7247151bdf06','1933988320','3');
INSERT INTO CISC191.order_items VALUES ('7247151bdf06','1933988673','1');
INSERT INTO CISC191.order_items VALUES ('58011a227c10','1933988657','3');
INSERT INTO CISC191.order_items VALUES ('58011a227c10','1932394613','1');
INSERT INTO CISC191.order_items VALUES ('8dd7d41c1b46','1933988762','1');
INSERT INTO CISC191.order_items VALUES ('8dd7d41c1b46','133034054','1');
INSERT INTO CISC191.order_items VALUES ('ec3a42efdc3b','1933988355','2');
INSERT INTO CISC191.order_items VALUES ('9fc40b6d40c7','1933988762','4');
INSERT INTO CISC191.order_items VALUES ('c580b2912870','193239415X','2');
INSERT INTO CISC191.order_items VALUES ('fedb1fc5314e','1933988673','3');
INSERT INTO CISC191.order_items VALUES ('fedb1fc5314e','1935182234','1');
INSERT INTO CISC191.order_items VALUES ('1d85dea84a53','1935182234','4');



