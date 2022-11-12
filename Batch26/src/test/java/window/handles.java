package window;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handles {
	 static WebDriver driver;
	
	@Test
	public void verifySpecificWindow() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[1]")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[2]")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[3]")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[4]")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> wList = new ArrayList<String>(handles);
		if(verifyTitle("Facebook", wList)) {
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
		}
		
	}

	@Test(dependsOnMethods="verifySpecificWindow")
	public static boolean verifyTitle(String windowTitle, List<String>wList) {
		for(String e :wList) {
			String titles = driver.switchTo().window(e).getTitle();
			if(titles.contains(windowTitle)) {
				System.out.println("found the right title");
				return true;
			}
		}
		return false;
	}
}
