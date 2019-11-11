package com.atmecs.tutorialsninja.scriptbase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.tutorialsninja.helper.PropertiesFileReader;
import com.atmecs.tutorialsninja.utils.AssertionAndValidationManager;
import com.atmecs.tutorialsninja.utils.UtilityFiles;
import com.atmecs.tutorialsninja.utils.WaitsandSimpleAlert;

public class HotSaucebase {
	public Logger log = Logger.getLogger("Testbase files");
	private PropertiesFileReader propertyreader = new PropertiesFileReader();
	public WaitsandSimpleAlert wait = new WaitsandSimpleAlert();
	public UtilityFiles utils = new UtilityFiles();
	private AssertionAndValidationManager assertandvalidate = new AssertionAndValidationManager();
	
	String actual,expected;
	public void movetoelement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);

		action.moveToElement(utils.findelement(driver, locator)).build().perform();
		log.info("Action performs");

	}
		public void buying_product(WebDriver driver) {

			actual = utils.expectedresult(driver, propertyreader.getLocatorValue("loc.viewing.mens"), 0, 12);
			expected = assertandvalidate.getdataval("HotSauce", "Validation", 1);

			assertandvalidate.assertequals(actual, expected);

			utils.click(driver, propertyreader.getLocatorValue("loc.buynow.habanero"));

			utils.click(driver, propertyreader.getLocatorValue("loc.select.redcolor"));

			utils.click(driver, propertyreader.getLocatorValue("loc.select.malesize"));

			String name = assertandvalidate.getdataval("HotSauce", "Validation", 2);

			utils.sendkeys(driver, propertyreader.getLocatorValue("loc.select.personalizedname"), name);

			utils.click(driver, propertyreader.getLocatorValue("loc.select.buynow"));

	}
	public void check_out(WebDriver driver) {
		utils.click(driver, propertyreader.getLocatorValue("loc.select.cartlink"));

		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.pname"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 1);
		
		assertandvalidate.assertequals(actual, expected);

		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.psize"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 2);
		
		assertandvalidate.assertequals(actual, expected);
		
		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.ppersonname"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 3);
		
		assertandvalidate.assertequals(actual, expected);

		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.pcolor"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 4);

		assertandvalidate.assertequals(actual, expected);
		
		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.price"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 5);

		assertandvalidate.assertequals(actual, expected);

		actual = utils.getActual(driver, propertyreader.getLocatorValue("loc.cartlink.totalprice"));
		expected = assertandvalidate.getdataval("HotSauce", "CartValidation", 6);

		assertandvalidate.assertequals(actual, expected);
		
		
	}


}
