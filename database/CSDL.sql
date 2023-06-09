USE [ElectronicStore]
GO
/****** Object:  User [HTKN]    Script Date: 07/05/2023 10:52:56 PM ******/
CREATE USER [HTKN] FOR LOGIN [HTKN] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [HTKN]
GO
/****** Object:  Table [CHINHANH]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [CHINHANH](
	[MaCN] [nvarchar](10) NOT NULL,
	[TenCN] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__CHINHANH__27258E0E7B6E747B] PRIMARY KEY CLUSTERED 
(
	[MaCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [CHUCVU]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [CHUCVU](
	[MaCV] [nvarchar](20) NOT NULL,
	[TenCV] [nvarchar](30) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__CHUCVU__27258E76403B3314] PRIMARY KEY CLUSTERED 
(
	[MaCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [CTHOADON]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [CTHOADON](
	[MaHD] [nvarchar](20) NOT NULL,
	[MaSP] [nvarchar](20) NOT NULL,
	[TenSP] [nvarchar](70) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [int] NULL,
	[ThanhTien] [int] NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__CTHOADON__F557F661081241B2] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [CTPHIEUNHAP]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [CTPHIEUNHAP](
	[MAPN] [nvarchar](20) NOT NULL,
	[MASP] [nvarchar](20) NOT NULL,
	[TenSP] [nvarchar](70) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [int] NULL,
	[ThanhTien] [int] NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__CTPHIEUN__563D496DD09EACA0] PRIMARY KEY CLUSTERED 
(
	[MAPN] ASC,
	[MASP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [HOADON]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [HOADON](
	[MaHD] [nvarchar](20) NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[TongTien] [int] NOT NULL,
	[MaNV] [nvarchar](20) NOT NULL,
	[MaKH] [nvarchar](20) NOT NULL,
	[MaKM] [nvarchar](20) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__HOADON__2725A6E0F7462D70] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [KHACHHANG]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [KHACHHANG](
	[MaKH] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](20) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[NamSinh] [int] NOT NULL,
	[GioiTinh] [nvarchar](20) NULL,
	[SoDT] [nvarchar](20) NULL,
	[DiaChi] [nvarchar](20) NULL,
	[IMG] [nvarchar](20) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__KHACHHAN__2725CF1E16408588] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [KHUYENMAI]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [KHUYENMAI](
	[MaKM] [nvarchar](20) NOT NULL,
	[TenKM] [nvarchar](50) NOT NULL,
	[PhanTramKM] [int] NOT NULL,
	[DieuKienKM] [int] NOT NULL,
	[NgayBD] [datetime] NOT NULL,
	[NgayKT] [datetime] NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__KHUYENMA__2725CF1521E2B7A4] PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [LOAI]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [LOAI](
	[MaLoai] [nvarchar](10) NOT NULL,
	[TenLoai] [nvarchar](20) NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__LOAI__730A575942AE6EB7] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [NHACUNGCAP]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [NHACUNGCAP](
	[MaNCC] [nvarchar](10) NOT NULL,
	[TenNCC] [nvarchar](30) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__NHACUNGC__3A185DEBA4730826] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [NHANVIEN]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [NHANVIEN](
	[MaNV] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](30) NULL,
	[Ten] [nvarchar](30) NULL,
	[NamSinh] [int] NULL,
	[GioiTinh] [nvarchar](20) NULL,
	[SoDT] [nvarchar](20) NULL,
	[DiaChi] [nvarchar](20) NULL,
	[MaCV] [nvarchar](20) NULL,
	[MaCN] [nvarchar](10) NULL,
	[IMG] [nvarchar](20) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__NHANVIEN__2725D70A6EB1363D] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [NHASANXUAT]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [NHASANXUAT](
	[MaNSX] [nvarchar](10) NOT NULL,
	[TenNSX] [nvarchar](20) NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__NHASANXU__3A1BDBD2F7645676] PRIMARY KEY CLUSTERED 
(
	[MaNSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [PHIEUNHAP]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PHIEUNHAP](
	[MaPN] [nvarchar](20) NOT NULL,
	[NgapLap] [datetime] NULL,
	[TongTien] [int] NULL,
	[MaNV] [nvarchar](20) NULL,
	[MaNCC] [nvarchar](10) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__PHIEUNHA__2725E7F0173A0AF5] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [SANPHAM]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [SANPHAM](
	[MaSP] [nvarchar](20) NOT NULL,
	[TenSP] [nvarchar](70) NOT NULL,
	[DonViTinh] [nvarchar](10) NOT NULL,
	[DonGia] [int] NULL,
	[MaLoai] [nvarchar](10) NULL,
	[MaNSX] [nvarchar](10) NULL,
	[MaNCC] [nvarchar](10) NULL,
	[IMG] [nvarchar](20) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__SANPHAM__2725081CE2BBDB2A] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [SANPHAM_CHINHANH]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [SANPHAM_CHINHANH](
	[MaSP] [nvarchar](20) NOT NULL,
	[MaCN] [nvarchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK_SanPham_ChiNhanh] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC,
	[MaCN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [sysdiagrams]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [sysdiagrams](
	[name] [sysname] NOT NULL,
	[principal_id] [int] NOT NULL,
	[diagram_id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[version] [int] NULL,
	[definition] [varbinary](max) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__sysdiagr__C2B05B6177F8AF0C] PRIMARY KEY CLUSTERED 
(
	[diagram_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_principal_name] UNIQUE NONCLUSTERED 
(
	[principal_id] ASC,
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [TAIKHOAN]    Script Date: 07/05/2023 10:52:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAIKHOAN](
	[TenDangNhap] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](30) NULL,
	[MaNV] [nvarchar](20) NULL,
	[TinhTrang] [bit] NULL,
	[MaCV] [nvarchar](20) NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
 CONSTRAINT [PK__TAIKHOAN__55F68FC110F36AAB] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [CHINHANH] ADD  CONSTRAINT [MSmerge_df_rowguid_B47D70F46E48418DBA78F0743A276458]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [CHUCVU] ADD  CONSTRAINT [MSmerge_df_rowguid_A046B7C47C6C45C49A8FD4A8045B38AC]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [CTHOADON] ADD  CONSTRAINT [MSmerge_df_rowguid_B98B2F597A114321B2FFBECCF041DE12]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [CTPHIEUNHAP] ADD  CONSTRAINT [MSmerge_df_rowguid_57595F6FBCFB4E01A0FE6F4E27DA7E18]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [HOADON] ADD  CONSTRAINT [MSmerge_df_rowguid_F54594E6F31548B2BE8A3599E5780865]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [KHACHHANG] ADD  CONSTRAINT [MSmerge_df_rowguid_3C71F70E1A6041F0A3F6042E4137C93C]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [KHUYENMAI] ADD  CONSTRAINT [MSmerge_df_rowguid_862E50CEE8F546499CB1BB99738E86C6]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [LOAI] ADD  CONSTRAINT [MSmerge_df_rowguid_B0C981A990594F3E9329EC2BE4759A65]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [NHACUNGCAP] ADD  CONSTRAINT [MSmerge_df_rowguid_C60795C495534F9ABD5064ED325A6F6F]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [NHANVIEN] ADD  CONSTRAINT [MSmerge_df_rowguid_51C1ED89E7474B4E848F70930736CC30]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [NHASANXUAT] ADD  CONSTRAINT [MSmerge_df_rowguid_45011FCED73B4E0BA418299BADF18AFA]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [PHIEUNHAP] ADD  CONSTRAINT [MSmerge_df_rowguid_61C7CC26B66B4D1A8E6E0682083640F7]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [SANPHAM] ADD  CONSTRAINT [MSmerge_df_rowguid_67EDDDE3265D4983BCC2A823E22C4972]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [SANPHAM_CHINHANH] ADD  CONSTRAINT [MSmerge_df_rowguid_F15EE38E8A264524AA48F50261B8BCC8]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [sysdiagrams] ADD  CONSTRAINT [MSmerge_df_rowguid_2EA93EFFA503448FBFCDDF7E3D63095E]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [TAIKHOAN] ADD  CONSTRAINT [MSmerge_df_rowguid_EA9D68614CAC49C19B6C28E10A406C8D]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
ALTER TABLE [CTHOADON]  WITH NOCHECK ADD  CONSTRAINT [FK_CTHOADON_HOADON] FOREIGN KEY([MaHD])
REFERENCES [HOADON] ([MaHD])
NOT FOR REPLICATION 
GO
ALTER TABLE [CTHOADON] CHECK CONSTRAINT [FK_CTHOADON_HOADON]
GO
ALTER TABLE [CTHOADON]  WITH NOCHECK ADD  CONSTRAINT [FK_CTHOADON_SANPHAM] FOREIGN KEY([MaSP])
REFERENCES [SANPHAM] ([MaSP])
NOT FOR REPLICATION 
GO
ALTER TABLE [CTHOADON] CHECK CONSTRAINT [FK_CTHOADON_SANPHAM]
GO
ALTER TABLE [CTPHIEUNHAP]  WITH NOCHECK ADD  CONSTRAINT [FK_CTPHIEUNHAP_PHIEUNHAP] FOREIGN KEY([MAPN])
REFERENCES [PHIEUNHAP] ([MaPN])
NOT FOR REPLICATION 
GO
ALTER TABLE [CTPHIEUNHAP] CHECK CONSTRAINT [FK_CTPHIEUNHAP_PHIEUNHAP]
GO
ALTER TABLE [CTPHIEUNHAP]  WITH NOCHECK ADD  CONSTRAINT [FK_CTPHIEUNHAP_SANPHAM] FOREIGN KEY([MASP])
REFERENCES [SANPHAM] ([MaSP])
NOT FOR REPLICATION 
GO
ALTER TABLE [CTPHIEUNHAP] CHECK CONSTRAINT [FK_CTPHIEUNHAP_SANPHAM]
GO
ALTER TABLE [HOADON]  WITH NOCHECK ADD  CONSTRAINT [FK_HOADON_KHACHHANG] FOREIGN KEY([MaKH])
REFERENCES [KHACHHANG] ([MaKH])
NOT FOR REPLICATION 
GO
ALTER TABLE [HOADON] CHECK CONSTRAINT [FK_HOADON_KHACHHANG]
GO
ALTER TABLE [HOADON]  WITH NOCHECK ADD  CONSTRAINT [FK_HOADON_KHUYENMAI] FOREIGN KEY([MaKM])
REFERENCES [KHUYENMAI] ([MaKM])
NOT FOR REPLICATION 
GO
ALTER TABLE [HOADON] CHECK CONSTRAINT [FK_HOADON_KHUYENMAI]
GO
ALTER TABLE [HOADON]  WITH NOCHECK ADD  CONSTRAINT [FK_HOADON_NHANVIEN] FOREIGN KEY([MaNV])
REFERENCES [NHANVIEN] ([MaNV])
NOT FOR REPLICATION 
GO
ALTER TABLE [HOADON] CHECK CONSTRAINT [FK_HOADON_NHANVIEN]
GO
ALTER TABLE [NHANVIEN]  WITH NOCHECK ADD  CONSTRAINT [FK_NHANVIEN_CHINHANH] FOREIGN KEY([MaCN])
REFERENCES [CHINHANH] ([MaCN])
NOT FOR REPLICATION 
GO
ALTER TABLE [NHANVIEN] NOCHECK CONSTRAINT [FK_NHANVIEN_CHINHANH]
GO
ALTER TABLE [NHANVIEN]  WITH NOCHECK ADD  CONSTRAINT [FK_NHANVIEN_CHUCVU] FOREIGN KEY([MaCV])
REFERENCES [CHUCVU] ([MaCV])
NOT FOR REPLICATION 
GO
ALTER TABLE [NHANVIEN] CHECK CONSTRAINT [FK_NHANVIEN_CHUCVU]
GO
ALTER TABLE [PHIEUNHAP]  WITH NOCHECK ADD  CONSTRAINT [FK_PHIEUNHAP_NHACUNGCAP] FOREIGN KEY([MaNCC])
REFERENCES [NHACUNGCAP] ([MaNCC])
NOT FOR REPLICATION 
GO
ALTER TABLE [PHIEUNHAP] CHECK CONSTRAINT [FK_PHIEUNHAP_NHACUNGCAP]
GO
ALTER TABLE [PHIEUNHAP]  WITH NOCHECK ADD  CONSTRAINT [FK_PHIEUNHAP_NHANVIEN] FOREIGN KEY([MaNV])
REFERENCES [NHANVIEN] ([MaNV])
NOT FOR REPLICATION 
GO
ALTER TABLE [PHIEUNHAP] CHECK CONSTRAINT [FK_PHIEUNHAP_NHANVIEN]
GO
ALTER TABLE [SANPHAM]  WITH NOCHECK ADD  CONSTRAINT [FK_SanPham_Loai] FOREIGN KEY([MaLoai])
REFERENCES [LOAI] ([MaLoai])
NOT FOR REPLICATION 
GO
ALTER TABLE [SANPHAM] CHECK CONSTRAINT [FK_SanPham_Loai]
GO
ALTER TABLE [SANPHAM]  WITH CHECK ADD  CONSTRAINT [FK_SANPHAM_NHACUNGCAP] FOREIGN KEY([MaNCC])
REFERENCES [NHACUNGCAP] ([MaNCC])
GO
ALTER TABLE [SANPHAM] CHECK CONSTRAINT [FK_SANPHAM_NHACUNGCAP]
GO
ALTER TABLE [SANPHAM]  WITH NOCHECK ADD  CONSTRAINT [FK_SanPham_NhaSanXuat] FOREIGN KEY([MaNSX])
REFERENCES [NHASANXUAT] ([MaNSX])
NOT FOR REPLICATION 
GO
ALTER TABLE [SANPHAM] CHECK CONSTRAINT [FK_SanPham_NhaSanXuat]
GO
ALTER TABLE [SANPHAM_CHINHANH]  WITH NOCHECK ADD  CONSTRAINT [FK_SANPHAM_CHINHANH_CHINHANH] FOREIGN KEY([MaCN])
REFERENCES [CHINHANH] ([MaCN])
NOT FOR REPLICATION 
GO
ALTER TABLE [SANPHAM_CHINHANH] CHECK CONSTRAINT [FK_SANPHAM_CHINHANH_CHINHANH]
GO
ALTER TABLE [SANPHAM_CHINHANH]  WITH NOCHECK ADD  CONSTRAINT [FK_SANPHAM_CHINHANH_SANPHAM] FOREIGN KEY([MaSP])
REFERENCES [SANPHAM] ([MaSP])
NOT FOR REPLICATION 
GO
ALTER TABLE [SANPHAM_CHINHANH] CHECK CONSTRAINT [FK_SANPHAM_CHINHANH_SANPHAM]
GO
ALTER TABLE [TAIKHOAN]  WITH NOCHECK ADD  CONSTRAINT [FK_TAIKHOAN_CHUCVU] FOREIGN KEY([MaCV])
REFERENCES [CHUCVU] ([MaCV])
NOT FOR REPLICATION 
GO
ALTER TABLE [TAIKHOAN] CHECK CONSTRAINT [FK_TAIKHOAN_CHUCVU]
GO
ALTER TABLE [TAIKHOAN]  WITH NOCHECK ADD  CONSTRAINT [FK_TAIKHOAN_NHANVIEN] FOREIGN KEY([MaNV])
REFERENCES [NHANVIEN] ([MaNV])
NOT FOR REPLICATION 
GO
ALTER TABLE [TAIKHOAN] CHECK CONSTRAINT [FK_TAIKHOAN_NHANVIEN]
GO
/****** Object:  StoredProcedure [sp_ChuyenChiNhanhNV]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_ChuyenChiNhanhNV](@MaNV nvarchar(20), @MaCN nvarchar(20))
as
begin
	if not exists(select * from NhanVien where MaNV = @MaNV)
	begin
		print N'Nhân viên không thuộc chi nhánh này'
	end
	else
	begin
		declare @tempCN1 nvarchar(20) = (select MaCN from LINK_TO_CN1.ElectronicStore.dbo.ChiNhanh)
		declare @tempCN2 nvarchar(20) = (select MaCN from LINK_TO_CN2.ElectronicStore.dbo.ChiNhanh)
		if (@MaCN = @tempCN1)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN1 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end
		else if (@MaCN = @tempCN2)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN2 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end

	end
end
GO
/****** Object:  StoredProcedure [sp_deleteSanPham]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [sp_deleteSanPham](@MaSP nvarchar(20))
as
begin
	if exists (select * from sanpham where MaSP = @MaSP)
		begin
			print N'Có tồn tại sản phẩm'
			if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh 3, không thể xóa'					
				end
			else if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh 2, không thể xóa'					
				end
			else if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh 1, không thể xóa'					
				end
			else 
				if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.CTPHIEUNHAP where MaSP = @MaSP)
				begin
						print N'Sản phẩm tồn tại trong CTPN3'
						if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.CTHOADON where MaSP = @MaSP)
						begin
							print N'Sản phẩm tồn tại trong CTHD3'
						end
					end
				else if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.CTPHIEUNHAP where MaSP = @MaSP)
					begin
						print N'Sản phẩm tồn tại trong CTPN2'
						if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.CTHOADON where MaSP = @MaSP)
						begin
							print N'Sản phẩm tồn tại trong CTHD2'
						end
					end
				else if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.CTPHIEUNHAP where MaSP = @MaSP)
					begin
						print N'Sản phẩm tồn tại trong CTPN1'
						if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.CTHOADON where MaSP = @MaSP)
						begin
							print N'Sản phẩm tồn tại trong CTHD1'
						end
					end	
				else
					begin
						print N'Sản phẩm không tồn tại trong bất kỳ CTPN, CTHD ở chi nhánh nào và xóa được'
						delete from LINK_TO_CN3.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						print N'Đã xóa ở CN3'
						delete from LINK_TO_CN2.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						print N'Đã xóa ở CN2'
						delete from LINK_TO_CN1.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						print N'Đã xóa ở CN1'
						delete from SANPHAM where MaSP = @MaSP
						print N'Đã xóa sản phẩm'
					end
		end
	else
		begin
			print N'Sản phẩm không tồn tại'
		end
end
GO
/****** Object:  StoredProcedure [sp_SanPhamBanChay]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SanPhamBanChay]
as
begin
	select MaSP, TenSP, SoLuongBanRa 
	from 
		(select MaSP, TenSP, count(*) as SoLuongBanRa from LINK_TO_CN1.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		union 
			select MaSP, TenSP, count(*) as SoLuongBanRa from LINK_TO_CN2.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		union 
			select MaSP, TenSP, count(*) as SoLuongBanRa from LINK_TO_CN3.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		) as ThongKe
	group by MaSP, TenSP, SoLuongBanRa
	order by SoLuongBanRa desc
end
GO
/****** Object:  StoredProcedure [sp_SelectAllCN]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllCN]
as
begin
	select * from LINK_TO_CN2.ElectronicStore.dbo.ChiNhanh
	union
	select * from LINK_TO_CN1.ElectronicStore.dbo.ChiNhanh
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.ChiNhanh
end
GO
/****** Object:  StoredProcedure [sp_SelectAllHD]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllHD]
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.HoaDon

end
GO
/****** Object:  StoredProcedure [sp_SelectAllMaHD]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllMaHD]
as
begin
	select MaHD from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
	union
	select MaHD from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
	union
	select MaHD from LINK_TO_CN3.ElectronicStore.dbo.HoaDon
end
GO
/****** Object:  StoredProcedure [sp_SelectAllMaKH]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllMaKH]
as
begin
SELECT MaKH from LINK_TO_CN1.ElectronicStore.dbo.KhachHang
union
select maKH from LINK_TO_CN2.ElectronicStore.dbo.KhachHang
union
select MaKH from LINK_TO_CN3.ElectronicStore.dbo.KhachHang
end
GO
/****** Object:  StoredProcedure [sp_SelectAllNV]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllNV]
as
begin
	select MaNV from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
	union
	select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
	union
	select MaNV from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
end
GO
/****** Object:  StoredProcedure [sp_SelectAllNV3ChiNhanh]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllNV3ChiNhanh]
as
begin
	select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
	union
	select * from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
end
GO
/****** Object:  StoredProcedure [sp_SelectAllPN]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllPN]
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.PhieuNhap
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.PhieuNhap
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.PhieuNhap

end

exec sp_SelectAllPN
GO
/****** Object:  StoredProcedure [sp_SelectAllTenDangNhap]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllTenDangNhap]
as
begin
	select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
	union
	select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
	union
	select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
end
GO
/****** Object:  StoredProcedure [sp_SelectAllTK]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_SelectAllTK]
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.TaiKhoan
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.TaiKhoan
	
end
GO
/****** Object:  StoredProcedure [sp_ThemCTPN]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [sp_ThemCTPN]
	@MaPN nvarchar(20),
	@MaSP nvarchar(20),
	@TenSP nvarchar(50),
	@SoLuong int,
	@DonGia int,
	@ThanhTien int
as
begin
	if not exists(select MaPN from CTPHIEUNHAP where MaPN = @MaPN)
		begin
			print N'Không tồn tại phiếu nhập ở chi nhánh này'
			return
		end
	if exists(select * from LINK_TO_CN1.ElectronicStore.dbo.CTPhieuNhap where MaPN = @MaPN and MaSP = @MaSP)
		begin
			print N'Đã tồn tại chi tiết phiếu nhập'
		end
	else if exists(select * from LINK_TO_CN2.ElectronicStore.dbo.CTPhieuNhap where MaPN = @MaPN and MaSP = @MaSP)
		begin
			print N'Đã tồn tại chi tiết phiếu nhập'
		end
	else if exists(select * from LINK_TO_CN3.ElectronicStore.dbo.CTPhieuNhap where MaPN = @MaPN and MaSP = @MaSP)
		begin
			print N'Đã tồn tại chi tiết phiếu nhập'
		end
	else
		begin
			insert into CTPHIEUNHAP (MaPN, MaSP, TenSP, SoLuong, DonGia,ThanhTien) values (@MaPN, @MaSP, @TenSP, @SoLuong, @DonGia, @ThanhTien)
		end
			
end
GO
/****** Object:  StoredProcedure [sp_ThemNV]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [sp_ThemNV] 
	@MaNV nvarchar(20), 
	@Ho nvarchar(20), 
	@Ten nvarchar(20), 
	@NamSinh int, 
	@GioiTinh nvarchar(20), 
	@SoDT nvarchar(20), 
	@DiaChi nvarchar(20),
	@MaCV nvarchar(20),
	@MaCN nvarchar(20),
	@IMG nvarchar(20)
AS
BEGIN
	IF EXISTS (SELECT manv FROM LINK_TO_CN1.ElectronicStore.dbo.NhanVien WHERE MaNV = @MaNV)
	BEGIN
		PRINT N'Mã nhân viên đã tồn tại'
	END
	ELSE IF EXISTS (SELECT manv FROM LINK_TO_CN2.ElectronicStore.dbo.NhanVien WHERE MaNV = @MaNV)
	BEGIN
		PRINT N'Mã nhân viên đã tồn tại'
	END
	ELSE IF EXISTS (SELECT manv FROM LINK_TO_CN3.ElectronicStore.dbo.NhanVien WHERE MaNV = @MaNV)
	BEGIN
		PRINT N'Mã nhân viên đã tồn tại'
	END
	ELSE
	BEGIN
		INSERT INTO nhanvien VALUES (@MaNV, @Ho, @Ten, @NamSinh, @GioiTinh, @SoDT, @DiaChi, @MaCV, @MaCN, @IMG, NEWID())
		PRINT N'Thêm thành công'
	END
END
GO
/****** Object:  StoredProcedure [sp_ThemPN]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [sp_ThemPN]
	@MaPN nvarchar(20),
	@NgayLap date,
	@TongTien int,
	@MaNV nvarchar(20),
	@MaNCC nvarchar(20)
as
begin
	if exists (select MaPN from LINK_TO_CN1.ElectronicStore.dbo.PhieuNhap where MaPN = @MaPN)
		begin
			print N'Đã tồn tại mã phiếu nhập trong hệ thống'
		end
	else if exists (select MaPN from LINK_TO_CN2.ElectronicStore.dbo.PhieuNhap where MaPN = @MaPN )
		begin
			print N'Đã tồn tại mã phiếu nhập trong hệ thống'
		end
	else if exists (select MaPN from LINK_TO_CN3.ElectronicStore.dbo.PhieuNhap where MaPN = @MaPN )
		begin
			print N'Đã tồn tại mã phiếu nhập trong hệ thống'
		end
	else
		if exists(select MaNV from nhanvien where MaNV = @MaNV)
			begin
				insert into PhieuNhap (MaPN, NgapLap, TongTien, MaNV, MaNCC) values (@MaPN, @NgayLap, @TongTien, @MaNV, @MaNCC) 
			end
		else
			print N'Nhân viên không thuộc chi nhánh này'
end
GO
/****** Object:  StoredProcedure [sp_ThongKeKH]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_ThongKeKH]
as
begin
    select top 10 MaKH, HoTen, SoHoaDon
    from
    (
        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN1.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN1.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten

        union

        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN2.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN2.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten

        union

        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN3.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN3.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten
    ) as DanhSach
    group by MaKH, HoTen, SoHoaDon
    order by SoHoaDon desc
end

GO
/****** Object:  StoredProcedure [sp_TimKiemNV]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [sp_TimKiemNV]
	@MaNV nvarchar(20)
as
begin

	declare @Ho nvarchar(20)
	declare @Ten nvarchar(20)
	declare @NamSinh int
	if exists (select * from LINK_TO_CN1.ElectronicStore.dbo.NhanVien where MaNV = @MaNV)
		begin
			select @Ho = Ho, @Ten = Ten, @NamSinh = NamSinh 
			from LINK_TO_CN1.ElectronicStore.dbo.NhanVien 
			where MaNV = @MaNV
			print @MaNV + ' ' + @Ho + ' ' + @Ten + ' ' + CAST(@NamSinh as nvarchar(20))
		end
	else if exists (select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien where MaNV = @MaNV)
		begin
			select @Ho = Ho, @Ten = Ten, @NamSinh = NamSinh 
			from LINK_TO_CN2.ElectronicStore.dbo.NhanVien 
			where MaNV = @MaNV
			print @MaNV + ' ' + @Ho + ' ' + @Ten + ' ' + CAST(@NamSinh as nvarchar(20))
		end
	else if exists (select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien where MaNV = @MaNV)
		begin
			select @Ho = Ho, @Ten = Ten, @NamSinh = NamSinh 
			from LINK_TO_CN3.ElectronicStore.dbo.NhanVien 
			where MaNV = @MaNV
			print @MaNV + ' ' + @Ho + ' ' + @Ten + ' ' + CAST(@NamSinh as nvarchar(20))
		end
	else
		print N'Nhân viên không tồn tại'
end
GO
/****** Object:  StoredProcedure [sp_TimKiemNVTheoTuoi]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [sp_TimKiemNVTheoTuoi]
	@TuoiBD int,
	@TuoiKT int
as
begin
	declare @rowcount int = 
	(select sum(tong) as tong1 
		from (
			select count(*) as tong from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
			union
			select count(*) as tong from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
			union
			select count(*) as tong from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
		) as tbl
	) 
	declare @MaNV nvarchar(20)
	declare @Ho nvarchar(20)
	declare @Ten nvarchar(20)
	declare @Tuoi int

	while(@rowcount > 0)
	begin
		set @rowcount = @rowcount - 1
		select @MaNV = MaNV, @Ho = Ho, @Ten = Ten, @Tuoi = NamSinh from 
			(select * from  LINK_TO_CN1.ElectronicStore.dbo.NhanVien
			 union
			 select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
			 union
			 select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien) as temp
		order by MaNV desc
		offset @rowcount rows
		fetch next 1 rows only
		if (@TuoiBD <= (year(getdate()) - @Tuoi) and (year(getdate()) - @Tuoi) <= @TuoiKT)
			print @MaNV + ' ' + @Ho + ' ' +@Ten + ' ' + cast(@Tuoi as nvarchar(20))
	end
end
GO
/****** Object:  StoredProcedure [sp_updateGiaBan]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [sp_updateGiaBan]
	@MaSP nvarchar(20),
	@GiaNhap int
as
begin
	update sanpham set DonGia = @GiaNhap*1.05 where MaSP = @MaSP
end
GO
/****** Object:  StoredProcedure [sp_XoaNV]    Script Date: 07/05/2023 10:52:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--sp xóa nhân viên khi đứng ở 1 chi nhánh bất kỳ
CREATE proc [sp_XoaNV](@MaNV nvarchar(20))
as
begin
	if not exists(select MaNV from nhanvien where MaNV = @MaNV)
		begin
			print N'Không tồn tại nhân viên trong chi nhánh'
		end
	else
		begin
			if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
				begin
					if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
						end
					else if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.HOADON where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 hóa đơn!'
						end
					else if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.TAIKHOAN where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã có tài khoản!'
						end
					else
						begin
							delete from LINK_TO_CN3.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
							print N'Xóa nhân viên thành công!'
						end
				end
			else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
				begin
					if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
						end
					else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.HOADON where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 hóa đơn!'
						end
					else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.TAIKHOAN where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã có tài khoản!'
						end
					else
						begin
							delete from LINK_TO_CN1.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
							print N'Xóa nhân viên thành công!'
						end
				end
			else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
				begin
					if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
						end
					else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.HOADON where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 hóa đơn!'
						end
					else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.TAIKHOAN where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã có tài khoản!'
						end
					else
						begin
							delete from LINK_TO_CN2.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
							print N'Xóa nhân viên thành công!'
						end
				end
		end
end
GO
