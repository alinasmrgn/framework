package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//input[@class='input input_ht_sm form-default__item' and @name='NAME']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@class='input input_ht_sm form-default__item' and @name='EMAIL']")
    private WebElement userNameEmail;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public AccountPage openPage() {
        driver.get("https://aimclo.ru/personal/profile/");
        return this;
    }

    public String getUserName(){
        return userNameField.getText();
    }

    public String getUserNameEmail(){
        return userNameEmail.getText();
    }
}
