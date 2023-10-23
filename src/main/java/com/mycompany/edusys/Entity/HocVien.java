/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.Entity;

/**
 *
 * @author ADMIN
 */
public class HocVien {
    private String maNH;
    private int maHV, maKH;
    private double diem;

    public HocVien() {
    }

    public HocVien(String maNH, int maHV, int maKH, double diem) {
        this.maNH = maNH;
        this.maHV = maHV;
        this.maKH = maKH;
        this.diem = diem;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
