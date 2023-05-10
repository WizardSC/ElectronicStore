create proc sp_SelectAllKM
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.KhuyenMai
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.KhuyenMai
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.KhuyenMai
end

exec sp_SelectAllKM