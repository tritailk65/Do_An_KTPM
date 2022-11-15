
package BUS;

import DAO.ChucVu_DAO;
import DTO.ChucVu_DTO;
import java.util.ArrayList;

public class ChucVu_BUS {
    public static ArrayList<ChucVu_DTO> dscv;
    
    public void docDSCV() throws Exception{
        ChucVu_DAO cvdao = new ChucVu_DAO();
        if(dscv == null || dscv.isEmpty()) dscv = new ArrayList<ChucVu_DTO>();
        dscv = cvdao.docDSCV();
    }
    
    
    
    
    
    public ArrayList<ChucVu_DTO> getAllChucVu() throws Exception{
        return new ChucVu_DAO().docDSCV();
    }
    public String addPhongBan(ChucVu_DTO CV) throws Exception{
        if(new ChucVu_DAO().hasChucVuID(CV.getID_chucvu()))
            return "Mã hợp đồng đã tồn tại";
        if(new ChucVu_DAO().addChucVu(CV))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    public String delChucVu(ChucVu_DTO PB) throws Exception{
        if(new ChucVu_DAO().delChucVu(PB.getID_chucvu()))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    public String suaChucVu(ChucVu_DTO PB) throws Exception{
        if(new ChucVu_DAO().suaChucVu(PB))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
}
