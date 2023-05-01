--Thêm phiếu nhập mới khi đứng ở một chi nhánh bất kỳ
alter proc sp_ThemPN
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


exec sp_ThemPN 'PN065', '2023-05-01', 10000, 'NV003', 'NCC001'

select * from LINK_TO_CN1.ElectronicStore.dbo.PhieuNhap
union
select * from LINK_TO_CN2.ElectronicStore.dbo.PhieuNhap
union
select * from LINK_TO_CN3.ElectronicStore.dbo.PhieuNhap

select * from nhanvien