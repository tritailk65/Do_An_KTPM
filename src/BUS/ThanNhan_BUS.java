
package BUS;
import DAO.ThanNhan_DAO;
import DTO.ThanNhan_DTO;        
import java.util.ArrayList;
public class ThanNhan_BUS {
    ThanNhan_DAO TNDAO=new ThanNhan_DAO();
    public ArrayList<ThanNhan_DTO> getAllThanNhan(){
        return TNDAO.getAllThanNhan();
    }
    public String addThanNhan(ThanNhan_DTO TN) throws Exception{
        if(TNDAO.hasThanNhanID(TN.getID_nguoithan()))
            return "Mã vi phạm đã tồn tại";
        if(TNDAO.addThanNhan(TN))
            return "Thêm thân nhân thành công";
        return "Thêm thân nhân thất bại";
    }
    public String delThanNhan(int id) throws Exception{
        if(TNDAO.delThanNhan(id))
            return "Xóa thân nhân thành công";
        return "Xóa thân nhân thất bại";
    }
    public String suaThanNhan(ThanNhan_DTO PB) throws Exception{
        if(TNDAO.suaThanNhan(PB))
            return "Sửa thân nhân thành công";
        return "Sửa thân nhân thất bại";
    }  
    public ArrayList<ThanNhan_DTO> TimKiemThanNhan(String st,int id,int stt){
        return TNDAO.CheckThanNhanID(st,id,stt);
    }
    public ThanNhan_DTO HienThiNT(int i){
        return TNDAO.get1ThanNhan(i);
    }
}
