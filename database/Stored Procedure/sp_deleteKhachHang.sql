alter proc sp_deleteKhachHang
	@MaKH nvarchar(20)
as
begin
	if exists (select MaKH from LINK_TO_CN1.ElectronicStore.dbo.HoaDon where MaKH = @MaKH)
		begin
			RAISERROR(N'Không thể xóa khách hàng vì đã lập 1 hóa đơn',16,1)
			return
		end
	if exists (select MaKH from LINK_TO_CN2.ElectronicStore.dbo.HoaDon where MaKH = @MaKH)
		begin
			RAISERROR(N'Không thể xóa khách hàng vì đã lập 1 hóa đơn',16,1)
			return
		end
	if exists (select MaKH from LINK_TO_CN3.ElectronicStore.dbo.HoaDon where MaKH = @MaKH)
		begin
			RAISERROR(N'Không thể xóa khách hàng vì đã lập 1 hóa đơn',16,1)
			return
		end
	else
		begin
			delete from KHACHHANG where MaKH = @MaKH
		end
end


exec sp_deleteKhachHang 'KH009'