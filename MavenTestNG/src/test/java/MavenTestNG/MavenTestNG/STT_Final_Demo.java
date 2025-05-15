package MavenTestNG.MavenTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class STT_Final_Demo {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@Test(dataProvider = "loginDataFinal")
	public void f(String username, String password, String expected) {
		test = extent.createTest("Login Test - " + username);
		test.info("Test started for username: " + username);

		try {
			// Login
			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input")).sendKeys(username);

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input")).sendKeys(password);

			driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/div/button")).click();
			test.pass("Login successful");

			// Choose Goldfish
			driver.findElement(By.xpath("//*[@id=\"MyList\"]/div/ul/li[4]/a")).click();
			test.pass("Goldfish selected");

			// Add to Cart
			driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
			test.pass("Item added to cart");

			// Proceed to Checkout
			driver.findElement(By.xpath("//*[@id=\"Cart\"]/a")).click();
			test.pass("Proceeded to checkout");

			// Payment Details
			new Select(driver.findElement(By.xpath("//*[@id='CenterForm']/form/table[1]/tbody/tr[1]/td[2]/select")))
					.selectByVisibleText("MasterCard");
			test.pass("Card type selected");

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[2]/td[2]/input"))
					.sendKeys("1234567812345678");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[3]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[1]/tbody/tr[3]/td[2]/input"))
					.sendKeys("12/2030");
			pause(500);

			// Billing Info
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[1]/td[2]/input"))
					.sendKeys("Drishtti");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[2]/td[2]/input"))
					.sendKeys("Narwal");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[3]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[3]/td[2]/input"))
					.sendKeys("Pashan");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[4]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[4]/td[2]/input"))
					.sendKeys("Baner");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[5]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[5]/td[2]/input"))
					.sendKeys("Pune");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[6]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[6]/td[2]/input"))
					.sendKeys("Maharashtra");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[7]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[7]/td[2]/input"))
					.sendKeys("411009");
			pause(500);

			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[8]/td[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/table[2]/tbody/tr[8]/td[2]/input"))
					.sendKeys("India");
			pause(500);

			// Continue and Confirm
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/div/button[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/div/button[1]")).click();
			test.pass("Order placed");

			// Logout
			driver.findElement(By.xpath("//*[@id=\"Menu\"]/div[1]/a[4]")).click();
			test.pass("Logged out");

		} catch (Exception e) {
			test.fail("Test failed due to exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@DataProvider(name = "loginDataFinal")
	public String[][] getData() {
		return new String[][] {
			{"2004", "abcd", "valid"}
		};
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jpetstore.aspectran.com/account/signonForm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Initialize Extent Report
		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@AfterClass
	public void afterClass() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		extent.flush(); // Write the report
	}

	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
