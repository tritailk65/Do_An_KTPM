
package BUS;
import DTO.HopDong_DTO;
import DAO.HopDong_DAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HopDong_BUS {
    HopDong_DAO hdDAO=new HopDong_DAO();
    public ArrayList<HopDong_DTO> getAllHopDong(){
        return hdDAO.getAllHopDong();
    }
    public String addHopDong(HopDong_DTO hd){
        if(hdDAO.hasHopDongID(hd.getID_hopdong()))
            return "Mã hợp đồng đã tồn tại";
        try {
            if(hdDAO.addHopDong(hd))
                return "Thêm thành công";
        } catch (Exception ex) {
            Logger.getLogger(HopDong_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thêm thất bại";
    }
    public String delHopDong(int id){
        if(hdDAO.delHopDong(id))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    public String updateHopDong(HopDong_DTO hd){
        try {
            if(hdDAO.updateHopDong(hd))
                return "Sửa thành công";
        } catch (Exception ex) {
            Logger.getLogger(HopDong_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Sửa thất bại";
    }
    public ArrayList<HopDong_DTO> checkHopDong(String st,int i,int stt){
        ArrayList<HopDong_DTO> rs=hdDAO.CheckHopDong(st,i,stt);
        return rs;
    }
    public HopDong_DTO HienThiHD(int i){
        return hdDAO.get1ViPham(i);
    }
}
