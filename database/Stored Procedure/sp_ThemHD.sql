--Stored procedure thêm hóa đơn khi đứng ở bất kỳ chi nhánh nào
--Chỉ nhân viên thuộc chi nhánh hiện tại mới có thể lập hóa đơn
--Số liệu tổng tiền hóa đơn sẽ dựa vào chi tiết hóa đơn (người dùng không được phép nhập)

create proc sp_ThemHD
	@MaHD nvarchar(20),
	@NgayLap datetime,

	@MaNV nvarchar(20),
	@MaKH nvarchar(20),
	@MaKM nvarchar(20)
as
begin
	if exists(select MaHD from LINK_TO_CN1.ElectronicStore.dbo.HoaDon where MaHD = @MaHD
				union
				select MaHD  from LINK_TO_CN2.ElectronicStore.dbo.HoaDon where MaHD = @MaHD
				union
				select MaHD  from LINK_TO_CN3.ElectronicStore.dbo.HoaDon where MaHD = @MaHD)
		begin
			print N'Đã tồn tại hóa đơn trong hệ thống'
		end
	else
		begin
			if not exists (select MaNV from nhanvien where MaNV = @MaNV)
				begin
					print N'Nhân viên không thuộc chi nhánh này'
					return
				end
			else
				insert into HOADON (MaHD, NgayLap, TongTien, MaNV, MaKH, MaKM)
				values (@MaHD, @NgayLap, 0, @MaNV, @MaKH, @MaKM)
				print N'Thêm hóa đơn thành công'

		end
end





go

exec sp_ThemHD 'HD021', '2023-05-09', 'NV002', 'KH001', null
select * from hoadon