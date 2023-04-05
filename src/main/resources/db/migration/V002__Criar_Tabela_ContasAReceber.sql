create table contasareceber(
id int not null primary key auto_increment,
dataconta date,
idcliente int not null,
valorconta decimal (12,2)
);
