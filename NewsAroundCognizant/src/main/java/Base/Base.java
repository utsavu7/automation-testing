package Base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	protected static List<String> list;
	public static List<String> matchh = new ArrayList<String>();
	public static List<String> toolTip = new ArrayList<String>();
	public static List<String> heading = new ArrayList<String>();
	public static List<WebElement> newsElement = new ArrayList<WebElement>();
	public static int start;

	public static WebDriver driver;
	public static Properties prop;

	public static void driverSetup() {

		prop = new Properties();
		try {
			prop.load(new FileInputStream("C:\\Users\\2272755\\Downloads\\Main_Project_Final (1)\\Main_Project_Final\\NewsAroundCognizant\\src\\main\\java\\Config\\Config.properties")); // Loading the properties
		} catch (Exception e) {
			e.printStackTrace();
		}


		//Launching Drivers
		/*if (prop.getProperty("browserName").matches("chrome")) {
			System.setProperty("WebDriver.driver","Drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if (prop.getProperty("browserName").matches("firefox")) {
			System.setProperty("WebDriver.driver","Drivers/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		else {
			System.out.println("Unable to launch driver");
		}*/
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\2272755\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();// To maximize the window
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Driver Launched:");


	}



	public static void openUrl() // Method to open URL for smoke test
	{
		driver.get(prop.getProperty("url"));
		System.out.println("Page Launched:");
	}


	public static void closeBrowser() // method to close the browser
	{
		System.out.println("Chrome Driver Closed:");
		driver.quit(); // To close the browser
	}

}