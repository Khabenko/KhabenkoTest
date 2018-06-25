import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Title;


public class TestCaseContectForm {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Title("This is our cool test suite")
    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://firstbridge.io/");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Test Test");
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("Test@gmail.com");
        driver.findElement(By.name("position")).click();
        driver.findElement(By.name("position")).clear();
        driver.findElement(By.name("position")).sendKeys("TestQA");
        driver.findElement(By.xpath("//textarea[@name='description']")).click();
        driver.findElement(By.xpath("//textarea[@name='description']")).clear();
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test");
        driver.findElement(By.xpath("//div[@id='root']/div/div[4]/div/div/div[2]/div[2]/div[2]/form/div[2]/div/label")).click();
        driver.findElement(By.id("file")).sendKeys(new File("src\\main\\resources\\test.txt").getAbsolutePath());
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            assertEquals("Please fill the required fields", driver.findElement(By.xpath("//div[@id='root']/div/div[4]/div/div/div[2]/div[2]/div/div/div")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
