/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author hiro1
 */
public class NghiPhepDTO {
    public int id_nghiphep;
    public String id_nhanvien;
    public String tennhanvien;
    public String lydo;
    public String ngaybatdau, ngayketthuc;
    public int songay;
    public Boolean visible;

    public NghiPhepDTO(int id_nghiphep, String id_nhanvien, String tennhanvien, String lydo,String ngaybatdau,String ngayketthuc, int songay, Boolean visible) {
        this.id_nghiphep = id_nghiphep;
        this.id_nhanvien = id_nhanvien;
        this.tennhanvien = tennhanvien;
        this.lydo = lydo;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.songay = songay;
        this.visible = visible;
    }

    public NghiPhepDTO(){
        
    }

    public int getId_nghiphep() {
        return id_nghiphep;
    }

    public String getId_nhanvien() {
        return id_nhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public String getLydo() {
        return lydo;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public int getSongay() {
        return songay;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setId_nghiphep(int id_nghiphep) {
        this.id_nghiphep = id_nghiphep;
    }

    public void setId_nhanvien(String id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

 
}