create table book(
                   isbn varchar(50) primary key,
                   book_name varchar(100),
                   price int
);

create table book_stock(
                         isbn varchar(50) primary key,
                         stock int,
                         check(stock > 0)
);

create table account(
                      username varchar(50) primary key,
                      balance int,
                      check(balance > 0)
);
