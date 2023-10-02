Create TABLE Comp_dep(
Comp_dep_code char(4),
Comp_dep_name nvarchar(4) not null,
primary key(Comp_dep_code)
)

Create TABLE Employee(
Em_id char(5),
Em_name nvarchar(4) not null,
Em_code char(4)
primary key(Em_id),
foreign key(Em_code) references Comp_dep(Comp_dep_code)
)