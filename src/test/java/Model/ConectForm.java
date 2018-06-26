package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ConectForm {
    public By name = By.name("name");
    public By email = By.name("email");
    public By buget = By.xpath("(//button[@type='button'])[4]");
    public By position = By.name("position");
    public By description = By.xpath("//textarea[@name='description']");
    public By attach = By.xpath("//div[@id='root']/div/div[4]/div/div/div[2]/div[2]/div[2]/form/div[2]/div/label");
    public By submit = By.xpath("//button[@type='submit']");
    public By submitMeassage = By.xpath("//div[@id='root']/div/div[4]/div/div/div[2]/div[2]/div/div/div");

    private WebDriver driver;


    public ConectForm(WebDriver driver){
       this.driver = driver;
    }


    public void fiilName(String name){
        driver.findElement(this.name).click();
        driver.findElement(this.name).clear();
        driver.findElement(this.name).sendKeys(name);
    }

    public void fillEmail(String email){
        driver.findElement(this.email).click();
        driver.findElement(this.email).clear();
        driver.findElement(this.email).sendKeys(email);
    }

    public void fillPosition(String position){
        driver.findElement(this.position).click();
        driver.findElement(this.position).clear();
        driver.findElement(this.position).sendKeys(position);
    }
    public void fillDescription(String description){
        driver.findElement(this.description).click();
        driver.findElement(this.description).clear();
        driver.findElement(this.description).sendKeys(description);
    }
    public void attachFile(String fileName){
        driver.findElement(this.attach).click();
        driver.findElement(By.id("file")).sendKeys(new File("src\\main\\resources\\"+fileName).getAbsolutePath());
    }

    public void pressSubmitButton(){
        driver.findElement(this.submit).click();
    }

    public void verifySubmitMeasage(String meassege){
            assertEquals(meassege, driver.findElement(this.submitMeassage).getText());
            makeScreenshot();
    }

    public void  fillBuget(BugetValue value){
        driver.findElement(this.buget).click();
        switch (value)
        {
            case LessThan15000$:
                driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
                break;
            case Between15000$And50000$:
                driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
                break;
            case MoreThan5000$:
                driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
                break;
        }

    }

    @Attachment(type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
