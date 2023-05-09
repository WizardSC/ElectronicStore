--Stored procedure thêm CTHD khi đứng ở 1 chi nhánh bất kỳ
-- Chỉ có thể thêm CTHD cho HD ở chi nhánh hiện tại
-- Chỉ cần nhập thông tin MaHD và MaSP cùng với SoLuong, các thông tin còn lại sẽ tự động được nhập để tránh sai lệch dữ liệu
-- Cập nhật giá trị hóa đơn với mỗi CTHD được nhập vào
create proc sp_ThemCTHD
	@MaHD nvarchar(20),
	@MaSP nvarchar(20),
	@SoLuong int
as
begin
	if not exists(select MaHD from hoadon where MaHD = @MaHD)
		begin
			print N'Không tồn tại hóa đơn ở chi nhánh này'
			return
		end
	if exists (select MaHD, MaSP from LINK_TO_CN1.ElectronicStore.dbo.CTHoaDon where MaHD = @MaHD and MaSP = @MaSP
			union
			select MaHD, MaSP from LINK_TO_CN2.ElectronicStore.dbo.CTHoaDon where MaHD = @MaHD and MaSP = @MaSP
			union
			select MaHD, MaSP from LINK_TO_CN3.ElectronicStore.dbo.CTHoaDon where MaHD = @MaHD and MaSP = @MaSP)
		begin
			print N'Đã tồn tại CTHD'
			return
		end
	else
		begin
			
			declare @TenSP nvarchar(140) = (select TenSP from sanpham where MaSP = @MaSP)
			declare @DonGia int = (select DonGia from sanpham where MaSP = @MaSP)
			declare @ThanhTien int
			set @ThanhTien = @DonGia * @SoLuong
			insert into CTHoaDon (MaHD, MaSP, TenSP, SoLuong,DonGia,ThanhTien)
			values (@MaHD, @MaSP, @TenSP, @SoLuong, @DonGia, @ThanhTien)
			print N'Thêm CTHD thành công'

			update hoadon set TongTien = @ThanhTien + TongTien where MaHD = @MaHD
		end

end
select * from CTHOADON

exec sp_SelectAllCTHD
delete from hoadon where MaHD = 'HD021'
exec sp_ThemCTHD 'HD021', 'SP006', 1

select * from SANPHAM
