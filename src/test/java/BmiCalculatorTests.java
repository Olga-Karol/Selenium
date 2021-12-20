import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestData;
import static utils.BaseUrl.PROD;


public class BmiCalculatorTests {
    static final String NAME_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    static final String VALUE_SYSTEM_PROPERTY = "src/test/resources/chromedriver.exe";
    public WebDriver driver;

        @BeforeTest
        public void launchBrowser()

        {
            System.setProperty(NAME_SYSTEM_PROPERTY, VALUE_SYSTEM_PROPERTY);
            driver = new ChromeDriver();
            driver.get(PROD);
        }

        @Test
        public void BmiCalculateSiValueTest() {
            TestData test1 = new TestData(54.60, 170.5);
            String wg = test1.getWeight().toString();
            String ht = test1.getHeight().toString();
            String expectedResult = String.format("%.2f", test1.getBmi());
            driver.findElement(By.name("wg")).sendKeys(wg);
            driver.findElement(By.name("ht")).sendKeys(ht);
            driver.findElement(By.name("cc")).click();
            String actualBmiValue = driver.findElement(By.name("si")).getAttribute("value");
            Assert.assertEquals(actualBmiValue, expectedResult, "Bmi value is calculated incorrectly");
        }

        @AfterTest
        public void closeBrowser() {
            driver.close();
        }
    }

