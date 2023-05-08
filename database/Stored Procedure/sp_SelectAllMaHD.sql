--Stored procedure để lấy danh sách tất cả các mã HD của tất cả các chi nhánh khi đứng ở một chi nhánh bất kỳ
--Ứng dụng: Dùng để làm mã HD tự tăng mỗi khi tạo 1 hóa đơn mới ở 1 chi nhánh bất kỳ
create proc sp_SelectAllMaHD
as
begin
	select MaHD from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
	union
	select MaHD from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
	union
	select MaHD from LINK_TO_CN3.ElectronicStore.dbo.HoaDon
end

exec sp_SelectAllMaHD