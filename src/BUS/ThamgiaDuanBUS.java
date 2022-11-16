package BUS;

import DAO.ThamgiaDuanDAO;
import DTO.NhanVienDTO;
import DTO.ThamgiaDuanDTO;
import java.sql.Date;
import java.util.ArrayList;

public class ThamgiaDuanBUS {
    //danh sách tổng quát chứa toàn bộ thông tin từ table thamgia_duan ở database
    public static ArrayList<ThamgiaDuanDTO> dstongquat;
    public ArrayList<NhanVienDTO> dsnvda = new ArrayList<NhanVienDTO>();
    public ThamgiaDuanBUS(){}
    
    public void docDSTGDA() throws Exception {
        ThamgiaDuanDAO thamgiadaDAO = new ThamgiaDuanDAO();
        if(dstongquat == null || dstongquat.isEmpty()) dstongquat = new ArrayList<ThamgiaDuanDTO>();
        dstongquat = thamgiadaDAO.docDSTGDA();
    } 
    
    //tạo danh sách nhân viên tham gia dự án theo idduan từ danh sách tổng quát
    public ArrayList taoDSNV(int idduan) throws Exception {
        ArrayList<NhanVienDTO> dsnv = null;
        if (NhanVienBUS.dsnv == null || NhanVienBUS.dsnv.isEmpty()) new NhanVienBUS().docDSNV();
        for(ThamgiaDuanDTO nv:dstongquat)
            if (nv.idduan == idduan) 
                for(NhanVienDTO nvdto:NhanVienBUS.dsnv) 
                    if (nv.idnv.equals(nvdto.id)){
                        dsnvda.add(nvdto);
                        break;
                    }
        return dsnvda;
    }
    
    public void themDSNV(String idnv, int vitri, Date ngayhoanthanh, int thuongduan) throws Exception {
        ThamgiaDuanDAO thamgiadaDAO = new ThamgiaDuanDAO();
        thamgiadaDAO.themDSTGDA(idnv, vitri, ngayhoanthanh, thuongduan);
    }
    
    public void themDSNV2(int idduan, String idnv, int vitri, Date ngayhoanthanh, int thuongduan) throws Exception {
        ThamgiaDuanDAO thamgiadaDAO = new ThamgiaDuanDAO();
        thamgiadaDAO.themDSTGDA2(idduan, idnv, vitri, ngayhoanthanh, thuongduan);
    }
    
    public void xoaDSNV(int idduan) throws Exception {
        ThamgiaDuanDAO thamgiadaDAO = new ThamgiaDuanDAO();
        thamgiadaDAO.xoaDSTGDA(idduan);
    }
}
