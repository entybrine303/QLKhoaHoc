/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.ChuyenDe;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author ACER
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({JdbcHelper.class,ChuyenDeDAO.class})
public class ChuyenDeDAOTest {
    ChuyenDeDAO chuyenDeDAO;
    ChuyenDeDAO chuyenDeDAOSpy;
    
    public ChuyenDeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        chuyenDeDAO = new ChuyenDeDAO();
        PowerMockito.mockStatic(JdbcHelper.class);
        chuyenDeDAOSpy = PowerMockito.spy(new ChuyenDeDAO());
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)
    public void testInsertWithNull() {
        ChuyenDe e = null;
        chuyenDeDAO.insert(e);
    }
     @Test(expected = Exception.class)
    public void testInsertWithEmptyModel() {
        ChuyenDe e = new ChuyenDe();
        chuyenDeDAO.insert(e);
    }
     @Test()
    public void testInsertWithValiModel() {
        
        ChuyenDe e = new ChuyenDe();
        e.setHocPhi(123);
        e.setMaCD("CD01");
        e.setMota("mota");
        e.setTenCD("Java");
        e.setThoiLuong(13);
        chuyenDeDAO.insert(e);
       
    }

    @Test(expected = Exception.class)
    public void testUpdateWithNullModel() {
        
        ChuyenDe e = null;
        
        chuyenDeDAO.update(e);
       
    }
    @Test(expected = Exception.class)
    public void testUpdateWithEmptyModel() {
        
        ChuyenDe e = new ChuyenDe();
        
        chuyenDeDAO.update(e);
       
    }
    @Test()
    public void testUpdateWithValiModle() {
        
        
        ChuyenDe e = new ChuyenDe();
        e.setHocPhi(123);
        e.setMaCD("CD01");
        e.setMota("mota");
        e.setTenCD("Java");
        e.setThoiLuong(13);
        
        
        chuyenDeDAO.update(e);
       
    }
    

    @Test(expected = Exception.class)
    public void testDeleteWithEmptyID() {
        
        String id = "";
        
        chuyenDeDAO.delete(id);
        
    }
    @Test(expected = Exception.class)
    public void testDeleteWithNullID() {
        
        String id = null;
        
        chuyenDeDAO.delete(id);
        
    }
    @Test()
    public void testDeleteWithValiID() {
        
        String id = "2";
        
        chuyenDeDAO.delete(id);
        
    }

    @Test
    public void testSelectAll() throws Exception{
        ChuyenDe chuyenDe = new ChuyenDe();
        
        List<ChuyenDe> expResult = new ArrayList<>();
        expResult.add(chuyenDe);
        PowerMockito.doReturn(expResult)
                .when(chuyenDeDAOSpy,"selectBySql",ArgumentMatchers.anyString());
        List<ChuyenDe> result = chuyenDeDAOSpy.selectAll();
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test
    public void testSelectByIdWithNotFound() throws Exception {
        
        System.out.println("selectById");
        String id = "";
        
        ChuyenDe expResult = null;        
        List<ChuyenDe> resuiltList = new ArrayList<>();
        
        PowerMockito.doReturn(resuiltList)
                .when(chuyenDeDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        
        ChuyenDe result = chuyenDeDAOSpy.selectById(id);
        
        assertThat(result, CoreMatchers.is(expResult));
 
    }
    @Test
    public void testSelectByIdWithFound() throws Exception {
        
        System.out.println("selectById");
        String id = "122";
        
        
        ChuyenDe expResult = new ChuyenDe();        
        List<ChuyenDe> resuiltList = new ArrayList<>();
        resuiltList.add(expResult);
        
        PowerMockito.doReturn(resuiltList)
                .when(chuyenDeDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        
        ChuyenDe result = chuyenDeDAOSpy.selectById(id);
        
        assertThat(result, CoreMatchers.is(expResult.getMaCD()));
 
    }

    @Test
    public void testSelectBySql() {
        System.out.println("selectBySql");
        String sql = "";
        Object[] args = null;
        ChuyenDeDAO instance = new ChuyenDeDAO();
        List<ChuyenDe> expResult = null;
        List<ChuyenDe> result = instance.selectBySql(sql, args);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
