create proc sp_SanPhamBanChay
as
begin
	select MaSP, TenSP, SoLuongBanRa 
	from 
		(select MaSP, TenSP, count(*) as SoLuongBanRa from LINK_TO_CN1.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		union 
			select MaSP, TenSP, count(*) as SoLuongBanRa from LINK_TO_CN2.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		union 
			select MaSP, TenSP, count(*) as SoLuongBanRa from LINK_TO_CN3.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		) as ThongKe
	group by MaSP, TenSP, SoLuongBanRa
	order by SoLuongBanRa desc
end

exec sp_SanPhamBanChay