package actitime.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.BaseClass;
import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;
@Listeners(actitime.genericLib.ListenerImplementation.class)
public class CustomerCreation extends BaseClass{
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		int num=cu.getRandomNum(10000);
		String customername=du.getDataFromExcelsheet("Sheet3", 0, 1);
		customername=customername+num;
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustome")).click();
		driver.findElement(By.className("newNameField")).sendKeys(customername);
		driver.findElement(By.cssSelector
				("[placeholder='Enter Customer Description']")).sendKeys("testing");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		cu.gettextTobePresentInElementLocated(driver,By.cssSelector
				(".titleEditButtonContainer>.title"), customername);
		String actualcustomername=driver.findElement
				(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		Reporter.log(actualcustomername,true);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(customername, actualcustomername);
		
		System.out.println("customer is TC pass");
		sa.assertAll();
		
	}

}











