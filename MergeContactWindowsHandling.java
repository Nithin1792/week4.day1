package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactWindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.xpath("//a[@style='color: black;']")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		Set<String> winHan = driver.getWindowHandles();

		List<String> merList = new ArrayList<String>(winHan);

		driver.switchTo().window(merList.get(1));

		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		driver.switchTo().window(merList.get(0));

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		Thread.sleep(2000);

		Set<String> winHan1 = driver.getWindowHandles();
		List<String> merList1 = new ArrayList<String>(winHan1);
		driver.switchTo().window(merList1.get(1));

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[2]")).click();

		driver.switchTo().window(merList1.get(0));
		driver.findElement(By.xpath("(//a[@class='buttonDangerous'])")).click();

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		System.out.println("Title of current page: " + driver.getTitle());
	}

}
