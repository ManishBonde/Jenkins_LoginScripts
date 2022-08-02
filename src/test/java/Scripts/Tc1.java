package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc1 {
	
@Test
public void OpenApp() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.id("email")).sendKeys("admin");
	driver.findElement(By.id("pass")).sendKeys("manager");
	driver.findElement(By.name("login")).click();
	Thread.sleep(5000);
	//System.out.println(driver.getTitle());
	String acttitle = driver.getTitle();
	System.out.println(acttitle);
	if (acttitle.equals("Facebook – log in or sign up")) {
		System.out.println("Pass: Homepage is displayed");
	}
	else {
		System.out.println("Fail: Homepage is not displayed");
	}
	driver.close();
   }
}