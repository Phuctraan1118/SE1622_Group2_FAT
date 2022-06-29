USE [master]
GO
/****** Object:  Database [HostelManagement]    Script Date: 6/29/2022 2:40:20 PM ******/
CREATE DATABASE [HostelManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HostelManagement', FILENAME = N'D:\Kì 5\Complete\NguyenHostelManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HostelManagement_log', FILENAME = N'D:\Kì 5\Complete\Nguyen\HostelManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
ALTER DATABASE [HostelManagement] SET QUERY_STORE = OFF
GO
USE [HostelManagement]
GO
/****** Object:  Table [dbo].[tblBill]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBill](
	[billId] [int] NOT NULL,
	[billName] [nvarchar](50) NOT NULL,
	[roomId] [int] NOT NULL,
	[username] [nvarchar](100) NOT NULL,
	[detail] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_tblBill] PRIMARY KEY CLUSTERED 
(
	[billId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBooking]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBooking](
	[bookingId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
	[bookingDate] [nvarchar](20) NULL,
 CONSTRAINT [PK_tblBooking] PRIMARY KEY CLUSTERED 
(
	[bookingId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBookingDetail]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBookingDetail](
	[roomId] [int] NOT NULL,
	[bookingId] [int] NOT NULL,
	[checkInDate] [nvarchar](20) NOT NULL,
	[checkOutDate] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tblBookingDetail] PRIMARY KEY CLUSTERED 
(
	[roomId] ASC,
	[bookingId] ASC,
	[checkInDate] ASC,
	[checkOutDate] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFeedback]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFeedback](
	[feedbackId] [int] NOT NULL,
	[feedbackName] [nvarchar](100) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblFeedback] PRIMARY KEY CLUSTERED 
(
	[feedbackId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFees]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFees](
	[feesId] [int] NOT NULL,
	[feesName] [nvarchar](100) NOT NULL,
	[detail] [nvarchar](500) NOT NULL,
	[feesPrice] [float] NOT NULL,
	[billId] [int] NOT NULL,
 CONSTRAINT [PK_tblFees] PRIMARY KEY CLUSTERED 
(
	[feesId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNotification]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNotification](
	[notificationId] [int] NOT NULL,
	[notificationName] [nvarchar](100) NOT NULL,
	[detail] [nvarchar](500) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_tblNotification] PRIMARY KEY CLUSTERED 
(
	[notificationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPayment]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPayment](
	[paymentId] [int] NOT NULL,
	[paymentName] [nvarchar](100) NOT NULL,
	[methodUser] [nvarchar](20) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_tblPayment] PRIMARY KEY CLUSTERED 
(
	[paymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRegulation]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRegulation](
	[regulationId] [int] NOT NULL,
	[regulationName] [nvarchar](100) NOT NULL,
	[feesId] [int] NOT NULL,
	[dateEdit] [date] NOT NULL,
	[roomId] [int] NOT NULL,
 CONSTRAINT [PK_tblRegulation] PRIMARY KEY CLUSTERED 
(
	[regulationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoom]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoom](
	[roomId] [int] IDENTITY(1,1) NOT NULL,
	[roomDescription] [nvarchar](100) NOT NULL,
	[roomPrice] [float] NOT NULL,
	[image] [nvarchar](50) NULL,
	[status] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblRoom] PRIMARY KEY CLUSTERED 
(
	[roomId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblService]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblService](
	[serviceId] [int] NOT NULL,
	[serviceName] [nvarchar](100) NOT NULL,
	[serviceDetail] [nvarchar](500) NOT NULL,
	[electricUsing] [float] NOT NULL,
	[waterUsing] [float] NOT NULL,
	[servicePrice] [float] NOT NULL,
 CONSTRAINT [PK_tblService] PRIMARY KEY CLUSTERED 
(
	[serviceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblServiceDetails]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblServiceDetails](
	[serviceDetailId] [int] NOT NULL,
	[serviceId] [int] NOT NULL,
	[billId] [int] NOT NULL,
	[serviceDetailPrice] [float] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tblServiceDetails] PRIMARY KEY CLUSTERED 
(
	[serviceDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 6/29/2022 2:40:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[idUser] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[email] [nvarchar](400) NOT NULL,
	[address] [nvarchar](20) NULL,
	[phone] [nvarchar](10) NULL,
	[citizenIdentification] [nvarchar](12) NULL,
	[status] [bit] NULL,
	[role] [nvarchar](20) NULL,
	[image] [nvarchar](400) NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblBill] ([billId], [billName], [roomId], [username], [detail]) VALUES (1, N'bill Thanh Toan', 1, N'nguyen', N'Tong So tien la : ....')
INSERT [dbo].[tblBill] ([billId], [billName], [roomId], [username], [detail]) VALUES (2, N'bill Thanh Toan', 2, N'nguyen', N'Tong So tien la : ....')
INSERT [dbo].[tblBill] ([billId], [billName], [roomId], [username], [detail]) VALUES (3, N'bill Thanh toan ', 6, N'thuan', N'Tong So tien la : ....')
INSERT [dbo].[tblBill] ([billId], [billName], [roomId], [username], [detail]) VALUES (4, N'bill', 7, N'thuan', N'Tong So tien la : ....')
INSERT [dbo].[tblBill] ([billId], [billName], [roomId], [username], [detail]) VALUES (5, N'bill', 8, N'thuan', N'Tong So tien la : ....')
GO
SET IDENTITY_INSERT [dbo].[tblBooking] ON 

INSERT [dbo].[tblBooking] ([bookingId], [username], [bookingDate]) VALUES (7, N'nguyen', N'23/06/2022')
INSERT [dbo].[tblBooking] ([bookingId], [username], [bookingDate]) VALUES (8, N'nguyenbkse151446@fpt.edu.vn', N'23/06/2022')
INSERT [dbo].[tblBooking] ([bookingId], [username], [bookingDate]) VALUES (9, N'nguyenbkse151446@fpt.edu.vn', N'24/06/2022')
INSERT [dbo].[tblBooking] ([bookingId], [username], [bookingDate]) VALUES (10, N'nguyen', N'24/06/2022')
INSERT [dbo].[tblBooking] ([bookingId], [username], [bookingDate]) VALUES (11, N'nguyen', N'24/06/2022')
INSERT [dbo].[tblBooking] ([bookingId], [username], [bookingDate]) VALUES (12, N'phucttse151436@fpt.edu.vn', N'29/06/2022')
SET IDENTITY_INSERT [dbo].[tblBooking] OFF
GO
INSERT [dbo].[tblBookingDetail] ([roomId], [bookingId], [checkInDate], [checkOutDate]) VALUES (1, 12, N'2022-06-30', N'2022-07-15')
INSERT [dbo].[tblBookingDetail] ([roomId], [bookingId], [checkInDate], [checkOutDate]) VALUES (1, 12, N'2022-07-16', N'2022-07-17')
INSERT [dbo].[tblBookingDetail] ([roomId], [bookingId], [checkInDate], [checkOutDate]) VALUES (6, 10, N'2022-06-30', N'2022-09-30')
INSERT [dbo].[tblBookingDetail] ([roomId], [bookingId], [checkInDate], [checkOutDate]) VALUES (7, 11, N'2022-06-30', N'2022-09-30')
INSERT [dbo].[tblBookingDetail] ([roomId], [bookingId], [checkInDate], [checkOutDate]) VALUES (8, 8, N'2022-06-23', N'2022-06-30')
INSERT [dbo].[tblBookingDetail] ([roomId], [bookingId], [checkInDate], [checkOutDate]) VALUES (9, 9, N'2022-06-30', N'2022-07-23')
GO
INSERT [dbo].[tblFeedback] ([feedbackId], [feedbackName], [username], [status]) VALUES (1, N'Phong nay hu may lanh', N'nguyen', 1)
INSERT [dbo].[tblFeedback] ([feedbackId], [feedbackName], [username], [status]) VALUES (2, N'Phong hu cai ghe', N'nguyen', 1)
INSERT [dbo].[tblFeedback] ([feedbackId], [feedbackName], [username], [status]) VALUES (3, N'Phong nay k co ghe tinh yeu', N'thuan', 1)
INSERT [dbo].[tblFeedback] ([feedbackId], [feedbackName], [username], [status]) VALUES (4, N'Phong nay co trom', N'thuan', 1)
INSERT [dbo].[tblFeedback] ([feedbackId], [feedbackName], [username], [status]) VALUES (5, N'phong ke ben no on ', N'thuan', 1)
INSERT [dbo].[tblFeedback] ([feedbackId], [feedbackName], [username], [status]) VALUES (6, N'phong nay k co tu lanh a` ', N'nguyen', 1)
GO
INSERT [dbo].[tblFees] ([feesId], [feesName], [detail], [feesPrice], [billId]) VALUES (1, N'Phi thang 8', N'Tien dien + tien nuoc  tien phong1+', 1, 1)
GO
SET IDENTITY_INSERT [dbo].[tblRoom] ON 

INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (1, N'phong 4 giuong 2 ngu                                                                                ', 100, N'blog-1.jpg', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (2, N'phong 1 giuong , 1 phong ngu', 130, N'project-2.jpg', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (3, N'phong 3 giuong                                                                                      ', 150, N'blog-2.jpg', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (4, N'phong 4 giuong                                    ', 200, N'client-logo-1.png', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (5, N'phong 3 giuong                                                                                      ', 400, N'building-black.png', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (6, N'phong co ghe tinh yeu ', 450, N'blog-2.jpg', N'B')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (7, N'phong 2 giuong , day du tien nghi ', 500, N'blog-2.jpg', N'B')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (8, N'phong 5 giuong ', 1000, N'blog-2.jpg', N'B')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (9, N'phong 15 giuong ', 1500, N'blog-2.jpg', N'B')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (10, N'phong chuc giuong', 50, N'', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (13, N'test thu', 10, N'7-480x880.jpg', N'NB')
INSERT [dbo].[tblRoom] ([roomId], [roomDescription], [roomPrice], [image], [status]) VALUES (14, N'test thu', 10, N'8-480x880.jpg', N'NB')
SET IDENTITY_INSERT [dbo].[tblRoom] OFF
GO
SET IDENTITY_INSERT [dbo].[tblUser] ON 

INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (3, N'HoangHai', N'123', N'Nguyen Hoang Hai', N'nguyenbkse151446@fpt.edu.vn', N'Vinhome Grand Park', N'0981321039', N'079201018735', 1, N'US', N'assets/images/userImage/user-default.png')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (18, N'hungphat', N'123123123', N'Pham Hung Phat', N'hungphatpl@gmail.com', N'Soc Trang', N'0845646645', N'123123123', 1, N'US', N'3-480x880.jpg')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (1, N'nguyen', N'1', N'BUI KHOI NGUYEN', N'buikhoinguyen2001@gmail.com', N'Quan 10', N'0903314123', N'123124125', 1, N'US', N'assets/images/userImage/nguyen.png')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (12, N'nguyenbkse151446@fpt.edu.vn', N'1', N'Bui Khoi Nguyen', N'nguyenbkse151446@fpt.edu.vn', N'', N'', N'', 1, N'USGOOGLE', N'https://lh3.googleusercontent.com/a-/AOh14Gh9U4H7yEJ3hUwGN-L9bD7rE-uTBloZJ2YWXM19bQ=s96-c')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (15, N'phat', N'1', N'Phat1', N'phatne@gmail.com', N'Q11', N'0909494999', N'123123123', 1, N'STAFF', N'kgklfkg')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (13, N'phuc', N'123', N'Tran Anna', N'phuctraan1118@gmail.com', N'Long An', N'0845646648', N'123123123123', 1, N'STAFF', N'fdfdfdf')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (17, N'phuc1234', N'123123123', N'Tran Thien Phuc', N'thienphucrt@gmail.com', N'Long An', N'0845646648', N'123123123', 1, N'STAFF', N'2-480x880.jpg')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (16, N'phucttse151436@fpt.edu.vn', N'1', N'Tran Thien Phuc', N'phucttse151436@fpt.edu.vn', N'', N'', N'', 1, N'USGOOGLE', N'https://lh3.googleusercontent.com/a/AATXAJwo9wCZqEA9OaFbK5M3btiFrrpK7Iu2m7xG6xeowA=s96-c')
INSERT [dbo].[tblUser] ([idUser], [username], [password], [fullName], [email], [address], [phone], [citizenIdentification], [status], [role], [image]) VALUES (14, N'thienphucrt@gmail.com', N'1', N'Thiên Phúc', N'thienphucrt@gmail.com', N'', N'', N'', 1, N'USGOOGLE', N'https://lh3.googleusercontent.com/a-/AOh14Gh4HL22ZY9vImo8Sodhcuz7accIGFs5CQDk0vkKXZg=s96-c')
SET IDENTITY_INSERT [dbo].[tblUser] OFF
GO
ALTER TABLE [dbo].[tblBooking]  WITH CHECK ADD  CONSTRAINT [FK_tblBooking_tblUser] FOREIGN KEY([username])
REFERENCES [dbo].[tblUser] ([username])
GO
ALTER TABLE [dbo].[tblBooking] CHECK CONSTRAINT [FK_tblBooking_tblUser]
GO
ALTER TABLE [dbo].[tblBookingDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblBookingDetail_tblBooking] FOREIGN KEY([bookingId])
REFERENCES [dbo].[tblBooking] ([bookingId])
GO
ALTER TABLE [dbo].[tblBookingDetail] CHECK CONSTRAINT [FK_tblBookingDetail_tblBooking]
GO
ALTER TABLE [dbo].[tblBookingDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblBookingDetail_tblRoom] FOREIGN KEY([roomId])
REFERENCES [dbo].[tblRoom] ([roomId])
GO
ALTER TABLE [dbo].[tblBookingDetail] CHECK CONSTRAINT [FK_tblBookingDetail_tblRoom]
GO
ALTER TABLE [dbo].[tblFees]  WITH CHECK ADD  CONSTRAINT [FK_tblFees_tblBill] FOREIGN KEY([billId])
REFERENCES [dbo].[tblBill] ([billId])
GO
ALTER TABLE [dbo].[tblFees] CHECK CONSTRAINT [FK_tblFees_tblBill]
GO
ALTER TABLE [dbo].[tblNotification]  WITH CHECK ADD  CONSTRAINT [FK_tblNotification_tblUser] FOREIGN KEY([username])
REFERENCES [dbo].[tblUser] ([username])
GO
ALTER TABLE [dbo].[tblNotification] CHECK CONSTRAINT [FK_tblNotification_tblUser]
GO
ALTER TABLE [dbo].[tblPayment]  WITH CHECK ADD  CONSTRAINT [FK_tblPayment_tblUser] FOREIGN KEY([username])
REFERENCES [dbo].[tblUser] ([username])
GO
ALTER TABLE [dbo].[tblPayment] CHECK CONSTRAINT [FK_tblPayment_tblUser]
GO
ALTER TABLE [dbo].[tblRegulation]  WITH CHECK ADD  CONSTRAINT [FK_tblRegulation_tblFees] FOREIGN KEY([feesId])
REFERENCES [dbo].[tblFees] ([feesId])
GO
ALTER TABLE [dbo].[tblRegulation] CHECK CONSTRAINT [FK_tblRegulation_tblFees]
GO
ALTER TABLE [dbo].[tblRegulation]  WITH CHECK ADD  CONSTRAINT [FK_tblRegulation_tblRoom] FOREIGN KEY([roomId])
REFERENCES [dbo].[tblRoom] ([roomId])
GO
ALTER TABLE [dbo].[tblRegulation] CHECK CONSTRAINT [FK_tblRegulation_tblRoom]
GO
ALTER TABLE [dbo].[tblServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblServiceDetails_tblBill] FOREIGN KEY([billId])
REFERENCES [dbo].[tblBill] ([billId])
GO
ALTER TABLE [dbo].[tblServiceDetails] CHECK CONSTRAINT [FK_tblServiceDetails_tblBill]
GO
ALTER TABLE [dbo].[tblServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblServiceDetails_tblService] FOREIGN KEY([serviceId])
REFERENCES [dbo].[tblService] ([serviceId])
GO
ALTER TABLE [dbo].[tblServiceDetails] CHECK CONSTRAINT [FK_tblServiceDetails_tblService]
GO
USE [master]
GO
ALTER DATABASE [HostelManagement] SET  READ_WRITE 
GO
