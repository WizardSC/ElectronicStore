
--Stored procedure để lấy danh sách tất cả các nhân viên đang làm việc tại cửa hàng khi đứng ở một chi nhánh cụ thể
create proc sp_SelectAllNV
as
begin
	select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
	union
	select * from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
end


GO


exec sp_SelectAllNV

