
package DAO;

import BUS.NhanVienBUS;
import BUS.PhongBanBUS;
import DTO.PhongBanDTO;
import JDBC.connectSQL;
import java.sql.*;
import java.util.ArrayList;


public class PhongBanDAO {
    public static Connection conn = null;
    public connectSQL connect = new connectSQL("localhost","sa","14112002","QLnhansu");
    public Statement st = null;
    public ResultSet rs = null;
    
    public PhongBanDAO() throws Exception{
        if(conn==null){
            try{
                conn = connect.getConnect();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public ArrayList docDSPB() throws SQLException {
        ArrayList dspb = new ArrayList<PhongBanDTO>();
        String query = "Select * from [phongban]";
        rs = connect.executeQuery(query);
        while(rs.next()){
            PhongBanDTO pb = new PhongBanDTO();
            pb.ID_phongban = rs.getString(1);
            pb.tenphongban = rs.getString(2);
            pb.ID_truongphong = rs.getString(3);
            pb.sdt_phongban = rs.getString(4);
            pb.visible = rs.getInt(5);
            dspb.add(pb);
        }
        return dspb;
    }
    
    public void themPB() throws Exception {
        //lấy dữ liệu phòng ban mới nhất vừa thêm vào arraylist trên bus
        PhongBanDTO pb = PhongBanBUS.dspb.get(PhongBanBUS.dspb.size()-1);
        String idnv = "";
        String query2 = "";
        if (pb.ID_truongphong == null || pb.ID_truongphong.equals("")) idnv = "null";
        //Nếu id không rỗng thì thực hiện update id_phongban mới cho nhân viên trưởng phòng bên bảng nhân viên
        else {
            idnv = "'"+pb.ID_truongphong+"'";
            query2 = "update [nhanvien] set"
                    + "[ID_phongban] = '"+pb.ID_phongban+"'"
                    + "where [ID_nhanvien] = "+idnv;
        }
        String query = "insert into [phongban] values("
                + "'"+pb.ID_phongban+"',"
                + "'"+pb.tenphongban+"',"
                + ""+idnv+","
                + "'"+pb.sdt_phongban+"',"
                + pb.visible+")";
        connect.getStatement().execute(query);
        connect.getStatement().execute(query2);
    }
    
    public void suaPB(int index, String oldIDPB, String oldIDNV) throws Exception {
        PhongBanDTO pb = PhongBanBUS.dspb.get(index);
        String idnv = "";
        String query2 = "";
        //Kiểm tra xem có thay đổi trưởng phòng không nếu có thì cập nhật lại dữ liệu
        if (!oldIDNV.equals(pb.ID_truongphong)) 
            if (pb.ID_truongphong == null || pb.ID_truongphong.equals("")) {
                idnv = "null";
                query2 = "update [nhanvien] set"
                    + "[ID_phongban] = null "
                    + "where [ID_nhanvien] = "+oldIDNV;
            }
            else {
                idnv = "'"+pb.ID_truongphong+"'";
                //xóa id phòng ban ở trưởng phòng cũ
                if (oldIDNV == null || oldIDNV.equals("")) oldIDNV = "'-1'";
                query2 = "update [nhanvien] set"
                    + "[ID_phongban] = null "
                    + "where [ID_nhanvien] = "+oldIDNV;
                System.out.println(query2);
                connect.getStatement().execute(query2);
                //cập nhật id phòng ban cho trưởng phòng mới
                query2 = "update [nhanvien] set"
                    + "[ID_phongban] = '"+pb.ID_phongban+"'"
                    + "where [ID_nhanvien] = "+idnv;
            }
        if (oldIDNV.equals(pb.ID_truongphong))
            if (pb.ID_truongphong == null || pb.ID_truongphong.equals("")) idnv = "null";
            else idnv = "'"+pb.ID_truongphong+"'";
        String query = "update [phongban] set"
                + "[ID_phongban] = '"+pb.ID_phongban+"',"
                + "[tenphongban] = '"+pb.tenphongban+"',"
                + "[ID_truongphong] = "+idnv+","
                + "[sdt_phongban] = '"+pb.sdt_phongban+"'"
                + "where [ID_phongban] = '"+oldIDPB+"'";
        System.out.println(query);
        System.out.println(query2);
        connect.getStatement().execute(query);
        connect.getStatement().execute(query2);
    }
    
    public void xoaPB(String idpb) throws Exception {
        String query = "update [phongban] set [visible] = 0 where [ID_phongban] = '"+idpb+"'";
        String query2 = "update [nhanvien] set [ID_phongban] = null where [ID_phongban] = '"+idpb+"'";
        connect.getStatement().execute(query2);
        connect.getStatement().execute(query);
    }
}
