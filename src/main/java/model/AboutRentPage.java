package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AboutRentPage {
    private final WebDriver driver;
    private static final By DELIVERY_DATE_FIELD = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле заполнения даты доставки
    private static final By RENT_PERIOD_FIELD = By.xpath(".//div[@aria-haspopup = 'listbox']");
    //Выпадающий список с количество дней аренды
    private static final By RENT_DAYS = By.xpath(".//div[@class = 'Dropdown-option' and text()= 'трое суток']");
    //Элемент выпадающего списка количества арендный дней
    private static final By COLOR_CHECK_BOX = By.xpath(".//input[@id = 'black']");
    //Чек-бокс с выбором цвета самоката
    private static final By COURIER_COMMENT = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Поле заполнения комментария
    private static final By ORDER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "Заказать" формы "Про аренду"
    private static final By ORDER_COMFIRMATION_WINDOW = By.xpath(".//div[@class= 'Order_ModalHeader__3FDaJ' and text() = 'Хотите оформить заказ?']");
    //Всплывающее окно подтверждения заказа
    private static final By COMFIRM_WINDOW_BUTTON = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[text() = 'Да']");
    //Кнопка подтверждения оформления заказа
    private static final By ORDER_CONFIRM = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");
    //Всплывающее окно информации о заказе


    public AboutRentPage(WebDriver driver){
        this.driver = driver;
    }
    public void setDeliveryDate(String deliveryDate){
        driver.findElement(DELIVERY_DATE_FIELD).sendKeys(deliveryDate);
        driver.findElement(DELIVERY_DATE_FIELD).sendKeys(Keys.ENTER);
    }
    public void setRentPeriod(){
        driver.findElement(RENT_PERIOD_FIELD).click();
        driver.findElement(RENT_DAYS).click();
    }
    public void setScooterColor(){
        driver.findElement(COLOR_CHECK_BOX).click();
    }
    public void setCourierComment(String comment){
        driver.findElement(COURIER_COMMENT).sendKeys(comment);
    }
    public void clickOrderButton(){
       WebElement element = new WebDriverWait(driver, 3).until(
                ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON));
        element.click();
    }
    public void clickAcceptOrderButton(){
         WebElement yesButton = new WebDriverWait(driver,3).until(
                ExpectedConditions.visibilityOfElementLocated(COMFIRM_WINDOW_BUTTON));
        yesButton.click();
    }
    public void fillRentPage(String deliveryDate, String comment){
        setDeliveryDate(deliveryDate);
        setRentPeriod();
        setScooterColor();
        setCourierComment(comment);
    }
    public boolean isOrderConfirm() {
        WebElement orderConfirm =
                new WebDriverWait(driver, 5).until(
                        ExpectedConditions.visibilityOfElementLocated(ORDER_CONFIRM));
        return orderConfirm.isDisplayed();
    }
    public void waitСonfirmationWindowDisplayed(){
        new WebDriverWait(driver, 10).until(
                        ExpectedConditions.visibilityOfElementLocated(ORDER_COMFIRMATION_WINDOW));
    }
}
