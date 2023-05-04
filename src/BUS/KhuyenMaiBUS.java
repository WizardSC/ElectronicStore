/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import MyCustom.XuLyException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class KhuyenMaiBUS {

    private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    private ArrayList<KhuyenMaiDTO> listKhuyenMai = null;
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        kmDAO.docMaCN(temp);
    }

    public void docDanhSach() {
        this.listKhuyenMai = kmDAO.getListKhuyenMai();
    }

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
        return listKhuyenMai;
    }

    public void add(KhuyenMaiDTO km) {
        listKhuyenMai.add(km);
        kmDAO.insertKhuyenMai(km);
    }

    public void update(KhuyenMaiDTO km) {
        for (int i = 0; i < listKhuyenMai.size(); i++) {
            if (listKhuyenMai.get(i).getMaKM().equals(km.getMaKM())) {
                listKhuyenMai.set(i, km);
                kmDAO.updateKhuyenMai(km);
                return;
            }
        }
    }

    public void delete(String MaKM) throws XuLyException {
        for (KhuyenMaiDTO km : listKhuyenMai) {
            if (km.getMaKM().equals(MaKM)) {
                try {
                    listKhuyenMai.remove(km);
                    kmDAO.deleteKhuyenmai(MaKM);
                } catch (SQLServerException e)  {
                    throw new XuLyException("Không thể xóakhuyến mãi vì đã có dữ liệu liên quan đến khuyến mãi này trong CSDL ");
                } catch (Exception e){
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
