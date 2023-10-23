package thi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HinhChuNhatTest {
    private HinhChuNhat hcn;

    @Before
    public void setUp() {
        hcn = new HinhChuNhat(5.0, 3.0);
    }

    @Test
    public void testTinhDienTich() {
        double expected = 15.0;
        double actual = hcn.tinhDienTich();
        Assert.assertEquals(expected, actual, 0.0001); // So sánh với sai số 0.0001
    }

    @Test
    public void testTinhChuVi() {
        double expected = 16.0;
        double actual = hcn.tinhChuVi();
        Assert.assertEquals(expected, actual, 0.0001); // So sánh với sai số 0.0001
    }
}
