import model.AboutRentPage;
import model.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.OrderPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


@RunWith(Parameterized.class)
public class OrderParameterizedTest {
    private final String userName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String comment;
    private WebDriver driver;
    public OrderParameterizedTest(String userName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, String comment){
        this.userName = userName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }
    @Before     //Запуск теста в Chrome
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

//  @Before   //Запуск теста в Firefox
//  public void setUp() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.get("https://qa-scooter.praktikum-services.ru/");
//  }

        @Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Макалей", "Калкин", "Сокольническая наб. 1984", "Сокольники", "123456789123" , "20.03.2023", "Qwerty" },
                {"Виктор", "Читалкин", "Компотно-малиновая улица 12", "Сокольники", "899932165487" , "13.02.2022", "Спасибо" },
        };
    }
    @Test
    public void makeOrderWithTopButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptAllCookie();
        mainPage.clickTopOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderPage(userName,lastName,address,metroStation,phoneNumber);
        orderPage.clickNextButton();
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillRentPage(deliveryDate, comment);
        aboutRentPage.clickOrderButton();
        aboutRentPage.waitСonfirmationWindowDisplayed();
        aboutRentPage.clickAcceptOrderButton();
        Assert.assertTrue(aboutRentPage.isOrderConfirm());
    }
    @Test
    public void makeOrderWithBottomButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptAllCookie();
        mainPage.scrollToBottomOrderButton();
        mainPage.clickBottomOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderPage(userName,lastName,address,metroStation,phoneNumber);
        orderPage.clickNextButton();
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillRentPage(deliveryDate, comment);
        aboutRentPage.clickOrderButton();
        aboutRentPage.waitСonfirmationWindowDisplayed();
        aboutRentPage.clickAcceptOrderButton();
        Assert.assertTrue(aboutRentPage.isOrderConfirm());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
