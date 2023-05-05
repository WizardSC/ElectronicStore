/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChucVuDAO;
import DTO.ChucVuDTO;
import MyCustom.XuLyException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class ChucVuBUS {

    private ChucVuDAO cvDAO = new ChucVuDAO();
    private ArrayList<ChucVuDTO> listChucVu = null;
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        cvDAO.docMaCN(temp);
    }

    public void docDanhSach() {
        this.listChucVu = cvDAO.getListChucVu();
    }

    public ArrayList<ChucVuDTO> getListChucVu() {
        return listChucVu;
    }

    public void add(ChucVuDTO cv) {
        listChucVu.add(cv);
        cvDAO.insertChucVu(cv);
    }

    public void update(ChucVuDTO cv) {
        for (int i = 0; i < listChucVu.size(); i++) {
            if (listChucVu.get(i).getMaCV().equals(cv.getMaCV())) {
                listChucVu.set(i, cv);
                cvDAO.updateChucVu(cv);
                return;
            }
        }
    }

    public void delete(String MaCV) throws XuLyException {
        for (ChucVuDTO cv : listChucVu) {
            if (cv.getMaCV().equals(MaCV)) {
                try {
                    listChucVu.remove(cv);
                    cvDAO.deleteChucVu(MaCV);
                    return;
                } catch (SQLServerException e) {
                    throw new XuLyException("Không thể xóa chức vụ vì đã có dữ liệu liên quan đến chức vụ này trong CSDL ");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
