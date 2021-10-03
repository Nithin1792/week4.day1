package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

driver.get("http://www.leafground.com/pages/Window.html");

driver.findElement(By.id("home")).click();

//WindowHanldes
//it returns set, so we cant access it with index so convert it into list
Set<String> winSet = driver.getWindowHandles();

//cnvert set to list

List<String> name = new ArrayList<String>(winSet);
System.out.println("before switiching control:" + driver.getTitle());
// control is goven to second window
driver.switchTo().window(name.get(1));
System.out.println("after switiching control:" + driver.getTitle());


// switching back again to main window by passsing index 0 
driver.switchTo().window(name.get(0));
System.out.println("switiching control back to main:" + driver.getTitle());


//number of window opened 

System.out.println("Number of windows: "+ winSet.size());

//driver.close(); // closes the current window
//driver.quit();//all the open windows will close

	
	}

}
