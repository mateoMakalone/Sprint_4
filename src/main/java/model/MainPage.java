package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private String text;
    private String text1;
    private final WebDriver driver;
    private static final String URL_PAGE = "https://qa-scooter.praktikum-services.ru/";
    //URL сервиса
    private static final By TOP_ORDER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //Кнопка "Заказать" в шапке страницы сервиса
    private static final By BOTTOM_ORDER_BUTTON = By.xpath(".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Дублирующая кнопка Заказать внизу страницы сервиса
    private static final By COOKIE_ACCEPT_BUTTON = By.xpath(".//button[@id = 'rcc-confirm-button']");
    //Кнопка принятие куки
    private static final By ABOUT_IMPORTANT_BLOCK = By.xpath(".//div[@class = 'Home_FourPart__1uthg']");
    //Блок "Вопросы о важном"
    private static final By DROP_DOWN_LIST_0 = By.id("accordion__heading-0");
    //Первый элемент выпадающего списка с ответами на вопросы
    private static final By DROP_DOWN_LIST_7 = By.id("accordion__heading-7");
    //Последний элемент выпадающего списка с ответами на вопросы
    private static final By DROP_DOWN_TEXT1 = By.id("accordion__panel-0");
    //Текст ответа на первый вопрос
    private static final By DROP_DOWN_TEXT7 = By.id("accordion__panel-7");
    //Текст ответа на последний вопрос

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage open(){
        driver.get(URL_PAGE);
        return this;
    }
    public void acceptAllCookie(){
        driver.findElement(COOKIE_ACCEPT_BUTTON).click();
    }

    public void clickTopOrderButton(){
        WebElement orderButtonVisible = new WebDriverWait(driver,(10)).until(
                ExpectedConditions.visibilityOfElementLocated(TOP_ORDER_BUTTON));
        orderButtonVisible.click();
    }

    public void clickBottomOrderButton(){
        WebElement bottomButton = new WebDriverWait(driver,10).until(
                ExpectedConditions.visibilityOfElementLocated(BOTTOM_ORDER_BUTTON));
        bottomButton.click();
    }

    public void scrollToBottomOrderButton(){
        WebElement element = driver.findElement(BOTTOM_ORDER_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void aboutImportantBlockScroll(){
        WebElement element = driver.findElement(ABOUT_IMPORTANT_BLOCK);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickFirtsQuestion(){
        driver.findElement(DROP_DOWN_LIST_0).click();
    }

    public void clickLastQuestion(){
        driver.findElement(DROP_DOWN_LIST_7).click();
    }
    public String checkFirstQuestionText(){
        text = driver.findElement(DROP_DOWN_TEXT1).getText();
        return text;
    }
    public String checkLastQuestionText(){
        text1 = driver.findElement(DROP_DOWN_TEXT7).getText();
        return text1;
    }
}
