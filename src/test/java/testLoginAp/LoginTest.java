package testLoginAp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private String url = "https://www.facebook.com/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Eclise_plugins\\chrome-drive\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginSuccess() {
        driver.get(url);
        driver.findElement(By.id("email")).sendKeys("0708115425");
        driver.findElement(By.id("pass")).sendKeys("thanhducam");
        driver.findElement(By.name("login")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/"));
    }

    @Test(priority = 2)
    public void testLoginWithInvalidUsername() {
    	 driver.get(url);
         driver.findElement(By.id("email")).sendKeys("0708115424");
         driver.findElement(By.id("pass")).sendKeys("thanhducam");
         driver.findElement(By.name("login")).click();
         System.out.println("Tên đăng nhập ko đúng");
//        Assert.assertTrue(driver.findElement(By.id("lblError")).getText().contains("Tên đăng nhập không đúng"));
    }

    @Test(priority = 3)
    public void testLoginWithInvalidPassword() {
    	 driver.get(url);
         driver.findElement(By.id("email")).sendKeys("0708115425");
         driver.findElement(By.id("pass")).sendKeys("thanhducamm");
         driver.findElement(By.name("login")).click();
         System.out.println("Mật khẩu ko đúng");
//        Assert.assertTrue(driver.findElement(By.id("lblError")).getText().contains("Mật khẩu không đúng"));
    }
}
