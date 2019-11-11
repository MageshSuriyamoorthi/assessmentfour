package com.atmecs.testscripts;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.tutorialsninja.scriptbase.HotSaucebase;
import com.atmecs.tutorialsninja.testbase.TestSuiteBase;
import com.atmecs.tutorialsninja.utils.AssertionAndValidationManager;

public class HotSauce extends TestSuiteBase {
	private AssertionAndValidationManager assertandvalidate = new AssertionAndValidationManager();
	private HotSaucebase base = new HotSaucebase();
	List<WebElement> list;
	String value,actual,expected;

	@BeforeClass
	public void open_Url() {

		utils.geturl(driver, propertyreader.getLocatorValue("config.url_two"));
		utils.maximize(driver);
	}

	@Test(priority = 0)
	public void home_page() {
		Actions action = new Actions(driver);

		list = utils.findelements(driver, propertyreader.getLocatorValue("loc.menu.alltabs"));
		for (int mouseover = 1; mouseover <= list.size(); mouseover++) {
			action.moveToElement(utils.replace(driver, propertyreader.getLocatorValue("loc.menu.tabs"), mouseover))
					.build().perform();
		}
		action.moveToElement(utils.findelement(driver, propertyreader.getLocatorValue("loc.merchandise.tab"))).build()
				.perform();
		WebElement element = utils.findelement(driver, propertyreader.getLocatorValue("loc.merchandise.mens"));

		action.click(element).perform();
		
		base.buying_product(driver);	
		
		base.check_out(driver);
	
		utils.click(driver, propertyreader.getLocatorValue("loc.cartlink.add"));
		
		utils.sendkey(driver, propertyreader.getLocatorValue("loc.cartlink.update"), Keys.DELETE);
		
		value=assertandvalidate.getdataval("HotSauce", "CartValidation", 8);
		
		utils.sendkeys(driver, propertyreader.getLocatorValue("loc.cartlink.add"), value);
		
		wait.ThreadWait(4000);
		
		utils.click(driver, propertyreader.getLocatorValue("loc.cartlink.update"));
		
		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.price"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 5);

		assertandvalidate.assertequals(actual, expected);

		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.totalprice"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 7);

		assertandvalidate.assertequals(actual, expected);

	}
}
