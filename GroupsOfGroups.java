import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class GroupsOfGroups {
    
    public static WebDriver driver;
    SoftAssert soft = new SoftAssert();
    
    @BeforeSuite (groups = {"Run"})
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    
    @Test (groups = {"Run"})
    void login(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    
    @Test (groups = {"Run"})
    void check(){
        String exp = "https://www.saucedemo.com/inventory.html";
        String act = driver.getCurrentUrl();
        soft.assertEquals(act,exp);
        soft.assertAll();
    }
    
    @Test (groups = {"NotRun"})
    void logout() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
    }
    
    @Test (groups = {"NotRun"})
    void check2(){
        String exp = "https://www.saucedemo.com/";
        String act = driver.getCurrentUrl();
        soft.assertEquals(act,exp);
        soft.assertAll();
    }

    @AfterSuite(groups = {"Run"})
    void closeBrowser(){
        driver.quit();
    }
}
