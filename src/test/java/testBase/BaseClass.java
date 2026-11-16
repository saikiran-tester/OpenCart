package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	//public static WebDriver driver;
	public Logger logger;
	//public Logger logger = LogManager.getLogger(getClass());
	public Properties p;
	
	@Parameters({"OS", "browser"})
	@BeforeClass(groups = {"sanity","regression","master"})
	//@BeforeTest(alwaysRun = true)
	public void setup(String os, String br) throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("./src//test/resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities cap = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("window"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				
				System.out.println("No matching od found");
				return;
			}
			
			//browser
			
			switch(br)
			{
			case"chrome" : cap.setBrowserName("chrome"); break;
			case "edge" : cap.setBrowserName("edge");break;
			default : System.out.println("Invalid browser..."); return;
	
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			Thread.sleep(15000);
			System.out.println("Grid session for " + getClass().getSimpleName()
			        + " = " + ((RemoteWebDriver) driver).getSessionId());
			
		}
	
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			
			switch(br.toLowerCase())
			{
			case "chrome" : driver= new ChromeDriver(); break;
			case "edge" : driver= new EdgeDriver(); break;
			default : System.out.println("Invalid browser..."); return;
		
			}
		}
		

		
		driver.get(p.getProperty("url"));	//reading file from config.properties	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
		driver.manage().window().maximize();
		
		
		
	}
	
	@AfterClass(groups = {"sanity","regression","master"})
	//@AfterTest(alwaysRun = true)
	public void tearDown()
	{
		
		    driver.quit();
		
	}
	
	@SuppressWarnings("deprecation")
	public String radomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generatedNumberic = RandomStringUtils.randomNumeric(10);
		return generatedNumberic;
	}
	
	@SuppressWarnings("deprecation")
	public  String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumberic = RandomStringUtils.randomNumeric(3);
		return (generatedString+generatedNumberic);
	}
	
	
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

	    Path screenshotFolder = Paths.get(System.getProperty("user.dir"), "screenshots");
	    Files.createDirectories(screenshotFolder);

	    Path targetFilePath = screenshotFolder.resolve(tname + "_" + timeStamp + ".png");

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    Files.move(sourceFile.toPath(), targetFilePath);

	    return targetFilePath.toString();
	}

}
