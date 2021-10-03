package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertAndFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

WebElement locateFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
	driver.switchTo().frame(locateFrame);
	
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
	Thread.sleep(2000);
	
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	alert.accept();
	
	String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
	if (text.contains("You pressed OK!")) {
		System.out.println("Alert was handled and you clicked on ok :" + text);
		
	}else
		System.out.println("Alert handled and you clicked on cancel using method alert.dismiss();" + text);
	}

}
