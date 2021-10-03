package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.get("http://www.leafground.com/pages/frame.html");
WebElement frames = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]"));
	driver.switchTo().frame(frames);
	driver.findElement(By.id("Click")).click();
	
	//it takes me out of all the frames and takes me to main page
	
	driver.switchTo().defaultContent();
	
	
	// nested frame
	
	
	}

}
