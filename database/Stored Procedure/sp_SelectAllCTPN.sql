create proc sp_SelectAllCTPN
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.CTPhieuNhap
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.CTPhieuNhap
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.CTPhieuNhap
end

exec sp_selectAllCTHD