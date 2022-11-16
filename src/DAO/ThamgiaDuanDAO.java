package DAO;

import BUS.DuAnBUS;
import BUS.ThamgiaDuanBUS;
import DTO.ThamgiaDuanDTO;
import JDBC.connectSQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ThamgiaDuanDAO {
    public static Connection conn = null;
    public connectSQL connect = new connectSQL("localhost","sa","14112002","QLnhansu");
    public Statement st = null;
    public ResultSet rs = null;
    
    public ThamgiaDuanDAO() throws Exception{
        if(conn==null){
            try{
                conn = connect.getConnect();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    //Hàm lấy dữ liệu từ database trả về dạng ArrayList
    public ArrayList docDSTGDA() throws Exception{
        ArrayList dstongquat = new ArrayList<ThamgiaDuanDTO>();
        String query = "Select * from [thamgia_duan]";
        rs = connect.executeQuery(query);
        while(rs.next()){
            ThamgiaDuanDTO nvtgda = new ThamgiaDuanDTO();
            nvtgda.idduan = rs.getInt(1);
            nvtgda.idnv = rs.getString(2);
            nvtgda.vitri = rs.getInt(3);
            nvtgda.ngaythamgia = rs.getDate(4);
            nvtgda.ngayhoanthanh = rs.getDate(5);
            nvtgda.thuongduan = rs.getInt(6);
            dstongquat.add(nvtgda);
        }
        return dstongquat;
    }
    
    //Thêm danh sách dự án cho dự án mới tạo
    public void themDSTGDA(String idnv, int vitri, Date ngayhoanthanh, int thuongduan) throws Exception {
        String query = "insert into [thamgia_duan] (ID_duan ,ID_nhanvien, vitri, ngaythamgia, ngayhoanthanh, thuongduan)" 
                + " values ('"+DuAnBUS.dsda.get(DuAnBUS.dsda.size()-1).idduan+"','"+idnv+"','"+vitri+"',getdate(),'" + ngayhoanthanh+"','"+thuongduan+"')";
        connect.getStatement().execute(query);
        //update lại danh sách
        ThamgiaDuanBUS.dstongquat.clear();
        new ThamgiaDuanBUS().docDSTGDA();
    }
    
    //Bổ sung nhân viên tham gia dự án
    public void themDSTGDA2(int idduan, String idnv, int vitri, Date ngayhoanthanh, int thuongduan) throws Exception {
        String query = "insert into [thamgia_duan] (ID_duan ,ID_nhanvien, vitri, ngaythamgia, ngayhoanthanh, thuongduan)" 
                + " values ('"+idduan+"','"+idnv+"','"+vitri+"',getdate(),'"+ngayhoanthanh+"','"+thuongduan+"')";
        connect.getStatement().execute(query);
        //update lại danh sách
        ThamgiaDuanBUS.dstongquat.clear();
        new ThamgiaDuanBUS().docDSTGDA();
    }
    
    public void xoaDSTGDA(int idduan) throws Exception {
        String query = "delete thamgia_duan where ID_duan = '"+idduan+"'";
        connect.getStatement().execute(query);
        //update lại danh sách
        ThamgiaDuanBUS.dstongquat.clear();
        new ThamgiaDuanBUS().docDSTGDA();
    }
}
