package magentoWebSiteg;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Parameters{
	
	WebDriver driver = new ChromeDriver();
	@BeforeTest

	public void mySetup() {

	}

	@Test(priority = 1)
	public void myFirstTest() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));		
//		driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
		
//		driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
		
		driver.findElement(By.linkText("Create an Account")).click();
		
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		
		//Interact with Elements
		FirstName.sendKeys(FirstNames[randomIndex]);
		LastName.sendKeys(lastNames[randomIndex]);
		Email.sendKeys(EmailId);
		Password.sendKeys(CommonPassword);
		ConfirmPassword.sendKeys(CommonPassword);
		
		WebElement CreateAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
		
		
		CreateAccountButton.click();
		String WelcomeMsg = driver.findElement(By.className("message-success")).getText();
		
		assertEquals(WelcomeMsg, "Thank you for registering with Main Website Store.");
	}
	
	@Test(priority = 2)
	public void LogoutProcess() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		
		System.out.println(driver.getCurrentUrl());
		
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
	}
	@Test(priority = 3)
	public void LoginProcess() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(EmailId);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		
		driver.findElement(By.id("send2")).click();
		
		
		Thread.sleep(3000);
		String WelcomeMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		
		assertEquals(WelcomeMsg.contains("Welcome"), true);
	}
	
	@Test(priority = 4)
	public void addOneRandomItem() {
		
		driver.get("https://magento.softwaretestingboard.com/");
//		driver.manage().window().maximize();
//		
//		WebElement Footer = driver.findElement(By.cssSelector(".footer.content"));
//		
//		
//		int TheNumberOfTagA = Footer.findElements(By.tagName("a")).size();	
//		System.out.println(TheNumberOfTagA);
		
		WebElement ItemsContainer= driver.findElement(By.cssSelector(".product-items.widget-product-grid"));	
		
		int numberOfItem = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(numberOfItem);
		
		int randomItemToSelect = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		
		WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int thesizes = sizesContainer.findElements (By.className("swatch-option")).size();
		
//		System.out.println(thesizes);
		sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(thesizes)).click();
		
		
		
		WebElement colorContainer = driver.findElement(By.cssSelector(".swatch-attribute .color"));
		int thecolor = colorContainer.findElements (By.className("color")).size();
		
//		System.out.println(thesizes);
		colorContainer.findElements(By.className("color")).get(rand.nextInt(thesizes)).click();
		
	}
	
	
}

