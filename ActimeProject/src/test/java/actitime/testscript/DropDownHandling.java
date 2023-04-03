package actitime.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class DropDownHandling extends BaseClass{
	@Test
	public void handleDropdown()
	{
		String expmsg="MODIFICATIONS NOT SAVED";
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Manage system settings')]/..")).click();
		WebElement usergroups=driver.findElement(By.id("userGroupNamingCodeSelect"));
		cu.getselectByvisibleText(usergroups,"Team");
		String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
		Reporter.log(msg,true);
		Assert.assertEquals(expmsg,msg);
		System.out.println("dropdown Tc IS Pass");
	}

}










 