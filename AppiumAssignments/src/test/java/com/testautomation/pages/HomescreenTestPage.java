package com.testautomation.pages;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomescreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "homepage.btn.skip")
	private QAFWebElement skipbutton;

	

	public QAFWebElement getHomepageBtnAuthentication() {
		return skipbutton;
	}
	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user skip the authentication")
	public void closeAuth()
	{
		skipbutton.waitForVisible();
		if(skipbutton.isPresent())
		{
			skipbutton.click();
		}
	}
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
}
