package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("FRAMES");

		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
//		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");
		WebElement animals = driver.findElement(By.id("animals"));
		Select drpdwn = new Select(animals);
		drpdwn.selectByValue("babycat");
	}

}
