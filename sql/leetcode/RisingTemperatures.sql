create table Weather (id int, recordDate date, temp int);
insert into Weather (id, recordDate, temp) values (1, '2015-01-01', 10);
insert into Weather (id, recordDate, temp) values(2, '2015-01-02',25);
insert into Weather (id, recordDate, temp) values(3, '2015-01-03',20);
insert into Weather (id, recordDate, temp) values(4, '2015-01-04',30);

select w1.id from Weather w1, Weather w2 where w1.temp > w2.temp and to_days(w1.recordDate)-to_days(w2.recordDate)=1;
