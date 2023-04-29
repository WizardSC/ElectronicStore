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