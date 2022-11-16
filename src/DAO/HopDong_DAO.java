
package DAO;
import DTO.ChucVu_DTO;
import DTO.HopDong_DTO;
import DTO.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;


public class HopDong_DAO {
    private Connection con; 
    NhanVienDAO NVDAO;
    ChucVu_DAO CVDAO;
    ArrayList<NhanVienDTO> arrNV;
    ArrayList<ChucVu_DTO> arrCV;
    public HopDong_DAO() {}
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
    public ArrayList<HopDong_DTO> getAllHopDong(){ 
        ArrayList<HopDong_DTO> arr = new ArrayList(); 
        if (openConnection()) {
        try { 
        String sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,tenchucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien,chucvu "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien and hopdonglaodong.id_chucvu=chucvu.id_chucvu";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            HopDong_DTO HD = new HopDong_DTO();
            HD.setID_hopdong(rs.getInt(1));
            HD.setID_nhanvien(rs.getString(2));
            HD.setTennhanvien(rs.getString(3));
            HD.setLoaihopdong(rs.getString(4));
            HD.setNgayBD(rs.getString(5));
            HD.setNgayKT(rs.getString(6));
            HD.setID_chucvu(rs.getInt(7));
            HD.setChucvu(rs.getString(8));
            HD.setVisible(rs.getInt(9));
            arr.add(HD);}
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
    public boolean addHopDong(HopDong_DTO HD) throws Exception { 
        boolean result = false;
        if (openConnection()) {
            try { 
            CVDAO = new ChucVu_DAO();
            NVDAO = new NhanVienDAO();
            arrCV=CVDAO.docDSCV();
            arrNV=NVDAO.getAllNV();
            String sql = "Insert into hopdonglaodong values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql); 
            for(int i=0;i<arrNV.size();i++){
                for(int j=0;j<arrCV.size();j++){ 
                if(arrCV.get(j).getTenchucvu().equals(HD.getChucvu())){
                    HD.setID_chucvu(arrCV.get(j).getID_chucvu());
                }
                if(arrNV.get(i).getName().equals(HD.getTennhanvien())&&
                   arrNV.get(i).getId_chucvu() == arrCV.get(j).getID_chucvu()){
                    HD.setID_nhanvien(arrNV.get(i).getId());
                }
            }}
            stmt.setString(1,HD.getID_nhanvien());
            stmt.setString(4,HD.getLoaihopdong());
            stmt.setString(2, HD.getNgayBD());
            stmt.setString(3, HD.getNgayKT());
            stmt.setInt(5,HD.getID_chucvu());
            stmt.setBoolean(6,true);
            if (stmt.executeUpdate()>=1)
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            } finally{
            closeConnection(); } }
            return result;
        }
    public boolean delHopDong(int id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql="UPDATE hopdonglaodong SET visible=0 WHERE ID_hopdong="+id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                result = true;
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
    public boolean updateHopDong(HopDong_DTO HD) throws Exception{
        boolean result=false;
         if(openConnection()){
            try{
                CVDAO = new ChucVu_DAO();
                NVDAO = new NhanVienDAO();
                arrNV=NVDAO.getAllNV();
                arrCV=CVDAO.docDSCV();
                String sql;
                for(int i=0;i<arrNV.size();i++){
                for(int j=0;j<arrCV.size();j++){ 
                if(arrCV.get(j).getTenchucvu().equals(HD.getChucvu())){
                    HD.setID_chucvu(arrCV.get(j).getID_chucvu());
                }
                if(arrNV.get(i).getName().equals(HD.getTennhanvien())&&
                   arrNV.get(i).getId_chucvu() == arrCV.get(j).getID_chucvu()){
                    HD.setID_nhanvien(arrNV.get(i).getId());
                }
            }
                sql = "update [hopdonglaodong] set"
                        + "[ID_nhanvien] = '"+HD.getID_nhanvien()+"',"
                        + "[ngaybatdau] = '"+HD.getNgayBD()+"',"
                        + "[ngayhethan] = '"+HD.getNgayKT()+"',"
                        + "[loaihopdong] = N'"+HD.getLoaihopdong()+"',"
                        + "[ID_chucvu] = "+HD.getID_chucvu()+" "
                        + "where [ID_hopdong] = "+HD.getID_hopdong();
                PreparedStatement stmt = con.prepareStatement(sql);
//                stmt.setString(1,HD.getID_nhanvien());
//                stmt.setString(2, HD.getNgayBD());
//                stmt.setString(3,  HD.getNgayKT());
//                stmt.setString(4, HD.getLoaihopdong());
//                stmt.setInt(5,HD.getID_chucvu());
                stmt.executeUpdate();
                result = true;}
            }catch (SQLException ex) {
            System.out.println(ex); 
            }finally{
            closeConnection(); } }
            return result;
    }
        public boolean hasHopDongID(int id){ 
        boolean result = false; 
        if (openConnection()) {
        try { 
        String sql = "Select * from hopdonglaodong where ID_hopdong="+id;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        result = rs.next(); 
        } catch (SQLException ex) {
        System.out.println(ex); 
        } finally { closeConnection(); } }
        return result;
    }  
    public ArrayList<HopDong_DTO> CheckHopDong(String st,int i,int stt){ 
        ArrayList<HopDong_DTO> arr = new ArrayList(); 
        String sql="";
        if (openConnection()) {
        try { 
        if(stt==0){
            sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien "
                + "and hopdonglaodong.ID_nhanvien like '%"+st+"%'";
        }
        if(stt==1){
            sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien "
                + "and nhanvien.hoten like N'%"+st+"%'";
        }
        if(stt==2){
            sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien "
                + "and ID_hopdong="+i;
        }
        if(stt==3){
            sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien "
                + "and loaihopdong like N'%"+st+"%'";
        }
        if(stt==4){
            sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien "
                + "and loaihopdong like N'%"+st+"%'";
        }
        if(stt==5){
            sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,hopdonglaodong.visible "
                + "from hopdonglaodong ,nhanvien "
                + "where (hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien) "
                + "and (loaihopdong like N'%"+st+"%' or hopdonglaodong.ID_nhanvien like '%"+st+"%' or nhanvien.hoten like N'%"+st+"%')";
        }
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            HopDong_DTO HD = new HopDong_DTO();
            HD.setID_hopdong(rs.getInt(1));
            HD.setID_nhanvien(rs.getString(2));
            HD.setTennhanvien(rs.getString(3));
            HD.setLoaihopdong(rs.getString(4));
            HD.setNgayBD(rs.getString(5));
            HD.setNgayKT(rs.getString(6));
            HD.setID_chucvu(rs.getInt(7));
            HD.setVisible(rs.getInt(8));
            arr.add(HD);}
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return arr;
        }
        public HopDong_DTO get1ViPham(int i){
        HopDong_DTO HD = new HopDong_DTO();
        if (openConnection()) {
        try { 
        String sql = "Select ID_hopdong,hopdonglaodong.ID_nhanvien,nhanvien.hoten,loaihopdong,ngaybatdau,ngayhethan,hopdonglaodong.ID_chucvu,tenchucvu "
                + "from hopdonglaodong ,nhanvien,chucvu "
                + "where hopdonglaodong.visible=1 and nhanvien.visible=1 and hopdonglaodong.ID_nhanvien=nhanvien.ID_nhanvien and hopdonglaodong.ID_chucvu=chucvu.ID_chucvu and id_hopdong="+i;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            HD.setID_hopdong(rs.getInt(1));
            HD.setID_nhanvien(rs.getString(2));
            HD.setTennhanvien(rs.getString(3));
            HD.setLoaihopdong(rs.getString(4));
            HD.setNgayBD(rs.getString(5));
            HD.setNgayKT(rs.getString(6));
            HD.setID_chucvu(rs.getInt(7));
            HD.setChucvu(rs.getString(8));
            }
        }catch (SQLException ex) {
        System.out.println(ex);
        } finally { 
        closeConnection();
        } }
        return HD;
    }
}
