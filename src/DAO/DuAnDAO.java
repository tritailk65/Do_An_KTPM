package DAO;

import BUS.DuAnBUS;
import DTO.DuAnDTO;
import JDBC.connectSQL;
import java.sql.*;
import java.util.ArrayList;

public class DuAnDAO {
    public static Connection conn = null;
    public connectSQL connect = new connectSQL("localhost","sa","14112002","QLnhansu");
    public Statement st = null;
    public ResultSet rs = null;
        
    public DuAnDAO() throws Exception{
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
    public ArrayList docDSDA() throws Exception{
        ArrayList dsda = new ArrayList<DuAnDTO>();
        String query = "Select * from [duan] where [visible] = 1";
        rs = connect.executeQuery(query);
        while(rs.next()) {
            DuAnDTO da = new DuAnDTO();
            da.idduan = rs.getInt(1);
            da.tenduan = rs.getString(2);
            da.mota = rs.getString(3);
            da.chiphi = rs.getLong(4);
            da.ngaybatdau = rs.getDate(5);
            da.ngayketthuc = rs.getDate(6);
            da.visible = rs.getInt(7);
            dsda.add(da);
        }
        return dsda;
    }
    
    //Hàm thêm dự án mới (phần tử mới nhất của ArrayList) vào database
    public void themDA() throws Exception {
        DuAnDTO duanDTO = new DuAnDTO();
        //lấy dữ liệu duan mới nhất vừa thêm vào arraylist trên bus
        duanDTO = DuAnBUS.dsda.get(DuAnBUS.dsda.size()-1);
        String query = "insert into [duan] (tenduan, mota, chiphi, ngaybatdau, ngayketthuc, visible)" +
                        "values (N'"+duanDTO.tenduan+"',N'"+duanDTO.mota+"',"+duanDTO.chiphi+
                ",'"+duanDTO.ngaybatdau+"','"+duanDTO.ngayketthuc+"',1)";
        connect.getStatement().execute(query);
        //update lại dsda
        DuAnBUS.dsda.clear();
        new DuAnBUS().docDSDA();
    }
    
    //Hàm sửa dự án theo id trong database
    public void suaDA(int index, int id) throws Exception {
        DuAnDTO duanDTO = new DuAnDTO();
        duanDTO.tenduan = DuAnBUS.dsda.get(index).tenduan;
        duanDTO.mota = DuAnBUS.dsda.get(index).mota;
        duanDTO.chiphi = DuAnBUS.dsda.get(index).chiphi;
        duanDTO.ngaybatdau = DuAnBUS.dsda.get(index).ngaybatdau;
        duanDTO.ngayketthuc = DuAnBUS.dsda.get(index).ngayketthuc;
        String query = "update [duan] set "
                + "tenduan = N'" + duanDTO.tenduan + "',"
                + "mota = N'" + duanDTO.mota + "',"
                + "chiphi = " + duanDTO.chiphi + ","
                + "ngaybatdau = '" + duanDTO.ngaybatdau + "',"
                + "ngayketthuc = '" + duanDTO.ngayketthuc + "'"
                + "where ID_duan =" + id;
        connect.getStatement().execute(query);
    }
    
    //Hàm xóa dự án theo id
    public void xoaDA(int id) throws Exception {
        String query = "update [duan] set [visible] = 0 where ID_duan = "+id;
        connect.getStatement().execute(query);
        //update lại dsda
        DuAnBUS.dsda.clear();
        new DuAnBUS().docDSDA();
    }
}