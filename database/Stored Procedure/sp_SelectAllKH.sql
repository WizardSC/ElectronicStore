create proc sp_SelectAllKH
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.KhachHang
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.KhachHang
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.KhachHang
end

exec sp_SelectAllKH
go

select * from hoadon
exec sp_SelectAllHD

exec sp_SelectAllKH