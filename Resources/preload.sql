DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(
    Id INT AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    Edition VARCHAR(5) NOT NULL,
    Price LONG,
    Stock INT,
    PRIMARY KEY (Id)
);
INSERT INTO BOOKS (Title, Author, Edition, Price, Stock) VALUES
                  ('C# 7.0 All-in-One','John Mueller', '1st', 34.44, 5),
                  ();
