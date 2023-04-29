create proc sp_SelectAllPN
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.PhieuNhap
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.PhieuNhap
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.PhieuNhap

end

exec sp_SelectAllPN