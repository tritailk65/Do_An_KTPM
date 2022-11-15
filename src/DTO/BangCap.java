/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hiro1
 */
public class BangCap {
    private int id_bangcap;
    private String bangcap;
    private int thuongcap;

    public BangCap(int id_bangcap, String bangcap, int thuongcap) {
        this.id_bangcap = id_bangcap;
        this.bangcap = bangcap;
        this.thuongcap = thuongcap;
    }

    public int getId_bangcap() {
        return id_bangcap;
    }

    public void setId_bangcap(int id_bangcap) {
        this.id_bangcap = id_bangcap;
    }

    public String getBangcap() {
        return bangcap;
    }

    public void setBangcap(String bangcap) {
        this.bangcap = bangcap;
    }

    public int getThuongcap() {
        return thuongcap;
    }

    public void setThuongcap(int thuongcap) {
        this.thuongcap = thuongcap;
    }
    
}
