create proc sp_ResetMatKhauTK
	@TenDangNhap nvarchar(20)
	
as
begin
	if not exists (select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap
					union
					select TenDangNhap from LINK_TO_CN2.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap
					union
					select TenDangNhap from LINK_TO_CN3.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap)
		begin
			print N'Tài khoản chưa tồn tại'
			return
		end
	if exists (select * from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap and MatKhau = N'111111'
			union
			select * from LINK_TO_CN2.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap and MatKhau = N'111111'
			union
			select * from LINK_TO_CN3.ElectronicStore.dbo.TaiKhoan where TenDangNhap = @TenDangNhap and MatKhau = N'111111')
		begin
			print N'Mật khẩu đã được reset mặc định'
			return
		end
	else
		begin
			update taikhoan set MatKhau = '111111' where TenDangNhap = @TenDangNhap
			print N'Reset mật khẩu thành công'
		end
end

exec sp_ResetMatKhauTK 'nv015'
select * from taikhoan

exec sp_SelectAllTK