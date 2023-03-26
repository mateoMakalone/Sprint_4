package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage {
    private final WebDriver driver;
    private static final String URL_PAGE = "https://qa-scooter.praktikum-services.ru/";
    //URL сервиса
    public static final By TOP_ORDER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //Кнопка "Заказать" в шапке страницы сервиса
    public static final By BOTTOM_ORDER_BUTTON = By.xpath(".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Дублирующая кнопка Заказать внизу страницы сервиса
    private static final By COOKIE_ACCEPT_BUTTON = By.xpath(".//button[@id = 'rcc-confirm-button']");
    //Кнопка принятие куки
    private static final By ABOUT_IMPORTANT_BLOCK = By.xpath(".//div[@class = 'Home_FourPart__1uthg']");
    //Блок "Вопросы о важном"
    public static final By DROP_DOWN_LIST_0 = By.id("accordion__heading-0");
    //1 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_1 = By.id("accordion__heading-1");
    //2 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_2 = By.id("accordion__heading-2");
    //3 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_3 = By.id("accordion__heading-3");
    //4 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_4 = By.id("accordion__heading-4");
    //5 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_5 = By.id("accordion__heading-5");
    //6 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_6 = By.id("accordion__heading-6");
    //7 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_LIST_7 = By.id("accordion__heading-7");
    //8 элемент выпадающего списка с ответами на вопросы
    public static final By DROP_DOWN_TEXT_0 = By.id("accordion__panel-0");
    //Текст ответа на 1 вопрос
    public static final By DROP_DOWN_TEXT_1 = By.id("accordion__panel-1");
    //Текст ответа на 2 вопрос
    public static final By DROP_DOWN_TEXT_2 = By.id("accordion__panel-2");
    //Текст ответа на 3 вопрос
    public static final By DROP_DOWN_TEXT_3 = By.id("accordion__panel-3");
    //Текст ответа на 4 вопрос
    public static final By DROP_DOWN_TEXT_4 = By.id("accordion__panel-4");
    //Текст ответа на 5 вопрос
    public static final By DROP_DOWN_TEXT_5 = By.id("accordion__panel-5");
    //Текст ответа на 6 вопрос
    public static final By DROP_DOWN_TEXT_6 = By.id("accordion__panel-6");
    //Текст ответа на 7 вопрос
    public static final By DROP_DOWN_TEXT_7 = By.id("accordion__panel-7");
    //Текст ответа на 8 вопрос

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(URL_PAGE);
    }
    public void acceptAllCookie(){
        driver.findElement(COOKIE_ACCEPT_BUTTON).click();
    }

    public void clickOrderButton(By orderButton){
        WebElement orderButtonVisible = new WebDriverWait(driver,(10)).until(
                ExpectedConditions.visibilityOfElementLocated(orderButton));
        orderButtonVisible.click();
    }
    public void aboutImportantBlockScroll(){
        WebElement element = driver.findElement(ABOUT_IMPORTANT_BLOCK);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestionField(By question){
        driver.findElement(question).click();
    }
    public String checkResponseText(By responseField, String text){
                new WebDriverWait(driver,(10)).until(
                ExpectedConditions.visibilityOfElementLocated(responseField));
        String text1 = driver.findElement(responseField).getText();
        return text1;
    }
}
