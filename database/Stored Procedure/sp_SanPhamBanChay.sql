--Stored procedure thống kê sản phẩm 
alter proc sp_SanPhamBanChay
as
begin
	select top 20 MaSP, TenSP, sum(SoLuongBanRa) as TongSoLuongBanRa
	from 
		(select MaSP, TenSP, sum(SoLuong) as SoLuongBanRa from LINK_TO_CN1.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		union 
			select MaSP, TenSP, sum(SoLuong) as SoLuongBanRa from LINK_TO_CN2.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		union 
			select MaSP, TenSP, sum(SoLuong) as SoLuongBanRa from LINK_TO_CN3.ElectronicStore.dbo.CTHOADON
			group by MaSP, TenSP
		) as ThongKe
	group by MaSP, TenSP
	order by TongSoLuongBanRa desc
end
exec sp_SanPhamBanChay

select * from cthoadon