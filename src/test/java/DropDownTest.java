import org.junit.Test;
import model.MainPage;
import static model.MainPage.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class DropDownTest {
    private WebDriver driver;
    private final String checkedText;
    private final By questionField;
    private final By responseField;

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
    public DropDownTest(By questionField,By responseField, String checkedText){
        this.questionField = questionField;
        this.responseField = responseField;
        this.checkedText = checkedText;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
        {DROP_DOWN_LIST_0, DROP_DOWN_TEXT_0 ,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
        {DROP_DOWN_LIST_1, DROP_DOWN_TEXT_1 ,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
        {DROP_DOWN_LIST_2, DROP_DOWN_TEXT_2 ,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
        {DROP_DOWN_LIST_3, DROP_DOWN_TEXT_3 ,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
        {DROP_DOWN_LIST_4, DROP_DOWN_TEXT_4 ,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
        {DROP_DOWN_LIST_5, DROP_DOWN_TEXT_5 ,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
        {DROP_DOWN_LIST_6, DROP_DOWN_TEXT_6 ,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
        {DROP_DOWN_LIST_7, DROP_DOWN_TEXT_7 ,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void AboutImportantDropDownElementTextCheck(){
    MainPage mainPage = new MainPage(driver);
    mainPage.acceptAllCookie();
    mainPage.aboutImportantBlockScroll();
    mainPage.clickQuestionField(questionField);
    String actual = mainPage.checkResponseText(responseField, checkedText);
    Assert.assertEquals("Некорректный текст ответа!", checkedText, actual);
    }
    @After
    public void tearDowm(){
        driver.quit();
    }
}
