USE [master]
GO
/****** Object:  Database [HostelManagement]    Script Date: 6/15/2022 2:57:44 PM ******/
CREATE DATABASE [HostelManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HostelManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\HostelManagement_log.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HostelManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\HostelManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [HostelManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HostelManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HostelManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HostelManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HostelManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HostelManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HostelManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [HostelManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HostelManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HostelManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HostelManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HostelManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HostelManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HostelManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HostelManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HostelManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HostelManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [HostelManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HostelManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HostelManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HostelManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HostelManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HostelManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HostelManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HostelManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HostelManagement] SET  MULTI_USER 
GO
ALTER DATABASE [HostelManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HostelManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HostelManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HostelManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [HostelManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [HostelManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'HostelManagement', N'ON'
GO
ALTER DATABASE [HostelManagement] SET QUERY_STORE = OFF
GO
USE [HostelManagement]
GO
/****** Object:  Table [dbo].[tblBill]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBill](
	[idBill] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[idRoom] [nvarchar](10) NOT NULL,
	[idUser] [nvarchar](10) NOT NULL,
	[detail] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblBill] PRIMARY KEY CLUSTERED 
(
	[idBill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[idCategory] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[detail] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[idCategory] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblContract]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblContract](
	[idContract] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[deposit] [float] NOT NULL,
	[detail] [nvarchar](50) NOT NULL,
	[idUser] [nvarchar](10) NOT NULL,
	[idRoom] [nvarchar](10) NOT NULL,
	[beginDate] [date] NOT NULL,
	[endDate] [date] NOT NULL,
 CONSTRAINT [PK_tblContract] PRIMARY KEY CLUSTERED 
(
	[idContract] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFeedback]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFeedback](
	[idFeedback] [nvarchar](20) NOT NULL,
	[name] [nvarchar](20) NOT NULL,
	[idUser] [nvarchar](10) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblFeedback] PRIMARY KEY CLUSTERED 
(
	[idFeedback] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFees]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFees](
	[idFee] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[detail] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[idBill] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblFees] PRIMARY KEY CLUSTERED 
(
	[idFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblImage]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblImage](
	[idImg] [nvarchar](10) NOT NULL,
	[nameImg] [nvarchar](20) NOT NULL,
	[image] [image] NOT NULL,
	[idRoom] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblImage] PRIMARY KEY CLUSTERED 
(
	[idImg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNotification]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNotification](
	[idNotification] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[detail] [nvarchar](50) NOT NULL,
	[idUser] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblNotification] PRIMARY KEY CLUSTERED 
(
	[idNotification] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPayment]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPayment](
	[idPayment] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[methodUser] [nvarchar](20) NOT NULL,
	[idUser] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblPayment] PRIMARY KEY CLUSTERED 
(
	[idPayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRegulation]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRegulation](
	[idRegulation] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[idFee] [nvarchar](10) NOT NULL,
	[dateEdit] [date] NOT NULL,
	[idRoom] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblRegulation] PRIMARY KEY CLUSTERED 
(
	[idRegulation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRooms]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRooms](
	[idRoom] [nvarchar](10) NOT NULL,
	[name] [nvarchar](30) NOT NULL,
	[idCategory] [nvarchar](10) NOT NULL,
	[quantity] [int] NOT NULL,
	[detail] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_tblRooms] PRIMARY KEY CLUSTERED 
(
	[idRoom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblService]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblService](
	[idService] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[detail] [nvarchar](50) NOT NULL,
	[electricUsing] [float] NOT NULL,
	[waterUsing] [float] NOT NULL,
	[price] [float] NOT NULL,
 CONSTRAINT [PK_tblService] PRIMARY KEY CLUSTERED 
(
	[idService] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblServiceDetails]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblServiceDetails](
	[idServiceDetails] [nvarchar](10) NOT NULL,
	[idService] [nvarchar](10) NOT NULL,
	[idBill] [nvarchar](10) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tblServiceDetails] PRIMARY KEY CLUSTERED 
(
	[idServiceDetails] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 6/15/2022 2:57:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[idUser] [nvarchar](10) NOT NULL,
	[username] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[email] [nvarchar](400) NOT NULL,
	[address] [nvarchar](20) NOT NULL,
	[phone] [nvarchar](10) NOT NULL,
	[citizenIndentification] [nvarchar](20) NOT NULL,
	[status] [bit] NOT NULL,
	[role] [nvarchar](20) NOT NULL,
	[image] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[idUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblCategory] ([idCategory], [name], [detail], [price]) VALUES (N'1', N'Phong 2', N'2 nguoi o ', 300000)
GO
INSERT [dbo].[tblRooms] ([idRoom], [name], [idCategory], [quantity], [detail]) VALUES (N'1', N'Room 1', N'1', 1, N'rong, sach se')
INSERT [dbo].[tblRooms] ([idRoom], [name], [idCategory], [quantity], [detail]) VALUES (N'2', N'Room 2', N'1', 2, N'fiasdjfoiasdj')
GO
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIndentification], [status], [role], [image]) VALUES (N'1', N'1gfour', N'1', N'Phat Hung Phat', N'hungphatpl@gmail.com', N'Soc Trang', N'0833231856', N'123123123', 1, N'STAFF', NULL)
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIndentification], [status], [role], [image]) VALUES (N'2', N'bitano111', N'1', N'Pham Hung Phat', N'hungphatpl1@gmail.com', N'Soc Trang', N'0903477277', N'12313212312', 1, N'STAFF', NULL)
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIndentification], [status], [role], [image]) VALUES (N'3', N'bitano11', N'1', N'Hung Phat Pham', N'hungphatpl1@gmail.com', N'Soc Trang', N'0454454456', N'312233231', 1, N'STAFF', N'pic-4.png')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIndentification], [status], [role], [image]) VALUES (N'4', N'hungphat', N'1', N'pham hung phat', N'hungphatpl2@gmail.com', N'Quan 9', N'0833231856', N'123123123', 1, N'STAFF', N'blog-5.jpg')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIndentification], [status], [role], [image]) VALUES (N'5', N'bitano2', N'1', N'Bi ta no', N'asdgasd@gmail.com', N'Soc trang', N'0833238195', N'123123123', 1, N'STAFF', N'blog-1.jpg')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIndentification], [status], [role], [image]) VALUES (N'6', N'phucne1312', N'1', N'Bi ta no', N'asdgasd@gmail.com', N'Soc trang', N'0833238195', N'123123123', 1, N'US', N'blog-3.jpg')
GO
ALTER TABLE [dbo].[tblBill]  WITH CHECK ADD  CONSTRAINT [FK_tblBill_tblRooms] FOREIGN KEY([idRoom])
REFERENCES [dbo].[tblRooms] ([idRoom])
GO
ALTER TABLE [dbo].[tblBill] CHECK CONSTRAINT [FK_tblBill_tblRooms]
GO
ALTER TABLE [dbo].[tblBill]  WITH CHECK ADD  CONSTRAINT [FK_tblBill_tblUser] FOREIGN KEY([idUser])
REFERENCES [dbo].[tblUser] ([idUser])
GO
ALTER TABLE [dbo].[tblBill] CHECK CONSTRAINT [FK_tblBill_tblUser]
GO
ALTER TABLE [dbo].[tblContract]  WITH CHECK ADD  CONSTRAINT [FK_tblContract_tblRooms] FOREIGN KEY([idRoom])
REFERENCES [dbo].[tblRooms] ([idRoom])
GO
ALTER TABLE [dbo].[tblContract] CHECK CONSTRAINT [FK_tblContract_tblRooms]
GO
ALTER TABLE [dbo].[tblContract]  WITH CHECK ADD  CONSTRAINT [FK_tblContract_tblUser] FOREIGN KEY([idUser])
REFERENCES [dbo].[tblUser] ([idUser])
GO
ALTER TABLE [dbo].[tblContract] CHECK CONSTRAINT [FK_tblContract_tblUser]
GO
ALTER TABLE [dbo].[tblFeedback]  WITH CHECK ADD  CONSTRAINT [FK_tblFeedback_tblUser] FOREIGN KEY([idUser])
REFERENCES [dbo].[tblUser] ([idUser])
GO
ALTER TABLE [dbo].[tblFeedback] CHECK CONSTRAINT [FK_tblFeedback_tblUser]
GO
ALTER TABLE [dbo].[tblFees]  WITH CHECK ADD  CONSTRAINT [FK_tblFees_tblBill] FOREIGN KEY([idBill])
REFERENCES [dbo].[tblBill] ([idBill])
GO
ALTER TABLE [dbo].[tblFees] CHECK CONSTRAINT [FK_tblFees_tblBill]
GO
ALTER TABLE [dbo].[tblImage]  WITH CHECK ADD  CONSTRAINT [FK_tblImage_tblRooms] FOREIGN KEY([idRoom])
REFERENCES [dbo].[tblRooms] ([idRoom])
GO
ALTER TABLE [dbo].[tblImage] CHECK CONSTRAINT [FK_tblImage_tblRooms]
GO
ALTER TABLE [dbo].[tblNotification]  WITH CHECK ADD  CONSTRAINT [FK_tblNotification_tblUser] FOREIGN KEY([idUser])
REFERENCES [dbo].[tblUser] ([idUser])
GO
ALTER TABLE [dbo].[tblNotification] CHECK CONSTRAINT [FK_tblNotification_tblUser]
GO
ALTER TABLE [dbo].[tblPayment]  WITH CHECK ADD  CONSTRAINT [FK_tblPayment_tblUser] FOREIGN KEY([idUser])
REFERENCES [dbo].[tblUser] ([idUser])
GO
ALTER TABLE [dbo].[tblPayment] CHECK CONSTRAINT [FK_tblPayment_tblUser]
GO
ALTER TABLE [dbo].[tblRegulation]  WITH CHECK ADD  CONSTRAINT [FK_tblRegulation_tblFees] FOREIGN KEY([idFee])
REFERENCES [dbo].[tblFees] ([idFee])
GO
ALTER TABLE [dbo].[tblRegulation] CHECK CONSTRAINT [FK_tblRegulation_tblFees]
GO
ALTER TABLE [dbo].[tblRegulation]  WITH CHECK ADD  CONSTRAINT [FK_tblRegulation_tblRooms] FOREIGN KEY([idRoom])
REFERENCES [dbo].[tblRooms] ([idRoom])
GO
ALTER TABLE [dbo].[tblRegulation] CHECK CONSTRAINT [FK_tblRegulation_tblRooms]
GO
ALTER TABLE [dbo].[tblRooms]  WITH CHECK ADD  CONSTRAINT [FK_tblRooms_tblCategory] FOREIGN KEY([idCategory])
REFERENCES [dbo].[tblCategory] ([idCategory])
GO
ALTER TABLE [dbo].[tblRooms] CHECK CONSTRAINT [FK_tblRooms_tblCategory]
GO
ALTER TABLE [dbo].[tblServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblServiceDetails_tblBill] FOREIGN KEY([idBill])
REFERENCES [dbo].[tblBill] ([idBill])
GO
ALTER TABLE [dbo].[tblServiceDetails] CHECK CONSTRAINT [FK_tblServiceDetails_tblBill]
GO
ALTER TABLE [dbo].[tblServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblServiceDetails_tblService] FOREIGN KEY([idService])
REFERENCES [dbo].[tblService] ([idService])
GO
ALTER TABLE [dbo].[tblServiceDetails] CHECK CONSTRAINT [FK_tblServiceDetails_tblService]
GO
USE [master]
GO
ALTER DATABASE [HostelManagement] SET  READ_WRITE 
GO
