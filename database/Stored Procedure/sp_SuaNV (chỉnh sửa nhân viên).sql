alter proc sp_SuaNV
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
as
begin
	if not exists (select * from LINK_TO_CN1.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
					union
					select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
					union
					select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
					)
		begin
			print N'Nhân viên không tồn tại'
		end
	else if not exists (select * from nhanvien where MaNV = @MaNV)
	begin
		print N'Nhân viên không thuộc chi nhánh này'
	end
	else
		update nhanvien
		set Ho = @Ho, Ten = @Ten, NamSinh = @NamSinh, GioiTinh = @GioiTinh, SoDT = @SoDT, DiaChi = @DiaChi, MaCV = @MaCV, IMG = @IMG
		where MaNV  = @MaNV
end

exec sp_SuaNV 'NV004', 'Nguyen', 'Van Syx Phu', 1990, 'Nam', '0987654321', 'Ha Noi', 'CV005', 'CN001', null

select * from nhanvien