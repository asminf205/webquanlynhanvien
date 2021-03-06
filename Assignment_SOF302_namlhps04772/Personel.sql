USE master
GO
--Tạo CSDL Personel
CREATE DATABASE Personel
GO
--Chọn CSDL làm việc
USE Personel
GO
--Tạo bảng User lưu thông tin người sử dụng
CREATE TABLE Users(
	Username nvarchar(50) NOT NULL,
	Password nvarchar(50) NOT NULL,
	Fullname nvarchar(50) NOT NULL,
	PRIMARY KEY(Username)
)
GO
--Tạo bảng Departs lưu thông tin phòng ban
CREATE TABLE Departs(
	Id nvarchar(10) NOT NULL,
	Name nvarchar(50) NOT NULL,
	PRIMARY KEY(Id)
)
GO
--Tạo bảng Staffs lưu thông tin nhân viên
CREATE TABLE Staffs(
	Id nvarchar(10) NOT NULL,
	Name nvarchar(50) NOT NULL,
	Gender bit NOT NULL,
	Birthday date NOT NULL,
	Photo nvarchar(50) NOT NULL,
	Email nvarchar(50) NOT NULL,
	Phone nvarchar(25) NOT NULL,
	Salary float NOT NULL,
	Notes nvarchar(500) NULL,
	DepartId nvarchar(10) NOT NULL,
	PRIMARY KEY(Id),
	FOREIGN KEY(DepartId) REFERENCES Departs(Id) ON DELETE CASCADE ON UPDATE CASCADE
)
GO
--Tạo bảng Records lưu thông tin thành tích và kỷ luật của nhân viên
CREATE TABLE Records(
	Id bigint IDENTITY(1,1) NOT NULL,
	Type int NOT NULL,
	Reason nvarchar(200) NOT NULL,
	Date date NOT NULL,
	StaffId nvarchar(10) NOT NULL,
	PRIMARY KEY(Id),
	FOREIGN KEY(StaffId) REFERENCES Staffs(Id) ON DELETE NO ACTION ON UPDATE CASCADE
 )
 GO
 insert into Users values('namlh','123','Le Hoang Nam');