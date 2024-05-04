import java.io.File;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class navigationTests
{
	final String HOMEPAGE_PATH = "homepage/homepage.html";
	final String LOGIN_PATH = "login-page/Login.html";
	final String REGISTER_PATH = "login-page/Register.html";
	final String MATERIAL_PATH = "material-page/material-page.html";
	final String PRODUCT_PATH = "product-page/product-page.html";
	final String SETTING_PATH = "setting-page/settingpage.html";
	final String TRANSACTION_PATH = "transaction/transaction.html";

	@Test
	@DisplayName("Navigate from login page to home page")
	void test_SuccessfulLoginPageToHomePage() {
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(LOGIN_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement signIn = driver.findElement(By.className("signinButton"));
		signIn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(HOMEPAGE_PATH));
		driver.quit();
	}

	@Test
	@DisplayName("Navigate from login page to registration page")
	void test_SuccessfulLoginPageToRegistrationPage(){
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(LOGIN_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(REGISTER_PATH));
		driver.quit();
	}

	@Test
	@DisplayName("Navigate from home page to transactions page")
	void test_SuccessfulHomePageToTransactionsPage(){
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(HOMEPAGE_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement transactions = driver.findElement(By.linkText("Transactions"));
		transactions.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(TRANSACTION_PATH));
		driver.quit();
	}

	@Test
	@DisplayName("Navigate from home page to materials page")
	void test_SuccessfulHomePageToMaterialsPage(){
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(HOMEPAGE_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement materials = driver.findElement(By.linkText("Materials"));
		materials.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(MATERIAL_PATH));
		driver.quit();
	}

	@Test
	@DisplayName("Navigate from home page to products page")
	void test_SuccessfulHomePageToProductsPage(){
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(HOMEPAGE_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement products = driver.findElement(By.linkText("Products"));
		products.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(PRODUCT_PATH));
		driver.quit();
	}

	@Test
	@DisplayName("Navigate from home page to profile and settings page")
	void test_SuccessfulHomePageToProfileSettingsPage(){
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(HOMEPAGE_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement profile_and_settings = driver.findElement(By.partialLinkText("Profile and Settings"));
		profile_and_settings.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(SETTING_PATH));
		driver.quit();
	}

	@Test
	@DisplayName("Sign out")
	void test_SuccessfulSignOut(){
		WebDriver driver = new ChromeDriver();
		driver.get(util.webPagePath(SETTING_PATH));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement signout = driver.findElement(By.className("signOutOption"));
		signout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		assertEquals(util.getLastSubDirectory(driver.getCurrentUrl()), util.getLastSubDirectory(LOGIN_PATH));
		driver.quit();
	}
}