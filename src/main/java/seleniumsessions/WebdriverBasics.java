package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverBasics {

	public static void main(String[] args) {
		// java + selenium (4.x)
	    // open browser
		//Automation steps
		WebDriver driver= new ChromeDriver();
		//WebDriver driver= new EdgeDriver();
		//Enter the URL
		driver.get("https://www.google.co.in/");
		String title=driver.getTitle();
		System.out.println("page title: "+ title);
		
		//Validation points/check points
		
		if (title.equals("Google")) {
			System.out.println("title is correct");
		}
		else {
			
			System.out.println("title is not correct");
		}
		//Automation steps +validations=Automation testing
		
		//get the current URL
		String url=driver.getCurrentUrl();
		System.out.println("page url: " + url);
		if (url.contains("google.co")) {
			System.out.println("url is correct");
		}
		else {
			System.out.println("url is not correct");
		}
		//close the browser
		//driver.close();;
	}
	

}
