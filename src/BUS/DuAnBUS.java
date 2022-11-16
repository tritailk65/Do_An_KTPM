package BUS;

import DAO.DuAnDAO;
import DTO.DuAnDTO;
import java.sql.Date;
import java.util.ArrayList;

public class DuAnBUS {
    public static ArrayList<DuAnDTO> dsda;
    public DuAnBUS(){}
    
    
    //Hàm đọc danh sách dự án từ ArrayList dưới DAO và lưu vào static ArrayList
    public void docDSDA() throws Exception{
        DuAnDAO duanDAO = new DuAnDAO();
        if(dsda == null || dsda.isEmpty()) dsda = new ArrayList<DuAnDTO>();
        dsda = duanDAO.docDSDA();
    }
    
    //Hàm thêm dự án mới vào ArrayList và thêm dự án vào DB từ DAO
    public void themDA(String tenduan, String mota, long chiphi, Date ngaybatdau, Date ngayketthuc) throws Exception {
        DuAnDAO duandao = new DuAnDAO();
        DuAnDTO duandto = new DuAnDTO();
        duandto.tenduan = tenduan;
        duandto.mota = mota;
        duandto.chiphi = chiphi;
        duandto.ngaybatdau = ngaybatdau;
        duandto.ngayketthuc = ngayketthuc;
        dsda.add(duandto);
        duandao.themDA(); 
    }
    
    //Hàm thêm dự án khỏi ArrayList và xóa dự án khỏi DB từ DAO
    public void suaDA(int index, String tenduan, String mota, long chiphi, Date ngaybatdau, Date ngayketthuc) throws Exception {
        DuAnDAO duanDAO = new DuAnDAO();
        dsda.get(index).tenduan = tenduan;
        dsda.get(index).mota = mota;
        dsda.get(index).chiphi = chiphi;
        dsda.get(index).ngaybatdau = ngaybatdau;
        dsda.get(index).ngayketthuc = ngayketthuc;
        duanDAO.suaDA(index, dsda.get(index).idduan);
    }
    
    //Hàm thêm dự án khỏi ArrayList và xóa dự án khỏi DB từ DAO
    public void xoaDA(int index) throws Exception {
        DuAnDAO duanDAO = new DuAnDAO();
        dsda.get(index).visible = 0;
        duanDAO.xoaDA(dsda.get(index).idduan);
    }
    
}
