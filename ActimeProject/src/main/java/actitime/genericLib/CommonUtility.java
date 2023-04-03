package actitime.genericLib;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	
	public int getRandomNum(int range)
	{
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
	}
	
	public String getAlertMsg(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		return msg;
	}
	
	public void alertOk(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public void gettextTobePresentInElementLocated(WebDriver driver,By locator,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
				(locator,text));
	}
	
	public void getselectByvisibleText(WebElement dropdown,String visibletext)
	{
		Select s=new Select(dropdown);
		s.selectByVisibleText(visibletext);
	}

}



















