import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import Model.BugetValue;
import Model.ConectForm;
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
    private ConectForm conectForm;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        conectForm = new ConectForm(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Title("This is our cool test suite")
    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://firstbridge.io/");

        conectForm.fiilName("Test Test");
        conectForm.fillBuget(BugetValue.LessThan15000$);
        conectForm.fillEmail("Test@gmail.com");
        conectForm.fillPosition("TestQA");
        conectForm.fillDescription("Test");
        //File from resources folder
        conectForm.attachFile("test.txt");
        conectForm.pressSubmitButton();

        try {
            conectForm.verifySubmitMeasage("Please fill the required fields");
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
