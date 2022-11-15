package BUS;

import DAO.BangCapDAO;
import DTO.BangCapDTO;
import java.util.ArrayList;

public class BangCapBUS {
    public static ArrayList<BangCapDTO> dsbc;
    
    public void docDSBC() throws Exception{
        BangCapDAO dao = new BangCapDAO();
        if(dsbc == null || dsbc.isEmpty()) dsbc = new ArrayList<BangCapDTO>();
        dsbc = dao.docDSBC();
    }
}
