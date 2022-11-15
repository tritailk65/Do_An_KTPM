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
    
    
    
    
    
    private Connection con; 
    public boolean openConnection() {
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=qlnhansu_1.2;trustServerCertificate=true" ;
        String username = "sa"; String password= "123456";
        con=DriverManager.getConnection( dbUrl, username, password);
        return true;
        } catch (Exception ex) {
        System.out.println(ex); 
        return false; }
      }
    public void closeConnection() {
        try {
        if (con!=null)
        con.close();
        } catch (SQLException ex) {
        System.out.println(ex); }
      }
    public ArrayList<ChucVu_DTO> getAllChucVu(){ 
        ArrayList<ChucVu_DTO> arr = new ArrayList(); 
        if (openConnection()) {
        try { 
        String sql = "Select * from chucvu";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            ChucVu_DTO CV = new ChucVu_DTO();
            CV.setID_chucvu(rs.getInt(1));
            CV.setTenchucvu(rs.getString(2));
            CV.setMota(rs.getString(3));
            CV.setNghiphep(rs.getInt(4));
            arr.add(CV);}
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
   public boolean addChucVu(ChucVu_DTO CV) { 
        boolean result = false;
        if (openConnection()) {
            try { 
            String sql = "Insert into chucvu values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setInt(1,CV.getID_chucvu());
            stmt.setString(2,CV.getTenchucvu());
            stmt.setString(3,CV.getMota());
            stmt.setInt(4,CV.getNghiphep());
            stmt.setBoolean(5,true);
            if (stmt.executeUpdate()>=1)
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            } finally{
            closeConnection(); } }
            return result;
        } 
    public boolean delChucVu(int id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql="UPDATE chucvu SET visible=0 WHERE id="+id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
    public boolean suaChucVu(ChucVu_DTO CV){
        boolean result=false;
         if(openConnection()){
            try{
                String sql="UPDATE hopdonglaodong SET ID_chucvu='?',tenchucvu='?',mota='?',nghiphep='?' WHERE id="+CV.getID_chucvu();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,CV.getID_chucvu());
                stmt.setString(2,CV.getTenchucvu());
                stmt.setString(3,CV.getMota());    
                stmt.setInt(4,CV.getNghiphep());
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
        public boolean hasChucVuID(int id){ 
        boolean result = false; 
        if (openConnection()) {
        try { 
        String sql = "Select * from chucvu where ID_chucvu="+id;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        result = rs.next(); 
        } catch (SQLException ex) {
        System.out.println(ex); 
        } finally { closeConnection(); } }
        return result;
    }  
}
