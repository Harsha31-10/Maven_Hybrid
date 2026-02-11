package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MainClass {
	
	public WebDriver driver;
	
	public Properties pr;	
	
	@BeforeClass
	
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) throws IOException
	{
		
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		
		pr = new Properties();
		
		pr.load(file);
		
		switch (browser)
		{
		  case "chrome" : driver = new ChromeDriver(); 
		  break;
		  
		  case "edge" : driver = new EdgeDriver();
		  break;

		default: System.out.println("Invalid Browser");
			return;
		}
		
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(pr.getProperty("url"));
				
		driver.manage().window().maximize();
		
	}
	
	
	
	@AfterClass
	public void closing() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.quit();
	}

}
