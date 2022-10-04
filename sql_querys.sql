CREATE DATABASE MyBookShelf;

use MyBookShelf;

CREATE TABLE library(
id varchar(50),
book_name varchar(50),
isbn varchar(50),
author varchar(50),
imgUrl varchar(2048),
year int,
isRead bool,
PRIMARY KEY (id));

INSERT INTO library(id, book_name, isbn, author, imgUrl, year, isRead) values("978-65-5921-083-1-2021","Política é para todos","978-65-5921-083-1","Gabriela Prioli","https://m.media-amazon.com/images/I/61QDJdGB6cS.jpg", 2021, false);

select * from library;

