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
public class ChuyenDeTest {
    
    public ChuyenDeTest() {
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
     * Test of getMaCD method, of class ChuyenDe.
     */
    @Test
    public void testGetMaCD() {
        
        ChuyenDe instance = new ChuyenDe();
        String expResult = "";
        String result = instance.getMaCD();
        assertEquals(expResult, result,null);
        
    }

    /**
     * Test of setMaCD method, of class ChuyenDe.
     */
    @Test//not pass
    public void testSetMaCD() { 
        System.out.println("setMaCD");
        String maCD = "No1";
        ChuyenDe instance = new ChuyenDe();
        instance.setMaCD(maCD);
        String expected = "No1";
        assertEquals(expected, instance.getMaCD());
    }

    /**
     * Test of getTenCD method, of class ChuyenDe.
     */
    @Test // pass
    public void testGetTenCD() {
        
        ChuyenDe instance = new ChuyenDe();
        String expResult = "cd123";
        String result = instance.getTenCD();
        assertEquals(expResult, result,null);

    }

    /**
     * Test of setTenCD method, of class ChuyenDe.
     */
    @Test // pass
    public void testSetTenCD() {
        System.out.println("setTenCD");
        String tenCD = "Java 4";
        String expected = "Java 4";
        ChuyenDe instance = new ChuyenDe();
        instance.setTenCD(tenCD);
        String result = instance.getTenCD();
        assertEquals(expected, result);
        
    }

    /**
     * Test of getHinh method, of class ChuyenDe.
     */
    @Test
    public void testGetHinh() {
        System.out.println("getHinh");
        ChuyenDe instance = new ChuyenDe();
        String expResult = "";
        
        String result = instance.getHinh();
        assertEquals(expResult, result,null);

    }

    /**
     * Test of setHinh method, of class ChuyenDe.
     */
    @Test//pass
    public void testSetHinh() {
        System.out.println("setHinh");
        String hinh = "m.jsp";
        ChuyenDe instance = new ChuyenDe();
        instance.setHinh(hinh);
        String expected = "m.jsp";
        String resuil = instance.getHinh();
        assertEquals(expected, resuil);
        

    }

    /**
     * Test of getMota method, of class ChuyenDe.
     */
    @Test
    public void testGetMota() {
        System.out.println("getMota");
        ChuyenDe instance = new ChuyenDe();
        String expResult = "test";
        String result = instance.getMota();
        assertEquals(expResult, result,null);
        
    }

    /**
     * Test of setMota method, of class ChuyenDe.
     */
    @Test //pass
    public void testSetMota() {
        System.out.println("setMota");
        String mota = "";
        String expected = "";
        ChuyenDe instance = new ChuyenDe();
        instance.setMota(mota);
        String result = instance.getMota();
        assertEquals(expected, mota);
    }

    /**
     * Test of getThoiLuong method, of class ChuyenDe.
     */
    @Test
    public void testGetThoiLuong() {
       
        ChuyenDe instance = new ChuyenDe();
        int expResult = 0;
        int result = instance.getThoiLuong();
        assertEquals(expResult, result,0);

    }

    /**
     * Test of setThoiLuong method, of class ChuyenDe.
     */
    @Test
    public void testSetThoiLuong() {
        System.out.println("setThoiLuong");
        int thoiLuong = 10;
        ChuyenDe instance = new ChuyenDe();
        instance.setThoiLuong(thoiLuong);
        int expected = 10;
        int result = instance.getThoiLuong();
        assertEquals(expected, result);

    }
     @Test(expected = ArithmeticException.class)
    public void testSetThoiLuongWithNegative() throws Exception{

        int thoiLuong = -10;
        ChuyenDe instance = new ChuyenDe();
        instance.setThoiLuong(thoiLuong);
        int expected = instance.getThoiLuong();
         assertEquals(expected, thoiLuong);
        

    }

    /**
     * Test of getHocPhi method, of class ChuyenDe.
     */
    @Test
    public void testGetHocPhi() {
        
        ChuyenDe instance = new ChuyenDe();
        double expResult = 0.0;
        double result = instance.getHocPhi();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setHocPhi method, of class ChuyenDe.
     */
    @Test
    public void testSetHocPhi() {

        double hocPhi = 600;
        ChuyenDe instance = new ChuyenDe();
        instance.setHocPhi(hocPhi);
        double expected =600;
        double result = instance.getHocPhi();
        assertEquals(expected, result,0.0);
    }
        @Test
    public void testSetHocPhiWithNegative() throws Exception{

        double hocPhi =-600;
        ChuyenDe instance = new ChuyenDe();
        instance.setHocPhi(hocPhi);
        
        
//        Exception exception = assertThrows(Exception.class, ()->instance.setHocPhi(hocPhi));
        
    }
        public void testSetHocPhiWithLarge() throws 
                 Exception{
 
        double hocPhi = 600000000;
        ChuyenDe instance = new ChuyenDe();
        instance.setHocPhi(hocPhi);
        
        
//        Exception exception = assertThrows(Exception.class, ()->instance.setHocPhi(hocPhi));
        
    }

    /**
     * Test of toString method, of class ChuyenDe.
     */
 

    /**
     * Test of equals method, of class ChuyenDe.
     */
 
    
}
