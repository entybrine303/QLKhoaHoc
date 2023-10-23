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
public class HocVienTest {
    
    public HocVienTest() {
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

    /**
     * Test of getMaNH method, of class HocVien.
     */
    @Test
    public void testGetMaNH() {
        
        HocVien instance = new HocVien();
        String expResult = "";
        String result = instance.getMaNH();
        assertEquals(expResult, result,null);
       
    }

    /**
     * Test of setMaNH method, of class HocVien.
     */
    @Test
    public void testSetMaNH() {
        
        String maNH = "PE1";
        HocVien instance = new HocVien();
        instance.setMaNH(maNH);
        String expected = instance.getMaNH();
        assertEquals(expected, maNH);
       
    }

    /**
     * Test of getMaHV method, of class HocVien.
     */
    @Test
    public void testGetMaHV() {
        System.out.println("getMaHV");
        HocVien instance = new HocVien();
        int expResult = 0;
        int result = instance.getMaHV();
        assertEquals(expResult, result,0);
        
        
    }

    /**
     * Test of setMaHV method, of class HocVien.
     */
    @Test
    public void testSetMaHV() {
        System.out.println("setMaHV");
        int maHV = 12;
        HocVien instance = new HocVien();
        instance.setMaHV(maHV);
        int expected = instance.getMaHV();
        assertEquals(expected, maHV);
        
    }

    /**
     * Test of getMaKH method, of class HocVien.
     */
    @Test
    public void testGetMaKH() {
        System.out.println("getMaKH");
        HocVien instance = new HocVien();
        int expResult = 0;
        int result = instance.getMaKH();
        assertEquals(expResult, result,0);
        
    }

    /**
     * Test of setMaKH method, of class HocVien.
     */
    @Test
    public void testSetMaKH() {
        System.out.println("setMaKH");
        int maKH = 12;
        HocVien instance = new HocVien();
        instance.setMaKH(maKH);
        int expected = instance.getMaKH();
        assertEquals(expected, maKH);
        
    }

    /**
     * Test of getDiem method, of class HocVien.
     */
    @Test
    public void testGetDiem() {
        HocVien instance = new HocVien();
        double expResult = 0.0;
        double result = instance.getDiem();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setDiem method, of class HocVien.
     */
    @Test
    public void testSetDiemNegative() throws Exception {
        
        double diem = -1;
        HocVien instance = new HocVien();
        instance.setDiem(diem);
        
    }
    public void testSetDiemMaxima() throws Exception {
        
        double diem = 11;
        HocVien instance = new HocVien();
        instance.setDiem(diem);
        
    }
    public void testSetDiem() throws Exception {
        
        double diem= 9  ;
        
        HocVien instance = new HocVien();
        instance.setDiem(diem);
        double expected = instance.getDiem();
        assertEquals(expected, diem);
        
        
        }
    }
    
    

