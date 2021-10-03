package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundFramesScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://leafground.com/pages/frame.html");
		
		
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(text(),'supported ')][1]"));
		driver.switchTo().frame(iframe);
		
		WebElement clickMe = driver.findElement(By.id("Click"));
		File screenshot = clickMe.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./snaps/sort.png");
		
		FileUtils.copyFile(screenshot, destination);
		
		
		List<WebElement> tagName = driver.findElements(By.tagName("iframe"));
		
		int size = tagName.size();
		System.out.println("Count of iframes: "+size);
		
		System.out.println(tagName);
	}

}
