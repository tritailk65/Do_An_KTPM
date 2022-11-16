
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
    
}
