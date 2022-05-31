USE [master]
GO
/****** Object:  Database [HostelManagement]    Script Date: 5/30/2022 9:18:09 PM ******/
CREATE DATABASE [HostelManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HostelManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENSEVER\MSSQL\DATA\HostelManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HostelManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENSEVER\MSSQL\DATA\HostelManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
/****** Object:  Table [dbo].[tblBill]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBill](
	[IdBill] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[IdRoom] [nvarchar](10) NOT NULL,
	[IdUser] [nvarchar](10) NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblBill] PRIMARY KEY CLUSTERED 
(
	[IdBill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[IdCategory] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
	[Price] [float] NOT NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[IdCategory] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblContract]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblContract](
	[IdContract] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Deposit] [float] NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
	[IdUser] [nvarchar](10) NOT NULL,
	[IdRoom] [nvarchar](10) NOT NULL,
	[BeginDate] [date] NOT NULL,
	[EndDate] [date] NOT NULL,
 CONSTRAINT [PK_tblContract] PRIMARY KEY CLUSTERED 
(
	[IdContract] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFeedback]    Script Date: 5/30/2022 9:18:09 PM ******/
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
/****** Object:  Table [dbo].[tblFees]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFees](
	[IdFee] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
	[Price] [float] NOT NULL,
	[IdBill] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblFees] PRIMARY KEY CLUSTERED 
(
	[IdFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblImage]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblImage](
	[IdImage] [nvarchar](10) NOT NULL,
	[NameImg] [nvarchar](30) NOT NULL,
	[IdRoom] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblImage] PRIMARY KEY CLUSTERED 
(
	[IdImage] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNotification]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNotification](
	[IdNotification] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
	[IdUser] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblNotification] PRIMARY KEY CLUSTERED 
(
	[IdNotification] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPayment]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPayment](
	[IdPayment] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[MethodUser] [nvarchar](20) NOT NULL,
	[IdUser] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblPayment] PRIMARY KEY CLUSTERED 
(
	[IdPayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRegulation]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRegulation](
	[IdRegulation] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[IdFee] [nvarchar](10) NOT NULL,
	[DateEdit] [date] NOT NULL,
	[IdRoom] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblRegulation] PRIMARY KEY CLUSTERED 
(
	[IdRegulation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoom]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoom](
	[IdRoom] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](20) NOT NULL,
	[IdCategory] [nvarchar](10) NOT NULL,
	[Quantity] [float] NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
	[Img] [image] NOT NULL,
 CONSTRAINT [PK_tblRoom] PRIMARY KEY CLUSTERED 
(
	[IdRoom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblService]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblService](
	[IdService] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Detail] [nvarchar](50) NOT NULL,
	[ElectricUsing] [float] NOT NULL,
	[WaterUsing] [float] NOT NULL,
	[Price] [float] NOT NULL,
 CONSTRAINT [PK_tblService] PRIMARY KEY CLUSTERED 
(
	[IdService] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblServiceDetails]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblServiceDetails](
	[IdServiceDetails] [nvarchar](10) NOT NULL,
	[IdService] [nvarchar](10) NOT NULL,
	[IdBill] [nvarchar](10) NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_tblServiceDetails] PRIMARY KEY CLUSTERED 
(
	[IdServiceDetails] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 5/30/2022 9:18:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[IdUser] [nvarchar](10) NOT NULL,
	[Username] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](20) NOT NULL,
	[Address] [nvarchar](20) NOT NULL,
	[Phone] [nvarchar](10) NOT NULL,
	[CitizenIdetification] [nvarchar](20) NOT NULL,
	[Status] [bit] NOT NULL,
	[Role] [nvarchar](20) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[IdUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblBill]  WITH CHECK ADD  CONSTRAINT [FK_tblBill_tblRoom] FOREIGN KEY([IdRoom])
REFERENCES [dbo].[tblRoom] ([IdRoom])
GO
ALTER TABLE [dbo].[tblBill] CHECK CONSTRAINT [FK_tblBill_tblRoom]
GO
ALTER TABLE [dbo].[tblContract]  WITH CHECK ADD  CONSTRAINT [FK_tblContract_tblRoom] FOREIGN KEY([IdRoom])
REFERENCES [dbo].[tblRoom] ([IdRoom])
GO
ALTER TABLE [dbo].[tblContract] CHECK CONSTRAINT [FK_tblContract_tblRoom]
GO
ALTER TABLE [dbo].[tblContract]  WITH CHECK ADD  CONSTRAINT [FK_tblContract_tblUser] FOREIGN KEY([IdUser])
REFERENCES [dbo].[tblUser] ([IdUser])
GO
ALTER TABLE [dbo].[tblContract] CHECK CONSTRAINT [FK_tblContract_tblUser]
GO
ALTER TABLE [dbo].[tblFeedback]  WITH CHECK ADD  CONSTRAINT [FK_tblFeedback_tblUser] FOREIGN KEY([idUser])
REFERENCES [dbo].[tblUser] ([IdUser])
GO
ALTER TABLE [dbo].[tblFeedback] CHECK CONSTRAINT [FK_tblFeedback_tblUser]
GO
ALTER TABLE [dbo].[tblImage]  WITH CHECK ADD  CONSTRAINT [FK_tblImage_tblRoom] FOREIGN KEY([IdRoom])
REFERENCES [dbo].[tblRoom] ([IdRoom])
GO
ALTER TABLE [dbo].[tblImage] CHECK CONSTRAINT [FK_tblImage_tblRoom]
GO
ALTER TABLE [dbo].[tblNotification]  WITH CHECK ADD  CONSTRAINT [FK_tblNotification_tblUser] FOREIGN KEY([IdUser])
REFERENCES [dbo].[tblUser] ([IdUser])
GO
ALTER TABLE [dbo].[tblNotification] CHECK CONSTRAINT [FK_tblNotification_tblUser]
GO
ALTER TABLE [dbo].[tblPayment]  WITH CHECK ADD  CONSTRAINT [FK_tblPayment_tblUser] FOREIGN KEY([IdUser])
REFERENCES [dbo].[tblUser] ([IdUser])
GO
ALTER TABLE [dbo].[tblPayment] CHECK CONSTRAINT [FK_tblPayment_tblUser]
GO
ALTER TABLE [dbo].[tblRegulation]  WITH CHECK ADD  CONSTRAINT [FK_tblRegulation_tblFees] FOREIGN KEY([IdFee])
REFERENCES [dbo].[tblFees] ([IdFee])
GO
ALTER TABLE [dbo].[tblRegulation] CHECK CONSTRAINT [FK_tblRegulation_tblFees]
GO
ALTER TABLE [dbo].[tblRegulation]  WITH CHECK ADD  CONSTRAINT [FK_tblRegulation_tblRoom] FOREIGN KEY([IdRoom])
REFERENCES [dbo].[tblRoom] ([IdRoom])
GO
ALTER TABLE [dbo].[tblRegulation] CHECK CONSTRAINT [FK_tblRegulation_tblRoom]
GO
ALTER TABLE [dbo].[tblRoom]  WITH CHECK ADD  CONSTRAINT [FK_tblRoom_tblCategory] FOREIGN KEY([IdCategory])
REFERENCES [dbo].[tblCategory] ([IdCategory])
GO
ALTER TABLE [dbo].[tblRoom] CHECK CONSTRAINT [FK_tblRoom_tblCategory]
GO
ALTER TABLE [dbo].[tblServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblServiceDetails_tblBill] FOREIGN KEY([IdBill])
REFERENCES [dbo].[tblBill] ([IdBill])
GO
ALTER TABLE [dbo].[tblServiceDetails] CHECK CONSTRAINT [FK_tblServiceDetails_tblBill]
GO
ALTER TABLE [dbo].[tblServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblServiceDetails_tblService] FOREIGN KEY([IdService])
REFERENCES [dbo].[tblService] ([IdService])
GO
ALTER TABLE [dbo].[tblServiceDetails] CHECK CONSTRAINT [FK_tblServiceDetails_tblService]
GO
USE [master]
GO
ALTER DATABASE [HostelManagement] SET  READ_WRITE 
GO
