package model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;
    private static final By NAME_FIELD = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле заполнения имени
    private static final By LASTNAME_FIELD = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле заполнения фамилии
    private static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле заполнения адреса
    private static final By METRO_STATION_FIELD = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Выпадающий список станций метро
    private static final By PHONE_NUMBER_FIELD = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Поле заполнения номера телефона
    private static final By NEXT_BUTTON = By.xpath(".//button[text() = 'Далее']");
    //Кнопка "Далее" страницы "Для кого самокат"
    private static final By SOKOLNIKI_METRO_STATION = By.xpath(".//li[@data-value = '4']");
    //Поле станции метро "Сокольники" выпадающего списка


    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String userName){
        WebElement nameField = new WebDriverWait(driver,(3)).until(
            ExpectedConditions.visibilityOfElementLocated(NAME_FIELD));
        nameField.sendKeys(userName);
    }
    public void setLastName(String lastName){
        driver.findElement(LASTNAME_FIELD).sendKeys(lastName);
    }
    public void setAddress (String address){
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }
    public void setMetroStation(String metroStation){
        driver.findElement(METRO_STATION_FIELD).sendKeys(metroStation);
        driver.findElement(SOKOLNIKI_METRO_STATION).click();
    }
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }
    public void clickNextButton(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        driver.findElement(NEXT_BUTTON).click();
    }
    public void fillOrderPage(String userName, String lastName,String address, String metroStation, String phoneNumber){
        setName(userName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
    }
}
