/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NghiPhepDAO;
import DTO.NghiPhepDTO;
import java.util.ArrayList;

public class NghiPhepBUS {
    NghiPhepDAO npDAO = new NghiPhepDAO();
    public static ArrayList<NghiPhepDTO> dsnp;

    public NghiPhepBUS() {
    }

    public void docDSNP() throws Exception {
        NghiPhepDAO nghiphepDAO = new NghiPhepDAO();
        if (dsnp == null)
            dsnp = new ArrayList<NghiPhepDTO>();
        dsnp = nghiphepDAO.getAllNP();
    }

    public ArrayList<NghiPhepDTO> getAllNP() {
        return npDAO.getAllNP();
    }

    public String addNP(NghiPhepDTO np) throws Exception {
        if (npDAO.hasNPID(np.getId_nghiphep()))
            return "Mã nghỉ phép đã tồn tại";
        if (npDAO.addNP(np))
            return "Thêm thành công!";
        return "Thêm thất bại!";
    }

    public String DeleteNP(int id_nghiphep) {
        if (npDAO.deleteNP(id_nghiphep))
            return "Xóa thành công!";
        return "Xóa thất bại!";
    }

    public String UpdateNP(NghiPhepDTO np) {
        if (npDAO.updateNP(np))
            return "Sửa thành công!";
        return "Sửa thất bại!";
    }

    public NghiPhepDTO getNPByID(int id_nghiphep) {
        return npDAO.getNPByID(id_nghiphep);
    }

    public ArrayList<NghiPhepDTO> TimKiemNghiPhepID(String st, int id, int stt){
        return npDAO.CheckNghiPhepByID(st, id, stt);
    }
}
