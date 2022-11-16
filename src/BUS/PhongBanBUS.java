
package BUS;

import DTO.PhongBanDTO;
import DAO.PhongBanDAO;
import java.util.ArrayList;
public class PhongBanBUS {
    public static ArrayList<PhongBanDTO> dspb;
    public PhongBanBUS() {}
    
    public void docDSPB() throws Exception {
        PhongBanDAO phongbanDAO = new PhongBanDAO();
        if(dspb == null || dspb.isEmpty()) dspb = new ArrayList<PhongBanDTO>();
        dspb = phongbanDAO.docDSPB();
    }
    
    public void themPB(String idpb, String tenphong, String idnv, String sdt) throws Exception {
        PhongBanDTO pb = new PhongBanDTO();
        PhongBanDAO dao = new PhongBanDAO();
        pb.ID_phongban = idpb;
        pb.tenphongban = tenphong;
        pb.ID_truongphong = idnv;
        pb.sdt_phongban= sdt;
        pb.visible = 1;
        dspb.add(pb);
        dao.themPB();
    }
    
    public void suaPB(int index, String oldIDPB, String oldIDNV, String idpb, String tenphong, String idnv, String sdt) throws Exception {
        PhongBanDAO dao = new PhongBanDAO();
        dspb.get(index).ID_phongban = idpb;
        dspb.get(index).tenphongban = tenphong;
        dspb.get(index).ID_truongphong = idnv;
        dspb.get(index).sdt_phongban = sdt;
        dao.suaPB(index, oldIDPB, oldIDNV);
    }
    
    public void xoaPB(int index) throws Exception {
        PhongBanDAO dao = new PhongBanDAO();
        String idpb = dspb.get(index).getID_phongban();
        dspb.get(index).visible = 0;
        dao.xoaPB(idpb);
    }
}
