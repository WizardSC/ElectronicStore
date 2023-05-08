--sp chuyển chi nhánh của nhân viên 
--Chi nhánh 1 --> Chi nhánh khác
alter proc sp_ChuyenChiNhanhNV(@MaNV nvarchar(20), @MaCN nvarchar(20))
as
begin
	if not exists(select * from NhanVien where MaNV = @MaNV)
	begin
		print N'Nhân viên không thuộc chi nhánh này'
	end
	else
	begin
		declare @tempCN2 nvarchar(20) = (select MaCN from LINK_TO_CN2.ElectronicStore.dbo.ChiNhanh)
		declare @tempCN3 nvarchar(20) = (select MaCN from LINK_TO_CN3.ElectronicStore.dbo.ChiNhanh)
		if (@MaCN = @tempCN2)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN2 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end
		else if (@MaCN = @tempCN3)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN3 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end

	end
end
select * from NHANVIEN
exec sp_SelectAllNV3ChiNhanh
exec sp_ChuyenChiNhanhNV N'NV019', N'CN003'
select * from chinhanh
update nhanvien set MaCN = N'CN002' where MaNV = N'NV014'

--sp chuyển chi nhánh của nhân viên 
--Chi nhánh 2 --> Chi nhánh khác
alter proc sp_ChuyenChiNhanhNV(@MaNV nvarchar(20), @MaCN nvarchar(20))
as
begin
	if not exists(select * from NhanVien where MaNV = @MaNV)
	begin
		print N'Nhân viên không thuộc chi nhánh này'
	end
	else
	begin
		declare @tempCN1 nvarchar(20) = (select MaCN from LINK_TO_CN1.ElectronicStore.dbo.ChiNhanh)
		declare @tempCN3 nvarchar(20) = (select MaCN from LINK_TO_CN3.ElectronicStore.dbo.ChiNhanh)
		if (@MaCN = @tempCN1)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN1 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end
		else if (@MaCN = @tempCN3)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN3 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end

	end
end

--sp chuyển chi nhánh của nhân viên 
--Chi nhánh 3 --> Chi nhánh khác
create proc sp_ChuyenChiNhanhNV(@MaNV nvarchar(20), @MaCN nvarchar(20))
as
begin
	if not exists(select * from NhanVien where MaNV = @MaNV)
	begin
		print N'Nhân viên không thuộc chi nhánh này'
	end
	else
	begin
		declare @tempCN1 nvarchar(20) = (select MaCN from LINK_TO_CN1.ElectronicStore.dbo.ChiNhanh)
		declare @tempCN2 nvarchar(20) = (select MaCN from LINK_TO_CN2.ElectronicStore.dbo.ChiNhanh)
		if (@MaCN = @tempCN1)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN1 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end
		else if (@MaCN = @tempCN2)
		begin
			ALTER TABLE NHANVIEN NOCHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
			update nhanvien set MaCN = @tempCN2 where MaNV = @MaNV
			print N'Chuyển chi nhánh thành công'
			ALTER TABLE NHANVIEN WITH CHECK CHECK CONSTRAINT FK_NHANVIEN_CHINHANH;
		end

	end
end