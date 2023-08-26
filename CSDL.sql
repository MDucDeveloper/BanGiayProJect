--use DA1

create table Hang
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null
)
go

--INSERT INTO Hang(Ten)
--VALUES ('Nike'),
--       ('Adidas'),
--       ('Puma'),
--       ('New Balance'),
--       ('Converse')
--go

create table Kichco
(
	Id int identity(1,1) primary key,
	Giatri int not null
)
go

--INSERT INTO Kichco(Giatri)
--VALUES (36),
--       (37),
--       (38),
--       (39),
--       (40),
--	   (41),
--	   (42),
--	   (43),
--	   (35)
--go
--select * from Kichco

create table Loaigiay
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null
)
go

--INSERT INTO Loaigiay(Ten)
--VALUES ('Sneaker'),
--       ('Boot'),
--       ('Sandal'),
--       ('Running'),
--       ('High Heels')
--go
--select * from Loaigiay

create table Mausac
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null
)
go

--INSERT INTO Mausac(Ten)
--VALUES (N'Đen'),
--       (N'Trắng'),
--       (N'Xanh'),
--       (N'Đỏ'),
--       (N'Vàng'),
--	   (N'Tím')
--go
--select * from Mausac


create table Chatlieu
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null
)
go

--INSERT INTO Chatlieu(Ten)
--VALUES (N'Da'),
--       (N'Vải'),
--       (N'Nhựa'),
--       (N'Da tổng hợp'),
--       (N'Canvas')
--go

create table Thuonghieu
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null
)
go

--INSERT INTO Thuonghieu(Ten)
--VALUES ('Nike'),
--       ('Adidas'),
--       ('Puma'),
--       ('New Balance'),
--       ('Converse')
--go

create table Xuatsu
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null
)
go

--INSERT INTO Xuatsu(Ten)
--VALUES (N'Mỹ'),
--       (N'Đức'),
--       (N'Việt Nam'),
--       (N'Anh'),
--       (N'Trung Quốc')
--go

create table Product
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null,
	Mota nvarchar(MAX) null,
	Gia int not null,
	ngaycapnhap date null,
	Id_hang int references Hang(Id),
	Id_kichco int references Kichco(Id),
	Id_loaigiay int references Loaigiay(Id),
	Id_mausac int references Mausac(Id),
	Id_chatlieu int references Chatlieu(Id),
	Id_thuonghieu int references Thuonghieu(Id),
	Id_xuatxu int references Xuatsu(Id)
)
go

select * from Product where  Id_kichco = 5



--alter table Product
--add image varchar(50)
--drop table Product

--VALUES ('Sneaker'),
--       ('Boot'),
--       ('Sandal'),
--       ('Running'),
--       ('High Heels')
--go
INSERT INTO Product(Ten,Mota,Gia,Id_hang,Id_kichco,Id_loaigiay,Id_mausac,Id_chatlieu,Id_thuonghieu,Id_xuatxu,ngaycapnhap,image)
VALUES 
('Converse One Star', N'Giày thể thao nổi tiếng với dấu sao từ Converse', 850000, 5, 4, 1, 7, 1, 3, 4,'11-11-2023','giay1.jpg'),
('Converse One Star II', N'Giày thể thao với đế cao su đặc trưng và vẻ ngoài phong cách', 1100000, 2, 3, 1, 8, 1, 2, 1, '08-07-2023','giay2.jpg'),
('Converse One Star X', N'Giày da với thiết kế vintage và phong cách thể thao', 900000, 3, 4, 1, 10, 1, 3, 2, '09-10-2023','giay3.jpg'),
('Converse One Star IV', N'Giày chạy bền bỉ với công nghệ đệm tốt và thiết kế đa phong cách', 1300000, 4, 5, 1, 11, 1, 4, 3, '10-10-2023','giay4.jpg'),
('Converse One Star V', N'Giày cao cổ kinh điển với đế cao su và phong cách đơn giản', 800000, 5, 3, 1, 9, 1, 5, 5, '11-12-2023','giay5.jpg'),

('Puma Suede Classic I', N'Giày thể thao nổi tiếng với dấu sao từ Converse', 850000, 5, 4, 2, 7, 1, 3, 4,'11-11-2023','boot1.jpg'),
('Puma Suede Classic II', N'Giày thể thao với đế cao su đặc trưng và vẻ ngoài phong cách', 1100000, 2, 3, 2, 8, 1, 2, 1, '08-07-2023','boot3.jpg'),
('Puma Suede Classic X', N'Giày da với thiết kế vintage và phong cách thể thao', 900000, 3, 4, 2, 10, 1, 3, 2, '09-10-2023','boot4.jpg'),
('Puma Suede Classic IV', N'Giày chạy bền bỉ với công nghệ đệm tốt và thiết kế đa phong cách', 1300000, 4, 5, 2, 11, 1, 4, 3, '10-10-2023','boot5.jpg'),
('Puma Suede Classic V', N'Giày cao cổ kinh điển với đế cao su và phong cách đơn giản', 800000, 5, 3, 2, 9, 1, 5, 5, '11-12-2023','boot6.jpg'),

('Adidas Superstar', N'Giày thể thao nổi tiếng với dấu sao từ Converse', 850000, 5, 4, 3, 7, 1, 3, 4,'11-11-2023','sandal1.jpg'),
('Adidas Superstar', N'Giày thể thao với đế cao su đặc trưng và vẻ ngoài phong cách', 1100000, 2, 3, 3, 8, 1, 2, 1, '08-07-2023','sandal2.jpg'),
('Adidas Superstar', N'Giày da với thiết kế vintage và phong cách thể thao', 900000, 3, 4, 3, 10, 1, 3, 2, '09-10-2023','sandal3.jpg'),
('Adidas Superstar', N'Giày chạy bền bỉ với công nghệ đệm tốt và thiết kế đa phong cách', 1300000, 4, 5, 3, 11, 1, 4, 3, '10-10-2023','sandal4.jpg'),
('Adidas Superstar', N'Giày cao cổ kinh điển với đế cao su và phong cách đơn giản', 800000, 5, 3, 3, 9, 1, 5, 5, '11-12-2023','sandal5.jpg'),

('New Balance 574 I', N'Giày thể thao nổi tiếng với dấu sao từ Converse', 850000, 5, 4, 4, 7, 1, 3, 4,'11-11-2023','running1.jpg'),
('New Balance 574 II', N'Giày thể thao với đế cao su đặc trưng và vẻ ngoài phong cách', 1100000, 2, 3, 4, 8, 1, 2, 1, '08-07-2023','running2.jpg'),
('New Balance 574 C', N'Giày da với thiết kế vintage và phong cách thể thao', 900000, 3, 4, 4, 10, 1, 3, 2, '09-10-2023','running3.jpg'),
('New Balance 574 IIA', N'Giày chạy bền bỉ với công nghệ đệm tốt và thiết kế đa phong cách', 1300000, 4, 5, 4, 11, 1, 4, 3, '10-10-2023','running4.jpg'),
('New Balance 574 X', N'Giày cao cổ kinh điển với đế cao su và phong cách đơn giản', 800000, 5, 3, 4, 9, 1, 5, 5, '11-12-2023','running5.jpg'),

('Chuck Taylor Star IV', N'Giày thể thao nổi tiếng với dấu sao từ Converse', 850000, 5, 4, 5, 7, 1, 3, 4,'11-11-2023','highheel1.jpg'),
('Chuck Taylor Star VI', N'Giày thể thao với đế cao su đặc trưng và vẻ ngoài phong cách', 1100000, 2, 3, 5, 8, 1, 2, 1, '08-07-2023','highheel2.jpg'),
('Chuck Taylor Star 23-A', N'Giày da với thiết kế vintage và phong cách thể thao', 900000, 3, 4, 5, 10, 1, 3, 2, '09-10-2023','highheel3.jpg'),
('Chuck Taylor Star 1C', N'Giày chạy bền bỉ với công nghệ đệm tốt và thiết kế đa phong cách', 1300000, 4, 5, 5, 11, 1, 4, 3, '10-10-2023','highheel4.jpg'),
('Chuck Taylor Star II', N'Giày cao cổ kinh điển với đế cao su và phong cách đơn giản', 800000, 5, 3, 5, 9, 1, 5, 5, '11-12-2023','highheel5.jpg')
go
--select * from HoaDon
create table KhachHang
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) null,
	Diachi nvarchar(50) null,
	Sdt varchar(11) null,
	Email varchar(30) null,
	Ngaysinh date null
)
go

--INSERT INTO KhachHang(Ten,Diachi,Sdt,Email,Ngaysinh)
--VALUES 
--(N'Nguyễn Văn A', N'123 Đường ABC, Quận X, Thành phố Y', '0901234567', 'nguyenvana@example.com', '1990-01-01'),
--(N'Trần Thị B', N'456 Đường XYZ, Quận P, Thành phố Q', '0912345678', 'tranthib@example.com', '1995-05-10'),
--(N'Lê Văn C', N'789 Đường DEF, Quận R, Thành phố S', '0987654321', 'levanc@example.com', '1988-12-15'),
--(N'Phạm Thị D', N'111 Đường GHI, Quận T, Thành phố U', '0976543210', 'phamthid@example.com', '1992-07-20'),
--(N'Hoàng Văn E', N'222 Đường JKL, Quận V, Thành phố W', '0965432109', 'hoangvane@example.com', '1997-03-25');

--select * from KhachHang

create table Hoadon
(
	Id int identity(1,1) primary key,
	Ngaydathang date not null,
	Tongtien int not null,
	Diachi nvarchar(max) null,
	Id_khachhang int references Khachhang(Id),
	Id_account varchar(30) references Account(Username)
)
go

--INSERT INTO Hoadon(Id_khachhang,Ngaydathang,Tongtien)
--VALUES 
--    (1, '2023-07-08', 2500000),
--    (2, '2023-07-09', 1800000),
--    (3, '2023-07-10', 3500000),
--    (4, '2023-07-11', 1200000),
--    (5, '2023-07-12', 2800000)
--go
--select * from Hoadon

create table Hoadonchitiet
(
	Id int identity(1,1) primary key,
	Soluong int not null,
	Giaban int not null,
	Id_Donhang int references Hoadon(Id),
	ID_Sanpham int references Product(Id)
)
go

--INSERT INTO Hoadonchitiet(Id_Donhang,ID_Sanpham,Soluong,Giaban)
--VALUES 
--    (1, 4, 2, 1200000),
--    (1, 5, 1, 900000),
--    (2, 4, 1, 1100000),
--    (2, 7, 1, 1300000),
--    (3, 6, 1, 1200000),
--    (3, 7, 2, 900000),
--    (3, 7, 1, 800000),
--    (4, 8, 1, 1100000),
--    (5, 4, 2, 1200000),
--    (5, 6, 1, 1300000)
--go
--select * from Hoadonchitiet

create table Chucvu
(
	Id varchar(20) primary key,
	Ten nvarchar(30) not null
)
go


--INSERT [dbo].Chucvu ([Id], [Ten]) VALUES (N'CUST', N'Customers')
--INSERT [dbo].Chucvu ([Id], [Ten]) VALUES (N'DIRE', N'Directors')
--INSERT [dbo].Chucvu ([Id], [Ten]) VALUES (N'STAF', N'Staffs')
--go
--select * from Chucvu

create table Account
(
	Username varchar(30) primary key,
	Pass varchar(50),
	Fullname nvarchar(50),
	Email varchar(30),
	Photo varchar(100)
)
go

--select * from Account

--Insert into Account(Username,Pass,Fullname,Email,Photo)
--values('staff','123','Toi la NV','nv1@gmail.com',Null),
--('staff2','123456','Toi la NV','nv2@gmail.com',Null)
--go


create table Authority
(
	Id int identity(1,1) primary key,
	Id_Chucvu varchar(20) references Chucvu(Id),
	Id_Account varchar(30) references Account(Username),
	Id_Nhanvien int references Nhanvien(Id)
)
go

--select * from Authority

--Insert into Authority(Id_Chucvu,Id_Account,Id_Nhanvien)
--values('CUST','staff',1),
--('STAF','staff2',2)
--go

create table Nhanvien
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null,
	Ngaysinh date not null,
	Diachi nvarchar(50) not null,
	Sdt varchar(11) not null,
	Email varchar(30) not null,
)
go

--INSERT INTO Nhanvien(Ten, Ngaysinh, Diachi, Sdt, Email)
--VALUES 
--    (N'Nguyễn Văn A', '01-01-1999', N'123 Đường ABC, Quận X, Thành phố Y', '0901234567', 'nguyenvana@example.com'),
--    (N'Trần Thị B', '10-05-1995', N'456 Đường XYZ, Quận P, Thành phố Q', '0912345678', 'tranthib@example.com'),
--    (N'Lê Văn C', '12-15-1988', N'789 Đường DEF, Quận R, Thành phố S', '0987654321', 'levanc@example.com'),
--    (N'Phạm Thị D', '07-20-1997', N'111 Đường GHI, Quận T, Thành phố U', '0976543210', 'phamthid@example.com'),
--    (N'Hoàng Văn E', '03-12-1999', N'222 Đường JKL, Quận V, Thành phố W', '0965432109', 'hoangvane@example.com')
--go

--select * from Nhanvien

create table Khuyenmai
(
	Id int identity(1,1) primary key,
	Ten nvarchar(30) not null,
	Mota nvarchar(max) not null,
	Ngaybatdau date  null,
	Ngayketthuc date null,
	Giamgia int  null
)
go

--INSERT INTO Khuyenmai(Ten,Mota,Ngaybatdau,Ngayketthuc,Giamgia)
--VALUES 
--    ('SUMMER2023', 'Giảm giá 20% cho tất cả sản phẩm mùa hè', '01-06-2023', '08-31-2023', 20),
--    ('SALE50', 'Giảm giá 50% cho một số sản phẩm đặc biệt', '07-15-2023', '07-31-2023', 50),
--    ('FREESHIP', 'Miễn phí vận chuyển cho đơn hàng trên 1 triệu đồng', '01-07-2023', '01-31-2023', NULL),
--    ('FLASHSALE', 'Giảm giá 30% trong 2 giờ đầu ngày', '10-07-2023', '10-17-2023', 30),
--    ('WEEKEND20', 'Giảm giá 20% cho các sản phẩm cuối tuần', '07-22-2023', '07-24-2023', 20)
--go
--select * from Khuyenmai


