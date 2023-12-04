package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class fetchHomePageNews extends Base
{
	public static void fetchNews()
	{
		System.out.println();
		System.out.println("Home Page");
		By mainHeading = By.xpath("//span[text()='be.cognizant']");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(mainHeading)));
		

		if(driver.findElement(mainHeading).getText().equals("be.cognizant"))
		{
			System.out.println("Landed to Be Cognizant");
		}
		else
		{
			System.out.println("Landed to a different Page");
		}


		driver.findElement(By.xpath("//*[@id='O365_HeaderRightRegion']")).click(); //Click DS Logo
		System.out.println("Finding Name");
		WebElement name=driver.findElement(By.id("mectrl_currentAccount_primary")); //Get Name
		String nam=name.getText();
		System.out.println(nam);

		System.out.println("Finding Employee"); //Get Email
		WebElement empl=driver.findElement(By.id("mectrl_currentAccount_secondary"));
		String emp=empl.getText();
		System.out.println(emp);

		System.out.println();
		WebElement ardCog = driver.findElement(By.xpath("//span[contains(text(),'Around Cognizant')]")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ardCog);//To scroll to Around Cognizant 
		if(ardCog.getText().equals("Around Cognizant"))
		{
			System.out.println("Around Cognizant News is being displayed:");
		}
		else
		{
			System.out.println("Around Cognizant News is not displayed:");
		}

		newsElement= driver.findElements(By.xpath("//a[@data-automation-id=\"newsItemTitle\"]"));


		for(int i =0; i < newsElement.size(); i++)
		{
			matchh.add(newsElement.get(i).getAttribute("aria-label"));
			toolTip.add(newsElement.get(i).getAttribute("title"));
			heading.add(newsElement.get(i).getText());
		}

		//Matching Tool tip and Heading
		ArrayList<String> al = new ArrayList<String>();
		System.out.println();
		int start = newsElement.size()-4;
		int ct=1;
		for(int i = start; i < newsElement.size(); i++)
		{
			if(matchh.get(i).equals(toolTip.get(i)))
			{
				System.out.println(ct+") ToolTip verified for "+matchh.get(i));
				al.add(matchh.get(i));
			}
			else
			{
				System.out.println(ct+") ToolTip wrong for "+matchh.get(i));
			}

			if(matchh.get(i).equals(heading.get(i)))
			{
				System.out.println(ct+") Heading verified for "+matchh.get(i));
			}
			else
			{
				System.out.println(ct+") Heading wrong for "+matchh.get(i));
			}
			ct++;
		}

		//Displaying News Content
		System.out.println();
		List<WebElement> newsElementDesc= driver.findElements(By.xpath("//a[@data-automation-id=\"newsItemTitle\"]/following-sibling::div[1]"));
		System.out.println();
		System.out.println("News and the corresponding Tool Tip");
		Base.list=new ArrayList<String>();
		for(int i = 0; i < newsElementDesc.size();i++)
		{
			System.out.println((i+1)+") News: "+newsElementDesc.get(i).getText());
			Base.list.add(newsElementDesc.get(i).getText());
		}
		System.out.println();

		//Clicking on See all
		WebElement seeAll = driver.findElement(By.xpath("//span[@class=\"fontSizeMedium\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeAll);//To scroll to Around Cognizant 
		seeAll.click();
		System.out.println("Clicked on See all");
	}
}