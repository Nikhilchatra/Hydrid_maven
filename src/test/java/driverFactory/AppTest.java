package driverFactory;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import commonFunctions.VerifyLoginPage;
import constant.AppUtil;
import utilites.ExcelFileUtil;
public class AppTest extends AppUtil{
	
	String inputpath ="D:\\selinium_practice\\DDT_Project\\TestInput\\testdata.xlsx";
    String outpupath ="D:\\selinium_practice\\DDT_Project\\TestOutput\\YahooDataResults.xlsx";
   
    @Test(dataProvider="DemoGuruData")
	public void loginDDT(String username,String psd) throws Throwable {
	VerifyLoginPage lp=new VerifyLoginPage(driver);
		lp.Setusername(username);
		lp.Setpassword(psd);
		lp.ClickLogin();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
			else
			{
				Assert.assertFalse(true);
				lp.ClickLogout();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
		}
    public boolean isAlertPresent()throws Throwable {
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
		return false;
	}
		}
    
}
