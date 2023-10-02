Create TABLE Employee2(
Em_id char(5),
Em_name nvarchar(4) not null,
sex char(4) null,
primary key(Em_id)
)

Create TABLE performance(
Em_id char(5),
Q1 int,
Q2 int
primary key(Em_id),
foreign key(Em_id) references Employee2(Em_id)
)