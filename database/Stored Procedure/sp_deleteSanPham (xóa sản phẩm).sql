alter proc sp_deleteSanPham(@MaSP nvarchar(20))
as
begin
	if exists (select * from sanpham where MaSP = @MaSP)
		begin
			print N'Có tồn tại sản phẩm'
			if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh 3, không thể xóa'					
				end
			else if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh 2, không thể xóa'					
				end
			else if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh 1, không thể xóa'					
				end
			else 
				if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.CTPHIEUNHAP where MaSP = @MaSP)
				begin
						print N'Sản phẩm tồn tại trong CTPN3'
						if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.CTHOADON where MaSP = @MaSP)
						begin
							print N'Sản phẩm tồn tại trong CTHD3'
						end
					end
				else if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.CTPHIEUNHAP where MaSP = @MaSP)
					begin
						print N'Sản phẩm tồn tại trong CTPN2'
						if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.CTHOADON where MaSP = @MaSP)
						begin
							print N'Sản phẩm tồn tại trong CTHD2'
						end
					end
				else if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.CTPHIEUNHAP where MaSP = @MaSP)
					begin
						print N'Sản phẩm tồn tại trong CTPN1'
						if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.CTHOADON where MaSP = @MaSP)
						begin
							print N'Sản phẩm tồn tại trong CTHD1'
						end
					end	
				else
					begin
						print N'Sản phẩm không tồn tại trong bất kỳ CTPN, CTHD ở chi nhánh nào và xóa được'
						delete from LINK_TO_CN3.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						print N'Đã xóa ở CN3'
						delete from LINK_TO_CN2.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						print N'Đã xóa ở CN2'
						delete from LINK_TO_CN1.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						print N'Đã xóa ở CN1'
						delete from SANPHAM where MaSP = @MaSP
						print N'Đã xóa sản phẩm'
					end
		end
	else
		begin
			print N'Sản phẩm không tồn tại'
		end
end

select * from SANPHAM_CHINHANH
exec sp_deleteSanPham 'SP060'
select * from sanpham
select * from LINK_TO_CN1.ElectronicStore.dbo.sanpham_chinhanh
