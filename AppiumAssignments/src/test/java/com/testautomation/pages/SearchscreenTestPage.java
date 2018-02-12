package com.testautomation.pages;




import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;


public class SearchscreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage>
{

	public static String ProductName;
	public static String Colour;



	@FindBy(locator = "searchpage.btn.search")
	private QAFWebElement searchpagebtn;

	@FindBy(locator = "search.txt.search")
	private QAFWebElement searchpagetxtbox;

	@FindBy(locator = "search.lnk.appleipadintablets")
	private QAFWebElement clickAppleipad;

	@FindBy(locator = "search.lst.searchProduct")
	private List<QAFWebElement> searchpagelstproduct;

	@FindBy(locator = "search.btn.addtocart")
	private QAFWebElement addtocartbutton;

	@FindBy(locator = "search.link.cartverify")
	private QAFWebElement cart;



	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSearchpagetxtSearch() {
		return searchpagetxtbox;
	}

	public QAFWebElement getSearchpageBtnSearch() {
		return searchpagebtn;
	}

	public QAFWebElement getSearchpageAppleipad() 
	{
		return clickAppleipad;
	}

	public List<QAFWebElement> getSearchpagelistOfProducts() {
		return  searchpagelstproduct;
	}
	public QAFWebElement getaddtocart() {
		return  addtocartbutton;
	}

	public QAFWebElement getcartdetails() {
		return  cart;
	}


	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 * @throws InterruptedException 
	 */
	@QAFTestStep(description = "user search for {0} in search")
	public void SearchtheDetails(String item) throws InterruptedException
	{
		getSearchpageBtnSearch().click();
		getSearchpagetxtSearch().waitForVisible(1000);
		getSearchpagetxtSearch().sendKeys(item);

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user clicks on {0} in search")
	public void SelectIpadOption(String appleipad)
	{

		QAFExtendedWebElement qafExtendedWebElement = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("search.lnk.appleipadintablets"), appleipad));
		qafExtendedWebElement.waitForVisible(2000);
		qafExtendedWebElement.click();
	}


	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 * @throws Exception 
	 */
	@QAFTestStep(description = "user gets the product list")
	public void productdetails() throws Exception
	{	
		int temp= 0;
		QAFWebElement element = searchpagelstproduct.get(0);   
		searchpagelstproduct.get(0).waitForPresent(3000);

		int startx = element.getLocation().getX(); 
		int starty = element.getLocation().getY();

		for (int i=0; i<49 ;i++)
		{
			new TouchAction((AppiumDriver) new WebDriverTestBase().getDriver().getUnderLayingDriver()).press(startx+200, starty+200).waitAction(2000)
			.moveTo(startx, starty).release().perform();
		}


		for(int i=0; i<searchpagelstproduct.size()-1; i++)
		{	
			String priceFirst =searchpagelstproduct.get(i).findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText().replace("Rs.", "");
			System.out.println(priceFirst);
			int price= Integer.parseInt(priceFirst);
			if(i== 0)temp= price;	

			if(price == temp || price > temp)
			{
				element= searchpagelstproduct.get(i);
				System.out.println("inside or loop");

				ProductName =driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[1]")).getText();
				System.out.println(ProductName);

				Colour= driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).getText();
				System.out.println(Colour);

			}
			element.click();		
		}


	}





	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user clicks on addtocart button")
	public void Addtocart()
	{
		System.out.println("inside add to cart");
		addtocartbutton.waitForVisible(5000);
		addtocartbutton.click();
		addtocartbutton.waitForVisible(3000);
		addtocartbutton.click();

	}




	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verify cart")
	public void verifyCart()
	{

		System.out.println(" verify cart");

		cart.waitForPresent(6000);

		cart.verifyVisible();


	}



}
