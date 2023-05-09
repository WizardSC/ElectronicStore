/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiNhanhDAO;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import MyCustom.XuLyException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienBUS {

    private NhanVienDAO nvDAO = new NhanVienDAO();

    private ArrayList<NhanVienDTO> listNhanVien = null;
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        nvDAO.docMaCN(MaCN);

    }

    public void docDanhSach() {
        this.listNhanVien = nvDAO.getListNhanVien();
    }

    public void docDanhSachNV3chinhanh() {
        this.listNhanVien = nvDAO.getListNV3ChiNhanh();
    }
    public void docDanhSachNVtheoMaCV(String MaCV){
        this.listNhanVien = nvDAO.getListNVTheoMaCV(MaCV);
    }
    public void docMaNV() {
        this.listNhanVien = nvDAO.getListMaNV();
    }

    public void docDanhSachNVMaTuTang() {
        this.listNhanVien = nvDAO.getListNVMaTuTang(MaCN);
    }

    public ArrayList<NhanVienDTO> getListNhanVien() {

        return listNhanVien;
    }

    public ArrayList<NhanVienDTO> getListMaNV() {
        return listNhanVien;
    }

    public ArrayList<NhanVienDTO> getListNV3ChiNhanh() {
//        this.listNhanVien = nvDAO.getListNV3ChiNhanh();
        return listNhanVien;
    }

    public ArrayList<NhanVienDTO> getListNVMaTuTang() {
        return listNhanVien;
    }

    public void add(NhanVienDTO nv) {
        listNhanVien.add(nv);
        nvDAO.insertNhanVien(nv);
    }

    public void update(NhanVienDTO nv) {

        for (int i = 0; i < listNhanVien.size(); i++) {

            if (listNhanVien.get(i).getMaNV().equals(nv.getMaNV())) {
                listNhanVien.set(i, nv);

                nvDAO.updateNhanVien(nv);
                return;
            }
        }
    }

    public void updateChiNhanh(NhanVienDTO nv) {
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getMaNV().equals(nv.getMaNV())) {
                listNhanVien.set(i, nv);

                nvDAO.updateChiNhanh(nv);
                return;
            }
        }
    }

    public void delete(String MaNV) throws XuLyException {
        docDanhSach(); //đọc danh sách nhân viên của chi nhánh hiện tại thôi

        for (NhanVienDTO nv : listNhanVien) {
            if (nv.getMaNV().equals(MaNV)) {
                try {
                    listNhanVien.remove(nv);
                    nvDAO.deleteNhanVien(MaNV);
                } catch (SQLServerException e) {
                    throw new XuLyException("Không thể xóa nhân viên vì đã có dữ liệu liên quan đến nhân viên này trong CSDL ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }

        }

    }
    
    public ArrayList<NhanVienDTO> getListNVtheoMaCV(){
        return listNhanVien;
    }

    public ArrayList<NhanVienDTO> searchMaNV(String tk, boolean search) {
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        if (search) {
            this.listNhanVien = nvDAO.getListNhanVien();
        } else {
            this.listNhanVien = nvDAO.getListNV3ChiNhanh();

        }
        tk = tk.toLowerCase();
        for (NhanVienDTO nv : listNhanVien) {
            if (nv.getMaNV().toLowerCase().contains(tk)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    
    public ArrayList<NhanVienDTO> searchHo(String tk, boolean search){
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        if(search){
            this.listNhanVien = nvDAO.getListNhanVien();
        } else {
            this.listNhanVien = nvDAO.getListNV3ChiNhanh();
        }
        tk = tk.toLowerCase();
        for(NhanVienDTO nv : listNhanVien){
            if(nv.getHo().toLowerCase().contains(tk)){
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    
    
    public ArrayList<NhanVienDTO> searchTen(String tk, boolean search){
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        if(search){
            this.listNhanVien = nvDAO.getListNhanVien();
        } else {
            this.listNhanVien = nvDAO.getListNV3ChiNhanh();
            
        }
        tk = tk.toLowerCase();
        for(NhanVienDTO nv : listNhanVien){
            if(nv.getTen().toLowerCase().contains(tk)){
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    public ArrayList<NhanVienDTO> searchTuoi(int TuoiBD, int TuoiKT, boolean search) {
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        if (search) {
            this.listNhanVien = nvDAO.getListNhanVien();
        } else {
            this.listNhanVien = nvDAO.getListNV3ChiNhanh();
        }
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        for (NhanVienDTO nv : listNhanVien) {

            int TuoiCanTim = year - nv.getNamSinh();

            if (TuoiBD <= TuoiCanTim && TuoiCanTim <= TuoiKT) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

}
