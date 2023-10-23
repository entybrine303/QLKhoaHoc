/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.DAO;

import com.mycompany.edusys.Entity.HocVien;
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
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author ACER
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({JdbcHelper.class, HocVienDAO.class})
public class HocVienDAOTest {

    HocVienDAO hocvien;
    HocVienDAO hocvienspy;

    public HocVienDAOTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hocvien = new HocVienDAO();
        PowerMockito.mockStatic(JdbcHelper.class);
        hocvienspy = PowerMockito.spy(new HocVienDAO());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {

        HocVien e = new HocVien();
        e.setDiem(9);
        e.setMaHV(12);
        e.setMaKH(32);
        e.setMaNH("PD1");
        hocvien.insert(e);

    }

    @Test(expected = Exception.class)
    public void testInsertWithNull() {
        HocVien e = null;
        hocvien.insert(e);
    }

    @Test(expected = Exception.class)
    public void testInsertWithEmptyModel() {
        HocVien e = new HocVien();
        hocvien.insert(e);
    }

    @Test
    public void testUpdate() {
        HocVien e = new HocVien();
        e.setDiem(9);
        e.setMaHV(12);
        e.setMaKH(32);
        e.setMaNH("PD2");
        hocvien.update(e);
    }

    @Test(expected = Exception.class)
    public void testUpdateWithNull() {

        HocVien e = null;

        hocvien.update(e);
    }

    @Test(expected = Exception.class)
    public void testUpdateWithEmptyModel() {

        HocVien e = new HocVien();

        hocvien.update(e);
    }

    @Test
    public void testSelectAll() throws Exception {
        HocVien hocVien = new HocVien();
        List<HocVien> exResult = new ArrayList<>();
        exResult.add(hocVien);
        PowerMockito.doReturn(exResult)
                .when(hocvienspy, "selectBySql", ArgumentMatchers.anyString());
        List<HocVien> result = hocvienspy.selectAll();
        assertThat(result, CoreMatchers.is(exResult));
    }

    @Test
    public void testSelectBySql() throws Exception {
        HocVien hocVien = new HocVien();
        List<HocVien> exResult = new ArrayList<>();
        exResult.add(hocVien);
        PowerMockito.doReturn(exResult)
                .when(hocvienspy, "selectBySql", ArgumentMatchers.anyString());
        List<HocVien> result = hocvienspy.selectAll();
        assertThat(result, CoreMatchers.is(exResult));

    }

    @Test
    public void testDelete() {
       
        Integer id = 12;
        hocvien.delete(id);
    }
    @Test(expected = Exception.class)
    public void testDeleteWithNull() {
       
        Integer id = null;
        hocvien.delete(id);
    }
    @Test(expected = Exception.class)
    public void testDeleteWithNotvali() {
       
        Integer id = 0;
        hocvien.delete(id);
    }

    @Test
    public void testSelectByIdWithNull() throws Exception {
       
        Integer id = null;
       
        HocVien expResult = null;
        List<HocVien> exresultlist = new ArrayList<>();
        PowerMockito.doReturn(exresultlist)
                .when(hocvienspy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        List<HocVien> result =(List<HocVien>) hocvienspy.selectById(id);
        assertThat(result, CoreMatchers.is(id));
    }
        @Test
    public void testSelectByIdWithVali() throws Exception {
        Integer id = 12;
        
       
        HocVien expResult = new HocVien();        
        List<HocVien> resuiltList = new ArrayList<>();
        resuiltList.add(expResult);
        
        PowerMockito.doReturn(resuiltList)
                .when(hocvienspy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        
        HocVien result = hocvienspy.selectById(id);
        
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test
    public void testSelectByKhoaHoc() throws Exception {
        System.out.println("selectByKhoaHoc");
        int makh = 1;
         HocVien expResult = new HocVien();        
        List<HocVien> resuiltList = new ArrayList<>();
        resuiltList.add(expResult);
        
        PowerMockito.doReturn(resuiltList)
                .when(hocvienspy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        
        HocVien result = hocvienspy.selectById(makh);
        
        assertThat(result, CoreMatchers.is(expResult));
    }
    @Test
    public void testSelectByKhoaHocwithnull() throws Exception {
        System.out.println("selectByKhoaHoc");
        
        
        int makh =0 ;
        
         HocVien expResult = null;        
        List<HocVien> resuiltList = new ArrayList<>();
        
        
        PowerMockito.doReturn(resuiltList)
                .when(hocvienspy,"selectBySql",ArgumentMatchers.anyString(),ArgumentMatchers.any());
        
        HocVien result = hocvienspy.selectById(makh);
        
        assertThat(result, CoreMatchers.is(expResult));  
    }

}
