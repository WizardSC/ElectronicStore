create proc sp_ThongKeKH
as
begin
	
end

select * from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
select MaKH, count(*) from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
group by MaKH
union
select MaKH, count(*) from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
group by MaKH
union
select MaKH, count(*) from LINK_TO_CN3.ElectronicStore.dbo.HoaDon
group by MaKH

go
select top 10 MaKH, SoHoaDon
from
		(select MaKH, count(*) as SoHoaDon from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
		group by MaKH
		union
		select MaKH, count(*) as SoHoaDon from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
		group by MaKH
		union
		select MaKH, count(*) as SoHoaDon from LINK_TO_CN3.ElectronicStore.dbo.HoaDon
		group by MaKH) as DanhSachHoaDon
group by MaKH, SoHoaDon
order by SoHoaDon desc;

go
select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon from LINK_TO_CN1.ElectronicStore.dbo.HoaDon as hd
	join LINK_TO_CN1.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
	group by kh.MaKH, kh.ho, kh.ten
union
select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon from LINK_TO_CN2.ElectronicStore.dbo.HoaDon as hd
	join LINK_TO_CN2.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
	group by kh.MaKH, kh.ho, kh.ten
union
select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon from LINK_TO_CN3.ElectronicStore.dbo.HoaDon as hd
	join LINK_TO_CN3.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
	group by kh.MaKH, kh.ho, kh.ten
