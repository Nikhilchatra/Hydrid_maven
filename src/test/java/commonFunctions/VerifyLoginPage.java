package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class VerifyLoginPage {
	WebDriver driver;
	public VerifyLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtusername;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogn;
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement btnLogout;
	

	public void Setusername(String uname) throws Throwable{
		txtusername.sendKeys(uname);
	}

	public void Setpassword(String pwd)throws Throwable {
		txtpassword.sendKeys(pwd);
	}

	public void ClickLogin() throws Throwable{
		btnLogn.click();
	}
	public void ClickLogout()throws Throwable{
		btnLogout.click();
	}

}



