--Stored procedure chỉnh sửa thông tin của nhân viên khi đứng tại 1 chi nhánh bất kỳ
--Chỉ có thể chỉnh sửa thông tin của nhân viên đang làm việc tại chi nhánh hiện tại
CREATE PROCEDURE sp_SuaNV
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
	IF NOT EXISTS (
		SELECT * FROM LINK_TO_CN1.ElectronicStore.dbo.NhanVien WHERE MaNV = @MaNV
		UNION
		SELECT * FROM LINK_TO_CN2.ElectronicStore.dbo.NhanVien WHERE MaNV = @MaNV
		UNION
		SELECT * FROM LINK_TO_CN3.ElectronicStore.dbo.NhanVien WHERE MaNV = @MaNV
	)
	BEGIN
		PRINT N'Nhân viên không tồn tại'
	END
	ELSE IF NOT EXISTS (SELECT * FROM nhanvien WHERE MaNV = @MaNV AND MaCN = @MaCN)
	BEGIN
		PRINT N'Nhân viên không thuộc chi nhánh này'
	END
	ELSE
	BEGIN
		UPDATE nhanvien
		SET Ho = @Ho, Ten = @Ten, NamSinh = @NamSinh, GioiTinh = @GioiTinh, SoDT = @SoDT, DiaChi = @DiaChi, MaCV = @MaCV, IMG = @IMG
		WHERE MaNV = @MaNV
	END
END

exec sp_SuaNV 'NV005', N'Nguyễn', N'Văn Sỹ Phú', 1990, 'Nam', '0987654321', 'TP. Ho Chi Minh', 'CV005', 'CN001', null

select * from nhanvien