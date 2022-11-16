
package BUS;
import DAO.ViPham_DAO;
import DTO.ViPham_DTO;
import java.util.ArrayList;
public class ViPham_BUS {
     ViPham_DAO VPDAO=new ViPham_DAO();
    public ArrayList<ViPham_DTO> getAllViPham(){
        return VPDAO.getAllViPham();
    }
    //Kiểm tra xem có thêm vi phạm mới được ko
    public String addViPham(ViPham_DTO VP) throws Exception{
        if(VPDAO.hasViPhamID(VP.getID_vipham()))
            return "Mã vi phạm đã tồn tại";
        if(VPDAO.addViPham(VP))
            return "Thêm vi phạm thành công";
        return "Thêm vi phạm thất bại";
    }
    //Kiểm tra xem có xóa được vi phạm ko
    public String delViPham(int id){
        if(VPDAO.delViPham(id))
            return "Xóa vi phạm thành công";
        return "Xóa vi phạm thất bại";
    }
    //Kiểm tra xem có sửa được dữ liệu ko
    public String updateViPham(ViPham_DTO VP) throws Exception{
        if(VPDAO.updateViPham(VP))
            return "Sửa vi phạm thành công";
        return "Sửa vi phạm thất bại";
    }
    //Trả về ArrayList tìm kiếm vi phạm
    public ArrayList<ViPham_DTO> TimKiemViPham(String st,int id,int stt){
        return VPDAO.CheckViPham(st,id,stt);
    }
    //Trả về kiểu dữ liệu hiển thị vi phạm
    public ViPham_DTO HienThiVP(int i){
        return VPDAO.get1ViPham(i);
    }
}
