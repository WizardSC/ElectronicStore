create proc sp_TaoTK
	@TenDangNhap nvarchar(50),
	@MatKhau nvarchar(30),
	@MaNV nvarchar(20),
	@TinhTrang bit,
	@MaCV nvarchar(20)
as
begin
	if not exists(select * from nhanvien where MaNV = @MaNV)
		begin
			print N'Nhân viên không thuộc chi nhánh này'
			return
		end
	if exists (select MaNV from taikhoan where MaNV = @MaNV)
		begin
			print N'Nhân viên đã có tài khoản'
			return
		end
	if exists (select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap
				union
				select TenDangNhap from LINK_TO_CN2.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap
				union
				select TenDangNhap from LINK_TO_CN3.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap)
		begin
			print N'Tên đăng nhập đã tồn tại'
			return
		end
	else
		insert into taikhoan (TenDangNhap, MatKhau, MaNV, TinhTrang, MaCV)
		values (@TenDangNhap, @MatKhau, @MaNV, @TinhTrang, @MaCV)
		print N'Tạo tài khoản thành công'
end

exec sp_TaoTK 'nv018', 'nv018', 'NV018', 1, 'CV001'

