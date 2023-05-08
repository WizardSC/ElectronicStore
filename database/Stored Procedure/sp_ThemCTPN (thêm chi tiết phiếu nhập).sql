select * from CTPhieuNhap
--Stored procedure Thêm CTPN khi đứng tại 1 chi nhánh bất kỳ
--Phiếu nhập phải tồn tại ở chi nhánh hiện tại
create proc sp_ThemCTPN
	@MaPN nvarchar(20),
	@MaSP nvarchar(20),
	@TenSP nvarchar(50),
	@SoLuong int,
	@DonGia int,
	@ThanhTien int
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
			insert into CTPHIEUNHAP (MaPN, MaSP, TenSP, SoLuong, DonGia,ThanhTien) values (@MaPN, @MaSP, @TenSP, @SoLuong, @DonGia, @ThanhTien)
		end
			
end

exec sp_ThemCTPN 'PN033', 'SP001', 'A', 20, 10000, 200000

select * from CTPHIEUNHAP