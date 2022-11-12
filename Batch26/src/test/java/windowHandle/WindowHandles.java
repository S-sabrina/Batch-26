package windowHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
	Logger log = LogManager.getLogger(WindowHandles.class);
	static WebDriver driver;
	
	
@Test
public void getRightWindow() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[1]")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[2]")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[3]")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-icon orangehrm-sm-icon'])[4]")).click();
	
Set<String> handles = driver.getWindowHandles();
List<String> wList = new ArrayList<String>(handles);
if(getTwitterWindow("Twitter", wList)) {
	System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
}

}

		public static boolean getTwitterWindow(String windowTitle, List<String>wList) {
			for(String e: wList) {
				String title = driver.switchTo().window(e).getTitle();
				if(title.contains(windowTitle)) {
				System.out.println("found the right window");
				return true;
			}
		}
		return false;
}

}	
		
	
		



