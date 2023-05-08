--Stored procedure thêm mới 1 nhân viên khi đứng ở 1 chi nhánh bất kỳ
CREATE PROC sp_ThemNV 
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

exec sp_ThemNV 'NV080', 'Nguyen', 'Van A', 1990, 'Nam', '0987654321', 'Ha Noi', 'CV005', 'CN001', null
select * from NHANVIEN
