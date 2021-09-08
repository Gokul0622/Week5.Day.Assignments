package nykkaProject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String parentWindowHandle = driver.getWindowHandle();
		// Men's Fashion
		WebElement MenBrands = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(MenBrands).perform();
		// Sports Shoes
		WebElement SportsBrands = driver.findElement(By.xpath("(//span[text()=\"Sports Shoes\"])[1]"));
		SportsBrands.click();
		String SportShoeCount = driver.findElement(By.xpath("(//span[@class=\"category-count\"])[1]")).getText();
		System.out.println(" Sports Shoes Count is " + SportShoeCount);

		WebElement TraningShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		TraningShoes.click();
		WebElement SortBy = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		SortBy.click();

		WebElement LowToHigh = driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]"));
		LowToHigh.click();

		WebElement BlueShoe = driver.findElement(By.xpath("//img[@title='VSS Blue Training Shoes']"));
		Actions Shoe = new Actions(driver);
		Shoe.moveToElement(BlueShoe).build().perform();
		WebElement QuickButton = driver.findElement(By.xpath("//div[@pogid='682897065126']"));
		QuickButton.click();

		String Price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String Discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(" Product Price and Discount : " + Price + "and " + Discount);

		WebElement Screenshot = driver.findElement(By.xpath("//img[@itemprop='image']"));
		File f = Screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("Screenshots.png"));

		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.close();
	}

}
