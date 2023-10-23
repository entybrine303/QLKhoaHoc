/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class NguoiHocTest {
    
    public NguoiHocTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetMaNH(){
        
        NguoiHoc instance = new NguoiHoc();
        String expResult = "";
        String result = instance.getMaNH();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetMaNH() {
        System.out.println("setMaNH");
        String maNH = "PA1";
        NguoiHoc instance = new NguoiHoc();
        instance.setMaNH(maNH);
        String expected = instance.getMaNH();
        assertEquals(expected, "PA1");
    }

    @Test
    public void testGetHoTen() {
        System.out.println("getHoTen");
        NguoiHoc instance = new NguoiHoc();
        String expResult = "";
        String result = instance.getHoTen();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetHoTen() {
        System.out.println("setHoTen");
        String hoTen = "Phan Tien Thanh";
        NguoiHoc instance = new NguoiHoc();
        instance.setHoTen(hoTen);
        String expected = instance.getHoTen();
        assertEquals(expected, hoTen);
        
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        NguoiHoc instance = new NguoiHoc();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "T@.fpt.edu";
        NguoiHoc instance = new NguoiHoc();
        instance.setEmail(email);
        String expected = instance.getEmail();
        assertEquals(expected, email);
    }

    @Test
    public void testGetDienThoai() {
        System.out.println("getDienThoai");
        NguoiHoc instance = new NguoiHoc();
        String expResult = "";
        String result = instance.getDienThoai();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetDienThoai() {
        System.out.println("setDienThoai");
        String dienThoai = "";
        NguoiHoc instance = new NguoiHoc();
        instance.setDienThoai(dienThoai);
         String expected = instance.getDienThoai();
        assertEquals(expected, dienThoai);
        
    }

    @Test
    public void testGetGhiChu() {
        System.out.println("getGhiChu");
        NguoiHoc instance = new NguoiHoc();
        String expResult = "";
        String result = instance.getGhiChu();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetGhiChu() {
        System.out.println("setGhiChu");
        String ghiChu = "";
        NguoiHoc instance = new NguoiHoc();
        instance.setGhiChu(ghiChu);
         String expected = instance.getGhiChu();
        assertEquals(expected, ghiChu);;
    }

    @Test
    public void testGetMaNV() {
        System.out.println("getMaNV");
        NguoiHoc instance = new NguoiHoc();
        String expResult = "";
        String result = instance.getMaNV();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetMaNV() {
        System.out.println("setMaNV");
        String maNV = "";
        NguoiHoc instance = new NguoiHoc();
        instance.setMaNV(maNV);
         String expected = instance.getMaNV();
        assertEquals(expected, maNV);
    }

    @Test
    public void testIsGioiTinh() {
        System.out.println("isGioiTinh");
        NguoiHoc instance = new NguoiHoc();
        boolean expResult = false;
        boolean result = instance.isGioiTinh();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetGioiTinh() {
        System.out.println("setGioiTinh");
        boolean gioiTinh = false;
        NguoiHoc instance = new NguoiHoc();
        instance.setGioiTinh(gioiTinh);
         boolean expected = instance.isGioiTinh();
        assertEquals(expected, gioiTinh);
    }

    @Test
    public void testGetNgaySinh() {
        System.out.println("getNgaySinh");
        NguoiHoc instance = new NguoiHoc();
        Date expResult = null;
        Date result = instance.getNgaySinh();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetNgaySinh() throws ParseException {
        System.out.println("setNgaySinh");
        String ngays = "26-06-2002";
        String pattern = "dd-MM-yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        Date ngaysinh = dateFormat.parse(ngays);
        NguoiHoc instance = new NguoiHoc();
        instance.setNgayDK(ngaysinh);
        Date expected = instance.getNgayDK();
        assertEquals(expected, ngaysinh);
        
    }

    @Test
    public void testGetNgayDK() {
        System.out.println("getNgayDK");
        NguoiHoc instance = new NguoiHoc();
        Date expResult = null;
        Date result = instance.getNgayDK();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetNgayDK() throws ParseException {
        System.out.println("setNgayDK");
        String ngaydk = "22-12-2002";
        String pattern = "dd-MM-yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        Date ngayDK = dateFormat.parse(ngaydk);
        NguoiHoc instance = new NguoiHoc();
        instance.setNgayDK(ngayDK);
        Date expected = instance.getNgayDK();
        assertEquals(expected, ngayDK);
    }
    
}
