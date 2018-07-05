import Model.BugetValue;
import Model.ConectForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class TestCaseContectFormWithParameter {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private ConectForm conectForm;
    @Parameterized.Parameter
    public String name;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        conectForm = new ConectForm(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Title("[Contact form] Checking the \"Name\" field")
    @Features("[Contact form]")
    @Stories("Negativ")
    @Test
    public void testCaseN1() throws Exception {
        driver.get("http://firstbridge.io/");

        conectForm.fiilName(name);
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


    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[] { "Maksim1 ", "!", "","!Maksim","Ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" };

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

