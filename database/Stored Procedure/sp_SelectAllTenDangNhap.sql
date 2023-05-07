create proc sp_SelectAllTenDangNhap
as
begin
	select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
	union
	select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
	union
	select TenDangNhap from LINK_TO_CN1.ElectronicStore.dbo.TaiKhoan
end

exec sp_SelectAllTenDangNhap