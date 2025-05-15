package MavenTestNG.MavenTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DDLogin1 {
	WebDriver driver = new ChromeDriver();
	
  @Test(dataProvider = "loginData")
  public void f(String username, String password, String expected) {
	  System.out.println(username + password + expected);
	  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
  }

  @DataProvider(name = "loginData")
  public String [] [] getData()
  {
	  String loginData[][] = {
			  {"student", "Password123", "valid"},
			  {"incorrectUser", "Password124", "invalid"}
	  };
	  return loginData;
  }
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver.get("https://practicetestautomation.com/practice-test-login/");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.navigate().back();
	  driver.navigate().refresh();
	  driver.close();
  }
}