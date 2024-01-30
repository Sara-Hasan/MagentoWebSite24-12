package magentoWebSiteg;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	
	Random rand = new Random();
	String[] FirstNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};

	String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	
	String CommonPassword = "asd123!@#$";
	
	int randomIndex = rand.nextInt(10);
	int randomEmailId = rand.nextInt(9999);
	
	String EmailId = FirstNames[randomIndex]+lastNames[randomIndex]+randomEmailId+"@"+"gmail.com";

}
