package DTO;


public class ThanNhan_DTO {
    int ID_nguoithan;
    String ID_nhanvien;
    String tennhanvien;
    String hoten;
    String moiquanhe;
    String ngaysinh;
    String sdt;
    int visible;

    public ThanNhan_DTO(int ID_nguoithan, String ID_nhanvien, String tennhanvien, String hoten, String moiquanhe, String ngaysinh, String sdt, int visible) {
        this.ID_nguoithan = ID_nguoithan;
        this.ID_nhanvien = ID_nhanvien;
        this.tennhanvien = tennhanvien;
        this.hoten = hoten;
        this.moiquanhe = moiquanhe;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.visible = visible;
    }

    public ThanNhan_DTO() {
    }

    public int getID_nguoithan() {
        return ID_nguoithan;
    }

    public String getID_nhanvien() {
        return ID_nhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public String getMoiquanhe() {
        return moiquanhe;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public int getVisible() {
        return visible;
    }

    public void setID_nguoithan(int ID_nguoithan) {
        this.ID_nguoithan = ID_nguoithan;
    }

    public void setID_nhanvien(String ID_nhanvien) {
        this.ID_nhanvien = ID_nhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setMoiquanhe(String moiquanhe) {
        this.moiquanhe = moiquanhe;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
    
}
