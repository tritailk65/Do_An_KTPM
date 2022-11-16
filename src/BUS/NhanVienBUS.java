package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
public class NhanVienBUS {
    public static ArrayList<NhanVienDTO> dsnv;
    public NhanVienBUS() {}
    
    //Hàm đọc danh sách dự án từ ArrayList dưới DAO và lưu vào static ArrayList
    public void docDSNV() throws Exception{
        NhanVienDAO nvDAO = new NhanVienDAO();
        if(dsnv == null || dsnv.isEmpty()) dsnv = new ArrayList<NhanVienDTO>();
        dsnv = nvDAO.docDSNV();
    }
    
    public void themNV(String id, String name, int idcv, String idpb, int idbc, int gioitinh, String ngaysinh, String sdt, String email, String cmnd, int luong, int phucap, int songaynghi, String diachi, String hinhanh) throws Exception {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVienDTO dto = new NhanVienDTO();
        dto.id = id;
        dto.name = name;
        dto.id_chucvu = idcv;
        dto.id_phongban = idpb;
        dto.id_bangcap = idbc;
        dto.gioitinh = gioitinh;
        dto.ngaysinh = ngaysinh;
        dto.sdt = sdt;
        dto.email = email;
        dto.cmnd = cmnd;
        dto.luong = luong;
        dto.phucap = phucap;
        dto.songaynghi = songaynghi;
        dto.diachi = diachi;
        dto.tinhtrang = 1;
        dto.hinhanh = hinhanh;
        dto.visible = 1;
        dsnv.add(dto);
        dao.themNV();
    }
    
    public void suaNV(int index, String name, int idcv, String idpb, int idbc, int gioitinh, String ngaysinh, String sdt, String email, String cmnd, int luong, int phucap, int songaynghi, String diachi, int tinhtrang, String hinhanh) throws Exception {
        NhanVienDAO dao = new NhanVienDAO();
        dsnv.get(index).name = name;
        dsnv.get(index).id_chucvu = idcv;
        dsnv.get(index).id_phongban = idpb;
        dsnv.get(index).id_bangcap = idbc;
        dsnv.get(index).gioitinh = gioitinh;
        dsnv.get(index).ngaysinh = ngaysinh;
        dsnv.get(index).sdt = sdt;
        dsnv.get(index).email = email;
        dsnv.get(index).cmnd = cmnd;
        dsnv.get(index).luong = luong;
        dsnv.get(index).phucap = phucap;
        dsnv.get(index).songaynghi = songaynghi;
        dsnv.get(index).diachi = diachi;
        dsnv.get(index).tinhtrang = tinhtrang;
        if (hinhanh == null || hinhanh.equals("")) 
        dsnv.get(index).hinhanh = dsnv.get(index).hinhanh;
        else dsnv.get(index).hinhanh = hinhanh;
        dao.suaNV(index);
    }
    
    public void xoaNV(String idnv, int index) throws Exception {
        NhanVienDAO dao = new NhanVienDAO();
        dsnv.get(index).visible = 0;
        dao.xoaNV(idnv);
    }
    
    
    NhanVienDAO nvDAO;
    public ArrayList<NhanVienDTO> getAllNV() throws Exception{
        nvDAO = new NhanVienDAO();
        return nvDAO.getAllNV();
    }
     public ArrayList<NhanVienDTO> CheckNhanVienByID(String st,int i,int stt){
         return nvDAO.CheckNhanVienByID(st,i,stt);
     }

}
 
    
