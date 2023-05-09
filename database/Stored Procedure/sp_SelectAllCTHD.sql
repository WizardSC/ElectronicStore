create proc sp_SelectAllCTHD
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.CTHoaDon
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.CTHoaDon
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.CTHoaDon
end