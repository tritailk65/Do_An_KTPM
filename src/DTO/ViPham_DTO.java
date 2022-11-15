
package DTO;



public class ViPham_DTO {
    private int ID_vipham;
    private String ID_nhanvien;
    private String tennhanvien;
    private String lydo;
    private String ngay;
    private int tienphat;
    private int visible;

    public ViPham_DTO(int ID_vipham, String ID_nhanvien, String tennhanvien, String lydo,String ngay, int tienphat, int visible) {
        this.ID_vipham = ID_vipham;
        this.ID_nhanvien = ID_nhanvien;
        this.tennhanvien = tennhanvien;
        this.lydo = lydo;
        this.ngay = ngay;
        this.tienphat = tienphat;
        this.visible = visible;
    }

    public ViPham_DTO() {
    }



    public String getTennhanvien() {
        return tennhanvien;
    }

    
    public int getID_vipham() {
        return ID_vipham;
    }

    public String getID_nhanvien() {
        return ID_nhanvien;
    }

    public String getLydo() {
        return lydo;
    }

    public String getNgay() {
        return ngay;
    }

    public int getTienphat() {
        return tienphat;
    }

    public int getVisible() {
        return visible;
    }

    public void setID_vipham(int ID_vipham) {
        this.ID_vipham = ID_vipham;
    }

    public void setID_nhanvien(String ID_nhanvien) {
        this.ID_nhanvien = ID_nhanvien;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setTienphat(int tienphat) {
        this.tienphat = tienphat;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }  
}
