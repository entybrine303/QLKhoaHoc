/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.Entity;

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
public class NhanVienTest {
    
    public NhanVienTest() {
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
    public void testGetMaNV() {
        System.out.println("getMaNV");
        NhanVien instance = new NhanVien();
        String expResult = "";
        String result = instance.getMaNV();
        assertEquals(expResult, result,null);
       
    }

    @Test
    public void testSetMaNV() {
        System.out.println("setMaNV");
        String maNV = "NV1";
        NhanVien instance = new NhanVien();
        instance.setMaNV(maNV);
        String expected = instance.getMaNV();
        assertEquals(expected, maNV);
        
    }

    @Test
    public void testGetHoTen() {
        System.out.println("getHoTen");
        NhanVien instance = new NhanVien();
        String expResult = "";
        String result = instance.getHoTen();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetHoTen() {
        System.out.println("setHoTen");
        String hoTen = "Phan Tien Thanh";
        NhanVien instance = new NhanVien();
        instance.setHoTen(hoTen);
        String expected = instance.getHoTen();
        assertEquals(expected, hoTen);
    }

    @Test
    public void testGetMatKhau() {
        System.out.println("getMatKhau");
        NhanVien instance = new NhanVien();
        String expResult = "";
        String result = instance.getMatKhau();
        assertEquals(expResult, result,null);
        
    }

    @Test
    public void testSetMatKhau() {
        System.out.println("setMatKhau");
        String matKhau = "2606";
        NhanVien instance = new NhanVien();
        instance.setMatKhau(matKhau);
        String expected = instance.getMatKhau();
    }

    @Test
    public void testGetVaiTro() {
        System.out.println("getVaiTro");
        NhanVien instance = new NhanVien();
        boolean expResult = false;
        boolean result = instance.getVaiTro();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetVaiTro() {
        System.out.println("setVaiTro");
        boolean vaiTro = false;
        NhanVien instance = new NhanVien();
        instance.setVaiTro(vaiTro);
        boolean expected = instance.getVaiTro();
        assertEquals(expected, vaiTro);
    }
    
}
