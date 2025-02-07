/****** Object:  Database [TTK music]    Script Date: 12/14/2022 11:28:04 AM ******/
CREATE DATABASE [TTK music]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TTK music].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TTK music] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TTK music] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TTK music] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TTK music] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TTK music] SET ARITHABORT OFF 
GO
ALTER DATABASE [TTK music] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TTK music] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TTK music] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TTK music] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TTK music] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TTK music] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TTK music] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TTK music] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TTK music] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TTK music] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TTK music] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TTK music] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TTK music] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TTK music] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TTK music] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TTK music] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TTK music] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TTK music] SET RECOVERY FULL 
GO
ALTER DATABASE [TTK music] SET  MULTI_USER 
GO
ALTER DATABASE [TTK music] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TTK music] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TTK music] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TTK music] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TTK music] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'TTK music', N'ON'
GO
USE [TTK music]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 12/14/2022 11:28:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](30) NOT NULL,
	[password] [nvarchar](30) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[status] [nvarchar](10) NULL,
	[phone] [char](11) NULL,
	[email] [nvarchar](50) NULL,
	[address] [nvarchar](200) NULL,
	[Role] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 12/14/2022 11:28:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](5) NOT NULL,
	[status] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 12/14/2022 11:28:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[startCourseDate] [date] NULL,
	[endCourseDate] [date] NULL,
	[lastUpdateDate] [date] NULL,
	[status] [nvarchar](10) NULL,
	[description] [nvarchar](100) NULL,
	[imagePath] [nvarchar](1000) NULL,
	[quantity] [int] NOT NULL,
	[startLessionTime] [int] NULL,
	[endLessionTime] [int] NULL,
	[discount] [int] NULL,
	[LastUpdateUserID] [int] NULL,
	[category] [nvarchar](100) NULL,
	[tuitionFee] [int] NULL,
	[LastUpdateUsername] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 12/14/2022 11:28:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[orderDate] [date] NULL,
	[paymentMethod] [int] NULL,
	[paymentStatus] [int] NULL,
	[orderStatus] [int] NULL,
	[customerName] [nvarchar](50) NULL,
	[customerPhone] [nvarchar](11) NULL,
	[customerEmail] [nvarchar](50) NULL,
	[customerAddress] [nvarchar](200) NULL,
	[CustomerID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 12/14/2022 11:28:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[quantity] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[originalTuitionFee] [int] NULL,
	[description] [nvarchar](100) NULL,
	[startCourseDate] [date] NULL,
	[endCourseDate] [date] NULL,
	[startLessionTime] [int] NULL,
	[endLessionTime] [int] NULL,
	[discount] [int] NULL,
	[CourseID] [int] NOT NULL,
	[OrderID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CourseID] ASC,
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 
GO
INSERT [dbo].[Account] ([ID], [username], [password], [name], [status], [phone], [email], [address], [Role]) VALUES (1, N'admin1', N'1', N'Admin 1', N'Active', NULL, NULL, NULL, N'Admin')
GO
INSERT [dbo].[Account] ([ID], [username], [password], [name], [status], [phone], [email], [address], [Role]) VALUES (2, N'admin2', N'1', N'Admin 2', N'Active', NULL, NULL, NULL, N'Admin')
GO
INSERT [dbo].[Account] ([ID], [username], [password], [name], [status], [phone], [email], [address], [Role]) VALUES (3, N'admin3', N'1', N'Admin 3', N'Disabled', NULL, NULL, NULL, N'Admin')
GO
INSERT [dbo].[Account] ([ID], [username], [password], [name], [status], [phone], [email], [address], [Role]) VALUES (5, N'customer1', N'1', N'Customer 1', N'Active', NULL, NULL, NULL, N'Customer')
GO
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 
GO
INSERT [dbo].[Category] ([ID], [Name], [status]) VALUES (1, N'Piano', N'1')
GO
INSERT [dbo].[Category] ([ID], [Name], [status]) VALUES (2, N'Organ', N'1')
GO
INSERT [dbo].[Category] ([ID], [Name], [status]) VALUES (7, N'Flute', N'1')
GO
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Course] ON 
GO
INSERT [dbo].[Course] ([ID], [name], [startCourseDate], [endCourseDate], [lastUpdateDate], [status], [description], [imagePath], [quantity], [startLessionTime], [endLessionTime], [discount], [LastUpdateUserID], [category], [tuitionFee], [LastUpdateUsername]) VALUES (1, N'Piano 1', CAST(N'2022-01-05' AS Date), CAST(N'2022-01-14' AS Date), CAST(N'2022-12-14' AS Date), N'Active', N'Piano for starter 2', N'https://vn.yamaha.com/vi/files/Image-Index_PSR-E473_900x900_10acf460c08f457db264fac40ee6f03e.jpg?impolicy=resize&imwid=396&imhei=396', 60, NULL, NULL, NULL, NULL, N'Advanced', 500, N'admin1')
GO
INSERT [dbo].[Course] ([ID], [name], [startCourseDate], [endCourseDate], [lastUpdateDate], [status], [description], [imagePath], [quantity], [startLessionTime], [endLessionTime], [discount], [LastUpdateUserID], [category], [tuitionFee], [LastUpdateUsername]) VALUES (2, N'Piano 2', NULL, NULL, CAST(N'2022-12-14' AS Date), N'Active', N'Piano for medium learner', N'https://vn.yamaha.com/vi/files/Image-Index_PSR-E473_900x900_10acf460c08f457db264fac40ee6f03e.jpg?impolicy=resize&imwid=396&imhei=396', 60, NULL, NULL, NULL, NULL, N'Medium', 900, N'admin1')
GO
INSERT [dbo].[Course] ([ID], [name], [startCourseDate], [endCourseDate], [lastUpdateDate], [status], [description], [imagePath], [quantity], [startLessionTime], [endLessionTime], [discount], [LastUpdateUserID], [category], [tuitionFee], [LastUpdateUsername]) VALUES (3, N'Piano 3', NULL, NULL, CAST(N'2022-12-14' AS Date), N'Active', N'Piano for Advanced', N'', 30, NULL, NULL, NULL, NULL, N'Advanced', 400, N'admin2')
GO
SET IDENTITY_INSERT [dbo].[Course] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Account__F3DBC57277860D1A]    Script Date: 12/14/2022 11:28:04 AM ******/
ALTER TABLE [dbo].[Account] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Account] ([ID])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Order] ([ID])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Course] ([ID])
GO
USE [master]
GO
ALTER DATABASE [TTK music] SET  READ_WRITE 
GO
