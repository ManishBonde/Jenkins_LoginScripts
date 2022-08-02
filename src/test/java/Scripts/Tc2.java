package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc2 {
		@Test
		public void OpenApp() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoapp.skillrary.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
			driver.findElement(By.id("email")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("manager");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			//System.out.println(driver.getTitle());
			String acttitle = driver.getTitle();
			System.out.println(acttitle);
			if (acttitle.equals("SkillRary Ecommerce")) {
				System.out.println("Pass: Homepage is displayed");
			}
			else {
				System.out.println("Fail: Homepage is not displayed");
			}
			
			driver.close();
			
		}
	}