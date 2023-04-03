package actitime.elementRepositiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators {
	
	public LoginLocators(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;
	
	public WebElement getUsername()
	{
		return username;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	
	
	public void loginApp(String username,String password)
	{
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		
		
	}

}









