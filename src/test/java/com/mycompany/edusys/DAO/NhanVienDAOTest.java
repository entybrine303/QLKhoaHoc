/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.NhanVien;
import com.mycompany.edusys.Utils.JdbcHelper;
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
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author ACER
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({JdbcHelper.class,NhanVienDAO.class})
public class NhanVienDAOTest {
    NhanVienDAO nhanVienDAO;
    NhanVienDAO nhanVienDAOSpy;
    
    public NhanVienDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nhanVienDAO = new NhanVienDAO();
        PowerMockito.mockStatic(JdbcHelper.class);
        nhanVienDAOSpy =  PowerMockito.spy(new NhanVienDAO());
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)
    public void testInsertWithNull() {
        
        NhanVien e = null;
        NhanVienDAO instance = new NhanVienDAO();
        instance.insert(e);
        
    }
        @Test(expected = Exception.class)
    public void testInsertWithEmptyvali() {
        
        NhanVien e =  new NhanVien();
        NhanVienDAO instance = new NhanVienDAO();
        instance.insert(e);
        
    }
        @Test()
    public void testInsertWithVali() {
        
        NhanVien e = new NhanVien();
        e.setHoTen("Phan Tien Thanh");
        e.setMaNV("PD1");
        e.setMatKhau("qwe");
        e.setVaiTro(true);
        NhanVienDAO d = new NhanVienDAO();
         d.insert(e);
        
        
    }

    @Test(expected = Exception.class)
    public void testUpdateWithNull() {
        
        NhanVien e = null;
        NhanVienDAO instance = new NhanVienDAO();
        instance.update(e);
        
    }
      @Test(expected = Exception.class)
    public void testUpdateWithEmptyVali() {
        
        NhanVien e = new NhanVien();
        NhanVienDAO instance = new NhanVienDAO();
        instance.update(e);
        
    }
      @Test(expected = Exception.class)
    public void testUpdateWithVali() {
        
        NhanVien e = new NhanVien();
        e.setHoTen("Phan Tien Thanh");
        e.setMaNV("PD1");
        e.setMatKhau("qwe");
        e.setVaiTro(true);
        NhanVienDAO instance = new NhanVienDAO();
        instance.update(e);
        
    }

    @Test(expected = Exception.class)
    public void testDeleteWithNull(){
        
        String id = null;
        NhanVienDAO instance = new NhanVienDAO();
        instance.delete(id);
       
    }
    @Test(expected = Exception.class)
    public void testDeleteWithEmpty(){
        
        String id = "";
        NhanVienDAO instance = new NhanVienDAO();
        instance.delete(id);
       
    }
    @Test
    public void testDeleteWithVali(){
        
        String id = "12";
        NhanVienDAO instance = new NhanVienDAO();
        instance.delete(id);
       
    }

    @Test
    public void testSelectAll() throws Exception {
        NhanVien nhanVien = new NhanVien();
        List<NhanVien> resultlist = new ArrayList<>();
        resultlist.add(nhanVien);
        PowerMockito.doReturn(resultlist)
                .when(nhanVienDAOSpy,"selectBySql",ArgumentMatchers.anyString());
        
        List<NhanVien> result = nhanVienDAOSpy.selectAll();
        assertThat(result, CoreMatchers.is(resultlist));
    }

    @Test
    public void testSelectById() throws Exception {
        System.out.println("selectById");
        String id = "12";
        NhanVien Exresult = new NhanVien();
        List<NhanVien> resultList = new ArrayList<>();
        resultList.add(Exresult);
        PowerMockito.doReturn(resultList)
                .when(nhanVienDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
           NhanVien  result = nhanVienDAOSpy.selectById(id);
           assertThat(result,CoreMatchers.is(Exresult));
        
    }
    @Test()
    public void testSelectByIdWithNull() throws Exception {
        System.out.println("selectById");
        String id = "";
        NhanVien Exresult = null;
        List<NhanVien> resultList = new ArrayList<>();
        resultList.add(Exresult);
        PowerMockito.doReturn(resultList)
                .when(nhanVienDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
           NhanVien  result = nhanVienDAOSpy.selectById(id);
           assertThat(result,CoreMatchers.is(Exresult));
        
    }

    @Test
    public void testSelectBySql() {
        System.out.println("selectBySql");
        String sql = "";
        Object[] args = null;
        NhanVienDAO instance = new NhanVienDAO();
        List<NhanVien> expResult = null;
        List<NhanVien> result = instance.selectBySql(sql, args);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
