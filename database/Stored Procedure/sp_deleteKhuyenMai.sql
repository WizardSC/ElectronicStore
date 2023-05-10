create proc sp_deleteKhuyenMai
	@MaKM nvarchar(20)
as
begin
	if exists (select * from LINK_TO_CN1.ElectronicStore.dbo.HoaDon where MaKM = @MaKM)
		begin
			RAISERROR('Đã tồn tại khuyến mãi',16,1)
			return
		end
	if exists (select * from LINK_TO_CN2.ElectronicStore.dbo.HoaDon where MaKM = @MaKM)
		begin
			RAISERROR('Đã tồn tại khuyến mãi',16,1)
			return
		end
	if exists (select * from LINK_TO_CN3.ElectronicStore.dbo.HoaDon where MaKM = @MaKM)
		begin
			RAISERROR('Đã tồn tại khuyến mãi',16,1)
			return
		end
	else
		begin
			delete from khuyenmai where MaKM = @MaKM
		end
end

exec sp_deleteKhuyenMai 'KM006'