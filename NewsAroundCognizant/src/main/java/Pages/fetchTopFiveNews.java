package Pages;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;
import io.netty.handler.timeout.TimeoutException;

public class fetchTopFiveNews extends Base{
	
	@SuppressWarnings("deprecation")
	public static void topFiveNews() throws TimeoutException, InterruptedException, BrokenBarrierException
	{

		System.out.println("Top 5 News");
		//Clicking on News
		//		driver.findElement(By.xpath("//*[@id=\"spPageChromeAppDiv\"]/div[2]/div[3]/section/article/div/div/div/div/div/div/div/div[1]/div/span")).click();
		//		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		for(int i=1;i<=5;i++)
		{   
			System.out.println("News "+i);
			

//			String XPATH = "//*[@id='spPageChromeAppDiv']/div[2]/div[3]/section/article/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[1]/div["+i+"]/div/div/div/div/div[2]/div[1]/a";
			String XPATH ="(//*[@class='ms-List-cell']//a[@data-automation-id='newsItemTitle'])["+i+"]";
			WebElement newsElement = driver.findElement(By.xpath(XPATH));
			//			System.out.println(XPATH);
			String expectedHeading=newsElement.getText();
			System.out.println("News: "+expectedHeading);
			newsElement.click();

//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180));

			WebElement NewsPage=driver.findElement(By.xpath("//div[@data-automation-id='TitleTextId']"));

//			wait.until(ExpectedConditions.visibilityOf(NewsPage));

			//Verifying Heading
			String actualHeading=NewsPage.getText();
			String actualToolTip = NewsPage.getAttribute("title");

			if(expectedHeading.equals(actualHeading)) {
				System.out.println("Heading verified for "+expectedHeading);
			}
			else {
				System.out.println("Heading not correct for "+expectedHeading);
			}

			//Verifying Tool Tip
			if(expectedHeading.equals(actualToolTip)) {
				System.out.println("ToolTip verified for "+expectedHeading);
			}
			else {
				System.out.println("ToolTip not correct for "+expectedHeading);
			}

			//Going back
			driver.navigate().back();
			System.out.println("Fetched News "+i);

		}
	}
	public static void checkNews() {
	for(int i=0;i<Base.list.size();i++) {
		String s=Base.list.get(i);
		String xpath="//a[@aria-label='"+s+"']";
		try {
			driver.findElement(By.xpath(xpath));
			System.out.println("News: "+(i+1)+" is present in see all news page");
		}
		catch(Exception e) {
			System.out.println("News: "+(i+1)+" is not present in see all news page");
		}
	}
	}
}