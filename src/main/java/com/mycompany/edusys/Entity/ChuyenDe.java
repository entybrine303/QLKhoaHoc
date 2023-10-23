/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edusys.Entity;

/**
 *
 * @author ADMIN
 */
public class ChuyenDe {
     private String maCD, tenCD, hinh, mota;
    private int thoiLuong;
    private double hocPhi;

    public ChuyenDe() {
    }

    public ChuyenDe(String maCD, String tenCD, String hinh, String mota, int thoiLuong, double hocPhi) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hinh = hinh;
        this.mota = mota;
        this.thoiLuong = thoiLuong;
        this.hocPhi = hocPhi;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        if(thoiLuong >0 || thoiLuong <1000){
        this.thoiLuong = thoiLuong;
        }
        else{
            throw new ArithmeticException("Thời Lượng sai");
        }
        
        
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }
    
    @Override
    public String toString(){
        return this.tenCD;
    }
    
    @Override
    public boolean equals(Object obj){
        ChuyenDe other = (ChuyenDe) obj;
        return other.getMaCD().equals(this.getMaCD());
    }
}
