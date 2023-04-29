--SP lấy tất cả nhân viên trong 3 chi nhánh khi đứng tại bất kỳ 1 chi nhánh nào đó
create proc sp_SelectAllNV
as
begin
	select MaNV from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
	union
	select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
	union
	select MaNV from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
end

exec sp_SelectAllNV


select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
select * from nhanvien

--SP lấy tất cả chi nhánh trong 3 chi nhánh khi đứng tại bất kỳ 1 chi nhánh nào đó
create proc sp_SelectAllCN
as
begin
	select * from LINK_TO_CN2.ElectronicStore.dbo.ChiNhanh
	union
	select * from LINK_TO_CN1.ElectronicStore.dbo.ChiNhanh
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.ChiNhanh
end

exec sp_SelectAllCN
--SP lấy tất cả mã khách hàng trong 3 chi nhánh khi đứng tại bất kỳ 1 chi nhánh nào đó 
create proc sp_SelectAllMaKH
as
begin
SELECT MaKH from LINK_TO_CN1.ElectronicStore.dbo.KhachHang
union
select maKH from LINK_TO_CN2.ElectronicStore.dbo.KhachHang
union
select MaKH from LINK_TO_CN3.ElectronicStore.dbo.KhachHang
end
----SP lấy tất cả mã hóa đơn trong 3 chi nhánh khi đứng tại bất kỳ 1 chi nhánh nào đó
create proc sp_SelectAllMaHD
as
begin
	select MaHD from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
	union
	select MaHD from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
	union
	select MaHD from LINK_TO_CN3.ElectronicStore.dbo.HoaDon
end
exec sp_SelectAllMaHD

create proc sp_SelectAllHD
as
begin
	select * from LINK_TO_CN1.ElectronicStore.dbo.HoaDon
	union
	select * from LINK_TO_CN2.ElectronicStore.dbo.HoaDon
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.HoaDon

end

exec sp_SelectAllHD

--sp xóa nhân viên khi đứng ở 1 chi nhánh bất kỳ
create proc sp_XoaNV(@MaNV nvarchar(20))
as
begin
	if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
		begin
			if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
			begin
				print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
			end
			else
			begin
				delete from nhanvien where MaNV = @MaNV
				print N'Xóa nhân viên thành công!'
			end
		end
	else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
		begin
			if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
			begin
				print N'Không thể xóa nhân viên ở CN1 do nhân viên đã lập 1 phiếu nhập!'
			end
			else
			begin
				delete from nhanvien where MaNV = @MaNV
				print N'Xóa nhân viên thành công!'
			end
		end
	else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
		begin
			if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
			begin
				print N'Không thể xóa nhân viên ở CN2 do nhân viên đã lập 1 phiếu nhập!'
			end
			else
			begin
				delete from nhanvien where MaNV = @MaNV
				print N'Xóa nhân viên thành công!'
			end
		end
end
drop proc sp_SelectAllNV3ChiNhanh

--sp hiển thị tất cả các nhân viên ở 3 chi nhánh
create proc sp_SelectAllNV3ChiNhanh
as
begin
	select * from LINK_TO_CN2.ElectronicStore.dbo.NhanVien
	union
	select * from LINK_TO_CN1.ElectronicStore.dbo.NhanVien
	union
	select * from LINK_TO_CN3.ElectronicStore.dbo.NhanVien
end


exec sp_SelectAllNV3ChiNhanh
go
--sp chuyển chi nhánh của nhân viên 
--Chi nhánh 1
alter proc sp_ChuyenChiNhanhNV(@MaNV nvarchar(20), @MaCN nvarchar(20))
as
begin
	if not exists(select * from NhanVien where MaNV = @MaNV)
	begin
		print N'Nhân viên không thuộc chi nhánh này'
	end
	else
	begin
		declare @tempCN2 nvarchar(20)
		set @tempCN2 = (select MaCN from LINK_TO_CN2.ElectronicStore.dbo.ChiNhanh)
		declare @tempCN3 nvarchar(20)
		set @tempCN3 = (select MaCN from LINK_TO_CN3.ElectronicStore.dbo.ChiNhanh)

		if (@MaCN = @tempCN2)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = 'CN002' where MaNV = @MaNV
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end
		else if (@MaCN = @tempCN3)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;

			update nhanvien set MaCN = 'CN003' where MaNV = @MaNV
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end

	end
end
select * from NHANVIEN
exec sp_SelectAllNV3ChiNhanh
exec sp_ChuyenChiNhanhNV N'NV002', N'CN002'
select * from chinhanh
update nhanvien set MaCN = N'CN002' where MaNV = N'NV014'


--sp xóa sản phẩm khi đứng ở 1 chi nhánh bất kỳ

alter proc sp_deleteSanPham(@MaSP nvarchar(20))
as
begin
	if exists (select * from sanpham where MaSP = @MaSP)
		begin
			print N'Có tồn tại sản phẩm'
			if exists (select MaSP from LINK_TO_CN3.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh khác, không thể xóa'					
				end
			else if exists (select MaSP from LINK_TO_CN2.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh khác, không thể xóa'					
				end
			else if exists (select MaSP from LINK_TO_CN1.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP and SoLuong > 0)
				begin
					print N'Sản phẩm còn hàng ở chi nhánh khác, không thể xóa'					
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
						delete from LINK_TO_CN2.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						delete from LINK_TO_CN1.ElectronicStore.dbo.SANPHAM_CHINHANH where MaSP = @MaSP
						delete from SANPHAM where MaSP = @MaSP
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
