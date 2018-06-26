import java.util.concurrent.TimeUnit;

import Model.BugetValue;
import Model.ConectForm;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
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


    @Title("[Contact form] Checking the \"Name\" field  (Contain Name and surname)")
    @Features("[Contact form]")
    @Stories("Positive")
    @Test
    public void testCaseP1() throws Exception {
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
            conectForm.verifySubmitMeasage("we'll contact you as soon as possible");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Title("[Contact form] Sending reqest  with correct data")
    @Features("[Contact form]")
    @Stories("Positive")
    @Test
    public void testCaseP2() throws Exception {
        driver.get("http://firstbridge.io/");

        conectForm.fiilName("Test");
        conectForm.fillBuget(BugetValue.LessThan15000$);
        conectForm.fillEmail("Test@gmail.com");
        conectForm.fillPosition("TestQA");
        conectForm.fillDescription("Test");
        //File from resources folder
        conectForm.attachFile("test.txt");
        conectForm.pressSubmitButton();

        try {
            conectForm.verifySubmitMeasage("we'll contact you as soon as possible");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Title("[Contact form] Checking the \"Name\" field  (use сyrillic)")
    @Features("[Contact form]")
    @Stories("Positive")
    @Test
    public void testCaseP3() throws Exception {
        driver.get("http://firstbridge.io/");

        conectForm.fiilName("Тест");
        conectForm.fillBuget(BugetValue.LessThan15000$);
        conectForm.fillEmail("Test@gmail.com");
        conectForm.fillPosition("TestQA");
        conectForm.fillDescription("Test");
        //File from resources folder
        conectForm.attachFile("test.txt");
        conectForm.pressSubmitButton();

        try {
            conectForm.verifySubmitMeasage("we'll contact you as soon as possible");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Title("[Contact form] Checking the \"Select budge\" field 15000-50000 $")
    @Features("[Contact form]")
    @Stories("Positive")
    @Test
    public void testCaseP4() throws Exception {
        driver.get("http://firstbridge.io/");

        conectForm.fiilName("Test");
        conectForm.fillBuget(BugetValue.Between15000$And50000$);
        conectForm.fillEmail("Test@gmail.com");
        conectForm.fillPosition("TestQA");
        conectForm.fillDescription("Test");
        //File from resources folder
        conectForm.attachFile("test.txt");
        conectForm.pressSubmitButton();

        try {
            conectForm.verifySubmitMeasage("we'll contact you as soon as possible");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Title("[Contact form] Checking the \"Select budge\" field 50000+ $")
    @Features("[Contact form]")
    @Stories("Positive")
    @Test
    public void testCaseP5() throws Exception {
        driver.get("http://firstbridge.io/");

        conectForm.fiilName("Test");
        conectForm.fillBuget(BugetValue.MoreThan5000$);
        conectForm.fillEmail("Test@gmail.com");
        conectForm.fillPosition("TestQA");
        conectForm.fillDescription("Test");
        //File from resources folder
        conectForm.attachFile("test.txt");
        conectForm.pressSubmitButton();

        try {
            conectForm.verifySubmitMeasage("we'll contact you as soon as possible");
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
