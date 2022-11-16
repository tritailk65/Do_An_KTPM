
package DTO;

public class ChucVu_DTO {
    public int ID_chucvu;
    public String tenchucvu;
    public String mota;
    public int nghiphep;
    public int visible;

    public ChucVu_DTO() {}
    
    public ChucVu_DTO(int ID_chucvu, String tenchucvu, String mota, int nghiphep, int visible) {
        this.ID_chucvu = ID_chucvu;
        this.tenchucvu = tenchucvu;
        this.mota = mota;
        this.nghiphep = nghiphep;
        this.visible = visible;
    }


    public int getVisible() {
        return visible;
    }

    public int getID_chucvu() {
        return ID_chucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public String getMota() {
        return mota;
    }

    public int getNghiphep() {
        return nghiphep;
    }

    public void setID_chucvu(int ID_chucvu) {
        this.ID_chucvu = ID_chucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setNghiphep(int nghiphep) {
        this.nghiphep = nghiphep;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
    
}
