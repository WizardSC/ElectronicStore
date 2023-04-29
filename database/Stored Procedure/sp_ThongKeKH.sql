create proc sp_ThongKeKH
as
begin
    select top 10 MaKH, HoTen, SoHoaDon
    from
    (
        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN1.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN1.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten

        union

        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN2.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN2.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten

        union

        select kh.MaKH, kh.ho + ' ' + kh.ten as HoTen, count(*) as SoHoaDon 
        from LINK_TO_CN3.ElectronicStore.dbo.HoaDon as hd
        join LINK_TO_CN3.ElectronicStore.dbo.KhachHang as kh on kh.MaKH = hd.makh
        group by kh.MaKH, kh.ho, kh.ten
    ) as DanhSach
    group by MaKH, HoTen, SoHoaDon
    order by SoHoaDon desc
end

go

exec sp_ThongKeKH
