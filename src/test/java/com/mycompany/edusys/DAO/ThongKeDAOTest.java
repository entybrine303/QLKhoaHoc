/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusys.DAO;

import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;
import com.mycompany.edusys.Utils.JdbcHelper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author ACER
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({JdbcHelper.class, ThongKeDAO.class})
public class ThongKeDAOTest {
    ThongKeDAO thongKeDAOSpy;

    @Mock
    MockConnection mockConnection;
    @Mock
    MockStatement statement;
    @Mock
    MockResultSet rs = new MockResultSet("myMock");



    public ThongKeDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        PowerMockito.mockStatic(JdbcHelper.class);
        thongKeDAOSpy = PowerMockito.spy(new ThongKeDAO());
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetBangDiem() {
        System.out.println("getBangDiem");
        Integer MaKH = null;
        ThongKeDAO instance = new ThongKeDAO();
        List expResult = null;
        List result = instance.getBangDiem(MaKH);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLuongNguoiHoc() throws Exception {
        System.out.println("getLuongNguoiHoc");
        rs = initMocResultset();
        PowerMockito.when(JdbcHelper.query("sp_ThongKeNguoiHoc"))
                .thenReturn(rs);
        PowerMockito.when(rs.getStatement()).thenReturn(statement);
        PowerMockito.when(statement.getConnection()).thenReturn(mockConnection);
        List result = thongKeDAOSpy.getLuongNguoiHoc();
        assertEquals(1, result.size());
        
    }

    @Test
    public void testGetDiemChuyenDe() {
        System.out.println("getDiemChuyenDe");
        ThongKeDAO instance = new ThongKeDAO();
        List expResult = null;
        List result = instance.getDiemChuyenDe();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDoanhThu() {
        System.out.println("getDoanhThu");
        Integer nam = null;
        ThongKeDAO instance = new ThongKeDAO();
        List expResult = null;
        List result = instance.getDoanhThu(nam);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    private MockResultSet initMocResultset() throws Exception {
        rs.addColumn("Nam",new Integer[]{1});
        rs.addColumn("Soluong",new Integer[]{1});
        rs.addColumn("DauTien",new java.util.Date[]{
            new java.sql.Date(new java.util.Date().getTime())
                });
        rs.addColumn("CuoiCung",new java.util.Date[]{
            new java.sql.Date(new java.util.Date().getTime())
                });
        rs.beforeFirst();
        return rs;
    }

}
