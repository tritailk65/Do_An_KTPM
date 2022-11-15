
package DAO;

import DTO.NhanVienDTO;
import DTO.ThanNhan_DTO;
import java.sql.*;
import java.util.ArrayList;


public class ThanNhan_DAO {
    private Connection con; 
    ArrayList<NhanVienDTO> arrNV;
    private NhanVienDAO nvdao;
    public boolean openConnection() {
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=QLnhansu;trustServerCertificate=true" ;
        String username = "sa"; String password= "14112002";
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
    public ArrayList<ThanNhan_DTO> getAllThanNhan(){ 
        ArrayList<ThanNhan_DTO> arr = new ArrayList(); 
        if (openConnection()) {
        try { 
        String sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where thannhan.visible=1 and nhanvien.visible=1 and thannhan.ID_nhanvien=nhanvien.ID_nhanvien";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            ThanNhan_DTO TN = new ThanNhan_DTO();
            TN.setID_nguoithan(rs.getInt(1));
            TN.setID_nhanvien(rs.getString(2));
            TN.setTennhanvien(rs.getString(3));
            TN.setHoten(rs.getString(4));
            TN.setMoiquanhe(rs.getString(5));
            TN.setNgaysinh(rs.getString(6));
            TN.setSdt(rs.getString(7));
            arr.add(TN);}
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }  
     public boolean addThanNhan(ThanNhan_DTO TN) throws Exception { 
        boolean result = false;
        if (openConnection()) {
            try { 
            nvdao = new NhanVienDAO();
            arrNV = nvdao.getAllNV();
            String sql = "";
                for (NhanVienDTO nhanVien : arrNV) {
                    if(nhanVien.getId().equalsIgnoreCase(TN.getID_nhanvien())&&
                        nhanVien.getName().equalsIgnoreCase(TN.getTennhanvien())){
                        sql = "insert into thannhan values ("
                                + "'"+TN.getID_nhanvien()+"',"
                                + "'"+TN.getHoten()+"',"
                                + "'"+TN.getMoiquanhe()+"',"
                                + "'"+TN.getNgaysinh()+"',"
                                + "'"+TN.getSdt()+"',"
                                + "1)";
                        Statement stmt = con.createStatement();
                        if (stmt.executeUpdate(sql)>=1)
                            result = true;
                        break;
                    }
                }
            }catch (SQLException ex) {
            System.out.println(ex); 
            } finally{
            closeConnection(); } }
            return result;
        } 
    public boolean delThanNhan(int id) throws Exception{
        boolean result =false;
        if(openConnection()){
            try{
                nvdao = new NhanVienDAO();
                arrNV = nvdao.getAllNV();
                String sql="UPDATE thannhan SET visible= 0 WHERE id_nguoithan="+id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
     public boolean suaThanNhan(ThanNhan_DTO TN) throws Exception{
        boolean result=false;
         if(openConnection()){
            try{
                nvdao = new NhanVienDAO();
                arrNV = nvdao.getAllNV();
                String sql="";
                for (NhanVienDTO nhanVien : arrNV)
                    if(nhanVien.getId().equalsIgnoreCase(TN.getID_nhanvien())&&
                       nhanVien.getName().equalsIgnoreCase(TN.getTennhanvien())){
                sql = "update thannhan set "
                        + "[ID_nhanvien] = '"+TN.getID_nhanvien()+"',"
                        + "[hoten] = '"+TN.getHoten()+"',"
                        + "[moiquanhe] = '"+TN.getMoiquanhe()+"',"
                        + "[ngaysinh] = '"+TN.getNgaysinh()+"',"
                        + "[sodienthoai] = '"+TN.getSdt()+"'"
                        + "where ID_nguoithan = "+TN.getID_nguoithan();
                        System.out.println(sql);
                PreparedStatement stmt = con.prepareStatement(sql);
                if (stmt.executeUpdate()>=1)
                    result = true;}
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
    public boolean hasThanNhanID(int id){ 
        boolean result = false; 
        if (openConnection()) {
        try { 
        String sql = "Select * from thannhan where ID_nguoithan="+id;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        result = rs.next(); 
        } catch (SQLException ex) {
        System.out.println(ex); 
        } finally { closeConnection(); } }
        return result;
    }  
    ///Phương thức tìm kiếm theo combobox
    public ArrayList<ThanNhan_DTO> CheckThanNhanID(String st,int i,int stt){ 
        ArrayList<ThanNhan_DTO> arr = new ArrayList();
        String sql="";
        if (openConnection()) {
        try { 
        if(stt==0){
            sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where thannhan.visible=1 and nhanvien.visible=1 and thannhan.ID_nhanvien=nhanvien.ID_nhanvien and id_nguoithan="+i;}
        if(stt==1){
            sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where thannhan.visible=1 and nhanvien.visible=1 and thannhan.ID_nhanvien=nhanvien.ID_nhanvien and thannhan.hoten like N'%"+st+"%'";
        }
        if(stt==2){
            sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where thannhan.visible=1 and nhanvien.visible=1 and thannhan.ID_nhanvien=nhanvien.ID_nhanvien and moiquanhe like N'%"+st+"%'";
        }
        if(stt==3){
            sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where thannhan.visible=1 and nhanvien.visible=1 and thannhan.ID_nhanvien=nhanvien.ID_nhanvien and thannhan.sodienthoai like N'%"+st+"%'";
        }
        if(stt==4){
            sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where (thannhan.visible=1 and nhanvien.visible=1 and thannhan.ID_nhanvien=nhanvien.ID_nhanvien) and "
                    +"(id_nguoithan="+i+" or thannhan.hoten like N'%"+st+"%' or moiquanhe like N'%"+st+"%' or thannhan.sodienthoai like N'%"+st+"%')";
        }
        if(!sql.isBlank()){
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
           ThanNhan_DTO TN = new ThanNhan_DTO();
            TN.setID_nguoithan(rs.getInt(1));
            TN.setID_nhanvien(rs.getString(2));
            TN.setTennhanvien(rs.getString(3));
            TN.setHoten(rs.getString(4));
            TN.setMoiquanhe(rs.getString(5));
            TN.setNgaysinh(rs.getString(6));
            TN.setSdt(rs.getString(7));
            arr.add(TN);}
        }
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
    public ThanNhan_DTO get1ThanNhan(int i){
        ThanNhan_DTO TN = new ThanNhan_DTO();
        if (openConnection()) {
        try { 
        String sql = "Select ID_nguoithan,thannhan.ID_nhanvien,nhanvien.hoten,thannhan.hoten,moiquanhe,thannhan.ngaysinh,thannhan.sodienthoai "
                + "from thannhan,nhanvien "
                + "where thannhan.visible=1 and nhanvien.visible=1 and thannhan.Id_nhanvien=nhanvien.ID_nhanvien and id_nguoithan="+i;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            TN.setID_nguoithan(rs.getInt(1));
            TN.setID_nhanvien(rs.getString(2));
            TN.setTennhanvien(rs.getString(3));
            TN.setHoten(rs.getString(4));
            TN.setMoiquanhe(rs.getString(5));
            TN.setNgaysinh(rs.getString(6));
            TN.setSdt(rs.getString(7));
            }
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return TN;
    }
}
