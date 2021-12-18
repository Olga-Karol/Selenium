import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BmiCalculatorTest {

    @Test
    public void BmiCalculateSiValueTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");


        Double weight = 54.60;
        Double height = 170.5;
        String wg = weight.toString();
        String ht = height.toString();

        double bmi = weight / ((height * height / 10000));
        String expectedResult = String.format("%.2f",bmi);


        driver.findElement(By.name("wg")).sendKeys(wg);
        driver.findElement(By.name("ht")).sendKeys(ht);
        driver.findElement(By.name("cc")).click();

        String actualBmiValue = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(actualBmiValue, expectedResult, "Bmi value is calculated incorrectly");
        driver.close();
    }



}
