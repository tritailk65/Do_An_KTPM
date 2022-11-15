package DAO;


import BUS.NhanVienBUS;
import java.util.ArrayList;
import DTO.NhanVienDTO;
import JDBC.connectSQL;
import java.sql.*;


public class NhanVienDAO {
public static Connection conn = null;
    public connectSQL connect = new connectSQL("localhost","sa","14112002","QLnhansu");
    public Statement st = null;
    public ResultSet rs = null;
    
    public NhanVienDAO() throws Exception{
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
    public ArrayList docDSNV() throws Exception{
        ArrayList dsnv = new ArrayList<NhanVienDTO>();
        String query = "Select * from [nhanvien]";
        rs = connect.executeQuery(query);
        while(rs.next()) {
            NhanVienDTO nv = new NhanVienDTO();
            nv.id = rs.getString(1);
            nv.name = rs.getString(2);
            nv.id_chucvu = rs.getInt(3);
            nv.id_phongban = rs.getString(4);
            nv.id_bangcap = rs.getInt(5);
            nv.gioitinh = rs.getInt(6);
            nv.ngaysinh = rs.getString(7);
            if (rs.getString(8) == null) nv.sdt = "";
            else nv.sdt = rs.getString(8);
            nv.email = rs.getString(9);
            nv.cmnd = rs.getString(10);
            nv.luong = rs.getInt(11);
            nv.phucap = rs.getInt(12);
            nv.songaynghi = rs.getInt(13);
            if (rs.getString(14) == null) nv.diachi = "";
            nv.diachi = rs.getString(14);
            nv.hinhanh = rs.getString(15);
            nv.tinhtrang = rs.getInt(16);
            nv.visible = rs.getInt(17);
            dsnv.add(nv);
        }
        return dsnv;
    }
    
    
    public void themNV() throws Exception {
        NhanVienDTO nv = NhanVienBUS.dsnv.get(NhanVienBUS.dsnv.size()-1);
        String idpb = "";
        String sdt = "", diachi = "";
        if (nv.id_phongban == null || nv.id_phongban.equals("")) idpb = "null";
        else idpb = "'"+nv.id_phongban+"'";
        if (nv.sdt == null || nv.sdt.equals("")) sdt = "null";
        else sdt = "'"+nv.sdt+"'";
        if (nv.diachi == null || nv.diachi.equals("")) diachi = "null";
        else diachi = "'"+nv.diachi+"'";
        String query = "insert into [nhanvien] values("
                + "'"+nv.id+"',"
                + "'"+nv.name+"',"
                + ""+nv.id_chucvu+","
                + ""+idpb+","
                + ""+nv.id_bangcap+","
                + ""+nv.gioitinh+","
                + "'"+nv.ngaysinh+"',"
                + ""+sdt+","
                + "'"+nv.email+"',"
                + "'"+nv.cmnd+"',"
                + ""+nv.luong+","
                + ""+nv.phucap+","
                + ""+nv.songaynghi+","
                + ""+diachi+","
                + "'"+nv.hinhanh+"',"
                + "1, 1)";
        System.out.println(query);
        connect.getStatement().execute(query);
    }
    
    public void suaNV(int index) throws Exception {
        NhanVienDTO nv = NhanVienBUS.dsnv.get(index);
        String idpb = "", sdt = "", diachi = "";
        if (nv.id_phongban == null || nv.id_phongban.equals("")) idpb = "null";
        else idpb = "'"+nv.id_phongban+"'";
        if (nv.sdt == null || nv.sdt.equals("")) sdt = "null";
        else sdt = "'"+nv.sdt+"'";
        if (nv.diachi == null || nv.diachi.equals("")) diachi = "null";
        else diachi = "'"+nv.diachi+"'";
        String query = "update [nhanvien] set "
                + "[hoten] = '"+nv.name+"',"
                + "[ID_chucvu] = "+nv.id_chucvu+","
                + "[ID_phongban] = "+idpb+","
                + "[ID_bangcap] = "+nv.id_bangcap+","
                + "[gioitinh] = "+nv.gioitinh+"," 
                + "[ngaysinh] = '"+nv.ngaysinh+"'," 
                + "[sodienthoai] = "+sdt+"," 
                + "[email] = '"+nv.email+"'," 
                + "[cmnd] = '"+nv.cmnd+"'," 
                + "[luong] = "+nv.luong+"," 
                + "[phucap] = "+nv.phucap+"," 
                + "[songaynghi] = "+nv.songaynghi+"," 
                + "[diachi] = "+diachi+"," 
                + "[anhthe] = '"+nv.hinhanh+"'," 
                + "[tinhtrang] = "+nv.tinhtrang+" " 
                + "where [ID_nhanvien] = '"+nv.id+"'";
        System.out.println(query);
        connect.getStatement().execute(query);
    }
    
    public void xoaNV(String idnv) throws Exception {
        String query = "update [nhanvien] set [visible] = 0 where ID_nhanvien = '"+idnv+"'";
        String query2 = "";
        connect.getStatement().execute(query);
        query2 = "update [hopdonglaodong] set [visible] = 0 where ID_nhanvien = '"+idnv+"'";
        connect.getStatement().execute(query2);
        query2 = "update [vipham] set [visible] = 0 where ID_nhanvien = '"+idnv+"'";
        connect.getStatement().execute(query2);
        query2 = "update [thannhan] set [visible] = 0 where ID_nhanvien = '"+idnv+"'";
        connect.getStatement().execute(query2);
    }
    
    
    
    
    
private Connection con; 
public boolean openConnection() {
try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=qlnhansu_1.2;trustServerCertificate=true";
        String username = "sa"; String password= "123456";
        con = DriverManager.getConnection(dbUrl, username, password); 
        return true;
    }catch (Exception ex) {
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
public ArrayList<NhanVienDTO> getAllNV(){ 
    ArrayList<NhanVienDTO> arr = new ArrayList<NhanVienDTO>(); 
    if (openConnection()) {
    try { 
        String sql = "Select *from nhanvien where visible = 1";
       Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        NhanVienDTO nv = new NhanVienDTO();
        nv.setId(rs.getString("id_nhanvien"));
        nv.setId_chucvu(rs.getInt("id_chucvu"));
        nv.setId_phongban(rs.getString("id_phongban"));
        nv.setId_bangcap(rs.getInt("id_bangcap"));
        nv.setName(rs.getString("hoten"));
        nv.setNgaysinh(rs.getString("ngaysinh"));
        nv.setDiachi(rs.getString("diachi"));
        nv.setCmnd(rs.getString("cmnd"));
        nv.setEmail(rs.getString("email"));
        nv.setLuong(rs.getInt("luong"));
        nv.setSdt(rs.getString("sodienthoai"));
        nv.setPhucap(rs.getInt("phucap"));
        nv.setSongaynghi(rs.getInt("songaynghi"));
        nv.setGioitinh(rs.getInt("gioitinh"));
        nv.setTinhtrang(rs.getInt("tinhtrang"));
        arr.add(nv); }
    } catch (SQLException ex) {
        System.out.println(ex);
    }     finally { 
        closeConnection();
    } }
        return arr;
}
public ArrayList<NhanVienDTO> CheckNhanVienByID(String st,int i,int stt){ 
        ArrayList<NhanVienDTO> arr = new ArrayList();
        String sql="";
        if (openConnection()) {
        try { 
        if(stt==0){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where  nhanvien.visible=1 and  id_nhanvien like N'%"+st+"%'";}
        if(stt==1){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and hoten like N'%"+st+"%'";
        }
        if(stt==2){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and sodienthoai like N'%"+st+"%'";
        }
        if(stt==3){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and gioitinh=1";
        }
         if(stt==4){
            sql ="Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang " 
                + "from nhanvien "
                + "where visible=1 and  gioitinh=0";
        }
        if(stt==5){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and ngaysinh like N'%"+st+"%'";
        }
        if(stt==6){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and email like N'%"+st+"%'";
        }
        if(stt==7){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and tinhtrang=1 ";
        }
          if(stt==8){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where visible=1 and tinhtrang=0 ";
        }
        if(stt==9){
            sql = "Select id_nhanvien,hoten,gioitinh,ngaysinh,sodienthoai,email,tinhtrang "
                + "from nhanvien "
                + "where (visible=1 and id_nhanvien) "
                + "(ngaysinh like N '%"+st+"%' or id_nhanvien like N'%"+st+"%'  or nhanvien.hoten like N'%"+st+"%' or nhanvien.email like N'%"+st+"%' or nhanvien.sodienthoai like N'%"+st+"%')";
        }
        
        if(!sql.isBlank()){
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while(rs.next()){
        NhanVienDTO nv = new NhanVienDTO();
        nv.setId(rs.getString(1));
        nv.setName(rs.getString(2));
        nv.setNgaysinh(rs.getString(4));
        nv.setEmail(rs.getString(6));
        nv.setSdt(rs.getString(5));
        nv.setGioitinh(rs.getInt(3));
        nv.setTinhtrang(rs.getInt(7));
        arr.add(nv);}
        }
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
}



