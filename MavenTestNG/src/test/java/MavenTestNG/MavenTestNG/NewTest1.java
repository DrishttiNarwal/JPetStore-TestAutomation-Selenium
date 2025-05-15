package MavenTestNG.MavenTestNG;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // initialize here
    }

    @Test
    public void f() throws InterruptedException {
        driver.get("https://mvnrepository.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
