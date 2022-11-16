package DTO;

import java.sql.Date;

public class ThamgiaDuanDTO {
    public int idduan;
    public String idnv;
    public int vitri;
    public Date ngaythamgia;
    public Date ngayhoanthanh;
    public int thuongduan;
    
    public ThamgiaDuanDTO() {}

    public ThamgiaDuanDTO(int idduan, String idnv, int vitri, Date ngaythamgia, Date ngayhoanthanh, int thuongduan) {
        this.idduan = idduan;
        this.idnv = idnv;
        this.vitri = vitri;
        this.ngaythamgia = ngaythamgia;
        this.ngayhoanthanh = ngayhoanthanh;
        this.thuongduan = thuongduan;
    }

    public int getIdduan() {
        return idduan;
    }

    public void setIdduan(int idduan) {
        this.idduan = idduan;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }

    public Date getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(Date ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }

    public Date getNgayhoanthanh() {
        return ngayhoanthanh;
    }

    public void setNgayhoanthanh(Date ngayhoanthanh) {
        this.ngayhoanthanh = ngayhoanthanh;
    }

    public int getThuongduan() {
        return thuongduan;
    }

    public void setThuongduan(int thuongduan) {
        this.thuongduan = thuongduan;
    }
}
