package TestSuite;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.fetchHomePageNews;
import Pages.fetchTopFiveNews;
import Pages.matchAllNews;
import io.netty.handler.timeout.TimeoutException;


public class AllTest {

	@BeforeSuite
	public void driverCall()
	{

		Base.driverSetup();
		Base.openUrl();
	}

//	@AfterSuite
//	public void driverClose()
//	{
//		Base.closeBrowser();
//	}



	//First Case
	@Test(priority=1)
	public void testOne()
	{
		fetchHomePageNews.fetchNews();
	}

	//Second Case
	@Test(priority=2)
	public void testTwo() throws InterruptedException ,IOException, TimeoutException, BrokenBarrierException
	{
//		matchAllNews.matchAllNewsContent();
		fetchTopFiveNews.checkNews();
	}

	//Third Case
	@Test(priority=3)
	public void testThree() throws InterruptedException, IOException, TimeoutException, BrokenBarrierException
	{
		fetchTopFiveNews.topFiveNews();
	}

}