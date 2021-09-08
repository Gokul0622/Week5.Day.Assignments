package nykkaProject;

import java.awt.Desktop.Action;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String parentWindowHandle = driver.getWindowHandle();

		WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(Brands).perform();

		WebElement PopularBrands = driver.findElement(By.xpath("//a[text()='Popular']"));
		Actions popular = new Actions(driver);
		popular.moveToElement(PopularBrands).perform();

		WebElement BrandName = driver
				.findElement(By.xpath("//header[@class='css-bxqdqd e1e0j9zy0']//li[5]//a[1]//img[1]"));
		BrandName.click();

		Set<String> WindowHandles = driver.getWindowHandles();
		for (String NewWindows : WindowHandles) {
			driver.switchTo().window(NewWindows);

		}
		String NewWindowsTitle = driver.getTitle();
		System.out.println(NewWindowsTitle);

		WebElement SortBy = driver.findElement(By.xpath("//div[@class='sort-btn clearfix']"));
		SortBy.click();
		WebElement CustomRated = driver
				.findElement(By.xpath("(//div[@class='control control--radio text-capitalize'])[4]"));
		CustomRated.click();

		WebElement Category = driver.findElement(By.xpath("//div[text()='Category']"));
		Category.click();

		WebElement Hair = driver.findElement(By.xpath("(//div[@class='category-wrap-top']/li)[1]"));
		Hair.click();

		WebElement HairCare = driver.findElement(By.xpath("(//span[text()='Hair Care'])[1]"));
		HairCare.click();

		WebElement Shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		Shampoo.click();

		WebElement ColorProtectShampoo = driver
				.findElement(By.xpath("(//div[@class='col-xs-12 card-img-container '])[11]"));
		ColorProtectShampoo.click();
		Thread.sleep(2000);
		Set<String> ChildWindow = driver.getWindowHandles();
		for (String NextTab : ChildWindow) {
			driver.switchTo().window(NextTab);

		}
		Thread.sleep(2000);
		WebElement SelectMl = driver.findElement(By.xpath("(//span[@class='size-pallets'])[1]"));
		SelectMl.click();
		String Price = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
		System.out.println("Price of the ColorProtectShampoois " + Price);

		driver.findElement(By.xpath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag "
				+ "nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]")).click();

		driver.findElement(By.xpath("//div[contains(@class,'action-text')]")).click();
		Thread.sleep(2000);
		Set<String> ProceedWindow2 = driver.getWindowHandles();
		for (String NewTab : ProceedWindow2) {
			driver.switchTo().window(NewTab);
		}
		driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(2000);
		String ActualPrice = driver.findElement(By.xpath("//span[@class='actual-price']")).getText();
		if (Price.equals(ActualPrice))
			System.out.println("Grand Total Matched");
		else
			System.out.println("Grand Total Not  Matched");
		driver.close();
	}

}
