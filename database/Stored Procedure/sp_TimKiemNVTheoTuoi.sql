--Tìm kiếm những nhân viên tại 1 chi nhánh bất kỳ có tuổi nằm trong khoảng nhất định 
alter proc sp_TimKiemNVTheoTuoi
	@TuoiBD int,
	@TuoiKT int
as
begin
	declare @rowcount int = 
	(select sum(tong) as tong1 
		from (
			select count(*) as tong from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
			union
			select count(*) as tong from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
			union
			select count(*) as tong from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
		) as tbl
	) 
	declare @MaNV nvarchar(20)
	declare @Ho nvarchar(20)
	declare @Ten nvarchar(20)
	declare @Tuoi int

	while(@rowcount > 0)
	begin
		set @rowcount = @rowcount - 1
		select @MaNV = MaNV, @Ho = Ho, @Ten = Ten, @Tuoi = NamSinh from 
			(select * from  LINK_TO_CN1.ElectronicStore.dbo.NhanVien
			 union
			 select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
			 union
			 select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien) as temp
		order by MaNV desc
		offset @rowcount rows
		fetch next 1 rows only
		if (@TuoiBD <= (year(getdate()) - @Tuoi) and (year(getdate()) - @Tuoi) <= @TuoiKT)
			print @MaNV + ' ' + @Ho + ' ' +@Ten + ' ' + cast(@Tuoi as nvarchar(20))
	end
end
exec sp_TimKiemNVTheoTuoi 20, 30

go

select MaNV, Year(getdate()) - NamSinh from  LINK_TO_CN1.ElectronicStore.dbo.NhanVien
union
select MaNV, Year(getdate()) - NamSinh from  LINK_TO_CN2.ElectronicStore.dbo.NhanVien
union
select MaNV, Year(getdate()) - NamSinh from  LINK_TO_CN3.ElectronicStore.dbo.NhanVien