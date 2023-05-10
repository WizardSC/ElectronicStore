create proc sp_SelectAllCV
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.ChucVu
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.ChucVu
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.ChucVu
end