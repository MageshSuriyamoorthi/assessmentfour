package com.atmecs.testscripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.tutorialsninja.scriptbase.TutorialsNinjaHomePageBase;
import com.atmecs.tutorialsninja.testbase.TestSuiteBase;
import com.atmecs.tutorialsninja.utils.AssertionAndValidationManager;

public class TutorialsNinjaHomePage extends TestSuiteBase {
	private TutorialsNinjaHomePageBase base = new TutorialsNinjaHomePageBase();
	private AssertionAndValidationManager assertandvalidate = new AssertionAndValidationManager();

	String getactual_title, getexpected_title;

	@BeforeClass
	public void open_Url() {

		utils.geturl(driver, propertyreader.getLocatorValue("config.url_one"));
		utils.maximize(driver);
	}

	@BeforeMethod
	public void validate_HomePage() {

		getactual_title = utils.gettitle(driver);

		getexpected_title = assertandvalidate.getdataval("HomePageData", "HomepageTitle", 1);

		assertandvalidate.assertequals(getactual_title, getexpected_title);
	}

	@Test
	public void search_product() {

		base.search_product(driver, assertandvalidate.getdataval("HomePageData", "SearchList", 1));

		utils.click(driver, propertyreader.getLocatorValue("loc.image.click"));

		base.add_cart(driver, assertandvalidate.getdataval("HomePageData", "Quantity", 1));

		base.product_validation(driver, "IphoneValidation");

		utils.click(driver, propertyreader.getLocatorValue("loc.addtocart.button"));

		utils.clear(driver, propertyreader.getLocatorValue("loc.search.textbox"));

		base.search_product(driver, assertandvalidate.getdataval("HomePageData", "SearchList", 2));

		utils.click(driver, propertyreader.getLocatorValue("loc.image.click"));

		base.add_cart(driver, assertandvalidate.getdataval("HomePageData", "Quantity", 2));

		base.product_validation(driver, "MacBookValidation");

		utils.click(driver, propertyreader.getLocatorValue("loc.addtocart.button"));
		
		utils.click(driver, propertyreader.getLocatorValue("loc.home.button"));
		
		utils.click(driver, propertyreader.getLocatorValue("loc.cart.button"));
	
		base.cost_validation(driver, "MacBookValidation");

	}
}
