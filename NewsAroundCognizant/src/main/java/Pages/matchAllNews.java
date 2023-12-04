package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.Base;

public class matchAllNews extends Base
{

	@SuppressWarnings("deprecation")
	public static void matchAllNewsContent() throws InterruptedException
	{

		System.out.println();
		//Clicking News
		//		driver.findElement(By.xpath("//*[@id=\"spPageChromeAppDiv\"]/div[2]/div[3]/section/article/div/div/div/div/div/div/div/div[1]/div/span"));
		//		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

		System.out.println("See All News");

		List<String> allNewsHeading = new ArrayList<String>();

		//Storing All Content
		for(int i=1; i < 50 ;i++)
		{

			String XPATH = "(//a[@data-automation-id='newsItemTitle'])["+i+"]";
			String var = driver.findElement(By.xpath(XPATH)).getText();
			//			System.out.println(var);
			allNewsHeading.add(var);
			driver.findElement(By.xpath(XPATH)).sendKeys(Keys.DOWN);
		}

		System.out.println(allNewsHeading);
		System.out.println("Verifying all news items are present in the current page or not");

		int flag =1;
		for(int i = start; i < newsElement.size();i++)
		{

			if(allNewsHeading.contains(matchh.get(i)))
			{
				System.out.println((i+1)+") ' "+matchh.get(i)+" ' is present.");
			}
			else
			{
				System.out.println((i+1)+") ' "+matchh.get(i)+" ' is missing.");
				flag = 0;
			}
		}
		System.out.println();

		if(flag ==1)
		{
			System.out.println("All news items are present.");
		}
		else
		{
			System.out.println("Some of the news items as mentioned above are missing.");
		}	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}
}


































//_____________________________________________________________OTHER WAY___________________________________________________________________________________________________

//package Pages;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Base.Base;
//public class matchAllNews extends Base
//{
//
//	@SuppressWarnings("deprecation")
//	public static void matchAllNewsContent() throws InterruptedException
//	{
//
//		System.out.println();
//		System.out.println("See All News");
//
//		List<WebElement> allNews = new ArrayList<WebElement>();
//		List<String> allNewsMatch = new ArrayList<String>(); 
//		List<String> allNewsToolTip = new ArrayList<String>(); 
//		List<String> allNewsHeading = new ArrayList<String>();
//
//		//Storing All Content
//		for(int i=1; i < 8;i++)
//		{
//			int j=0;
//			WebElement l ;
//
//			for(j = 1; j < 8;j++)
//			{
//				//Store visible element
//				String XPATH = "//*[@id='spPageChromeAppDiv']/div[2]/div[3]/section/article/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div["+i+"]/div["+j+"]/div/div/div/div/div[2]/div[1]/a";
////				System.out.println(XPATH);
//				l = driver.findElement(By.xpath("//*[@id='spPageChromeAppDiv']/div[2]/div[3]/section/article/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div["+i+"]/div["+j+"]/div/div/div/div/div[2]/div[1]/a"));
//				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//				System.out.println(l.getText());
////				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//				allNews.add(l);
//				allNewsMatch.add(l.getAttribute("aria-label"));
////				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//				allNewsToolTip.add(l.getAttribute("title"));
////				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//				allNewsHeading.add(l.getText());
////				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//			}
//
//			String scrollTill="//*[@id='spPageChromeAppDiv']/div[2]/div[3]/section/article/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div["+i+"]/div["+(j-1)+"]/div/div/div/div/div[2]/div[1]/a";
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180));
//			WebElement NewsPage=driver.findElement(By.xpath(scrollTill));
////			JavascriptExecutor js = (JavascriptExecutor) driver;
//			Actions ac = new Actions(driver);
//			ac.moveToElement(NewsPage).build().perform();
////			js.executeScript("arguments[0]", NewsPage);
//			wait.until(ExpectedConditions.visibilityOf(NewsPage));
//			//This will scroll the page till the element is found	
//
//
//			System.out.println("Fteching the data: ");
//		}
//
//		System.out.println(allNewsMatch);
//		System.out.println("Verifying all news items are present in the current page or not");
//
//		int flag =1;
//		for(int i = start; i < newsElement.size();i++)
//		{
//
//			if(allNewsMatch.contains(matchh.get(i)))
//			{
//				System.out.println((i+1)+") ' "+matchh.get(i)+" ' is present.");
//			}
//			else
//			{
//				System.out.println((i+1)+") ' "+matchh.get(i)+" ' is missing.");
//				flag = 0;
//			}
//		}
//		System.out.println();
//
//		if(flag ==1)
//		{
//			System.out.println("All news items are present.");
//		}
//		else
//		{
//			System.out.println("Some of the news items as mentioned above are missing.");
//		}
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
//	}
//}