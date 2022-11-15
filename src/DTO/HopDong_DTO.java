
package DTO;

import java.util.Date;

public class HopDong_DTO {
    private int ID_hopdong;
    private String ID_nhanvien;
    private String Tennhanvien;
    private String Loaihopdong;
    private String NgayBD;
    private String NgayKT;
    private String Chucvu;
    private int ID_chucvu;
    
    String tinhtrang;
    int visible;
    public HopDong_DTO() {
    }


    public HopDong_DTO(int ID_hopdong, String ID_nhanvien, String Tennhanvien, String Loaihopdong, String NgayBD, String NgayKT, String Chucvu, int ID_chucvu, String tinhtrang, int visible) {
        this.ID_hopdong = ID_hopdong;
        this.ID_nhanvien = ID_nhanvien;
        this.Tennhanvien = Tennhanvien;
        this.Loaihopdong = Loaihopdong;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.Chucvu = Chucvu;
        this.ID_chucvu = ID_chucvu;
        this.tinhtrang = tinhtrang;
        this.visible = visible;
    }

    public String getChucvu() {
        return Chucvu;
    }



    public String getTinhtrang() {
        return tinhtrang;
    }


    public int getVisible() {
        return visible;
    }
    
    public int getID_hopdong() {
        return ID_hopdong;
    }

    public String getTennhanvien() {
        return Tennhanvien;
    }

    public String getLoaihopdong() {
        return Loaihopdong;
    }

    public String getID_nhanvien() {
        return ID_nhanvien;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public int getID_chucvu() {
        return ID_chucvu;
    }



    public void setID_nhanvien(String ID_nhanvien) {
        this.ID_nhanvien = ID_nhanvien;
    }

    public void setID_hopdong(int ID_hopdong) {
        this.ID_hopdong = ID_hopdong;
    }

    public void setTennhanvien(String Tennhanvien) {
        this.Tennhanvien = Tennhanvien;
    }

    public void setLoaihopdong(String Loaihopdong) {
        this.Loaihopdong = Loaihopdong;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public void setID_chucvu(int ID_chucvu) {
        this.ID_chucvu = ID_chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }


    public void setVisible(int visible) {
        this.visible = visible;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

}
