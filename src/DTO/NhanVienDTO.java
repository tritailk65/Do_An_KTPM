package DTO;


/**
 *
 * @author hiro1
 */
public class NhanVienDTO {
    public String id;
    public String name;
    public int id_chucvu;
    public String id_phongban;
    public int id_bangcap;
    public String ngaysinh;
    public String sdt;
    public String email;
    public String cmnd;
    public int luong;
    public int phucap;
    public int songaynghi;
    public String diachi;
    public int gioitinh;
    public int tinhtrang;
    public String hinhanh;
    public int visible;

    public NhanVienDTO() {}
    
    public NhanVienDTO(String id, String name, int id_chucvu, String id_phongban, int id_bangcap, String ngaysinh, String sdt, String email, String cmnd, int luong, int phucap, int songaynghi, String diachi, int gioitinh, int tinhtrang, String hinhanh, int visible) {
        this.id = id;
        this.name = name;
        this.id_chucvu = id_chucvu;
        this.id_phongban = id_phongban;
        this.id_bangcap = id_bangcap;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.email = email;
        this.cmnd = cmnd;
        this.luong = luong;
        this.phucap = phucap;
        this.songaynghi = songaynghi;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.tinhtrang = tinhtrang;
        this.hinhanh = hinhanh;
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_chucvu() {
        return id_chucvu;
    }

    public void setId_chucvu(int id_chucvu) {
        this.id_chucvu = id_chucvu;
    }

    public String getId_phongban() {
        return id_phongban;
    }

    public void setId_phongban(String id_phongban) {
        this.id_phongban = id_phongban;
    }

    public int getId_bangcap() {
        return id_bangcap;
    }

    public void setId_bangcap(int id_bangcap) {
        this.id_bangcap = id_bangcap;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getPhucap() {
        return phucap;
    }

    public void setPhucap(int phucap) {
        this.phucap = phucap;
    }

    public int getSongaynghi() {
        return songaynghi;
    }

    public void setSongaynghi(int songaynghi) {
        this.songaynghi = songaynghi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    
}
