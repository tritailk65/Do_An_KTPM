package DTO;

import java.sql.Date;

public class DuAnDTO {
    public int idduan;
    public String tenduan;
    public String mota;
    public long chiphi;
    public Date ngaybatdau;
    public Date ngayketthuc;
    public int visible;

    public DuAnDTO(){}
    
    public DuAnDTO(int idduan, String tenduan, String mota, long chiphi, Date ngaybatdau, Date ngayketthuc, int visible) {
        this.idduan = idduan;
        this.tenduan = tenduan;
        this.mota = mota;
        this.chiphi = chiphi;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.visible = visible;
    }

    public int getIdduan() {
        return idduan;
    }

    public String getTenduan() {
        return tenduan;
    }

    public String getMota() {
        return mota;
    }

    public long getChiphi() {
        return chiphi;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setIdduan(int idduan) {
        this.idduan = idduan;
    }

    public void setTenduan(String tenduan) {
        this.tenduan = tenduan;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setChiphi(long chiphi) {
        this.chiphi = chiphi;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
