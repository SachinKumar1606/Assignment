// Assignmnet 1 on Xpath of facebook "Chield parent xpath Day2 Assignmnet"
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Ad {
	WebDriver driver;
	void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(5000); 
	}
	void question1() {
		driver.findElement(By.xpath("//div[@class='_1lch']//child::button")).click();
	}
	
	void question2() {
		driver.findElement(By.xpath("//button[@class='_6j"
				+ " mvm _6wk _6wl _58mi _3ma _6o _6v']//parent::div//preceding-sibling::div[@id='fullname_field']//child::input[@name='firstname']"))
		.sendKeys("We are done");
	}
	void question3() {
		driver.findElement(By.xpath("//input[@name='reg_email__']//following::input[@name='reg_passwd__']")).click();
	}
	
	void question4() {
		driver.findElement(By.xpath("//div[@class='mbm _br- _a4y']//preceding::input[@name='reg_email__']")).sendKeys("sachinkumar");
	}
	
	void question5() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.bbc.com/");
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='module__content']//following::a[@class='media__link']"));
		li.forEach(name->{
			System.out.println(name.getText());
		});
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Assignment_1 obj = new Assignment_1();
//		obj.setup();
//		obj.question1();
//		obj.question2();
//		obj.question3();
//		obj.question4();
		obj.question5();
		
		
		
		obj.driver.close();

	}

}
