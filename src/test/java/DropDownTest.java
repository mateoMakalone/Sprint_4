import org.junit.Test;
import model.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class DropDownTest {
    private WebDriver driver;
    private final String  firstElementText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String LastElementText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

      @Before    //Запуск теста в Chrome
      public void setUp() {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      driver = new ChromeDriver(options);
      driver.get("https://qa-scooter.praktikum-services.ru/");
      }
//      @Before   //Запуск теста в Firefox
//      public void setUp() {
//          WebDriverManager.firefoxdriver().setup();
//          driver = new FirefoxDriver();
//          driver.get("https://qa-scooter.praktikum-services.ru/");
//        }

    @Test
    public void dropDownFirstElementTextCheck(){
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptAllCookie();
        mainPage.aboutImportantBlockScroll();
        mainPage.clickFirtsQuestion();
        mainPage.checkFirstQuestionText();
        Assert.assertEquals(firstElementText, mainPage.checkFirstQuestionText());
    }
    @Test
    public void dropDownLastElementTextCheck(){
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptAllCookie();
        mainPage.aboutImportantBlockScroll();
        mainPage.clickLastQuestion();
        mainPage.checkLastQuestionText();
        Assert.assertEquals(LastElementText, mainPage.checkLastQuestionText());
    }
    @After
    public void tearDowm(){
        driver.quit();
    }
}
