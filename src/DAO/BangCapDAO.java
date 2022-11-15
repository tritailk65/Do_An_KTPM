package DAO;

import DTO.BangCapDTO;
import JDBC.connectSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BangCapDAO {
    public static Connection conn = null;
     public connectSQL connect = new connectSQL("localhost","sa","14112002","QLnhansu");
    public Statement st = null;
    public ResultSet rs = null;
        
    public BangCapDAO() throws Exception{
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
    public ArrayList docDSBC() throws Exception{
        ArrayList dsbc = new ArrayList<BangCapDTO>();
        String query = "Select * from [bangcap] where [visible] = 1";
        rs = connect.executeQuery(query);
        while(rs.next()) {
            BangCapDTO bc = new BangCapDTO();
            bc.setId(rs.getInt(1));
            bc.setBangcap(rs.getString(2));
            bc.setThuongbangcap(rs.getInt(3));
            bc.setVisible(rs.getInt(4));
            dsbc.add(bc);
        }
        return dsbc;
    }
}
