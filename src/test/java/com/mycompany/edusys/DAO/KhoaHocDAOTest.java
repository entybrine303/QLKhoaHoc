/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.KhoaHoc;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
@PrepareForTest({JdbcHelper.class,KhoaHocDAO.class})
public class KhoaHocDAOTest {
    KhoaHocDAO khoaHocDAO;
    KhoaHocDAO khoaHocDAOSpy;
    
    public KhoaHocDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        khoaHocDAO = new KhoaHocDAO();
        PowerMockito.mockStatic(JdbcHelper.class);
        khoaHocDAOSpy = PowerMockito.spy(new KhoaHocDAO());
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)
    public void testInsertWithNull() {
        
        KhoaHoc e = null;
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.insert(e);
        
    }
    @Test(expected = Exception.class)
    public void testInsertWithEmptyFound() {
        
        KhoaHoc e = new KhoaHoc();
       
        khoaHocDAO.insert(e);
        
    }
    
    @Test
    public void testInsertWithValiFound() {
        
        KhoaHoc e = new KhoaHoc();
        e.setHocPhi(100);
        e.setGhiChu("hoc");
        e.setMaCD("PD1");
        e.setMaKH(13);
        e.setMaNV("PD1");
        e.setNgayKG(new Date());
        e.setNgayTao(new Date());
        e.setThoiLuong(123);
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.insert(e);
        
    }

    @Test(expected = Exception.class)
    public void testUpdateWithnull() {
        
        KhoaHoc e = null;
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.update(e);
       
    }
     @Test(expected = Exception.class)
    public void testUpdateWithEmptyFould() {
        
        KhoaHoc e = new KhoaHoc();
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.update(e);
       
    }
    @Test
    public void testUpdateWithValiFould() {
        
        KhoaHoc e = new KhoaHoc();
        e.setHocPhi(100);
        e.setGhiChu("hoc");
        e.setMaCD("PD1");
        e.setMaKH(13);
        e.setMaNV("PD1");
        e.setNgayKG(new Date());
        e.setNgayTao(new Date());
        e.setThoiLuong(123);
        KhoaHocDAO instance = new KhoaHocDAO();
        
        instance.update(e);
       
    }


    @Test(expected = Exception.class)
    public void testDeleteWithNull() {
        
        Integer id = null;
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.delete(id);
        
    }
    @Test(expected = Exception.class)
    public void testDeleteWithEmptyFound() {
        
        Integer id = 0;
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.delete(id);
        
    }
    @Test()
    public void testDeleteWithValiFound() {
        
        Integer id = 12;
        KhoaHocDAO instance = new KhoaHocDAO();
        instance.delete(id);
        
    }



    @Test
    public void testSelectAll() throws Exception {
        KhoaHoc khoaHoc = new KhoaHoc();
        List<KhoaHoc> exresult = new ArrayList<>();
        exresult.add(khoaHoc);
        PowerMockito.doReturn(exresult)
                .when(khoaHocDAOSpy,"selectBySql",ArgumentMatchers.anyString());
        List<KhoaHoc> result = khoaHocDAOSpy.selectAll();
        assertThat(result, CoreMatchers.is(exresult));
    }

    @Test
    public void testSelectById() throws Exception {
        System.out.println("selectById");
        Integer id = 12;
        KhoaHoc exResult = new KhoaHoc();
        List<KhoaHoc> list = new ArrayList<>();
        list.add(exResult);
        PowerMockito.doReturn(list)
                .when(khoaHocDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        KhoaHoc result = khoaHocDAOSpy.selectById(id);
        Assert.assertThat(result,CoreMatchers.is(exResult));
    }
    @Test
    public void testSelectByEmptyId() throws Exception {
        System.out.println("selectById");
        Integer id = -1;
        KhoaHoc exResult = null;
        List<KhoaHoc> list = new ArrayList<>();
        list.add(exResult);
        PowerMockito.doReturn(list)
                .when(khoaHocDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        KhoaHoc result = khoaHocDAOSpy.selectById(id);
        Assert.assertThat(result,CoreMatchers.is(exResult));
    }

    @Test
    public void testSelectBySql() {
        System.out.println("selectBySql");
        String sql = "";
        Object[] args = null;
        KhoaHocDAO instance = new KhoaHocDAO();
        List<KhoaHoc> expResult = null;
        List<KhoaHoc> result = instance.selectBySql(sql, args);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectByChuyenDeWithfound() throws Exception {
        
        String maCD = "12";
        KhoaHoc exresuil = new KhoaHoc();
        List<KhoaHoc> resultlist = new ArrayList<>();
        resultlist.add(exresuil);
        PowerMockito.doReturn(resultlist)
                .when(khoaHocDAOSpy,"selectByChuyenDe",ArgumentMatchers.anyString());
        List<KhoaHoc> result = khoaHocDAOSpy.selectByChuyenDe(maCD);
        assertThat(result, CoreMatchers.is(resultlist));
        
    }
     @Test
    public void testSelectByChuyenDeEmptyFound() throws Exception {
        
        String maCD = "";
        KhoaHoc exresuil = null;
        List<KhoaHoc> resultlist = new ArrayList<>();
        resultlist.add(exresuil);
        PowerMockito.doReturn(resultlist)
                .when(khoaHocDAOSpy,"selectByChuyenDe",ArgumentMatchers.anyString());
        List<KhoaHoc> result = khoaHocDAOSpy.selectByChuyenDe(maCD);
        assertThat(result, CoreMatchers.is(exresuil));
        
    }

    @Test
    public void testSelectYear() {
        System.out.println("selectYear");
        KhoaHocDAO instance = new KhoaHocDAO();
        List<Integer> expResult = null;
        List<Integer> result = instance.selectYear();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
