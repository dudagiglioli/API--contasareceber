alter table contasareceber add constraint FK_cliente_contasareceber
                    foreign key (idcliente) references cliente(id);

insert into cliente(nomecliente) values('José Aparecido');
insert into cliente(nomecliente) values('Maria Clara');
insert into cliente(nomecliente) values('Eduardo');
insert into cliente(nomecliente) values('Fernanda');
insert into cliente(nomecliente) values('Antônio');

insert into contasareceber(dataconta, idcliente, valorconta) values('2019-09-11', 5, '1.500');
insert into contasareceber(dataconta, idcliente, valorconta) values('2020-02-11', 3, '2.300');
insert into contasareceber(dataconta, idcliente, valorconta) values('2022-12-11', 1, '5.000');
insert into contasareceber(dataconta, idcliente, valorconta) values('2023-8-11', 4, '500');
insert into contasareceber(dataconta, idcliente, valorconta) values('2023-10-11', 2, '1.000');