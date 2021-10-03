package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main (String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://www.leafground.com/pages/Alert.html");

//Simple Alert
driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
//switch to helps in transferring control to the current active dialog
Alert alert = driver.switchTo().alert();

//Click ok 
Thread.sleep(2000);
alert.accept();

//Confirmation Alert

driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
// control is already switch above in simple alert
Thread.sleep(2000);
alert.dismiss();
String text = driver.findElement(By.id("result")).getText();
if (text.contains("You pressed Cancel!")) {
	System.out.println("you pressed cancel button:" + text);
}
else {
	System.out.println("you pressed ok button");
	
}		

driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
alert.sendKeys("HCL");
Thread.sleep(2000);
alert.accept();

String text2 = driver.findElement(By.id("result1")).getText();
if (text2.contains("You should not have enjoyed learning at HCL as compared to TestLeaf! Right?")) {
System.out.println("I have changed the text in alert box and pressed ok: " + text2);	
}
else {
	System.out.println("I have pressed cancel");
}
	}
}
