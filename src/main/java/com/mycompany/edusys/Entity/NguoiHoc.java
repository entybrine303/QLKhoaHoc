/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.Entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NguoiHoc {
    private String maNH, hoTen, email, dienThoai, ghiChu, maNV;
    private boolean  gioiTinh;
    private Date ngaySinh, ngayDK;

    public NguoiHoc() {
    }

    public NguoiHoc(String maNH, String hoTen, String email, String dienThoai, String ghiChu, String maNV, boolean gioiTinh, Date ngaySinh, Date ngayDK) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.email = email;
        this.dienThoai = dienThoai;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayDK = ngayDK;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }
}
