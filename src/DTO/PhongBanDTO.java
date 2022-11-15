
package DTO;

public class PhongBanDTO {
    public String ID_phongban;
    public String tenphongban;
    public String ID_truongphong;
    public String sdt_phongban;
    public int visible;

    public PhongBanDTO(String ID_phongban, String tenphongban, String ID_truongphong, String sdt_phongban, int visible) {
        this.ID_phongban = ID_phongban;
        this.tenphongban = tenphongban;
        this.ID_truongphong = ID_truongphong;
        this.sdt_phongban = sdt_phongban;
        this.visible = visible;
    }


    public PhongBanDTO() {
    }

    public int getVisible() {
        return visible;
    }

    public String getID_phongban() {
        return ID_phongban;
    }

    public String getTenphongban() {
        return tenphongban;
    }

    public String getID_truongphong() {
        return ID_truongphong;
    }

    public String getSdt_phongban() {
        return sdt_phongban;
    }

    public void setID_phongban(String ID_phongban) {
        this.ID_phongban = ID_phongban;
    }

    public void setTenphongban(String tenphongban) {
        this.tenphongban = tenphongban;
    }

    public void setID_truongphong(String ID_truongphong) {
        this.ID_truongphong = ID_truongphong;
    }

    public void setSdt_phongban(String sdt_phongban) {
        this.sdt_phongban = sdt_phongban;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
    
}
