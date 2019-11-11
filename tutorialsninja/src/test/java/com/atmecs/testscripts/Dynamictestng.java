package com.atmecs.testscripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Dynamictestng {
	@SuppressWarnings("deprecation")
	public void suite_test() {
		String[] browser = { "chrome", "firefox", "ie" };
		String[] url = { /*urlname*/};
		int testname=0;
		XmlClass publictestclass;

		List<String> browsernames = new ArrayList<String>();
		List<String> urlnames = new ArrayList<String>();
		for (String browsername : browser) {
			browsernames.add(browsername);
		}
		for (String urlname : url) {
			urlnames.add(urlname);
		}
		XmlSuite xmlsuite = new XmlSuite();
		xmlsuite.setParallel("tests");
		xmlsuite.setThreadCount(browsernames.size());
		List<XmlSuite> suite = new ArrayList<XmlSuite>();
		Map<String, String> passingparameter = new HashMap<String, String>();
		List<XmlClass> xmlclass = new ArrayList<XmlClass>();
	
		for (String uname : urlnames) {
			for (String bname : browsernames) {
				XmlTest xmltest = new XmlTest(xmlsuite);
				passingparameter.put("browser", bname);
				System.out.println(bname);
				passingparameter.put("url", uname);
				System.out.println(uname);
				xmltest.setParameters(passingparameter);
				xmltest.setThreadCount(3);
				xmltest.setName(bname+testname);
				testname++;
				if(uname==url[1]) {
				 publictestclass = new XmlClass(/* classname 1*/);
				}
				else
				{
					 publictestclass = new XmlClass(/* classname 2*/);
				}
		System.out.println(publictestclass);
				xmlclass.add(publictestclass);
				xmltest.setXmlClasses(xmlclass);
			}
		}
		TestNG testng = new TestNG();

		suite.add(xmlsuite);
		testng.setXmlSuites(suite);
		testng.run();

	}

}
