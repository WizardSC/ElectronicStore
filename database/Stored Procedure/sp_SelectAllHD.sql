create proc sp_SelectAllHD
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.HoaDon

end