package AddToBasket;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToBasket
{
    WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    @BeforeTest
    public void checkdriverChrome()
    {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com.tr");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void searchElement()
    {
        driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")).sendKeys("GittiGidiyor");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
    }

    @Test(priority = 2)
    public void clickWebSite()
    {
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div")).click();
    }
    @Test(priority = 3)
    public void writeProduct ()
    {
        WebElement writeProduct = driver.findElement(By.xpath("//input[@placeholder='Aklına gelenler kapına gelsin']"));
        writeProduct.click();
        writeProduct.sendKeys("MacBook Pro");
    }

    @Test(priority = 4)
    public void searchProduct()
    {
        driver.findElement(By.xpath("//span[contains(text(), 'BUL')]")).click();
    }

    @Test(priority = 5)
    public void enterProductDetail()
    {
        driver.findElement(By.id("item-info-block-633602581")).click();
    }

    @Test(priority = 6)
    public void addToBasket()
    {
        ((JavascriptExecutor) driver).executeScript("scroll(0, 400);");
        driver.findElement(By.id("add-to-basket")).click();
    }

    @Test(priority = 7)
    public void myBasket()
    {
        driver.findElement(By.xpath("//span[contains(text(),'Sepet')]")).click();
    }

    @Test(priority = 8)
    public void enterBasket()
    {
        driver.findElement(By.xpath("//*[@id=\"cart-continue-button-container\"]/input")).click();
    }

    @Test(priority = 9)
    public void continueWithoutUser()
    {
        WebElement enterUsername =  driver.findElement(By.id("continueWithoutUser"));
        enterUsername.click();
    }

    @Test(priority = 10)
    public void enterEmail()
    {
        WebElement enterEmail = driver.findElement(By.name("email"));
        enterEmail.click();
        enterEmail.sendKeys("hakan.ozcan44@hotmail.com");
    }

    @Test(priority = 11)
    public void enterPhone()
    {
        WebElement enterPhone =  driver.findElement(By.name("phone-number"));
        enterPhone.click();
        enterPhone.sendKeys("5343243534");
    }

    @Test(priority = 12)
    public void enterName()
    {
        WebElement enterName = driver.findElement(By.name("name"));
        enterName.click();
        enterName.sendKeys("Hakan");
    }

    @Test(priority = 13)
    public void enterSurname()
    {
        WebElement enterPhone = driver.findElement(By.name("surname"));
        enterPhone.click();
        enterPhone.sendKeys("Ozcan");
    }

    @Test(priority = 12)
    public void chooseCity()
    {
        Select city = new Select(driver.findElement(By.name("cityId")));
        city.selectByValue("34");
    }

    @Test(priority = 13)
    public void chooseDistinct()
    {
        Select chooseDistinct = new Select(driver.findElement(By.name("countyId")));
        chooseDistinct.selectByValue("447");
    }

    @Test(priority = 14)
    public void chooseNeighborhood()
    {
        ((JavascriptExecutor) driver).executeScript("scroll(0, 300);");
        Select chooseNeighborhood = new Select(driver.findElement(By.name("neighborhoodId")));
        chooseNeighborhood.selectByValue("35642");
    }

    @Test(priority = 15)
    public void enterAddress()
    {
        WebElement enterAddress = driver.findElement(By.name("address"));
        enterAddress.click();
        enterAddress.sendKeys("Kaya Caddesi Kıraç Sokak No:1 Daire:1");
    }

    @Test(priority = 16)
    public void enterZipCode()
    {
        WebElement zipCode =  driver.findElement(By.name("zipCode"));
        zipCode.click();
        zipCode.sendKeys("45678");
    }

    @Test(priority = 16)
    public void continuePayment()
    {
        WebElement continuePayment =  driver.findElement(By.id("post-address-form"));
        continuePayment.click();
    }

    @Test(priority = 17)
    public void closeBrowser()
    {
        driver.close();
    }

}