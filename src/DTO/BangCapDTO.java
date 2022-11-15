package DTO;

public class BangCapDTO {
    public int id;
    public String bangcap;
    public int thuongbangcap;
    public int visible;
    
    public BangCapDTO() {}

    public BangCapDTO(int id, String bangcap, int thuongbangcap, int visible) {
        this.id = id;
        this.bangcap = bangcap;
        this.thuongbangcap = thuongbangcap;
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBangcap() {
        return bangcap;
    }

    public void setBangcap(String bangcap) {
        this.bangcap = bangcap;
    }

    public int getThuongbangcap() {
        return thuongbangcap;
    }

    public void setThuongbangcap(int thuongbangcap) {
        this.thuongbangcap = thuongbangcap;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
    
    
}
