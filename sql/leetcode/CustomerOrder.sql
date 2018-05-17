create table Customers (Id int, Name varchar(10));
create table Orders (Id int, CustomerId int);
insert into Orders (Id, CustomerId) values (1,3);
insert into Orders (Id, CustomerId) values (2,1);


insert into Customers (Id, Name) values (1,'Joe');
insert into Customers (Id, Name) values (2,'Henry');
insert into Customers (Id, Name) values (3,'Sam');
insert into Customers (Id, Name) values (4,'Max');


select A.Name as Customers from Customers A where not exists (select 1 from Orders B where A.Id = B.CustomerId);
