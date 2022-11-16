package DAO;

import DTO.ChucVu_DTO;
import JDBC.connectSQL;
import java.sql.*;
import java.util.ArrayList;


public class ChucVu_DAO {
    public static Connection conn = null;
     public connectSQL connect = new connectSQL("localhost","sa","14112002","QLnhansu");
    public Statement st = null;
    public ResultSet rs = null;
    
    public ChucVu_DAO() throws Exception{
        if(conn==null){
            try{
                conn = connect.getConnect();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    
    public ArrayList docDSCV() throws Exception{
        ArrayList dscv = new ArrayList<ChucVu_DTO>();
        String query = "Select * from [chucvu] where [visible] = 1";
        rs = connect.executeQuery(query);
        while(rs.next()){
            ChucVu_DTO cvdto = new ChucVu_DTO();
            cvdto.ID_chucvu = rs.getInt(1);
            cvdto.tenchucvu = rs.getString(2);
            cvdto.mota = rs.getString(3);
            cvdto.nghiphep = rs.getInt(4);
            dscv.add(cvdto);
        }
        return dscv;
    }
 }
