package DAO;

import BUS.NhanVienBUS;
import java.util.ArrayList;
import DTO.NghiPhepDTO;
import DTO.NhanVienDTO;
import java.sql.*;

public class NghiPhepDAO {
    private Connection con;
    //public connectSQL connect = new connectSQL("localhost", "sa", "123456", "qlnhansu_1.2");
    NhanVienDAO NV;
    NhanVienBUS NVBUS;
    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=QLnhansu;trustServerCertificate=true";
            String username = "sa";
            String password = "14112002"; // 14112002
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<NghiPhepDTO> getAllNP() {
        ArrayList<NghiPhepDTO> arr = new ArrayList<NghiPhepDTO>();
        if (openConnection()) {
            try {
                String sql = "SELECT id_nghiphep,nghiphep.id_nhanvien,lydo,ngaybatdau,ngayketthuc,songay,nghiphep.visible,hoten "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 and nhanvien.visible=1 and nghiphep.id_nhanvien=nhanvien.id_nhanvien ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    NghiPhepDTO np = new NghiPhepDTO();
                    np.setId_nghiphep(rs.getInt("id_nghiphep"));
                    np.setId_nhanvien(rs.getString("id_nhanvien"));
                    np.setLydo(rs.getString("lydo"));
                    np.setTennhanvien(rs.getString("hoten"));
                    np.setNgaybatdau(rs.getString("ngaybatdau"));
                    np.setNgayketthuc(rs.getString("ngayketthuc"));
                    np.setSongay(rs.getInt("songay"));
                    np.setVisible(rs.getBoolean("visible"));
                    arr.add(np);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }

    public boolean addNP(NghiPhepDTO np) throws Exception {
        boolean result = false;
        //String tennv = "";
        NVBUS.docDSNV();
        if (openConnection()) {
            try {
                String sql = "INSERT INTO nghiphep VALUES(?,?,?,?,?,?)";
                String sql1 = "UPDATE nhanvien SET songaynghi = ? WHERE ID_nhanvien = '" + np.getId_nhanvien() + "'";                 
                PreparedStatement stmt = con.prepareStatement(sql);
                PreparedStatement stmt1 = con.prepareStatement(sql1);
                stmt.setString(1, np.getId_nhanvien());
                /* for (int i = 0; i < arrnv.size(); i++) {
                    if (arrnv.get(i).getName().equals(np.getID_NhanVien())) {
                        tennv = arrnv.get(i).getID_NhanVien();
                    }
                }
                if (!tennv.isEmpty()) {
                    stmt.setString(2, tennv);
                    stmt.executeQuery();
                } */
                int songayconlai = 0;
                for (NhanVienDTO nv : NhanVienBUS.dsnv) {
                    if(nv.getId().equals(np.getId_nhanvien())){
                        songayconlai=nv.getSongaynghi()-np.getSongay();
                    }
                }
                stmt1.setInt(1, songayconlai);
                stmt.setString(2, np.getLydo());
                stmt.setString(3,np.getNgaybatdau());
                stmt.setString(4,np.getNgayketthuc());
                stmt.setInt(5, np.getSongay());
                stmt.setBoolean(6,true);
                
                if (stmt.executeUpdate() >= 1 && stmt1.executeUpdate() >= 1) {
                    result = true;
                    //nv.updateNV_SoNgayNghi(np.getID_NhanVien(), np.getSoNgay());
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean hasNPID(int id_nghiphep) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "SELECT * FROM nghiphep WHERE ID_nghiphep =" + id_nghiphep;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean updateNP(NghiPhepDTO np) {
        boolean result = false;
        if (openConnection()) {
            try {
               String sql2= "SELECT id_nghiphep,nghiphep.id_nhanvien,lydo,ngaybatdau,ngayketthuc,songay,nghiphep.visible,hoten "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 and nhanvien.visible=1 and nghiphep.id_nhanvien=nhanvien.id_nhanvien WHERE ID_nghiphep = " + np.getId_nghiphep();
                String sql = "UPDATE nghiphep SET ID_nhanvien = ?, lydo = ?, ngaybatdau = ?, ngayketthuc = ?, songay = ? WHERE ID_nghiphep = " + np.getId_nghiphep();
                String sql1 = "UPDATE nhanvien SET songaynghi = ? WHERE ID_nhanvien = '" + np.getId_nhanvien() + "'";
                PreparedStatement stmt = con.prepareStatement(sql);
                PreparedStatement stmt1 = con.prepareStatement(sql1);
                stmt.setString(1, np.getId_nhanvien());
                ResultSet rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    NghiPhepDTO np1 = new NghiPhepDTO();
                    np1.setId_nghiphep(rs.getInt("id_nghiphep"));
                    np1.setId_nhanvien(rs.getString("id_nhanvien"));
                    np1.setLydo(rs.getString("lydo"));
                    np1.setTennhanvien(rs.getString("hoten"));
                    np1.setNgaybatdau(rs.getString("ngaybatdau"));
                    np1.setNgayketthuc(rs.getString("ngayketthuc"));
                    np1.setSongay(rs.getInt("songay"));
                    np1.setVisible(rs.getBoolean("visible"));
                }
                int songayconlai=0;
                /* for(int i=0;i<arrNV.size();i++){
                    if(arrNV.get(i).getName().equals(VP.getTennhanvien()))
                        VP.setID_nhanvien(arrNV.get(i).getId());
                } */
                stmt.setString(2, np.getLydo());
                stmt.setString(3, np.getNgaybatdau());
                //stmt.setDate(3, (Date)np.getNgayBatDau()); 
                stmt.setString(4,np.getNgayketthuc());
                //stmt.setDate(4, (Date)np.getNgayKetThuc());
                stmt.setInt(5, np.getSongay());
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean deleteNP(int id_nghiphep) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE nghiphep SET visible = 0 WHERE ID_nghiphep ="+ id_nghiphep;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                result = true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public NghiPhepDTO getNPByID(int id_nghiphep){ 
        NghiPhepDTO np = new NghiPhepDTO();
        if (openConnection()) {
            try { 
                String sql = "SELECT id_nghiphep,nghiphep.id_nhanvien,lydo,ngaybatdau,ngayketthuc,songay,nghiphep.visible,hoten "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 and nhanvien.visible=1 and nghiphep.id_nhanvien=nhanvien.id_nhanvien and id_nghiphep="+id_nghiphep;
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    np.setId_nghiphep(rs.getInt(1));
                    np.setLydo(rs.getString(3));
                    np.setId_nhanvien(rs.getString(2));
                    np.setTennhanvien(rs.getString(8));
                    np.setNgaybatdau(rs.getString(4));
                    np.setNgayketthuc(rs.getString(5));
                    np.setSongay(rs.getInt(6));
                     
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally { 
                closeConnection();
            }
        }
        return np;
    }

    public ArrayList<NghiPhepDTO> CheckNghiPhepByID(String st, int i, int stt){ 
        ArrayList<NghiPhepDTO> arr = new ArrayList<NghiPhepDTO>();
        String sql = "";
        if (openConnection()) {
            try { 
                if(stt == 0){
                    sql = "SELECT ID_nghiphep, nghiphep.ID_nhanvien, nhanvien.hoten, lydo, ngaybatdau, ngayketthuc, songay "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 AND nhanvien.visible = 1 AND nghiphep.ID_nhanvien = nhanvien.ID_nhanvien AND ID_nghiphep = " + i;
                }
                if(stt == 1){
                    sql = "SELECT ID_nghiphep, nghiphep.ID_nhanvien, nhanvien.hoten, lydo, ngaybatdau, ngayketthuc, songay "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 AND nhanvien.visible = 1 AND nghiphep.ID_nhanvien = nhanvien.ID_nhanvien AND nhanvien.hoten LIKE N'%" + st + "%'";
                }
                if(stt == 2){
                    sql = "SELECT ID_nghiphep, nghiphep.ID_nhanvien, nhanvien.hoten, lydo, ngaybatdau, ngayketthuc, songay "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 AND nhanvien.visible = 1 AND nghiphep.ID_nhanvien = nhanvien.ID_nhanvien AND ngaybatdau LIKE '%" + st + "%'";
                }
                if(stt == 3){
                    sql = "SELECT ID_nghiphep, nghiphep.ID_nhanvien, nhanvien.hoten, lydo, ngaybatdau, ngayketthuc, songay "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE nghiphep.visible = 1 AND nhanvien.visible = 1 AND nghiphep.ID_nhanvien = nhanvien.ID_nhanvien AND ngayketthuc LIKE '%" + st + "%'";
                }
                if(stt == 4){
                    sql = "SELECT ID_nghiphep, nghiphep.ID_nhanvien, nhanvien.hoten, lydo, ngaybatdau, ngayketthuc, songay "
                        + "FROM nghiphep, nhanvien "
                        + "WHERE (nghiphep.visible = 1 AND nhanvien.visible = 1 AND nghiphep.ID_nhanvien = nhanvien.ID_nhanvien) AND "
                        + "(ngaybatdau LIKE '%" + st + "%' or ngayketthuc LIKE '%" + st + "%' or ID_nghiphep = " + i + " or nhanvien.hoten LIKE N'%" + st + "%' or lydo LIKE N'%" + st + "%')";
                }
        if(!sql.isBlank()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NghiPhepDTO np = new NghiPhepDTO();
                np.setId_nghiphep(rs.getInt(1));
                np.setId_nhanvien(rs.getString(2));
                np.setTennhanvien(rs.getString(3));
                np.setLydo(rs.getString(4));
                np.setNgaybatdau(rs.getString(5));
                np.setNgayketthuc(rs.getString(6));
                np.setSongay(rs.getInt(7));
                arr.add(np);}
        }
        }catch (SQLException ex) {
            System.out.println(ex);
        } finally { 
            closeConnection();
        } }
        return arr;
    }

    /* public ArrayList<NghiPhepDTO> CheckNghiPhepByID(String st, int i, int stt) {
        ArrayList<NghiPhepDTO> arr = new ArrayList<NghiPhepDTO>();
        String sql = "";
        if (openConnection()) {
            try {
                if (stt == 0) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE nghiphep.visible = 1 AND id_nghiphep LIKE N'%" + st + "%'";
                }
                if (stt == 1) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND  lydo LIKE N'%" + st + "%'";
                }
                if (stt == 2) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND  ngayketthuc LIKE N'%" + st + "%'";
                }
                if (stt == 3) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND gioitinh=1";
                }
                if (stt == 4) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND  gioitinh=0";
                }
                if (stt == 5) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND ngaybatdau LIKE N'%" + st + "%'";
                }
                if (stt == 6) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND  songay LIKE N'%" + st + "%'";
                }
                if (stt == 7) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND tinhtrang=1 ";
                }
                if (stt == 8) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE visible=1 AND tinhtrang=0 ";
                }
                if (stt == 9) {
                    sql = "SELECT id_nghiphep, lydo, ngaybatdau, ngayketthuc, songay "
                            + "FROM nghiphep "
                            + "WHERE (visible=1 AND id_nghiphep) "
                            + "(ngaybatdau LIKE N '%" + st + "%' or id_nghiphep LIKE N'%" + st
                            + "%'  or nghiphep.lydo LIKE N'%" + st + "%' or nghiphep.songay LIKE N'%" + st
                            + "%' or nghiphep.ngayketthuc LIKE N'%" + st + "%')";
                }

                if (!sql.isBlank()) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        NhanVien nv = new NhanVien();
                        nv.setId(rs.getString(1));
                        nv.setName(rs.getString(2));
                        nv.setNgaysinh(rs.getString(4));
                        nv.setEmail(rs.getString(6));
                        nv.setSodienthoai(rs.getString(5));
                        nv.setGioitinh(rs.getBoolean(3));
                        nv.setTinhtrang(rs.getBoolean(7));
                        arr.add(nv);
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    } */
}

