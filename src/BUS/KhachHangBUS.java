/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import MyCustom.XuLyException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Phuc Toan
 */
public class KhachHangBUS {

    private KhachHangDAO khDAO = new KhachHangDAO();
    private ArrayList<KhachHangDTO> listKhachHang = null;
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        khDAO.docMaCN(temp);
    }

    public void docDanhSachMaKH() {
        this.listKhachHang = khDAO.getListMaKH();
    }

    public void docDanhSach() {
        this.listKhachHang = khDAO.getListKhachHang();
    }

    public ArrayList<KhachHangDTO> getListKhachHang() {
        return listKhachHang;
    }

    public ArrayList<KhachHangDTO> getListMaKH() {
        return listKhachHang;
    }

    public void add(KhachHangDTO kh) {
        listKhachHang.add(kh);
        khDAO.insertKhachHang(kh);

    }

    public void update(KhachHangDTO kh) {
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getMaKH().equals(kh.getMaKH())) {
                listKhachHang.set(i, kh);
                khDAO.updateKhachHang(kh);
                return;
            }
        }
    }

    public void delete(String MaKH) throws XuLyException {
        for (KhachHangDTO kh : listKhachHang) {
            if (kh.getMaKH().equals(MaKH)) {
                try {
                    listKhachHang.remove(kh);
                    khDAO.deleteKhachHang(MaKH);

                } catch (SQLServerException e) {
                    throw new XuLyException("Không thể xóa khách hàng vì đã có dữ liệu liên quan đến khách hàng này trong CSDL ");

                } catch (Exception e) {
                    throw new XuLyException("Không thể xóa khách hàng vì đã có dữ liệu liên quan đến khách hàng này trong CSDL ");
                }
                return;
            }

        }
    }

    public ArrayList<KhachHangDTO> searchMaKH(String tk) {
        docDanhSach();

        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        tk = tk.toLowerCase();
        for (KhachHangDTO kh : listKhachHang) {
            if (kh.getMaKH().toLowerCase().contains(tk)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }
    
    public ArrayList<KhachHangDTO> searchHo(String tk){
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        tk = tk.toLowerCase();
        for(KhachHangDTO kh : listKhachHang){
            if(kh.getHo().toLowerCase().contains(tk)){
                dskh.add(kh);
            }
        }
        return dskh;
    }
    public ArrayList<KhachHangDTO> searchTen(String tk){
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        tk = tk.toLowerCase();
        for(KhachHangDTO kh : listKhachHang){
            if(kh.getTen().toLowerCase().contains(tk)){
                dskh.add(kh);
            }
        }
        return dskh;
    }
    

    public ArrayList<KhachHangDTO> searchTuoi(int TuoiBD, int TuoiKT) {
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        for (KhachHangDTO kh : listKhachHang) {
            int TuoiCanTim = year - Integer.parseInt(kh.getNamSinh());

            if (TuoiBD <= TuoiCanTim && TuoiCanTim <= TuoiKT) {
                dskh.add(kh);
            }
        }
        return dskh;
    }
}
