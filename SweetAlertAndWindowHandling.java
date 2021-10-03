package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SweetAlertAndWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
//ChromeDriver driver = new ChromeDriver();
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notification");

ChromeDriver driver = new ChromeDriver(options);


driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.get("https://www.irctc.co.in/nget/train-search");

driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

Thread.sleep(5000);

driver.findElement(By.xpath("//li[@class='menu-list header-icon-menu'][3]/a")).click();


Set<String> windowHandles = driver.getWindowHandles();

// here set holds both the handles for windows and we need to pass the index to get the req. window so we need to convert set to List

List<String> newList = new ArrayList<String>(windowHandles);
System.out.println("Before switching control to new window: "+driver.getTitle());

//pass control to second window
driver.switchTo().window(newList.get(1));
System.out.println("Title after control change to second window:" +driver.getTitle());

String text = driver.findElement(By.xpath("//div[@class='block-nav-right d-none d-md-block'][2]")).getText();
if (text.contains("flights")) {
	System.out.println("email id fetched is: "+ text);
}

else {
	System.err.println("failed");
}





	}

}
