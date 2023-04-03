package actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.BaseClass;
import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;

public class AlertPopupHandlingTest extends BaseClass {
	@Test
	public void alertHandling() throws EncryptedDocumentException, IOException {
		String expmsg="Are you sure you want to cancel the Type of Work creation?";
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelsheet("Sheet3",2,1));
		driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
		String msg=cu.getAlertMsg(driver);
		Reporter.log(msg,true);
		cu.alertOk(driver);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(expmsg,msg);
		System.out.println("alert is TC pass");
		sa.assertAll();
		
	}

}











