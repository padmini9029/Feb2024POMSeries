package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleWithList {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		Set<String> handles=driver.getWindowHandles();
		
		//converting set to a list
		List<String> handlesList=new ArrayList<String>(handles);
		String parentWindowId=handlesList.get(0);
		System.out.println(parentWindowId);
        
		String childWindowId=handlesList.get(1);
		System.out.println(childWindowId);
		
		//switching work
		driver.switchTo().window(childWindowId);
		System.out.println("child window title: " +driver.getCurrentUrl());
		
		driver.close();//close the child window
		
		//driver is lost on close
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title: " + driver.getCurrentUrl());
		driver.quit();// it will close the parent window as well

	}

}
