--12. Stored procedure thống kê số hóa đơn mà khách hàng đã mua ở cửa hàng
alter proc sp_ThongKeKH
as
begin
    select top 10 MaKH, HoTen, sum(SoHoaDon) as TongSoHoaDon
    from
    (
        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN1.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN1.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten

        union all

        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN2.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN2.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten

        union all

        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN3.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN3.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten
    ) as DanhSach
    group by MaKH, HoTen
    order by TongSoHoaDon desc
end

select * from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
exec sp_SelectAllHD
go

exec sp_ThongKeKH
