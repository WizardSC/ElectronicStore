--5. Stored procedure xóa nhân viên khi đứng ở 1 chi nhánh bất kỳ
--Chỉ có thể xóa nhân viên đang làm việc ở chi nhánh hiện tại
create proc sp_XoaNV(@MaNV nvarchar(20))
as
begin
	if not exists(select MaNV from nhanvien where MaNV = @MaNV)
		begin
			print N'Không tồn tại nhân viên trong chi nhánh'
		end
	else
		begin
			if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
				begin
					if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
						end
					else if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.HOADON where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 hóa đơn!'
						end
					else if exists(select MaNV from LINK_TO_CN3.ElectronicStore.dbo.TAIKHOAN where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã có tài khoản!'
						end
					else
						begin
							delete from LINK_TO_CN3.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
							print N'Xóa nhân viên thành công!'
						end
				end
			else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
				begin
					if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
						end
					else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.HOADON where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 hóa đơn!'
						end
					else if exists(select MaNV from LINK_TO_CN1.ElectronicStore.dbo.TAIKHOAN where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã có tài khoản!'
						end
					else
						begin
							delete from LINK_TO_CN1.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
							print N'Xóa nhân viên thành công!'
						end
				end
			else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.NHANVIEN where MaNV = @MaNV)
				begin
					if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.PHIEUNHAP where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 phiếu nhập!'
						end
					else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.HOADON where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã lập 1 hóa đơn!'
						end
					else if exists(select MaNV from LINK_TO_CN2.ElectronicStore.dbo.TAIKHOAN where MaNV = @MaNV)
						begin
							print N'Không thể xóa nhân viên do nhân viên đã có tài khoản!'
						end
					else
						begin
							delete from LINK_TO_CN2.ElectronicStore.dbo.NhanVien where MaNV = @MaNV
							print N'Xóa nhân viên thành công!'
						end
				end
		end
end

exec sp_XoaNV 'NV080'

select * From nhanvien
exec sp_SelectAllNV
exec sp_SelectAllHD