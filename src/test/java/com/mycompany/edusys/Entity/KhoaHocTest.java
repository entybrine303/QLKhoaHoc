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
public class KhoaHocTest {
    
    public KhoaHocTest() {
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
    public void testGetMaCDisnull() throws Exception{
        
        KhoaHoc instance = new KhoaHoc();
        String expResult = "";
        String result = instance.getMaCD();
        assertEquals(expResult, result,null);
        
    }
    @Test
    public void testGetMaCDVali() {
        
         
        String maCD = "No1";
        ChuyenDe instance = new ChuyenDe();
        instance.setMaCD(maCD);
        String expected = "No1";
        assertEquals(expected, instance.getMaCD());
        
    }


    @Test
    public void testGetGhiChu() throws Exception{
        
        KhoaHoc instance = new KhoaHoc();
        String expResult = "";
        String result = instance.getGhiChu();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetGhiChu() {
        System.out.println("setGhiChu");
        String ghiChu = "hoc";
        KhoaHoc instance = new KhoaHoc();
        instance.setGhiChu(ghiChu);
        String expected = instance.getGhiChu();
        assertEquals(expected, ghiChu);
        
    }

    @Test
    public void testGetMaNV() {
        
        KhoaHoc instance = new KhoaHoc();
        String expResult = "";
        String result = instance.getMaNV();
        assertEquals(expResult, result,null);
       
    }

    @Test
    public void testSetMaNV() {
        System.out.println("setMaNV");
        String maNV = "PD1";
        KhoaHoc instance = new KhoaHoc();
        instance.setMaNV(maNV);
        String Expected = instance.getMaNV();
        assertEquals(Expected, maNV);
    }

    @Test
    public void testGetMaKH() {
        
        KhoaHoc instance = new KhoaHoc();
        int expResult = 0;
        int result = instance.getMaKH();
        assertEquals(expResult, result,0);
        
    }

    @Test
    public void testSetMaKH() throws Exception {
        System.out.println("setMaKH");
        int maKH = 0;
        
        KhoaHoc instance = new KhoaHoc();
        
        instance.setMaKH(maKH);
        
    }
     @Test
    public void testSetMaKHNegative() throws Exception {
        System.out.println("setMaKH");
        int maKH = -1;
        KhoaHoc instance = new KhoaHoc();
        instance.setMaKH(maKH);
        
    }
     @Test
    public void testSetMaKHPosttive() {
        System.out.println("setMaKH");
        int maKH = 1;
        KhoaHoc instance = new KhoaHoc();
        instance.setMaKH(maKH);
        int expedted = instance.getMaKH();
         assertEquals(expedted, maKH);
        
    }

    @Test
    public void testGetThoiLuong() {
        System.out.println("getThoiLuong");
        KhoaHoc instance = new KhoaHoc();
        int expResult = 0;
        int result = instance.getThoiLuong();
        assertEquals(expResult, result,0);
       
    }

    @Test
    public void testSetThoiLuong() {
        System.out.println("setThoiLuong");
        int thoiLuong = 10;
        KhoaHoc instance = new KhoaHoc();
        instance.setThoiLuong(thoiLuong);
        int expected = instance.getThoiLuong();
        assertEquals(expected, thoiLuong);
    }

    @Test
    public void testGetHocPhi() {
        
        KhoaHoc instance = new KhoaHoc();
        double expResult = 0.0;
        double result = instance.getHocPhi();
        assertEquals(expResult, result, 0.0);
        
    }

    @Test()
    public void testSetHocPhiNegative() throws Exception{
        System.out.println("setHocPhi");
        double hocPhi = -200.0;
        KhoaHoc instance = new KhoaHoc();
        instance.setHocPhi(hocPhi);
        
    }
    @Test()
    public void testSetHocPhiWihtzero() {
        System.out.println("setHocPhi");
        double hocPhi = 0.0;
        KhoaHoc instance = new KhoaHoc();
        instance.setHocPhi(hocPhi);
        double actual =instance.getHocPhi();
         assertEquals(actual, hocPhi,0.0);
    }
    @Test()
    public void testSetHocPhiPosttive() {
        
        double hocPhi = 200.0;
        KhoaHoc instance = new KhoaHoc();
        instance.setHocPhi(hocPhi);
        double actual =instance.getHocPhi();
         assertEquals(actual, hocPhi,200.0);
        
    }
    @Test
    public void testGetNgayKG() throws Exception {
        
        KhoaHoc instance = new KhoaHoc();
        Date expResult = null;
        Date result = instance.getNgayKG();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetNgayKG() throws ParseException {
        String NDK = "26-06-2002";
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        
       
        Date ngayKG =format.parse(NDK);
        KhoaHoc instance = new KhoaHoc();
        instance.setNgayKG(ngayKG);
        Date expected = instance.getNgayKG();
        assertEquals(expected, ngayKG);
    }

    @Test
    public void testGetNgayTao() throws Exception{
        
        KhoaHoc instance = new KhoaHoc();
        Date expResult = null;
        Date result = instance.getNgayTao();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSetNgayTao() throws ParseException {
        System.out.println("setNgayTao");
        String NT = "09-03-2002";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayTao = dateFormat.parse(NT);
        KhoaHoc instance = new KhoaHoc();
        instance.setNgayTao(ngayTao);
        Date expected = instance.getNgayTao();
        assertEquals(expected, ngayTao);
        
    }

    
    
}
