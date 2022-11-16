
package DAO;
import DTO.NhanVienDTO;
import DTO.ViPham_DTO;
import java.sql.*;
import java.util.ArrayList;
public class ViPham_DAO {
    private Connection con; 
    NhanVienDAO NVDAO;
    ArrayList<NhanVienDTO> arrNV;
    //Mở cổng kết nối JDBC
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
    //Đóng cổng kết nối
    public void closeConnection() {
        try {
        if (con!=null)
        con.close();
        } catch (SQLException ex) {
        System.out.println(ex); }
      }
    //Lấy dữ liệu từ database sang ArrayList
    public ArrayList<ViPham_DTO> getAllViPham(){ 
        ArrayList<ViPham_DTO> arr = new ArrayList(); 
        if (openConnection()) {
        try { 
        String sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where vipham.visible=1 and nhanvien.visible=1";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            ViPham_DTO VP = new ViPham_DTO();
            VP.setID_vipham(rs.getInt(1));
            VP.setID_nhanvien(rs.getString(2));
            VP.setTennhanvien(rs.getString(3));
            VP.setLydo(rs.getString(4));
            VP.setNgay(rs.getString(5));
            VP.setTienphat(rs.getInt(6));
            arr.add(VP);}
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
   //Thêm vi phạm mới vào database 
   public boolean addViPham(ViPham_DTO VP) throws Exception { 
        boolean result = false;
        if (openConnection()) {
            try { 
            NVDAO = new NhanVienDAO();
            arrNV=NVDAO.getAllNV();
            String sql = "Insert into vipham values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql); 
            for (NhanVienDTO nhanVien : arrNV)
                    if(nhanVien.getId().equalsIgnoreCase(VP.getID_nhanvien())&&
                       nhanVien.getName().equalsIgnoreCase(VP.getTennhanvien())){
        //Kiểm tra xem id nhân viên nhập có đúng là tên nhân viên nhập không
                    stmt.setString(1,VP.getID_nhanvien());
                    stmt.setString(2,VP.getLydo());
                    stmt.setString(3,VP.getNgay());
                    stmt.setInt(4,VP.getTienphat());
                    stmt.setBoolean(5,true);
             if (stmt.executeUpdate()>=1)
                result = true;}
            }catch (SQLException ex) {
            System.out.println(ex); 
            } finally{
            closeConnection(); } }
            return result;
        } 
    //Xóa vi phạm tham chiếu theo id
    public boolean delViPham(int id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql="UPDATE vipham SET visible= 0 WHERE id_vipham="+id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
    //Sửa thông tin của vi phạm trừ id vi phạm
    public boolean updateViPham(ViPham_DTO VP) throws Exception{
        boolean result=false;
         if(openConnection()){
            try{
            NVDAO = new NhanVienDAO();
                arrNV=NVDAO.getAllNV();
                String sql="UPDATE vipham SET id_nhanvien=?, ngayvipham=?, lydo=?, tienphat=? WHERE id_vipham="+VP.getID_vipham();
                PreparedStatement stmt = con.prepareStatement(sql);
                for (NhanVienDTO nhanVien : arrNV)
                    if(nhanVien.getName().equalsIgnoreCase(VP.getTennhanvien())){
                    stmt.setString(1,VP.getID_nhanvien());
                    stmt.setString(3,VP.getLydo());
                    stmt.setString(2,VP.getNgay());
                    stmt.setInt(4,VP.getTienphat());
                    if (stmt.executeUpdate()>=1)
                    result = true;}
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
    //Kiểm tra id vi phạm có trùng hay không
    public boolean hasViPhamID(int id){ 
        boolean result = false; 
        if (openConnection()) {
        try { 
        String sql = "Select * from vipham where ID_vipham="+id;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        result = rs.next(); 
        } catch (SQLException ex) {
        System.out.println(ex); 
        } finally { closeConnection(); } }
        return result;
    }
    //Tìm kiếm vi phạm theo nhiều lựa chọn 
    public ArrayList<ViPham_DTO> CheckViPham(String st,int i,int stt){ 
        ArrayList<ViPham_DTO> arr = new ArrayList();
        String sql="";
        if (openConnection()) {
        try { 
        //Tìm kiếm theo id vi phạm
        if(stt==0){
            sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where vipham.visible=1 and nhanvien.visible=1 and id_vipham="+i;}
        //Tìm kiếm theo tiền phạt
        if(stt==1){
            sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where vipham.visible=1 and nhanvien.visible=1 and tienphat="+i;
        }
        //Tìm kiếm theo họ tên nhân viên
        if(stt==2){
            sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where vipham.visible=1 and nhanvien.visible=1 and nhanvien.hoten like N'%"+st+"%'";
        }
        //Tìm kiếm theo ngày vi phạm 
        if(stt==3){
            sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where vipham.visible=1 and nhanvien.visible=1 and ngayvipham like '%"+st+"%'";
        }
        //Tìm kiếm theo tất cả dữ liệu trong table vi phạm
        if(stt==4){
            sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where (vipham.visible=1 and nhanvien.visible=1) and "
                + "(ngayvipham like '%"+st+"%' or id_vipham="+i+" or tienphat="+i+" or nhanvien.hoten like N'%"+st+"%')";
        }
        if(!sql.isBlank()){
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            ViPham_DTO VP = new ViPham_DTO();
            VP.setID_vipham(rs.getInt(1));
            VP.setID_nhanvien(rs.getString(2));
            VP.setTennhanvien(rs.getString(3));
            VP.setLydo(rs.getString(4));
            VP.setNgay(rs.getString(5));
            VP.setTienphat(rs.getInt(6));
            arr.add(VP);}
        }
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
    //Lấy 1 Vi phạm theo id vi phạm cho button hiển thị bên GUI
    public ViPham_DTO get1ViPham(int i){
        ViPham_DTO VP = new ViPham_DTO();
        if (openConnection()) {
        try { 
        String sql = "Select ID_vipham,vipham.ID_nhanvien,nhanvien.hoten,lydo,ngayvipham,tienphat "
                + "from vipham join nhanvien on vipham.Id_nhanvien=nhanvien.ID_nhanvien "
                + "where vipham.visible=1 and nhanvien.visible=1 and id_vipham="+i;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            VP.setID_vipham(rs.getInt(1));
            VP.setID_nhanvien(rs.getString(2));
            VP.setTennhanvien(rs.getString(3));
            VP.setLydo(rs.getString(4));
            VP.setNgay(rs.getString(5));
            VP.setTienphat(rs.getInt(6));
            }
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return VP;
    }
}
