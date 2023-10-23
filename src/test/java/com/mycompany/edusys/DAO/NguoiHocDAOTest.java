/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.KhoaHoc;
import com.mycompany.edusys.Entity.NguoiHoc;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.util.ArrayList;
import java.util.Date;
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
@PrepareForTest({JdbcHelper.class,NguoiHocDAO.class})
public class NguoiHocDAOTest {
    NguoiHocDAO nguoiHocDAO;
    NguoiHocDAO nguoiHocDAOSpy;
    
            
    public NguoiHocDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nguoiHocDAO = new NguoiHocDAO();
        PowerMockito.mockStatic(JdbcHelper.class);
        nguoiHocDAOSpy = PowerMockito.spy(new NguoiHocDAO());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsertWithVali() {
        
        NguoiHoc e = new NguoiHoc();
        e.setDienThoai("093213123");
        e.setEmail("t@gamil.com");
        e.setGhiChu("");
        e.setGioiTinh(true);
        e.setHoTen("thanh");
        e.setMaNH("3");
        e.setMaNV("pd1");
        e.setNgayDK(new Date());
        e.setNgaySinh(new Date());
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.insert(e);
        
    }
    @Test(expected = Exception.class)
    public void testInsertWithNull() {
        
        NguoiHoc e = null;
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.insert(e);
        
    }
    @Test(expected = Exception.class)
    public void testInsertWithEmptyVali() {
        
        NguoiHoc e = new NguoiHoc();
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.insert(e);
        
    }

    @Test
    public void testUpdateWithVali() {
        
        NguoiHoc e = new NguoiHoc();
        NguoiHocDAO instance = new NguoiHocDAO();
        e.setDienThoai("093213123");
        e.setEmail("t@gamil.com");
        e.setGhiChu("");
        e.setGioiTinh(true);
        e.setHoTen("thanh");
        e.setMaNH("3");
        e.setMaNV("pd1");
        e.setNgayDK(new Date());
        e.setNgaySinh(new Date());
        
        instance.update(e);
        
    }
    @Test(expected = Exception.class)
    public void testUpdateWithNull() {
        
        NguoiHoc e = null;
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.update(e);
        
    }
    @Test(expected = Exception.class)
    public void testUpdateWithEmptyVali() {
        
        NguoiHoc e = new NguoiHoc();
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.update(e);
       
    }
    @Test
    public void testDeleteWithVali() {
        
        String id = "12";
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.delete(id);
        
    }
    @Test(expected = Exception.class)
    public void testDeleteWithNull() {
        System.out.println("delete");
        String id = null;
        NguoiHocDAO instance = null;
        instance.delete(id);
        
    }
    @Test(expected = Exception.class)
    public void testDeleteWithEmpty() {
        System.out.println("delete");
        String id = "";
        NguoiHocDAO instance = new NguoiHocDAO();
        instance.delete(id);
        
    }

    @Test
    public void testSelectAll() throws Exception {
        NguoiHoc nguoiHoc = new NguoiHoc();
        List<NguoiHoc> resultlist = new ArrayList<>();
        resultlist.add(nguoiHoc);
        PowerMockito.doReturn(resultlist)
                .when(nguoiHocDAOSpy,"selectBySql",ArgumentMatchers.anyString());
        
        List<NguoiHoc> result = nguoiHocDAOSpy.selectAll();
        assertThat(result, CoreMatchers.is(resultlist));
        
    }

    @Test
    public void testSelectById() throws Exception {
        
        String id = "12";
        NguoiHoc exresult = new NguoiHoc();
        List<NguoiHoc> resultlist = new ArrayList<>();
        
        resultlist.add(exresult);
        PowerMockito.doReturn(resultlist)
                .when(nguoiHocDAOSpy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        NguoiHoc result = nguoiHocDAOSpy.selectById(id);
        assertThat(exresult, CoreMatchers.is(result));
        
        
    }

    @Test
    public void testSelectBySql() {
        System.out.println("selectBySql");
        String sql = "";
        Object[] args = null;
        NguoiHocDAO instance = new NguoiHocDAO();
        List<NguoiHoc> expResult = null;
        List<NguoiHoc> result = instance.selectBySql(sql, args);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectByKeyword() {
        System.out.println("selectByKeyword");
        String keyword = "";
        NguoiHocDAO instance = new NguoiHocDAO();
        List<NguoiHoc> expResult = null;
        List<NguoiHoc> result = instance.selectByKeyword(keyword);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectNotInCourse() {
        System.out.println("selectNotInCourse");
        int makh = 0;
        String key = "";
        NguoiHocDAO instance = new NguoiHocDAO();
        List<NguoiHoc> expResult = null;
        List<NguoiHoc> result = instance.selectNotInCourse(makh, key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
