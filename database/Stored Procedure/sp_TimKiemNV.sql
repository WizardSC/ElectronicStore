--Tìm kiếm nhân viên (xuất ra MaNV, Họ, Tên, Năm sinh) theo mã NV khi đứng ở 1 chi nhánh bất kỳ
alter proc sp_TimKiemNV
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

exec sp_TimKiemNV 'NV003'

select * from nhanvien

select (year(getdate()) - NamSinh) from nhanvien where manv = 'NV001'