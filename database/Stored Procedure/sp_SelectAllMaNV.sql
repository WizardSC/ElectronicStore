

create proc sp_SelectAllMaNV
as
begin
	select MaNV from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
	union
	select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
	union
	select MaNV from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
end
GO


