package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowWithMultipleTabsHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent window
		
		//window handler APIs
		//any browser/windows
		//any advertisements 
		String parentWindowId=driver.getWindowHandle();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		while (it.hasNext()) {
			String windowId=it.next();
			driver.switchTo().window(windowId);
			
			System.out.println(driver.getCurrentUrl());
			if (!parentWindowId.equals(windowId)) {
			driver.close();
			}
		}
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
	}

}
