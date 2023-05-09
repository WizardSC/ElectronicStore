-- Stored procedure thêm CTPN khi đứng ở 1 chi nhánh bất kỳ
-- Chỉ có thể thêm CTPN cho PN ở chi nhánh hiện tại
-- Chỉ cần nhập thông tin MaPN và MaSP cùng với SoLuong, các thông tin còn lại sẽ tự động được nhập để tránh sai lệch dữ liệu
-- Cập nhật giá trị hóa đơn với mỗi CTPN được nhập vào
alter proc sp_ThemCTPN
	@MaPN nvarchar(20),
	@MaSP nvarchar(20),	
	@SoLuong int
as
begin
	if not exists(select MaPN from PHIEUNHAP where MaPN = @MaPN)
		begin
			print N'Không tồn tại phiếu nhập ở chi nhánh này'
			return
		end
	if exists(select * from LINK_TO_CN1.ElectronicStore.dbo.CTPhieuNhap where MaPN = @MaPN and MaSP = @MaSP)
		begin
			print N'Đã tồn tại chi tiết phiếu nhập'
		end
	else if exists(select * from LINK_TO_CN2.ElectronicStore.dbo.CTPhieuNhap where MaPN = @MaPN and MaSP = @MaSP)
		begin
			print N'Đã tồn tại chi tiết phiếu nhập'
		end
	else if exists(select * from LINK_TO_CN3.ElectronicStore.dbo.CTPhieuNhap where MaPN = @MaPN and MaSP = @MaSP)
		begin
			print N'Đã tồn tại chi tiết phiếu nhập'
		end
	else
		begin
			declare @TenSP  nvarchar(140) = (select TenSP from SANPHAM where MaSP = @MaSP)
			declare @DonGiaNhap int = (select DonGia = DonGia/1.05 from sanpham where MaSP = @MaSP)
			declare @ThanhTien int = @SoLuong * @DonGiaNhap
			insert into CTPHIEUNHAP (MaPN, MaSP, TenSP, SoLuong, DonGia,ThanhTien) values (@MaPN, @MaSP, @TenSP, @SoLuong, @DonGiaNhap, @ThanhTien)
			print N'Thêm chi tiết phiếu nhập thành công'
			update PHIEUNHAP set TongTien = TongTien + @ThanhTien where MaPN = @MaPN
		end
			
end

exec sp_ThemCTPN 'PN060', 'SP007', 1
delete CTPHIEUNHAP where MaPN = 'PN060'

select * from CTPHIEUNHAP